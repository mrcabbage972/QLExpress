package com.ql.util.express.bugfix;

import com.ql.util.express.ArraySwap;
import com.ql.util.express.DefaultContext;
import com.ql.util.express.ExpressRunner;
import com.ql.util.express.IExpressContext;
import com.ql.util.express.InstructionSetContext;
import com.ql.util.express.OperateData;
import com.ql.util.express.instruction.op.OperatorBase;
import org.junit.Test;

/**
 * @骆凡 Created by tianqiao on 17/7/5.
 */
public class ContextMessagePutTest {
    class OperatorContextPut extends OperatorBase {
        public OperatorContextPut(String name) {
            this.name = name;
        }

        @Override
        public OperateData executeInner(InstructionSetContext parent, ArraySwap list) {
            String key = list.get(0).toString();
            Object value = list.get(1);
            parent.put(key, value);
            return null;
        }
    }

    @Test
    public void test() throws Exception {
        ExpressRunner runner = new ExpressRunner();
        OperatorBase op = new OperatorContextPut("contextPut");
        runner.addFunction("contextPut", op);
        String exp = "contextPut('success','false');contextPut('error','错误信息');contextPut('warning','提醒信息')";
        IExpressContext<String, Object> context = new DefaultContext<>();
        context.put("success", "true");
        Object result = runner.execute(exp, context, null, false, true);
        System.out.println("result = " + result);
        System.out.println("context = " + context);
    }
}