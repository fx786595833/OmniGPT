package cn.lanehub.ai.core.view;

import cn.lanehub.ai.core.spell.ISpell;

public class ViewSpell implements ISpell {
    @Override
    public String getType() {
        return "view";
    }
}
