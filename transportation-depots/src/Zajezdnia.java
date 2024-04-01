import java.util.ArrayList;
import java.util.List;

public class Zajezdnia<T extends Wypisywalne> {
    private final String nazwa;
    private final List<T> garażowanePojazdy;

    public Zajezdnia(String nazwa) {
        this.nazwa = nazwa;
        garażowanePojazdy = new ArrayList<>();
    }

    public void garażuj(T pojazd) {
        garażowanePojazdy.add(pojazd);
    }

    public String getNazwa() {
        return nazwa;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("==================OPIS ZAJEZDNI==================\n");
        sb.append("Nazwa zajezdni: ").append(nazwa).append('\n');
        sb.append("Typ zajezdni: ");
        if (garażowanePojazdy.size() == 0) {
            sb.append("Pusta zajezdnia\n");
        } else {
            sb.append(garażowanePojazdy.get(0).dajTypZajezdni());
            sb.append('\n');
        }
        for (T pojazd : garażowanePojazdy) {
            sb.append(pojazd.dajTypPojazdu());
            sb.append(pojazd);
            sb.append("\n");
        }
        return sb.toString();
    }
}
