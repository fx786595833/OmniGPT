package cn.lanehub.ai;

import cn.lanehub.ai.core.call.CallSpell;
import cn.lanehub.ai.core.spell.ISpell;
import cn.lanehub.ai.core.view.ViewSpell;
import cn.lanehub.ai.exceptions.ViewSpellCustomizeNotSupport;
import cn.lanehub.ai.gpt.model.Chat;

public class OmniGPT {


    public static void register(ISpell spell){


        if(spell instanceof ViewSpell){
            throw new ViewSpellCustomizeNotSupport();
        }

    }

    public static void flush(){

    }

    public static Chat startChat(){

        // 传入system提示词
        // 启动一个GPT对话


        return null;
    }


}
