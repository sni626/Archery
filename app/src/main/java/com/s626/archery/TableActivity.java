package com.s626.archery;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.Vector;


public class TableActivity extends ActionBarActivity {

    //Test data
    String[][] arrows = {
            {"6", "7", "8", "9", "10", "11", " "},
            {"1", "3", "4", "5", "6", "4", " "}
    };

    Vector<ListRow6> listRow6s = new Vector<>();
    CustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table);
        ListView lvTarget = (ListView) findViewById(R.id.listView);

        //adding by passing independent parameters
        listRow6s.add(new ListRow6("1", "3", "4", "5", "6", "4", " "));

        String tmpArrows = listRow6s.get(0).rowTotal;

        //adding by passing massive
        listRow6s.add(new ListRow6(arrows[0]));

        //Calculating Total of two rows and setting it into a Vector
        arrows[0][6] = String.valueOf(Integer.parseInt(tmpArrows) + Integer.parseInt(listRow6s.get(1).rowTotal));
        listRow6s.set(1, new ListRow6(arrows[0]));

// Connect adapter to the ListView
        adapter = new CustomAdapter(TableActivity.this, R.layout.list_item_row, listRow6s);
        lvTarget.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_table, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void openScoring(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, ScoringActivity.class);
        startActivity(intent);
    }
}
