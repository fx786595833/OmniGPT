package cn.lanehub.ai.gpt.llm;

import cn.lanehub.ai.gpt.model.Chat;
import cn.lanehub.ai.gpt.model.Message;

public interface IChatAPI {

    Message generate(Chat chat);


}
