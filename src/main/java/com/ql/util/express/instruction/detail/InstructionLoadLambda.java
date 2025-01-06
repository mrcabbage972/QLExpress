package com.ql.util.express.instruction.detail;

import java.util.List;

import com.ql.util.express.InstructionSet;
import com.ql.util.express.QLambda;
import com.ql.util.express.instruction.OperateDataCacheManager;

/**
 * 将一个 QLambda 加载到栈上
 */
public class InstructionLoadLambda extends Instruction {
    private final InstructionSet lambdaSet;

    public InstructionLoadLambda(InstructionSet lambdaSet) {
        this.lambdaSet = lambdaSet;
    }

    @Override
    public void execute(RunEnvironment environment, List<String> errorList) {
        environment.push(
            new QLambda(lambdaSet, environment, errorList)
        );
        environment.programPointAdd(1);
    }

    @Override
    public String toString() {
        return "Load Lambda " + lambdaSet.toString() + "Lambda End";
    }
}