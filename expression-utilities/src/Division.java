public class Division extends BinaryExpression {

    public Division(Expression arg1, Expression arg2) {
        super(arg1, arg2);
    }

    @Override
    protected double execute(double value1, double value2) {
        return value1 / value2;
    }

    @Override
    protected int getPriority(boolean isRight) {
        return 10;
    }

    @Override
    public Expression derivative() {
        return arg1.derivative().getMultiplication(arg2).
                getSubtraction(arg1.getMultiplication(arg2.derivative())).
                getDivision(arg2.getMultiplication(arg2));
    }

    @Override
    public String toString() {
        return super.toString('/');
    }
}
