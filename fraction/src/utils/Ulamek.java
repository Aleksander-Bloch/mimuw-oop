package utils;

public class Ulamek {
    private int licznik;
    private int mianownik;

    Ulamek(int licznik, int mianownik) {
        this.licznik = licznik;
        this.mianownik = mianownik;
        if(mianownik == 0) {
            // dzielenie przez zero
        }
        skroc();
    }

    public int getLicznik() {
        return licznik;
    }

    public int getMianownik() {
        return mianownik;
    }

    public int nwd(int a, int b) {
        if (a == 0)
            return b;
        return nwd(b % a, a);
    }

    public void skroc() {
        int dzielnik = nwd(licznik, mianownik);
        licznik /= dzielnik;
        mianownik /= dzielnik;
        if(mianownik < 0) {
            licznik = -licznik;
            mianownik = -mianownik;
        }
    }

    public void dodaj(Ulamek u) {
        int nowyMianownik = mianownik * u.getMianownik();
        int nowyLicznik = licznik * u.getMianownik() + u.getLicznik() * mianownik;
        licznik = nowyLicznik;
        mianownik = nowyMianownik;
        skroc();
    }

    public void odejmij(Ulamek u) {
        int nowyMianownik = mianownik * u.getMianownik();
        int nowyLicznik = licznik * u.getMianownik() - u.getLicznik() * mianownik;
        licznik = nowyLicznik;
        mianownik = nowyMianownik;
        skroc();
    }

    public void pomnoz(Ulamek u) {
        licznik = licznik * u.getLicznik();
        mianownik = mianownik * u.getMianownik();
        skroc();
    }

    public void podziel(Ulamek u) {
        licznik = licznik * u.getMianownik();
        mianownik = mianownik * u.getLicznik();
        skroc();
    }

    @Override
    public String toString() {
        if(licznik == 0) {
            return "0";
        }
        else {
            return licznik + "/" + mianownik;
        }
    }
}
