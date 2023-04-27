package cn.lanehub.ai.core.spell.manager.impl;

import cn.lanehub.ai.core.spell.ISpell;
import cn.lanehub.ai.core.spell.manager.ISpellManager;

import java.util.List;

public class SearchSpellManager extends AbstractSpellManager {


    public static final ISpellManager INSTANCE = new SearchSpellManager();


    private SearchSpellManager() {
        super("search");
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