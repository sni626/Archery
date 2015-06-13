package com.s626.archery;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class ScoringActivity extends ActionBarActivity implements View.OnClickListener {
    final Integer numberOfArrows = 6;

    Integer count = 0;
    Integer total = 0;
    Integer previousResult;
    String[] arrowsArray = {" ", " ", " ", " ", " ", " ", " "};

    TextView textViewS1, textViewS2, textViewS3,
            textViewS4, textViewS5, textViewS6, textView_totalS1;


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
            case R.id.button_rescore:
                if (count > 0)
                scoreRemover();
                break;
            case R.id.button_save:
                Intent resultIntent = new Intent();
                resultIntent.putExtra("RETURN_ARROWS", arrowsArray);
                setResult(Activity.RESULT_OK, resultIntent);
                finish();
                break;
            default:
                break;
        }
    }

    //Horrible function for successively writing to the textViews
    public void scoreWriter(Integer result) {
        String resultString;

        switch (result){
            case 0:
                resultString = "0";
                break;
            case 11:
                resultString = "X";
                result--;
                break;
            default:
                resultString = String.valueOf(result);
                break;
        }

        if (count < numberOfArrows) {
        switch (count) {
            case 0:
                textViewS1.setText(resultString);
                break;
            case 1:
                textViewS2.setText(resultString);
                break;
            case 2:
                textViewS3.setText(resultString);
                break;
            case 3:
                textViewS4.setText(resultString);
                break;
            case 4:
                textViewS5.setText(resultString);
                break;
            case 5:
                textViewS6.setText(resultString);
                break;
            default:
                break;
        }

            arrowsArray[count] = resultString;
            count++;
            total = total + result;
            previousResult = result;
            textView_totalS1.setText(String.valueOf(total));

        }
    }

    public void scoreRemover(){
        count--;
        total = total - previousResult;
        textView_totalS1.setText(String.valueOf(total));
        arrowsArray[count] = " ";
        switch (count) {
            case 0:
                previousResult = 0;
                textViewS1.setText("");
                break;
            case 1:
                previousResult = Integer.parseInt(textViewS1.getText().toString());
                textViewS2.setText("");
                break;
            case 2:
                previousResult = Integer.parseInt(textViewS2.getText().toString());
                textViewS3.setText("");
                break;
            case 3:
                previousResult = Integer.parseInt(textViewS3.getText().toString());
                textViewS4.setText("");
                break;
            case 4:
                previousResult = Integer.parseInt(textViewS4.getText().toString());
                textViewS5.setText("");
                break;
            case 5:
                previousResult = Integer.parseInt(textViewS5.getText().toString());
                textViewS6.setText("");
                break;
            default:
                break;
        }

    }
}
