package ood.math_exp.function.baseFunction;

import ood.math_exp.expression.ConstExp;
import ood.math_exp.expression.Expression;
import ood.math_exp.expression.MExpression;
import ood.math_exp.function.Function;
import ood.math_exp.expression.Variable;

import java.util.List;

public class ConstValue extends Function {
    private double value;

    public ConstValue(double value) {
        super();
        this.value = value;
    }

    public double apply(List<Expression> args) {
        return this.value;
    }

    public Expression derived(Variable variable) {
        return new ConstExp(0);
    }


}
