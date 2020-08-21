package ood.math_exp.expression;

import ood.math_exp.function.ConstValue;
import ood.math_exp.function.Variable;

public class ConstExp extends Expression {
    public ConstExp(double arg) {
        super(new ConstValue(arg), null);
    }

    public void evaluateVariable(Variable v, double value) {}

    public double evaluate() {
        return this.function.apply(null);
    }
}
