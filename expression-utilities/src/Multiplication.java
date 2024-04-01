public class Multiplication extends BinaryExpression {

    public Multiplication(Expression arg1, Expression arg2) {
        super(arg1, arg2);
    }

    @Override
    protected double execute(double value1, double value2) {
        return value1 * value2;
    }

    @Override
    protected int getPriority(boolean isRight) {
        if (isRight) {
            return 9;
        } else {
            return 10;
        }
    }

    @Override
    public Expression derivative() {
        return arg1.derivative().getMultiplication(arg2).
                getAddition(arg1.getMultiplication(arg2.derivative()));
    }

    @Override
    public String toString() {
        return super.toString('*');
    }
}
