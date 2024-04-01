package utils;

public class Main {

    public static void main(String[] args) {
        Ulamek u1 = new Ulamek(1, 4);
        Ulamek u2 = new Ulamek(3, 4);
        u1.odejmij(u2);
        System.out.println(u1);
    }
}
