package ood.math_exp;

import ood.math_exp.expression.ConstExp;
import ood.math_exp.expression.Expression;
import ood.math_exp.expression.MExpression;
import ood.math_exp.expression.Variable;
import ood.math_exp.function.baseFunction.Cos;
import ood.math_exp.function.baseFunction.Div;
import ood.math_exp.function.baseFunction.Sub;
import org.junit.Test;

import static java.lang.Math.PI;
import static org.junit.Assert.assertEquals;

public class ExamTest {
    @Test
    public void examTest() {
        Variable x = new Variable("x");
        Variable y = new Variable("y");

        Expression cosx = new MExpression(new Cos(), x);
        Expression cosx_1 = new MExpression(new Sub(), cosx, new ConstExp(1));

        Expression exp = new MExpression(new Div(), cosx_1, y);
        Expression yEval = exp.evaluateVariable(y, 2);

        Expression derived = yEval.derivative(x);
        Expression xEval = derived.evaluateVariable(x, 0);

        assertEquals(0, xEval.evaluate(), 1E-5);
        xEval = derived.evaluateVariable(x, PI/2);

        assertEquals(-0.5, xEval.evaluate(), 1E-5);
    }
}
