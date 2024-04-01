public class Cosinus extends UnaryExpression {

    public Cosinus(Expression arg) {
        super(arg);
    }

    @Override
    protected int getPriority(boolean isRight) {
        return 100;
    }

    @Override
    public double evaluate(double value) {
        return Math.cos(arg.evaluate(value));
    }

    @Override
    public Expression derivative() {
        return new Minus(new Sinus(arg)).getMultiplication(arg.derivative());
    }

    @Override
    public String toString() {
        return super.toString("cos");
    }
}
