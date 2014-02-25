package rejasupotaro.flippreferencestables;

import com.jakewharton.fliptables.FlipTables;

import android.content.SharedPreferences;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class PreferencesTables {

    private static final String[] HEADERS = {"key", "value"};

    private SharedPreferences prefs;

    private List<KeyValue> rows = new ArrayList<KeyValue>();

    public static PreferencesTables makeTable(SharedPreferences prefs) {
        return new PreferencesTables(prefs);
    }

    private PreferencesTables(SharedPreferences prefs) {
        this.prefs = prefs;
    }

    public FlipTables all() {
        Map<String, ?> map = prefs.getAll();
        String[] keys = toArray(map.keySet());
        String[] values = toArray(map.values());

        for (int i = 0; i < map.size(); i++) {
            rows.add(new KeyValue(keys[i], values[i]));
        }

        return FlipTables.makeTable(HEADERS, toArray(rows));
    }

    public FlipTables in(String... containsKeys) {
        Map<String, ?> map = prefs.getAll();
        String[] keys = toArray(map.keySet());
        String[] values = toArray(map.values());

        for (int i = 0; i < map.size(); i++) {
            if (contains(containsKeys, keys[i])) {
                rows.add(new KeyValue(keys[i], values[i]));
            }
        }

        return FlipTables.makeTable(HEADERS, toArray(rows));
    }

    public FlipTables notIn(String... containsKeys) {
        Map<String, ?> map = prefs.getAll();
        String[] keys = toArray(map.keySet());
        String[] values = toArray(map.values());

        for (int i = 0; i < map.size(); i++) {
            if (!contains(containsKeys, keys[i])) {
                rows.add(new KeyValue(keys[i], values[i]));
            }
        }

        return FlipTables.makeTable(HEADERS, toArray(rows));
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
