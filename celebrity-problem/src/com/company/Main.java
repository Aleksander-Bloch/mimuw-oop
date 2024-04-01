package com.company;

public class Main {

    public static void main(String[] args) {
        int n = 5;
        boolean[][] zna = {
                {true, false, false, true, false},
                {false, true, true, true, false},
                {false, true, true, true, true},
                {true, false, false, true, false},
                {false, false, false, true, true}
        };
        wypiszMacierz(zna);
        int osoba = osobistosc(zna, n);
        if(osoba == -1) {
            System.out.println("Nie znaleziono osobistosci!");
        }
        else {
            System.out.println("Osobistosc to osoba o indeksie " + osoba);
        }
    }

    private static void wypiszMacierz(boolean[][] zna) {
        System.out.println("Tablica osobistosci:");
        for(int i = 0; i < zna.length; i++) {
            for(int j = 0; j < zna[i].length; j++) {
                System.out.print(zna[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static int osobistosc(boolean[][] zna, int n) {
        int i = 0;
        int j = n - 1;
        while(i < j) {
            if(zna[j][i]) {
                j--;
            }
            else {
                i++;
            }
        }
        int kandydat = i;
        for (i = 0; i < n; i++) {
            if (i != kandydat) {
                if (zna[i][kandydat] == false || zna[kandydat][i] == true)
                    return -1;
            }
        }
        return kandydat;
    }
}
