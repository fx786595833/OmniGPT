package cn.lanehub.ai.gpt.llm.impl;

import cn.lanehub.ai.core.spell.manager.ISpellManager;
import cn.lanehub.ai.core.spell.book.IMagicSpellBook;
import cn.lanehub.ai.core.spell.book.impl.MagicSpellBook;
import cn.lanehub.ai.gpt.llm.IChatAPI;
import cn.lanehub.ai.gpt.model.Chat;
import cn.lanehub.ai.gpt.model.Message;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class AbstractChatAPI implements IChatAPI {


    private static final IMagicSpellBook resolver = MagicSpellBook.INSTANCE;

    @Override
    public Message generate(Chat chat) {

        // 执行AI生成结果
        Message result = doGenerate(chat);

        // 如果生成的内容中包含咒语，那么下一条一定是以System视角追加的一条咒语结果数据。
        List<String> spells = findSpells(result.getContent());

        if(spells.size()>0){
            int p =1;
            StringBuilder sb = new StringBuilder();
            for(String spellText:spells){
                sb.append("["+ p++ +"] ");
                ISpellManager spellManager =  resolver.resolve(spellText);
                sb.append(spellManager.castSpell(spellText)).append("\n");
            }

            chat.appendMessage(new Message("system", sb.toString()));

            // 咒语的返回用户不可见，AI需要自己加工后再次对用户生成。
            return generate(chat);
        }
        return result;
    }


    protected abstract Message doGenerate(Chat chat);



    public static List<String> findSpells(String text) {
        List<String> spells = new ArrayList<>();
        Pattern pattern = Pattern.compile("\\[SPELL-S\\](.*?)\\[SPELL-E\\]");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            String spell = matcher.group(1);
            spells.add(spell);
        }
        return spells;
    }
}
