public abstract class PojazdKomunikacjiMiejskiej <T extends Wypisywalne> extends Pojazd {
    private final int numer;
    private final Zajezdnia<T> miejsceGarażowania;

    public PojazdKomunikacjiMiejskiej(double szybkośćMaksymalna, int numer,
                                      Zajezdnia<T> miejsceGarażowania) {
        super(szybkośćMaksymalna);
        this.numer = numer;
        this.miejsceGarażowania = miejsceGarażowania;
    }

    @Override
    public String toString() {
        return  super.toString() +
                "Numer: " + numer + '\n' +
                "Miejsce garażowania: " + miejsceGarażowania.getNazwa() + '\n';
    }
}
