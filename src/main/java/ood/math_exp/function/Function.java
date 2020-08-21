package ood.math_exp.function;

public abstract class Function {
    protected final String name;
    protected final int numArguments;

    public Function(String name, int numArguments) {
        if (numArguments < 0) {
            throw new IllegalArgumentException("The number of function arguments can not be negative");
        }
        if (!isValidFunctionName(name)) {
            throw new IllegalArgumentException("function name(" + name + ") is invalid");
        }
        this.name = name;
        this.numArguments = numArguments;
    }

    public Function(int numArguments) {
        this(null, numArguments);
    }

    public String getName() {
        return name;
    }

    public int getNumArguments() {
        return numArguments;
    }

    public abstract double apply(Function... args);
    public abstract Function derived(Variable variable);

    private static boolean isValidFunctionName(final String name) {
        return name != null && name.length() != 0;
    }
}