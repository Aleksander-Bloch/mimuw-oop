package utils;

public class Main {

    public static void main(String[] args) {
        Variable x = new Variable("x");
        Variable y = new Variable("y");
        LogicalAND and = new LogicalAND(x, y);
        LogicalOR or = new LogicalOR(x, y);
        LogicalAND and1 = new LogicalAND(and, or);
        LogicalNOT not = new LogicalNOT(and1);
        Constant c = new Constant(false);
        LogicalExpression expr = new LogicalAND(not, c);
        System.out.println(not);
        System.out.println(not.evaluate(true, false));
        System.out.println(expr);
        System.out.println(expr.evaluate(true, false));
    }
}
