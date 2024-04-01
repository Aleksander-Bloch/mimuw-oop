package utils;

public class Main {

    public static void main(String[] args) {

        int[] wspolczynniki1 = {1, 0, 1};
        int[] wspolczynniki2 = {0, -1, -1};
	    Wielomian w1 = new Wielomian(wspolczynniki1);
        Wielomian w2 = new Wielomian(wspolczynniki2);

        Wielomian suma = w1.dodaj(w2);
        Wielomian iloczyn = w1.pomnoz(w2);

        System.out.println(w1);
        System.out.println(w2);
        System.out.println(w1.policzWPunkcie(1));
        System.out.println(w2.policzWPunkcie(-1));
        System.out.println(suma);
        System.out.println(iloczyn);
    }
}
