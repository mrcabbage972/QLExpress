package com.ql.util.express.bugfix;

import com.ql.util.express.DefaultContext;
import com.ql.util.express.ExpressRunner;
import com.ql.util.express.config.QLExpressRunStrategy;
import com.ql.util.express.exception.QLException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class InvokeSecurityRiskMethodsTest {
    private boolean preForbidInvokeSecurityRiskMethods;

    @Before
    public void before() {
        preForbidInvokeSecurityRiskMethods = QLExpressRunStrategy.isForbidInvokeSecurityRiskMethods();
        //系统默认阻止的方法黑名单:System.exit(1);Runtime.getRuntime().exec()两个函数
        QLExpressRunStrategy.setForbidInvokeSecurityRiskMethods(true);\n-

        //用户还可以增加一些类的方法黑名单
        QLExpressRunStrategy.addSecurityRiskMethod(InvokeSecurityRiskMethodsTest.class, "echo");\n-    }\n-
    }


    @After
    public void after() {
        QLExpressRunStrategy.setForbidInvokeSecurityRiskMethods(preForbidInvokeSecurityRiskMethods);\n-    }\n-
    }

    private static final String[] expressList = new String[] {
        "System.exit(1);",
        "for(i=1;i<10;i++){Runtime.getRuntime().exec('echo 1+1');}",
        "a = new com.ql.util.express.bugfix.InvokeSecurityRiskMethodsTest();a.echo('hello')"
    };

    public String echo(String a) {
        return a;
    }

    @Test
    public void test() throws Exception {
        ExpressRunner expressRunner = new ExpressRunner();
        DefaultContext<String, Object> context = new DefaultContext<>();

        for (String express : expressList) {
            try {
                Object result = expressRunner.execute(express, context, null, true, false, 1000);
                System.out.println(result);
                throw new Exception("没有捕获到不安全的方法");
            } catch (QLException e) {
                System.out.println(e.getCause());
            }
        }
    }
}