package cn.lanehub.ai.gpt.llm.openai;

import cn.lanehub.ai.gpt.llm.IChatAPI;
import cn.lanehub.ai.gpt.llm.impl.AbstractChatAPI;
import cn.lanehub.ai.gpt.model.Chat;
import cn.lanehub.ai.gpt.model.Message;

public class GPT4ChatAPI extends AbstractChatAPI {


    public static final IChatAPI INSTANCE = new GPT4ChatAPI();

    private GPT4ChatAPI(){}


    @Override
    protected Message doGenerate(Chat chat) {

        // TODO @杨恒

        return null;
    }
}
