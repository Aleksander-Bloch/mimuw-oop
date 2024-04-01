package lista;

import pliki.ElementKatalogu;

import java.util.ArrayList;
import java.util.List;

public class ListaPlików {
    private final List<ElementKatalogu> pliki;

    public ListaPlików() {
        pliki = new ArrayList<>();
    }

    public void add(ElementKatalogu plik) {
        pliki.add(plik);
    }

    public void remove(ElementKatalogu plik) {
        for (int i = 0; i < pliki.size(); i++) {
            if (pliki.get(i) == plik) {
                pliki.remove(i);
                break;
            }
        }
    }

    public int ile() {
        return pliki.size();
    }

    public ElementKatalogu getPlik(int index) {
        return pliki.get(index);
    }

    public void clear() {
        pliki.clear();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (ElementKatalogu plik : pliki) {
            sb.append(plik);
        }
        return sb.toString();
    }
}
