package cn.lanehub.ai.prompts;

public interface IPrompt {


    String getPrompt();

    String getPromptByLanguage(Language language);


}
