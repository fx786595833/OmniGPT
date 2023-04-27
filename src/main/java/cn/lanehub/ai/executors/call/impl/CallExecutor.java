package cn.lanehub.ai.executors.call.impl;

import cn.lanehub.ai.executors.IExecutor;
import cn.lanehub.ai.executors.call.ICallExecutor;

public class CallExecutor implements ICallExecutor {

    public static final ICallExecutor INSTANCE = new CallExecutor();

    private CallExecutor(){
    }

    @Override
    public String doExecute() {
        return null;
    }
}
