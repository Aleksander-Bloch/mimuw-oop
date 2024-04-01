public class Zero extends Constant {

    public Zero() {
        super(0.0);
    }

    @Override
    public double evaluate(double value) {
        return 0.0;
    }
}
