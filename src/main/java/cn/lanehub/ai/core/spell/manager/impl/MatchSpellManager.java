package cn.lanehub.ai.core.spell.manager.impl;

import cn.lanehub.ai.core.spell.ISpell;
import cn.lanehub.ai.core.spell.manager.ISpellManager;

import java.util.List;

public class MatchSpellManager extends AbstractSpellManager {



    public static final ISpellManager INSTANCE = new MatchSpellManager();

    private MatchSpellManager() {
        super("match");
    }

    @Override
    public String getSpellPrompt() {
        return null;
    }


    @Override
    public void registerSpell(ISpell spell) {

    }


    @Override
    protected String doCastSpell(List<String> spellArgs) {
        return null;
    }
}
