package pliki;

public class Dowiązanie extends ElementKatalogu {
    private final PlikLubKatalog plik;

    public Dowiązanie(Katalog nadrzędny, PlikLubKatalog plik) {
        super(nadrzędny);
        this.plik = plik;
        plik.dodajDowiązanie(this);
    }

    public PlikLubKatalog getPlik() {
        return plik;
    }

    @Override
    public void usuń() {
        usuń(true);
    }

    void usuń(boolean czyInfoWPliku){
        if (czyInfoWPliku) {
            plik.usuńDowiązanie(this);
        }
        nadrzędny.usuńElement(this);
    }

    public void mv(Katalog nowyKatalog) {
        zmieńKatalogNadrzędny(nowyKatalog);
    }

    @Override
    public String toString() {
        return nadrzędny + "(" + plik.nazwa + ")/";
    }
}
