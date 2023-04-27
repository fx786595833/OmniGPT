package cn.lanehub.ai.prompts.impl;

import cn.lanehub.ai.prompts.Language;

public class CallPrompt extends AbstractPrompt{

    private static CallPrompt INSTANCE = new CallPrompt();

    static{
        INSTANCE.promptMap.put(Language.CHINESE, "");

        INSTANCE.promptMap.put(Language.ENGLISH, "");

    }

    private CallPrompt(){

    }

    public static CallPrompt getInstance(){
        return INSTANCE;
    }

}
