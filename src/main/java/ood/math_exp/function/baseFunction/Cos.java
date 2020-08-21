package ood.math_exp.function.baseFunction;

import ood.math_exp.expression.ConstExp;
import ood.math_exp.expression.Expression;
import ood.math_exp.expression.MExpression;
import ood.math_exp.expression.Variable;
import ood.math_exp.function.Function;

import java.util.List;

public class Cos extends Function {

    public Cos() {
        super("cos");
    }

    public double apply(List<Expression> args) {
        return Math.cos(args.get(0).evaluate());
    }


    public Expression derivative(Variable variable, List<Expression> args) {
        Expression exp = new MExpression(
                new Mul(),
                args.get(0).derivative(variable),
                new MExpression(new Sin(), args.get(0))
        );

        return new MExpression(new Mul(), new ConstExp(-1), exp);
    }
}
