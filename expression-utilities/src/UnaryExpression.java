public abstract class UnaryExpression extends Expression {
    protected Expression arg;

    public UnaryExpression(Expression arg) {
        this.arg = arg;
    }

    public String toString(String operator) {
        int p = arg.getPriority(false);
        StringBuilder sb = new StringBuilder();

        sb.append(operator);
        if (p < this.getPriority(false)) {
            sb.append('(');
            sb.append(arg.toString());
            sb.append(')');
        } else {
            sb.append(arg.toString());
        }

        return sb.toString();
    }
}
