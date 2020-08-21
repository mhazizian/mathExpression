package ood.math_exp.function.baseFunction;

import ood.math_exp.expression.Expression;
import ood.math_exp.expression.MExpression;
import ood.math_exp.expression.Variable;
import ood.math_exp.function.Function;

import java.util.List;

public class Sin extends Function {

    public Sin() {
        super("sin");
    }

    public double apply(List<Expression> args) {
        return Math.sin(args.get(0).evaluate());
    }


    public Expression derivative(Variable variable, List<Expression> args) {
        return new MExpression(new Mul(), args.get(0).derivative(variable), new MExpression(new Cos(), args.get(0)));
    }
}
