package ood.math_exp.function.baseFunction;

import ood.math_exp.expression.Expression;
import ood.math_exp.expression.MExpression;
import ood.math_exp.expression.Variable;
import ood.math_exp.function.Function;

import java.util.ArrayList;
import java.util.List;

public class Sum extends Function {

    public Sum() {
        super("sum");
    }

    public double apply(List<Expression> args) {
        double result = 0;
        for (Expression exp : args) {
            result += exp.evaluate();
        }
        return result;
    }


    public Expression derivative(Variable variable, List<Expression> args) {
        List<Expression> newArgs = new ArrayList<Expression>();

        for (Expression arg : args)
            newArgs.add(arg.derivative(variable));

        return new MExpression(this, newArgs);
    }
}
