public class Main {
    public static void main(String[] args) {
        StringCyclicBuffer original = new StringCyclicBuffer("Original");
        StringCyclicBuffer left = new StringCyclicBuffer("Left");
        StringCyclicBuffer right = new StringCyclicBuffer("Right");
        StringCyclicBuffer middle = new StringCyclicBuffer("Middle");

        System.out.println("Original string: " + original);

        int index = 3;
        System.out.println("Character at index " + index + ": " + original.charAtIndex(index));

        original.insertString(left, 0);
        System.out.println("Inserting string to the left: " + original);

        original.appendString(right);
        System.out.println("Appending string: " + original);

        original.insertString(middle, 4);
        System.out.println("Inserting string in the middle: " + original);

        original.eraseStringInRange(10, 17);
        System.out.println("Erasing original string: " + original);

        StringCyclicBuffer riddle = new StringCyclicBuffer("Riddle");
        System.out.println("First string for comparison: " + right);
        System.out.println("Second string for comparison: " + riddle);
        int compareResult = StringCyclicBuffer.lexCompareStrings(right, riddle);
        if(compareResult == 0) {
            System.out.println("Strings are equal.");
        }
        else if(compareResult > 0) {
            System.out.println("First string is lexicographically greater.");
        }
        else {
            System.out.println("First string is lexicographically smaller.");
        }

        StringCyclicBuffer id = middle.createStringInRange(1, 2);
        System.out.println("Creating id from middle: " + id);
    }
}