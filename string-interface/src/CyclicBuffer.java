public class CyclicBuffer {
    private int capacity;
    private int size = 0;
    private int head = 0;
    private int tail = -1;
    private Object[] array;

    public CyclicBuffer(int capacity) {
        this.capacity = capacity;
        array = new Object[capacity];
    }

    public int getSize() {
        return size;
    }

    private void increaseCapacity() {
        Object[] temp = new Object[capacity * 2 + 1];
        int pointer = head;
        int index = 0;
        while (pointer != tail && size > 0) {
            temp[index] = array[pointer];
            pointer = (pointer + 1) % capacity;
            index++;
        }
        if (size > 0) {
            temp[index] = array[pointer];
        }
        array = temp;
        capacity = capacity * 2 + 1;
        head = 0;
        tail = size - 1;
    }

    public void pushBack(Object element) {
        if (size == capacity) {
            increaseCapacity();
        }
        int index = (tail + 1) % capacity;
        array[index] = element;
        size++;
        tail = index;
    }

    public Object popFront() {
        Object deleted = array[head];
        head = (head + 1) % capacity;
        size--;
        return deleted;
    }

    public Object lookupElementAtIndex(int index) {
        return array[(head + index) % capacity];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        int i = head;
        while (i != tail) {
            sb.append(array[i]);
            i = (i + 1) % capacity;
        }
        sb.append(array[i]);
        return sb.toString();
    }
}
