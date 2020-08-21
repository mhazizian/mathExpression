package ood.math_exp;

import ood.math_exp.expression.ConstExp;
import ood.math_exp.expression.Expression;
import ood.math_exp.function.baseFunction.Sum;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class ExpressionBuilderTest {

    @Test
    public void testSumFunc() {
        Expression exp1 = new ConstExp(10.01);
        Expression exp2 = new ConstExp(7.16);
        Expression exp3 = new ConstExp(1);
        Expression exp4 = new ConstExp(2);
        Expression sum = new Expression(new Sum(), exp1, exp2, exp3, exp4);

        assertEquals(sum.evaluate(), (double) 20.17, 0);
    }
}
