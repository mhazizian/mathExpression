package ood.math_exp.function.preDefinedFunctino;

import ood.math_exp.function.Variable;
import ood.math_exp.function.Function;

public class Sum extends Function {

    public Sum() {
        super("sum", 2);
    }

    public double apply(Function... args) {
        double value;
        for (Function arg : args) {
            value += arg.
        }
    }

    public Function derived(Variable variable) {
        return null;
    }
}
