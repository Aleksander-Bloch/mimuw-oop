package utils;

public class LogicalAND extends BinaryExpression {
    public LogicalAND(LogicalExpression arg1, LogicalExpression arg2) {
        super(arg1, arg2);
    }

    @Override
    public String getOperator() {
        return "&&";
    }

    @Override
    public boolean execute(boolean x, boolean y) {
        return x && y;
    }
}
