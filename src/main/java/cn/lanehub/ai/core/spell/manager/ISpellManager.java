package cn.lanehub.ai.core.spell.manager;

import cn.lanehub.ai.core.spell.ISpell;

public interface ISpellManager {


    /**
     * Get the Spell Prompt
     * @return
     */
    String getSpellPrompt();


    String getSpellName();


    boolean fit(String spellName);


    String castSpell(String spell);


    void registerSpell(ISpell spell);


}
