public class StringCyclicBuffer implements StringUtilities<StringCyclicBuffer>{
    CyclicBuffer stringCB;

    public StringCyclicBuffer(String s) {
        stringCB = new CyclicBuffer(s.length());
        for (int i = 0; i < s.length(); i++) {
            stringCB.pushBack(s.charAt(i));
        }
    }

    public CyclicBuffer getBuffer() {
        return stringCB;
    }

    @Override
    public char charAtIndex(int index) {
        return (char)stringCB.lookupElementAtIndex(index);
    }

    @Override
    public void appendString(StringCyclicBuffer s) {
        CyclicBuffer appendBuffer = s.getBuffer();
        for (int i = 0; i < appendBuffer.getSize(); i++) {
            stringCB.pushBack(appendBuffer.lookupElementAtIndex(i));
        }
    }

    @Override
    public void insertString(StringCyclicBuffer s, int start) {
        CyclicBuffer insertBuffer = s.getBuffer();
        CyclicBuffer buffer = new CyclicBuffer(insertBuffer.getSize() + stringCB.getSize());
        while (start > 0) {
            buffer.pushBack(stringCB.popFront());
            start--;
        }
        for (int i = 0; i < insertBuffer.getSize(); i++) {
            buffer.pushBack(insertBuffer.lookupElementAtIndex(i));
        }
        while (!stringCB.isEmpty()) {
            buffer.pushBack(stringCB.popFront());
        }
        stringCB = buffer;
    }

    @Override
    public void eraseStringInRange(int start, int end) {
        int range = end - start + 1;
        CyclicBuffer buffer = new CyclicBuffer(stringCB.getSize() - range);
        while (start > 0) {
            buffer.pushBack(stringCB.popFront());
            start--;
        }
        while (range > 0) {
            stringCB.popFront();
            range--;
        }
        while (!stringCB.isEmpty()) {
            buffer.pushBack(stringCB.popFront());
        }
        stringCB = buffer;
    }

    @Override
    public StringCyclicBuffer createStringInRange(int start, int end) {
        StringCyclicBuffer buffer = new StringCyclicBuffer("");
        for (int i = start; i <= end; i++) {
            buffer.getBuffer().pushBack(stringCB.lookupElementAtIndex(i));
        }
        return buffer;
    }

    public static int lexCompareStrings(StringCyclicBuffer s1, StringCyclicBuffer s2) {
        int i = 0;
        CyclicBuffer buffer1 = s1.getBuffer();
        CyclicBuffer buffer2 = s2.getBuffer();

        while (i < Math.min(buffer1.getSize(), buffer2.getSize()) &&
                (char)buffer1.lookupElementAtIndex(i) ==
                        (char)buffer2.lookupElementAtIndex(i)) {
            i++;
        }
        if (i < Math.min(buffer1.getSize(), buffer2.getSize())) {
            return Character.compare((char) buffer1.lookupElementAtIndex(i),
                    (char) buffer2.lookupElementAtIndex(i));
        }
        else {
            return Integer.compare(buffer1.getSize(), buffer2.getSize());
        }
    }

    @Override
    public String toString() {
        return stringCB.toString();
    }
}
