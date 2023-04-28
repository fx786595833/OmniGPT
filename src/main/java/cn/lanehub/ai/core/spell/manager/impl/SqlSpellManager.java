package cn.lanehub.ai.core.spell.manager.impl;

import cn.lanehub.ai.core.spell.ISpell;
import cn.lanehub.ai.core.spell.manager.ISpellManager;

import java.util.List;

public class SqlSpellManager extends AbstractSpellManager {

    public SqlSpellManager() {
        super("sql");
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
