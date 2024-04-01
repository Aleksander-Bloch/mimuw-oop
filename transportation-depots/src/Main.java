public class Main {
    public static void main(String[] args) {
        final var zajezdniaAutobusowa1 = new Zajezdnia<Autobus>("Ostrobramska");
        final var autobus11 = new Autobus(100, 60, 523, zajezdniaAutobusowa1);
        final var autobus12 = new Autobus(99.99, 75.6, 182, zajezdniaAutobusowa1);
        final var autobus13 = new Autobus(87.3, 77.7, 187, zajezdniaAutobusowa1);

        final var zajezdniaAutobusowa2 = new Zajezdnia<Autobus>("Woronicza");
        final var autobus21 = new Autobus(87, 120.22, 189, zajezdniaAutobusowa2);
        final var autobus22 = new Autobus(200, 121, 402, zajezdniaAutobusowa2);

        final var zajezdniaAutobusowa3 = new Zajezdnia<Autobus>("Inflancka");

        final var zajezdniaTramwajowa1 = new Zajezdnia<Tramwaj>("Mokotów");
        final var tramwaj11 = new Tramwaj(ZestawWagonów.DWA_WAGONY, 40.4, 18, zajezdniaTramwajowa1);
        final var tramwaj12 = new Tramwaj(ZestawWagonów.JEDEN_WAGON, 50.5, 14, zajezdniaTramwajowa1);
        final var tramwaj13 = new Tramwaj(ZestawWagonów.TRZY_WAGONY, 43.3, 15, zajezdniaTramwajowa1);

        final var zajezdniaTramwajowa2 = new Zajezdnia<Tramwaj>("Żoliborz");

        System.out.println(zajezdniaAutobusowa1);
        System.out.println(zajezdniaTramwajowa1);
        System.out.println(zajezdniaAutobusowa2);
        System.out.println(zajezdniaTramwajowa2);
        System.out.println(zajezdniaAutobusowa3);
    }
}