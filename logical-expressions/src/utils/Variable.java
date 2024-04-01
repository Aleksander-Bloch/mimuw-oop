package utils;

public class Variable extends LogicalExpression {
    String name;

    public Variable(String name) {
        this.name = name;
    }

    @Override
    public boolean evaluate(boolean x, boolean y) {
        if(name.equals("x")) {
            return x;
        }
        else {
            return y;
        }
    }

    @Override
    public String toString() {
        return name;
    }
}
