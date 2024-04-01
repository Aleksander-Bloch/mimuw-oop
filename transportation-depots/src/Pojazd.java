public abstract class Pojazd {
    private final double szybkośćMaksymalna;

    public Pojazd(double szybkośćMaksymalna) {
        this.szybkośćMaksymalna = szybkośćMaksymalna;
    }

    @Override
    public String toString() {
        return "Szybkość maksymalna: " + szybkośćMaksymalna + "km/h\n";
    }
}
