package com.s626.archery;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class ScoringActivity extends ActionBarActivity implements View.OnClickListener {
    String arrows[];
    Integer count = 0;
    Integer total = 0;


    TextView textViewS1, textViewS2, textViewS3,
            textViewS4, textViewS5, textViewS6, textView_totalS1;
    Button button1, button2, button3, button4, button5,
            button6, button7, button8, button9, button10,
            button_M, button_X;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scoring);

        textViewS1 = (TextView) findViewById(R.id.textViewS1);
        textViewS2 = (TextView) findViewById(R.id.textViewS2);
        textViewS3 = (TextView) findViewById(R.id.textViewS3);
        textViewS4 = (TextView) findViewById(R.id.textViewS4);
        textViewS5 = (TextView) findViewById(R.id.textViewS5);
        textViewS6 = (TextView) findViewById(R.id.textViewS6);
        textView_totalS1 = (TextView) findViewById(R.id.textView_totalS1);

//        button1 = (Button)findViewById(R.id.button1);
//        button2 = (Button)findViewById(R.id.button2);
//        button3 = (Button)findViewById(R.id.button3);
//        button4 = (Button)findViewById(R.id.button4);
//        button5 = (Button)findViewById(R.id.button5);
//        button6 = (Button)findViewById(R.id.button6);
//        button7 = (Button)findViewById(R.id.button7);
//        button8 = (Button)findViewById(R.id.button8);
//        button9 = (Button)findViewById(R.id.button9);
//        button10 = (Button)findViewById(R.id.button10);
//        button_M = (Button)findViewById(R.id.button_M);
//        button_X = (Button)findViewById(R.id.button_X);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_scoring, menu);
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

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button1:
                scoreWriter(1);
                break;
            case R.id.button2:
                scoreWriter(2);
                break;
            case R.id.button3:
                scoreWriter(3);
                break;
            case R.id.button4:
                scoreWriter(4);
                break;
            case R.id.button5:
                scoreWriter(5);
                break;
            case R.id.button6:
                scoreWriter(6);
                break;
            case R.id.button7:
                scoreWriter(7);
                break;
            case R.id.button8:
                scoreWriter(8);
                break;
            case R.id.button9:
                scoreWriter(9);
                break;
            case R.id.button10:
                scoreWriter(10);
                break;
            case R.id.button_M:
                scoreWriter(0);
                break;
            case R.id.button_X:
                scoreWriter(10);
                break;
            default:
                break;
        }
    }

    //Horrible function for successively writing to the textViews
    public void scoreWriter(Integer result) {

        switch (count) {
            case 0:
                textViewS1.setText(String.valueOf(result));
                break;
            case 1:
                textViewS2.setText(String.valueOf(result));
                break;
            case 2:
                textViewS3.setText(String.valueOf(result));
                break;
            case 3:
                textViewS4.setText(String.valueOf(result));
                break;
            case 4:
                textViewS5.setText(String.valueOf(result));
                break;
            case 5:
                textViewS6.setText(String.valueOf(result));
                break;
            default:
                break;
        }
        if (count < 5) {
            count++;
            total = total + result;
            textView_totalS1.setText(String.valueOf(total));
        }
    }
}
