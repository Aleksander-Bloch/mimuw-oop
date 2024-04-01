package utils;

public class LogicalOR extends BinaryExpression {
    public LogicalOR(LogicalExpression arg1, LogicalExpression arg2) {
        super(arg1, arg2);
    }

    @Override
    public String getOperator() {
        return "||";
    }

    @Override
    public boolean execute(boolean x, boolean y) {
        return x || y;
    }
}
