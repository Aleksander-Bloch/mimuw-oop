import java.util.ArrayList;
import java.util.List;

public class PowerList<T> {
    private final List<List<T>> powerList;

    public PowerList(T[] elements) {
        powerList = new ArrayList<>();
        int size = elements.length;
        for (int i = 0; i < 1 << size; i++) {
            powerList.add(new ArrayList<>());
            for (int j = 0; j < size; j++) {
                if ((i & (1 << j)) > 0) {
                    powerList.get(i).add(elements[j]);
                }
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (List<T> list : powerList) {
            sb.append("{");
            for (T element : list) {
                sb.append(element).append(",");
            }
            if (!list.isEmpty()) {
                sb.deleteCharAt(sb.length() - 1);
            }
            sb.append("},");
        }
        if (!powerList.isEmpty()) {
            sb.deleteCharAt(sb.length() - 1);
        }
        sb.append("}");
        return sb.toString();
    }
}
