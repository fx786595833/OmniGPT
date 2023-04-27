package cn.lanehub.ai.gpt.model;

import java.util.List;

public class Chat {


    private List<Message> chatContent;


    public void appendMessage(Message message){
        this.chatContent.add(message);
    }

}
