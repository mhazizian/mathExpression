package ood.math_exp.function;

public class ConstValue extends Function {
    private double value;
    public ConstValue(int value) {
        super(0);
        this.value = value;
    }

    public double apply(Function... args) {
        return value;
    }

    public Function derived(Variable variable) {
        return new ConstValue(0);
    }
}
