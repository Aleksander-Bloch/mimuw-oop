package pliki;

import lista.ListaPlików;

public class PlikLubKatalog extends ElementKatalogu {
    protected String nazwa;
    protected ListaPlików dowiązania;

    public PlikLubKatalog(Katalog nadrzędny, String nazwa) {
        super(nadrzędny);
        this.nazwa = nazwa;
        this.dowiązania = new ListaPlików();
    }

    @Override
    public void usuń(){
        int ileDowiązań = dowiązania.ile();
        for (int i = 0; i < ileDowiązań; i++) {
            ((Dowiązanie)dowiązania.getPlik(i)).usuń(false);
        }
        dowiązania.clear();
        nadrzędny.usuńElement(this);
    }

    protected void dodajDowiązanie(Dowiązanie dowiązanie){
        dowiązania.add(dowiązanie);
    }

    protected void usuńDowiązanie(Dowiązanie dowiązanie){
        dowiązania.remove(dowiązanie);
    }

    public void rename(String nowaNazwa){
        nazwa = nowaNazwa;
    }

    public String toString(){
        if (nadrzędny == null) {
            return "~/";
        }
        return nadrzędny + nazwa + "/";
    }

    @Override
    public void wypisz(){
        System.out.println(this);
    }
}
