package utils;

public abstract class UnaryExpression extends LogicalExpression {
    LogicalExpression arg;

    public UnaryExpression(LogicalExpression arg) {
        this.arg = arg;
    }

    public abstract String getOperator();

    @Override
    public String toString() {
        return this.getOperator() + "(" + arg + ")";
    }
}
