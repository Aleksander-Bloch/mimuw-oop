package utils;

public class LogicalNOT extends UnaryExpression {
    public LogicalNOT(LogicalExpression arg) {
        super(arg);
    }

    @Override
    public String getOperator() {
        return "!";
    }

    public boolean evaluate(boolean x, boolean y) {
        return !arg.evaluate(x, y);
    }
}
