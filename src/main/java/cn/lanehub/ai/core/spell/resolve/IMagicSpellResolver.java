package cn.lanehub.ai.core.spell.resolve;

import cn.lanehub.ai.core.spell.manager.ISpellManager;

/**
 * resolve the spell command and
 */
public interface IMagicSpellResolver {


    ISpellManager resolve(String spell);


}
