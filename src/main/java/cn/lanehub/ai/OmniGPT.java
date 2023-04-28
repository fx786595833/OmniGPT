package cn.lanehub.ai;

import cn.lanehub.ai.core.spell.ISpell;
import cn.lanehub.ai.core.spell.book.IMagicSpellBook;
import cn.lanehub.ai.core.spell.book.impl.MagicSpellBook;
import cn.lanehub.ai.core.view.ViewSpell;
import cn.lanehub.ai.exceptions.ViewSpellCustomizeNotSupport;
import cn.lanehub.ai.gpt.llm.IChatAPI;
import cn.lanehub.ai.gpt.llm.openai.GPT4ChatAPI;
import cn.lanehub.ai.gpt.model.Chat;
import cn.lanehub.ai.gpt.model.Message;

public class OmniGPT {

    private String customSystemPrompt;

    private IMagicSpellBook spellBook;

    public OmniGPT(String customSystemPrompt){
        this.customSystemPrompt = customSystemPrompt;
        spellBook = new MagicSpellBook();
    }
    public OmniGPT(){

    }

    private static IChatAPI chatAPI = GPT4ChatAPI.INSTANCE;

    public void register(ISpell spell){

        spellBook.register(spell);
        if(spell instanceof ViewSpell){
            throw new ViewSpellCustomizeNotSupport();
        }

    }


    public Chat startChat(){

        // 生成system角色提示词。
        // 传入system提示词
        // 启动一个GPT对话


        return null;
    }


    /**
     *
     * 接受用户的消息输入，返回AI的输出，并且追加到chat中
     * @param chat
     * @param userMessage
     * @return
     */
    public Message proceedUserMessage(Chat chat, Message userMessage){

        chat.appendMessage(userMessage);
        Message aiResponse = chatAPI.generate(chat);
        chat.appendMessage(aiResponse);

        return aiResponse;

    }




}
