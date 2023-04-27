package cn.lanehub.ai.core.call;

import cn.lanehub.ai.core.spell.ISpell;
import cn.lanehub.ai.model.Arg;
import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * Call的添加方式有：
 * 1. 通过代码进行注册，工程师在代码中自己构造CallSpell对象。
 * 2. 通过继承API接口，注册器自动发现和注册CallSpell对象。
 * 3. 通过用户手动录入API的信息，系统帮助用户构造CallSpell对象。
 * 4. 通过Swagger等接口文档系统导入，系统自动构造和注册CallSpell对象。
 * 5. 通过OmniGPT注解标注某个方法，该方法则会被自动构造和注册CallSpell对象。
 */
@Data
public class CallSpell implements ISpell {

    String apiName;

    String url;
    /**
     * 需要GPT提供的参数
     */
    List<Arg> gptFeedArgs;

    CallSpellType callSpellType;

    Map<String,String> headers;

    Map<String,String> querys;

    /**
     * 如
     * {
     *     "name":${name}
     * }
     * 其中${name}为gptFeedArgs中的某个参数。
     *
     */
    String requestTemplate;


    @Override
    public String getType() {
        return "call";
    }
}
