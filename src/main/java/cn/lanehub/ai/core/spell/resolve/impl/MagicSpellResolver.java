package cn.lanehub.ai.core.spell.resolve.impl;

import cn.lanehub.ai.core.spell.manager.ISpellManager;
import cn.lanehub.ai.core.spell.manager.impl.*;
import cn.lanehub.ai.core.spell.resolve.IMagicSpellResolver;
import cn.lanehub.ai.exceptions.Assert;
import cn.lanehub.ai.exceptions.SpellNotFoundException;
import cn.lanehub.ai.util.SpellUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MagicSpellResolver implements IMagicSpellResolver {


    public static final MagicSpellResolver INSTANCE = new MagicSpellResolver();

    private MagicSpellResolver(){}

    private static List<ISpellManager> supportedMagicSpellManagers = new ArrayList<>();
    static{
        supportedMagicSpellManagers.add(CallSpellManager.INSTANCE);
        supportedMagicSpellManagers.add(SearchSpellManager.INSTANCE);
        supportedMagicSpellManagers.add(ViewSpellManager.INSTANCE);
        supportedMagicSpellManagers.add(SqlSpellManager.INSTANCE);
        supportedMagicSpellManagers.add(MatchSpellManager.INSTANCE);
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




}
