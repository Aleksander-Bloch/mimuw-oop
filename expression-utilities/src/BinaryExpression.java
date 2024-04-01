public abstract class BinaryExpression extends Expression {
    protected Expression arg1;
    protected Expression arg2;

    public BinaryExpression(Expression arg1, Expression arg2) {
        this.arg1 = arg1;
        this.arg2 = arg2;
    }

    protected abstract double execute(double value1, double value2);

    @Override
    public double evaluate(double value) {
        return execute(arg1.evaluate(value), arg2.evaluate(value));
    }

    public String toString(char operator) {
        int pl = arg1.getPriority(false);
        int pr = arg2.getPriority(true);
        StringBuilder sb = new StringBuilder();

        // Argument 1
        if (pl < this.getPriority(false)) {
            sb.append('(');
            sb.append(arg1.toString());
            sb.append(')');
        } else {
            sb.append(arg1.toString());
        }

        sb.append(operator);

        // Argument 2
        if (pr < this.getPriority(false)) {
            sb.append('(');
            sb.append(arg2.toString());
            sb.append(')');
        } else {
            sb.append(arg2.toString());
        }

        return sb.toString();
    }
}
