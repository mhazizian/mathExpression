package ood.math_exp.function.baseFunction;

import ood.math_exp.expression.Expression;
import ood.math_exp.expression.MExpression;
import ood.math_exp.expression.Variable;
import ood.math_exp.function.Function;

import java.util.List;

public class Div extends Function {

    public Div() {
        super("mul");
    }

    public double apply(List<Expression> args) {
        double denominator = args.get(1).evaluate();
        if (denominator == 0)
            throw new ArithmeticException("Div by zero");
        return args.get(0).evaluate() / denominator;
    }


    public Expression derivative(Variable variable, List<Expression> args) {
        Expression exp1 = new MExpression(
                new Mul(),
                args.get(0).derivative(variable),
                args.get(1)
        );

        Expression exp2 = new MExpression(
                new Mul(),
                args.get(0),
                args.get(1).derivative(variable)
        );

        Expression numerator = new MExpression(new Sub(), exp1, exp2);
        Expression denominator = new MExpression(new Mul(), args.get(1), args.get(1));

        return new MExpression(new Div(), numerator, denominator);
    }
}
