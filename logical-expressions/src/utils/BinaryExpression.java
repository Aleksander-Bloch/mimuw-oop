package utils;

public abstract class BinaryExpression extends LogicalExpression {
    LogicalExpression arg1;
    LogicalExpression arg2;

    public BinaryExpression(LogicalExpression arg1, LogicalExpression arg2) {
        this.arg1 = arg1;
        this.arg2 = arg2;
    }

    public abstract String getOperator();

    public abstract boolean execute(boolean x, boolean y);

    @Override
    public boolean evaluate(boolean x, boolean y) {
        return execute(arg1.evaluate(x, y), arg2.evaluate(x, y));
    }

    @Override
    public String toString() {
        return "(" + arg1 + this.getOperator() + arg2 + ")";
    }
}
