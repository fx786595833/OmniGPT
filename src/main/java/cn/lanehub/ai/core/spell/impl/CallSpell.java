package cn.lanehub.ai.core.spell.impl;

import cn.lanehub.ai.core.spell.IMagicSpell;

public class CallSpell extends AbstractSpell {


    private final static String spellName = "call";

    CallSpell() {
        super("call");
    }

    @Override
    public String getSpellPrompt() {
        return null;
    }


}
