package utils;
import java.util.Arrays;

public class Wielomian {
    private int[] wspolczynniki;

    public Wielomian(int[] wspolczynniki) {
        this.wspolczynniki = Arrays.copyOfRange(wspolczynniki, 0, wspolczynniki.length);
    }

    public int[] getWspolczynniki() {
        return wspolczynniki;
    }

    public Wielomian dodaj(Wielomian w) {
        int[] noweWspolczynniki;
        if(wspolczynniki.length > w.getWspolczynniki().length) {
            noweWspolczynniki = Arrays.copyOfRange(wspolczynniki, 0, wspolczynniki.length);
            for(int i = 0; i < w.getWspolczynniki().length; i++) {
                noweWspolczynniki[i] += w.getWspolczynniki()[i];
            }
        }
        else {
            noweWspolczynniki = Arrays.copyOfRange(w.getWspolczynniki(), 0, w.getWspolczynniki().length);
            for(int i = 0; i < wspolczynniki.length; i++) {
                noweWspolczynniki[i] += wspolczynniki[i];
            }
        }
        return new Wielomian(noweWspolczynniki);
    }

    public int policzWPunkcie(int x) {
        int wynik = 0;
        for(int i = 0; i < wspolczynniki.length; i++) {
            wynik += wspolczynniki[i] * Math.pow(x, i);
        }
        return wynik;
    }

    //(1 + x + 5x^2) * (2 + 3x)

    public Wielomian pomnoz(Wielomian w) {
        int maxPower = wspolczynniki.length + w.getWspolczynniki().length - 1;
        int[] noweWspolczynniki = new int[maxPower];

        for(int i = 0; i < wspolczynniki.length; i++) {
            for(int j = 0; j < w.getWspolczynniki().length; j++) {
                noweWspolczynniki[i + j] += wspolczynniki[i] * w.getWspolczynniki()[j];
            }
        }

        return new Wielomian(noweWspolczynniki);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < wspolczynniki.length; i++) {
            if(wspolczynniki[i] != 0) {
                sb.append(wspolczynniki[i]);
                if(i != 0) {
                    sb.append("x^" + i);
                }
                if(i != wspolczynniki.length - 1) {
                    sb.append(" + ");
                }
            }
        }
        return sb.toString();
    }
}
