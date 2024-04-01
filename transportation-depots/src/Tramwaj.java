public class Tramwaj extends PojazdKomunikacjiMiejskiej<Tramwaj> implements Wypisywalne{
    private final ZestawWagonów składKolejowy;

    public Tramwaj(ZestawWagonów składKolejowy, double szybkośćMaksymalna, int numer,
                   Zajezdnia<Tramwaj> miejsceGarażowania) {
        super(szybkośćMaksymalna, numer, miejsceGarażowania);
        miejsceGarażowania.garażuj(this);
        this.składKolejowy = składKolejowy;
    }

    @Override
    public String dajTypZajezdni() {
        return "Zajezdnia tramwajowa\n";
    }

    @Override
    public String dajTypPojazdu() {
        return "Tramwaj\n";
    }

    @Override
    public String toString() {
        return super.toString() + "Skład kolejowy: " + składKolejowy + '\n';
    }
}
