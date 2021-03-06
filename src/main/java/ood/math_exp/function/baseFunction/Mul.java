package ood.math_exp.function.baseFunction;

import ood.math_exp.expression.Expression;
import ood.math_exp.expression.MExpression;
import ood.math_exp.expression.Variable;
import ood.math_exp.function.Function;

import java.util.List;

public class Mul extends Function {

    public Mul() {
        super("mul");
    }

    public double apply(List<Expression> args) {
        double result = 1;
        for (Expression exp : args) {
            result *= exp.evaluate();
        }
        return result;
    }


    public Expression derivative(Variable variable, List<Expression> args) {
        Expression exp1 = new MExpression(
                this,
                args.get(0).derivative(variable),
                args.get(1)
        );

        Expression exp2 = new MExpression(
                this,
                args.get(0),
                args.get(1).derivative(variable)
        );

        return new MExpression(new Sum(), exp1, exp2);
    }
}
