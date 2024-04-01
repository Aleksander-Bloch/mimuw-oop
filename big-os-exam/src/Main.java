import pliki.Dowiązanie;
import pliki.Katalog;
import pliki.Plik;

public class Main {
    public static void main(String[] args) {
        Katalog główny = new Katalog(null, "");
        Katalog dokumenty = new Katalog(główny, "Dokumenty");
        Katalog po = new Katalog(dokumenty, "po");
        Katalog macierze = new Katalog(po, "projekt-macierze");
        Katalog szybkość = new Katalog(po, "szybkość-programów");
        Katalog md = new Katalog(dokumenty, "Matematyka-Dyskretna");

        Plik sudoku = new Plik(po, "sudoku.c", 0x123, Plik.DO_PISANIA);
        Plik matrix_factory = new Plik(po, "DoubleMatrixFactory.java", 0xA3434);
        Plik diagram_zajezdnie = new Plik(dokumenty, "zajezdnie.dia", 0x111);
        Dowiązanie dowiązanie_diagram1 = new Dowiązanie(główny, diagram_zajezdnie);
        Dowiązanie dowiązanie_diagram2 = new Dowiązanie(dokumenty, diagram_zajezdnie);

        System.out.println("Symulacja systemu plików BigOS");
        System.out.println("Stan początkowy");
        główny.wypisz();

        sudoku.mv(szybkość);
        matrix_factory.mv(macierze);
        diagram_zajezdnie.mv(po);
        System.out.println();
        System.out.println("mv sudoku.c szybkość-programów");
        System.out.println("mv DoubleMatrixFactory.java projekt-macierze");
        System.out.println("mv zajezdnie.dia po");
        główny.wypisz();

        diagram_zajezdnie.usuń();
        System.out.println();
        System.out.println("rm zajezdnie.dia");
        główny.wypisz();

        po.rename("Programowanie-Obiektowe");
        System.out.println();
        System.out.println("rename po Programowanie-Obiektowe");
        główny.wypisz();

        po.usuń();
        System.out.println();
        System.out.println("rm Programowanie-Obiektowe");
        główny.wypisz();

        md.usuń();
        System.out.println();
        System.out.println("rm Matematyka-Dyskretna");
        główny.wypisz();
    }
}