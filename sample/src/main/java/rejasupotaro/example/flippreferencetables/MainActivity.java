package rejasupotaro.example.flippreferencetables;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import rejasupotaro.example.flippreferencestables.R;
import rejasupotaro.example.flippreferencetables.FlipPreferencesTables;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences prefs = getPrefs(this);
        writeDummyDate(prefs);

        StringBuilder builder = new StringBuilder();
        builder.append("(╯°□°）╯︵ ┻━┻\n\n");
        builder.append("[all]\n");
        builder.append(FlipPreferencesTables.of(prefs).all());
        builder.append("\n");
        builder.append("[in Foo]\n");
        builder.append(FlipPreferencesTables.of(prefs).in("Foo"));
        builder.append("\n");
        builder.append("[not in Foo]\n");
        builder.append(FlipPreferencesTables.of(prefs).notIn("Foo"));

        TextView textView = (TextView) findViewById(R.id.text);
        textView.setText(builder.toString());
    }

    private static SharedPreferences getPrefs(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context);
    }

    public static void clear(SharedPreferences prefs) {
        prefs.edit().clear();
    }

    public static void writeDummyDate(SharedPreferences prefs) {
        clear(prefs);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("Foo", "Bar");
        editor.putString("Kit", "Kat");
        editor.putString("Ping", "Pong");
        editor.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
