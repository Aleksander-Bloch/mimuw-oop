public class Variable extends Expression {
    @Override
    protected int getPriority(boolean isRight) {
        return 100;
    }

    @Override
    public double evaluate(double value) {
        return value;
    }

    @Override
    public Expression derivative() {
        return new One();
    }

    @Override
    public String toString() {
        return "x";
    }
}
