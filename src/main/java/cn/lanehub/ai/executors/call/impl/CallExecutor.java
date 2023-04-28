package cn.lanehub.ai.executors.call.impl;

import cn.lanehub.ai.executors.IExecutor;
import cn.lanehub.ai.executors.ITask;
import cn.lanehub.ai.executors.call.CallTask;
import cn.lanehub.ai.executors.call.ICallExecutor;

public class CallExecutor implements ICallExecutor {

    public static final ICallExecutor INSTANCE = new CallExecutor();

    private CallExecutor(){
    }

    @Override
    public String doExecute(ITask task) {

        CallTask callTask = (CallTask) task;

        // TODO @杨恒


        return null;
    }
}
