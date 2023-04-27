package cn.lanehub.ai.core.spell;

public interface IMagicSpell {


    /**
     * Get the Spell Prompt
     * @return
     */
    String getSpellPrompt();


    String getSpellName();


    boolean fit(String spellName);


}
