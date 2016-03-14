package impl.org.controlsfx.table;

import java.util.HashMap;

final class DupeCounter<T> {

    private final HashMap<T,Integer> counts = new HashMap<>();

    public int add(T value) {
        Integer prev = counts.get(value);
        int newVal;
        if (prev == null) {
            newVal = 1;
            counts.put(value, newVal);
        }  else {
            newVal = prev + 1;
            counts.put(value, newVal);
        }
        return newVal;
    }
    public int remove(T value) {
        Integer prev = counts.get(value);
        if (prev != null && prev > 0) {
            int newVal = prev - 1;
            if (newVal == 0) {
                counts.remove(value);
            } else {
                counts.put(value, newVal);
            }
            return newVal;
        }
        else {
            throw new IllegalStateException();
        }
    }
}