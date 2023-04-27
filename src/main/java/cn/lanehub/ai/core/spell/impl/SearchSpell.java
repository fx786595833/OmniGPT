package cn.lanehub.ai.core.spell.impl;

import cn.lanehub.ai.core.spell.IMagicSpell;

public class SearchSpell  extends AbstractSpell {

    SearchSpell() {
        super("search");
    }

    @Override
    public String getSpellPrompt() {
        return null;
    }
}
