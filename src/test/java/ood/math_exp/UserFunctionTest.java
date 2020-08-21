package ood.math_exp;

import ood.math_exp.expression.ConstExp;
import ood.math_exp.expression.Expression;
import ood.math_exp.expression.MExpression;
import ood.math_exp.expression.Variable;
import ood.math_exp.function.Function;
import ood.math_exp.function.UserFunction;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class UserFunctionTest {

    @Test
    public void simpleConstantUserFuncTest() {
        new UserFunction().addFunction(
                "myFunc",
                new Function() {
                    @Override
                    public double apply(List<Expression> args) {
                        return 17.17;
                    }

                    @Override
                    public Expression derivative(Variable variable, List<Expression> args) {
                        return new ConstExp(0);
                    }
                }
        );

        Expression exp = new MExpression("myFunc");
        assertEquals(17.17, exp.evaluate(), 0);
    }

    @Test
    public void StepFunctionUsingUserFuncTest() {
        new UserFunction().addFunction(
                "myFunc2",
                new Function() {
                    @Override
                    public double apply(List<Expression> args) {
                        if (args.get(0).evaluate() > 0)
                            return 1;
                        else
                            return 0;
                    }

                    @Override
                    public Expression derivative(Variable variable, List<Expression> args) {
                        return new ConstExp(0);
                    }
                }
        );

        Expression exp = new MExpression("myFunc2", new ConstExp(10));
        assertEquals(1, exp.evaluate(), 0);

        Expression exp2 = new MExpression("myFunc2", new ConstExp(-10));
        assertEquals(0, exp2.evaluate(), 0);
    }

    @Test
    public void MultipleUseOfUserFuncTest() {
        new UserFunction().addFunction(
                "myFunc3",
                new Function() {
                    @Override
                    public double apply(List<Expression> args) {
                        return args.get(0).evaluate() * 10;
                    }

                    @Override
                    public Expression derivative(Variable variable, List<Expression> args) {
                        return new ConstExp(0);
                    }
                }
        );

        Expression exp1 = new MExpression("myFunc3", new ConstExp(1));
        Expression exp2 = new MExpression("myFunc3", exp1);
        Expression exp3 = new MExpression("myFunc3", exp2);
        Expression exp4 = new MExpression("myFunc3", exp3);

        assertEquals(10000, exp4.evaluate(), 0);
    }
}
