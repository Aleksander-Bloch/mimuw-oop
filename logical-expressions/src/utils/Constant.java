package utils;

public class Constant extends LogicalExpression {
    private boolean value;

    public Constant(boolean value) {
        this.value = value;
    }

    @Override
    public boolean evaluate(boolean x, boolean y) {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
