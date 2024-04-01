public class Sinus extends UnaryExpression {

    public Sinus(Expression arg) {
        super(arg);
    }

    @Override
    protected int getPriority(boolean isRight) {
        return 100;
    }

    @Override
    public double evaluate(double value) {
        return Math.sin(arg.evaluate(value));
    }

    @Override
    public Expression derivative() {
        return new Cosinus(arg).getMultiplication(arg.derivative());
    }

    @Override
    public String toString() {
        return super.toString("sin");
    }
}
