public class Addition extends BinaryExpression {
    public Addition(Expression arg1, Expression arg2) {
        super(arg1, arg2);
    }

    @Override
    protected double execute(double value1, double value2) {
        return value1 + value2;
    }

    @Override
    protected int getPriority(boolean isRight) {
        return 1;
    }

    @Override
    public Expression derivative() {
        return arg1.derivative().getAddition(arg2.derivative());
    }

    @Override
    public String toString() {
        return super.toString('+');
    }
}
