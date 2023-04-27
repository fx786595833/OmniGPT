package cn.lanehub.ai.prompts.impl;

import cn.lanehub.ai.prompts.IPrompt;
import cn.lanehub.ai.prompts.Language;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractPrompt implements IPrompt {


    protected Map<Language, String> promptMap= new HashMap<Language, String>();

    @Override
    public String getPrompt() {
        return getPromptByLanguage(Language.CHINESE);
    }

    @Override
    public String getPromptByLanguage(Language language) {
        return promptMap.get(language);
    }
}
