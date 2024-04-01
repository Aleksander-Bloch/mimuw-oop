package pliki;

import lista.ListaPlików;

public class Katalog extends PlikLubKatalog {
    private final ListaPlików listaElementów;

    public Katalog(Katalog nadrzędny, String nazwa) {
        super(nadrzędny, nazwa);
        this.listaElementów = new ListaPlików();
    }

    void dodajElement(ElementKatalogu plik){
        listaElementów.add(plik);
    }

    void usuńElement(ElementKatalogu plik){
        listaElementów.remove(plik);
    }

    @Override
    public void usuń(){
        if (listaElementów.ile() == 0) {
            super.usuń();
        }
    }

    @Override
    public void wypisz() {
        System.out.println(this);
        int ileElementów = listaElementów.ile();
        for (int i = 0; i < ileElementów; i++) {
            listaElementów.getPlik(i).wypisz();
        }
    }
}
