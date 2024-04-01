public class Minus extends UnaryExpression {

    public Minus(Expression arg) {
        super(arg);
    }

    @Override
    protected int getPriority(boolean isRight) {
        return 100;
    }

    @Override
    public double evaluate(double value) {
        return -arg.evaluate(value);
    }

    @Override
    public Expression derivative() {
        return new Minus(arg.derivative());
    }

    @Override
    public String toString() {
        return super.toString("-");
    }
}
