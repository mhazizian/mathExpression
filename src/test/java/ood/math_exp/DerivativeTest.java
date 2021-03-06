package ood.math_exp;
import com.sun.org.apache.xpath.internal.operations.VariableSafeAbsRef;
import ood.math_exp.expression.ConstExp;
import ood.math_exp.expression.Expression;
import ood.math_exp.expression.MExpression;
import ood.math_exp.expression.Variable;
import ood.math_exp.function.baseFunction.Div;
import ood.math_exp.function.baseFunction.Mul;
import ood.math_exp.function.baseFunction.Sub;
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

        assertEquals(2, sum.derivative(x).evaluate(), 0);
    }

    @Test
    public void testSubDerivative() {
        Variable x = new Variable("x");
        Variable y = new Variable("y");
        Expression sub = new MExpression(new Sub(), y, x);

        assertEquals(-1, sub.derivative(x).evaluate(), 0);
    }

    @Test
    public void testMulDerivative() {
        Variable x = new Variable("x");
        Expression c = new ConstExp(17);

        Expression mul = new MExpression(new Mul(), x, c);
        assertEquals(17, mul.derivative(x).evaluateVariable(x, 100).evaluate(), 0);

        Expression mul2 = new MExpression(new Mul(), x, c);
        assertEquals(17, mul2.derivative(x).evaluateVariable(x, 100).evaluate(), 0);
    }

    @Test
    public void testDivDerivative() {
        Variable x = new Variable("x");
        Expression c = new ConstExp(10);
        Expression div = new MExpression(new Div(), c, x);

        assertEquals(-2.5, div.derivative(x).evaluateVariable(x, 2).evaluate(), 0);
    }
}
