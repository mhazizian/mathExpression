package ood.math_exp.function.baseFunction;

import ood.math_exp.expression.Expression;
import ood.math_exp.expression.MExpression;
import ood.math_exp.expression.Variable;
import ood.math_exp.function.Function;

import java.util.List;

public class Sub extends Function {

    public Sub() {
        super("sub");
    }

    public double apply(List<Expression> args) {
        return args.get(0).evaluate() - args.get(1).evaluate();
    }


    public Expression derivative(Variable variable, List<Expression> args) {
        return new MExpression(
                this,
                args.get(0).derivative(variable),
                args.get(1).derivative(variable)
        );
    }
}
