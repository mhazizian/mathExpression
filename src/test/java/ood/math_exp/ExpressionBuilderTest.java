package ood.math_exp;

import ood.math_exp.expression.ConstExp;
import ood.math_exp.expression.Expression;
import ood.math_exp.expression.MExpression;
import ood.math_exp.expression.Variable;
import ood.math_exp.function.baseFunction.Sum;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class ExpressionBuilderTest {

    @Test
    public void testConstExpression() {
        Expression exp1 = new ConstExp(10.01);
        Expression exp2 = new ConstExp(7.16);
        Expression exp3 = new ConstExp(1);
        Expression exp4 = new ConstExp(2);
        Expression sum = new MExpression(new Sum(), exp1, exp2, exp3, exp4);

        assertEquals(sum.evaluate(), (double) 20.17, 0);
    }

    @Test
    public void testVariableExpression() {
        Variable x = new Variable("x");
        Expression sum = new MExpression(new Sum(), x, x);
        Expression xEval = sum.evaluateVariable(x, 10);

        assertEquals(xEval.evaluate(), (double) 20, 0);
    }

    @Test
    public void testVariableExpressionWithMultipleVarialbe() {
        Variable x = new Variable("x");
        Variable y = new Variable("y");
        Expression sum = new MExpression(new Sum(), x, y);
        Expression xEval = sum.evaluateVariable(x, 10);
        Expression xyEval = xEval.evaluateVariable(y, 20);

        assertEquals(xyEval.evaluate(), (double) 30, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testVariableExpressionNotEValuated() {
        Variable x = new Variable("x");
        Expression sum = new MExpression(new Sum(), x, x);
        sum.evaluateVariable(x, 10);

        assertEquals(sum.evaluate(), (double) 20, 0);
    }
}
