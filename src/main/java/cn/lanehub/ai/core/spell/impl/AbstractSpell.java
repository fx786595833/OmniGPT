package cn.lanehub.ai.core.spell.impl;

import cn.lanehub.ai.core.spell.IMagicSpell;

public abstract class AbstractSpell implements IMagicSpell {


    AbstractSpell(String spellName){
        this.spellName = spellName;
    }


    private String spellName;


    @Override
    public String getSpellName() {
        return spellName;
    }

    @Override
    public boolean fit(String spellName) {
        return this.spellName.equals(spellName);
    }

}
