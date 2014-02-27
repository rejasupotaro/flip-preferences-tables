package rejasupotaro.flippreferencestables;

import com.jakewharton.fliptables.FlipTable;

import android.content.SharedPreferences;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class FlipPreferencesTables {

    private static final String[] HEADERS = {"key", "value"};

    private String[] keys;

    private String[] values;

    private List<KeyValue> rows = new ArrayList<KeyValue>();

    public static FlipPreferencesTables of(SharedPreferences prefs) {
        return new FlipPreferencesTables(prefs);
    }

    private FlipPreferencesTables(SharedPreferences prefs) {
        Map<String, ?> map = prefs.getAll();
        keys = toArray(map.keySet());
        values = toArray(map.values());
    }

    public String all() {
        for (int i = 0; i < keys.length; i++) {
            rows.add(new KeyValue(keys[i], values[i]));
        }

        return FlipTable.of(HEADERS, toArray(rows));
    }

    public String in(String... containsKeys) {
        for (int i = 0; i < keys.length; i++) {
            if (contains(containsKeys, keys[i])) {
                rows.add(new KeyValue(keys[i], values[i]));
            }
        }

        return FlipTable.of(HEADERS, toArray(rows));
    }

    public String notIn(String... containsKeys) {
        for (int i = 0; i < keys.length; i++) {
            if (!contains(containsKeys, keys[i])) {
                rows.add(new KeyValue(keys[i], values[i]));
            }
        }

        return FlipTable.of(HEADERS, toArray(rows));
    }

    private String[] toArray(Collection<?> collection) {
        return collection.toArray(new String[0]);
    }

    private String[][] toArray(List<KeyValue> rows) {
        String[][] data = new String[rows.size()][2];
        for (int i = 0; i < rows.size(); i++) {
            KeyValue column = rows.get(i);
            data[i][0] = column.getKey();
            data[i][1] = column.getValue();
        }
        return data;
    }

    private boolean contains(String[] containsKeys, String key) {
        for (int i = 0; i < containsKeys.length; i++) {
            if (containsKeys[i].equals(key)) {
                return true;
            }
        }
        return false;
    }
}
