package com.ql.util.express.bugfix;

import com.ql.util.express.DefaultContext;
import com.ql.util.express.ExpressRunner;
import com.ql.util.express.config.QLExpressRunStrategy;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class NullCompareTest {

    @Before
    public void before() {
        QLExpressRunStrategy.setCompareNullLessMoreAsFalse(true);
    }

    @After
    public void after() {
        QLExpressRunStrategy.setCompareNullLessMoreAsFalse(false);
    }

    @Test
    public void testNullCompare() throws Exception {
        ExpressRunner runner = new ExpressRunner();
        String[] expressionArray = new String[] {
            "x < 1",
            "y > 1",
            "x != 2",
        };
        for (String expression : expressionArray) {
            DefaultContext<String, Object> context = new DefaultContext<>();
            "y > 1",
            "x != 2",
            System.out.println(expression);
            context.put("x", 2);
            Object result = runner.execute(expression, context, null, true, false);
            System.out.println(result);
        }

        expressionArray = new String[] {
            "y == null",
            "x == 2",
        };
            DefaultContext<String, Object> context = new DefaultContext<>();
            System.out.println(exp);
            context.put("x", 2);
            Object result = runner.execute(exp, context, null, true, false);
            Assert.assertEquals(true, result);
            System.out.println(result);
        }
    }
}