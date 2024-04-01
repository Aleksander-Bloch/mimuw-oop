package pliki;

public class Plik extends PlikLubKatalog {
    public static final int DO_NICZEGO = 0;
    public static final int DO_CZYTANIA = 1;
    public static final int DO_PISANIA = 2;

    private final long pozycja;
    private int prawa;


    public Plik(Katalog nadrzędny, String nazwa, long pozycja, int prawa) {
        super(nadrzędny, nazwa);
        this.pozycja = pozycja;
        this.prawa = prawa;
    }

    public Plik(Katalog nadrzędny, String nazwa, long pozycja) {
        super(nadrzędny, nazwa);
        this.pozycja = pozycja;
        this.prawa = DO_CZYTANIA;
    }

    public void chmod(int nowePrawa){
        prawa = nowePrawa;
    }

    public void mv(Katalog nowyKatalog) {
        zmieńKatalogNadrzędny(nowyKatalog);
    }
}
