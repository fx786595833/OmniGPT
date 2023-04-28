package cn.lanehub.ai.core.spell.book.impl;

import cn.lanehub.ai.core.spell.ISpell;
import cn.lanehub.ai.core.spell.manager.ISpellManager;
import cn.lanehub.ai.core.spell.manager.impl.*;
import cn.lanehub.ai.core.spell.book.IMagicSpellBook;
import cn.lanehub.ai.exceptions.Assert;
import cn.lanehub.ai.exceptions.SpellNotFoundException;
import cn.lanehub.ai.util.SpellUtil;

import java.util.ArrayList;
import java.util.List;

public class MagicSpellBook implements IMagicSpellBook {


    private List<ISpellManager> supportedMagicSpellManagers;

    public MagicSpellBook(){
        supportedMagicSpellManagers = new ArrayList<>();
        supportedMagicSpellManagers.add(new CallSpellManager());
        supportedMagicSpellManagers.add(new SearchSpellManager());
        supportedMagicSpellManagers.add(ViewSpellManager.INSTANCE);
        supportedMagicSpellManagers.add(new SqlSpellManager());
        supportedMagicSpellManagers.add(new MatchSpellManager());
    }



    @Override
    public ISpellManager resolve(String spellText) {

        List<String> spellParts = SpellUtil.getSpellParts(spellText);

        String spellName = spellParts.get(0).toLowerCase();
        Assert.isNotBlank(spellName, "Spell name");

        for (ISpellManager spell : supportedMagicSpellManagers){
            if(spell.fit(spellName)){
                return spell;
            }
        }

        throw new SpellNotFoundException(spellParts.get(0));
    }

    @Override
    public void register(ISpell spell) {
         for(ISpellManager spellManager: supportedMagicSpellManagers){
            if(spellManager.fit((spell.getType().getName()))){
                spellManager.registerSpell(spell);
                return;
            }
         }
    }


}
