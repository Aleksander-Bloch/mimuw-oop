public class Autobus extends PojazdKomunikacjiMiejskiej<Autobus> implements Wypisywalne {

    private final double zużyciePaliwaWMiesiącu;

    public Autobus(double zużyciePaliwaWMiesiącu, double szybkośćMaksymalna, int numer,
                   Zajezdnia<Autobus> miejsceGarażowania) {
        super(szybkośćMaksymalna, numer, miejsceGarażowania);
        miejsceGarażowania.garażuj(this);
        this.zużyciePaliwaWMiesiącu = zużyciePaliwaWMiesiącu;
    }

    @Override
    public String dajTypZajezdni() {
        return "Zajezdnia autobusowa\n";
    }

    @Override
    public String dajTypPojazdu() {
        return "Autobus\n";
    }

    @Override
    public String toString() {
        return super.toString() + "Zużycie paliwa w miesiącu: " + zużyciePaliwaWMiesiącu + "l\n";
    }
}
