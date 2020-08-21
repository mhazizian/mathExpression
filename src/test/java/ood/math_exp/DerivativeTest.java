package ood.math_exp;
import com.sun.org.apache.xpath.internal.operations.VariableSafeAbsRef;
import ood.math_exp.expression.ConstExp;
import ood.math_exp.expression.Expression;
import ood.math_exp.expression.MExpression;
import ood.math_exp.expression.Variable;
import ood.math_exp.function.baseFunction.Sum;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class DerivativeTest {
    @Test
    public void testMainVariableDerivative() {
        Variable x = new Variable("x");
        assertEquals(x.derivative(x).evaluate(), (double) 1, 0);
    }

    @Test
    public void testOtherVariableDerivative() {
        Variable x = new Variable("x");
        Variable y = new Variable("y");
        assertEquals(x.derivative(y).evaluate(), (double) 0, 0);
    }

    @Test
    public void testConstantDerivative() {
        Variable x = new Variable("x");
        Expression c = new ConstExp(100);
        assertEquals(c.derivative(x).evaluate(), (double) 0, 0);
    }

    @Test
    public void testSumDerivative() {
        Variable x = new Variable("x");
        Variable y = new Variable("y");
        Expression sum = new MExpression(new Sum(), x, x, y);

        assertEquals(sum.derivative(x).evaluate(), (double) 2, 0);
    }
}
