package com.s626.archery;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void openTarget(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, TargetActivity.class);
        startActivity(intent);
    }

    public void openTable(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, TableActivity.class);
        startActivity(intent);
    }

    public void openResults(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, ViewResults.class);
        startActivity(intent);
    }
}
