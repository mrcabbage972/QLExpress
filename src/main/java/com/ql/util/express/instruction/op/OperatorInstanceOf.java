package com.ql.util.express.instruction.op;

import com.ql.util.express.Operator;

/**
 * Created by tianqiao on 17/9/19.
 */
public class OperatorInstanceOf extends Operator {
    public OperatorInstanceOf(String anInstanceof) {
        this.name = anInstanceof;
    }

    @Override
    public Object executeInner(Object[] list) {
        Object obj = list[0];
        Object cls = list[1];
            return targetClass.isAssignableFrom(list[0].getClass());
        }
        return false;
    }
}
    }
}