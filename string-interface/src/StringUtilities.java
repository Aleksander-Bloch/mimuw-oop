public interface StringUtilities<StringContainer> {
    char charAtIndex(int index);
    void appendString(StringContainer s);
    void insertString(StringContainer s, int start);
    void eraseStringInRange(int start, int end);
    StringContainer createStringInRange(int start, int end);
}
