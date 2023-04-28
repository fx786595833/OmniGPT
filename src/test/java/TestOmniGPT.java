import cn.lanehub.ai.OmniGPT;
import cn.lanehub.ai.core.call.CallSpell;
import cn.lanehub.ai.core.call.CallSpellType;
import cn.lanehub.ai.core.spell.ISpell;
import cn.lanehub.ai.gpt.model.Chat;
import cn.lanehub.ai.gpt.model.Message;
import cn.lanehub.ai.model.Arg;

import java.util.Collections;

public class TestOmniGPT {


    public static void main(String[] args) {


        String customSystemPrompt = "";
        OmniGPT omniGPT = new OmniGPT(customSystemPrompt);

        // 将圆领查询商品的接口注册为一个CALL 咒语
        ISpell spell = new CallSpell.Builder()
                .setApiName("api-name")
                .setUrl("http://example.com/api")
                .setGptFeedArgs(Collections.singletonList(new Arg(false,"arg-name", "arg-value")))
                .setCallSpellType(CallSpellType.REST_POST_CALL)
                .setHeaders(Collections.singletonMap("Content-Type", "application/json"))
                .setQuerys(Collections.singletonMap("page", "1"))
                .setRequestTemplate("{\"name\":\"${arg-name}\"}")
                .build();

        omniGPT.register(spell);

        //  启动聊天
        Chat chat = omniGPT.startChat();

        //选择1： 让AI先说第一句话
        //选择2： 让用户先说第一句话
        String query = "帮我查询一下价格在100~200的商品列表，返回格式为 价格：URL。";
        Message message = new Message("user", query);

        // 进行聊天
        Message aiResponse = omniGPT.proceedUserMessage(chat, message);
        System.out.println(aiResponse);

    }



}
