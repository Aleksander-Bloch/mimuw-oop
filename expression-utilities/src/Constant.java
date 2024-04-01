public class Constant extends Expression {
    private double value;

    public Constant(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    @Override
    protected int getPriority(boolean isRight) {
        return 100;
    }

    @Override
    public double evaluate(double value) {
        return this.value;
    }

    @Override
    public Expression derivative() {
        return new Zero();
    }

    @Override
    public String toString() {
        return Double.toString(value);
    }
}
