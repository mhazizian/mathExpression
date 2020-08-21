package ood.math_exp.expression;

import ood.math_exp.function.Function;
import ood.math_exp.function.baseFunction.ConstValue;

public class ConstExp implements Expression {
    private Function function;

    public ConstExp(double value) {
        this.function = new ConstValue(value);
    }

    public ConstExp(ConstValue function) {
        this.function = function;
    }

    public Expression evaluateVariable(Variable v, double value) {
        return new ConstExp((ConstValue) this.function);
    }

    public double evaluate() {
        return this.function.apply(null);
    }
}
