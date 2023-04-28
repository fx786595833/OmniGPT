package cn.lanehub.ai.model;

import java.util.List;

/**
 * 所有实现了该API的类中都会被自动并注册。
 */
public interface API {


    String getName();

    String getDescription();


    Object spellRoutine(List<Arg> argList);


}
