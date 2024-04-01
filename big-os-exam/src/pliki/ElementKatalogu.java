package pliki;

public abstract class ElementKatalogu {
    protected Katalog nadrzędny;

    public ElementKatalogu(Katalog nadrzędny) {
        this.nadrzędny = nadrzędny;
        if (nadrzędny != null) {
            nadrzędny.dodajElement(this);
        }
    }

    protected void zmieńKatalogNadrzędny(Katalog nowyKatalog) {
        nadrzędny.usuńElement(this);
        nadrzędny = nowyKatalog;
        nadrzędny.dodajElement(this);
    }

    public abstract void usuń();

    public void wypisz(){
        System.out.println(this);
    }
}
