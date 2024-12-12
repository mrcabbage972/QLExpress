package com.ql.util.express.bugfix;

import com.ql.util.express.DefaultContext;
import com.ql.util.express.ExpressRunner;
import com.ql.util.express.IExpressContext;
import org.junit.Test;

public class CompareObjectTest {

    @Test
    public void test() throws Exception {
        System.out.println('a' < 98);
        ExpressRunner runner = new ExpressRunner(false, false);
        String[] expList = new String[] {
            "'a' < 'b'",
            "'a' <= 'b'",
            "'a' == 'a'",
            "test == 'a'",
            "test <= 'a'",
            "'a' >= test",
        };
        IExpressContext<String, Object> context = new DefaultContext<>();
        context.put("test", 'a' + 0);
        for (String exp : expList) {
            Object result = runner.execute(exp, context, null, false, false);
            System.out.println(result);
            assert ((Boolean)result);
        }
    }
}