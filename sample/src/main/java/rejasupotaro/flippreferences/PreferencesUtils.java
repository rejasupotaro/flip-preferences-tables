package rejasupotaro.flippreferences;

import com.jakewharton.fliptables.FlipTables;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;

import java.util.List;
import java.util.Map;

public final class PreferencesUtils {

    private static SharedPreferences getPrefs(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context);
    }

    public static void clear(Context context) {
        getPrefs(context).edit().clear();
    }

    public static void writeDummyDate(Context context) {
        clear(context);
        SharedPreferences prefs = getPrefs(context);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("Foo", "Bar");
        editor.putString("Kit", "Kat");
        editor.putString("Ping", "Pong");
        editor.commit();
    }

    public static void dump(Context context) {
        SharedPreferences prefs = getPrefs(context);
        Map<String, ?> map = prefs.getAll();
        String[] keys = map.keySet().toArray(new String[0]);
        String[] values = map.values().toArray(new String[0]);

        String[][] data = new String[3][2];
        for (int i = 0; i < map.size(); i++) {
            data[i][0] = keys[i];
            data[i][1] = values[i];
        }

        String[] headers = {"key", "value"};
        Log.d("DEBUG", FlipTables.makeTable(headers, data).toString());
    }

    private PreferencesUtils() {}
}
