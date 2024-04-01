public class Main {
    public static void main(String[] args) {
        final var powerNumbers = new PowerList<>(new Integer[] {1024, 2048, 2 << 13});
        final var powerChars = new PowerList<>(new Character[] {'\uffe1', '\u20ac', '\uff04'});
        final var powerStrings = new PowerList<>(new String[] {"#Collections", "#Java", "#OOP"});
        System.out.println(powerNumbers);
        System.out.println(powerChars);
        System.out.println(powerStrings);
    }
}