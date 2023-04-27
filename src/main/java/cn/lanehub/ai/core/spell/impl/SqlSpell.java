package cn.lanehub.ai.core.spell.impl;

import cn.lanehub.ai.core.spell.IMagicSpell;

public class SqlSpell extends AbstractSpell  {

    SqlSpell() {
        super("sql");
    }

    @Override
    public String getSpellPrompt() {
        return null;
    }
}
