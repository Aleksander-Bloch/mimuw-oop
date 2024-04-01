public abstract class Expression {
    protected abstract int getPriority(boolean isRight);

    public abstract double evaluate(double value);

    public abstract Expression derivative();

    public Expression getAddition(Expression expr) {
        if (this instanceof Zero) {
            return expr;
        }
        if (expr instanceof Zero) {
            return this;
        }
        if (this instanceof Constant && expr instanceof Constant) {
            return new Constant(((Constant) this).getValue() + ((Constant) expr).getValue());
        }
        return new Addition(this, expr);
    }

    public Expression getSubtraction(Expression expr) {
        if (this instanceof Zero) {
            return new Minus(expr);
        }
        if (expr instanceof Zero) {
            return this;
        }
        if (this instanceof Constant && expr instanceof Constant) {
            return new Constant(((Constant) this).getValue() - ((Constant) expr).getValue());
        }
        return new Subtraction(this, expr);
    }

    public Expression getMultiplication(Expression expr) {
        if (this instanceof Zero) {
            return this;
        }
        if (expr instanceof Zero) {
            return expr;
        }
        if (this instanceof One) {
            return expr;
        }
        if (expr instanceof One) {
            return this;
        }
        if (this instanceof Constant && expr instanceof Constant) {
            return new Constant(((Constant) this).getValue() * ((Constant) expr).getValue());
        }
        return new Multiplication(this, expr);
    }

    public Expression getDivision(Expression expr) {
        if (this instanceof Zero || expr instanceof One) {
            return this;
        }
        if (this instanceof Constant && expr instanceof Constant) {
            return new Constant(((Constant) this).getValue() / ((Constant) expr).getValue());
        }
        return new Division(this, expr);
    }

    public double definiteIntegral(double a, double b, int numTrapezoids) {
        double delta = (b - a) / numTrapezoids;
        double x = a + delta;
        double accumulator = 0;
        for (int i = 0; i < numTrapezoids - 1; i++) {
            accumulator += this.evaluate(x);
            x += delta;
        }
        accumulator += (this.evaluate(a) + this.evaluate(b)) / 2;
        return accumulator * delta;
    }
}
