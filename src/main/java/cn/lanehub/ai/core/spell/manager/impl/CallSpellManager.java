package cn.lanehub.ai.core.spell.manager.impl;

import cn.lanehub.ai.core.call.CallSpell;
import cn.lanehub.ai.core.spell.ISpell;
import cn.lanehub.ai.core.spell.manager.ISpellManager;
import cn.lanehub.ai.exceptions.Assert;
import cn.lanehub.ai.executors.IExecutor;
import cn.lanehub.ai.executors.ITask;
import cn.lanehub.ai.executors.call.CallTask;
import cn.lanehub.ai.executors.call.impl.CallExecutor;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Call咒语管理器，包含基础的功能以及咒语执行管理
 */
public class CallSpellManager extends AbstractSpellManager {

    public static final ISpellManager INSTANCE = new CallSpellManager();

    private static final IExecutor executor = CallExecutor.INSTANCE;

    private final static String spellName = "call";

    private static final Map<String, CallSpell> callSpellMap = new HashMap<String, CallSpell>();


    private CallSpellManager() {
        super("call");
    }

    @Override
    public String getSpellPrompt() {
        return null;
    }


    @Override
    public void registerSpell(ISpell spell) {
        Assert.judge(spell instanceof CallSpell, "Can not register the " + spell.getType()+"-type spell to CallSpellManager.");
        CallSpell _spell = (CallSpell) spell;
        callSpellMap.put(_spell.getApiName(), _spell);
    }


    @Override
    protected String doCastSpell(List<String> spellArgs) {


        Assert.isNotEmpty(spellArgs,"Call-type spell's args");
        String callName = spellArgs.get(0);
        Assert.isNotBlank(callName,"callName");

        // 1. 根据callName找到对应的咒语对象。
        Assert.judge(callSpellMap.get(callName) != null, "The call api named "+ callName+" is not registered, please check the GPT prompts.");
        CallSpell callSpell = callSpellMap.get(callName);


        // 2. 构建咒语执行任务
        spellArgs.remove(0);
        ITask callTask = new CallTask(callSpell, spellArgs);


        // 3. 执行咒语返回文本结果
        return executor.doExecute(callTask);

    }
}
