public class Main {
    public static void main(String[] args) {
        Variable var = new Variable();
        Sinus sin = new Sinus(var);
        Expression trigFunction = sin.getDivision(var);
        Expression dx = trigFunction.derivative();
        One one = new One();
        Expression rationalFunction = one.getDivision(var);
        Expression dx2 = rationalFunction.derivative();

        Constant constant1 = new Constant(5.0);
        Constant constant2 = new Constant(2.0);
        Zero zero = new Zero();

        Cosinus cosComposite = new Cosinus(var.getMultiplication(var));
        Expression expr = cosComposite.getSubtraction(var).
                getMultiplication(one.getAddition(constant1.getMultiplication(var))).
                getDivision(constant2.getAddition(zero).getAddition(var));

        Cosinus cos = new Cosinus(var);
        double area = cos.definiteIntegral(0, Math.PI / 2, 1000000);

        System.out.println("Derivative demo:");
        System.out.println("f(x) = " + trigFunction);
        System.out.println("f'(x) = " + dx);
        System.out.println("g(x) = " + rationalFunction);
        System.out.println("g'(x) = " + dx2);

        System.out.println();
        System.out.println("Value at point demo:");
        System.out.println("h(x) = " + expr);
        System.out.println("h(0.0) = " + expr.evaluate(0.0));

        System.out.println();
        System.out.println("Definite integration demo:");
        System.out.println("s(x) = " + sin);
        System.out.println("Integral of s(x) from 0 to pi/2 has value of " + area);
    }
}