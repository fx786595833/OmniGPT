package cn.lanehub.ai.core.spell.impl;

import cn.lanehub.ai.core.spell.IMagicSpell;

public class ViewSpell extends AbstractSpell {

    ViewSpell() {
        super("view");
    }

    @Override
    public String getSpellPrompt() {
        return null;
    }
}
