package com.s626.archery;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import java.util.Vector;


public class TableActivity extends ActionBarActivity {


    Vector<ListRow6> listRow6s = new Vector<ListRow6>();
    Integer counter =0;

    public String[] emptyArrow = {" ", " ", " ", " ", " ", " ", " "};
    CustomAdapter adapter;
    ListView lvTarget;
    DBHelper dbHelper;
    ContentValues cvSession = new ContentValues();

    final String LOG_TAG = "myLogs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table);

        listRow6s.add(0, new ListRow6(emptyArrow));

// Присоединяем адаптер к ListView
        lvTarget = (ListView) findViewById(R.id.listView);
        adapter = new CustomAdapter(TableActivity.this, R.layout.list_item_row, listRow6s);
        lvTarget.setAdapter(adapter);

        // Создание объекта для работы с БД
        dbHelper = new DBHelper(this);
    }


    public void openScoring(View view) {
        Intent intent = new Intent(TableActivity.this, ScoringActivity.class);
        if (counter <11)
        startActivityForResult(intent, 1);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case (1): {
                if (resultCode == Activity.RESULT_OK) {
                    String[] arrows = data.getStringArrayExtra("RETURN_ARROWS");
                    counter = listRow6s.size();

                    if (counter < 11)
                    writeLine(arrows);
                    if (counter < 9)
                    listRow6s.add(new ListRow6(emptyArrow));
                }
                break;
            }
        }
    }



    public void writeLine(String[] arrows) {
        String tmpArrows;

        //Записываем значение в последнюю пустую линию
        counter--;
        listRow6s.set(counter, new ListRow6(arrows));

        //Если линия не первая - вычисляем общий результат
        if (counter > 0) {
            if (counter == 1) {tmpArrows = listRow6s.get(counter - 1).rowTotal;
            } else {tmpArrows = listRow6s.get(counter - 1).allTotal;}

            //Вычисляем сумму двух рядов и задаём её значение вектору
            arrows[6] = String.valueOf(Integer.parseInt(tmpArrows) +
                    Integer.parseInt(listRow6s.get(counter).rowTotal));
            listRow6s.set(counter, new ListRow6(arrows));
        }

        adapter = new CustomAdapter(TableActivity.this, R.layout.list_item_row, listRow6s);
        lvTarget.setAdapter(adapter);

        writeRowToDB(arrows);

        //проверка на заполнение десятого поля
        if (counter==9)
            counter=counter +2;
    }




    public void writeRowToDB (String[] arrows)
    {
        ContentValues cv = new ContentValues();

        SQLiteDatabase db = dbHelper.getWritableDatabase();

        cv.put("first", arrows[0]);
        cv.put("second", arrows[0]);
        cv.put("third", arrows[2]);
        cv.put("fourth", arrows[3]);
        cv.put("fifth", arrows[4]);
        cv.put("sixth", arrows[5]);
        cv.put("rowTotal", listRow6s.get(counter).rowTotal);
        cv.put("allTotal", arrows[6]);

        long rowID = db.insert("rowArrows", null, cv);

        switch (counter){
            case 0:
                cvSession.put("firstRow", rowID);
                break;
            case 1:
                cvSession.put("secondRow", rowID);
                break;
            case 2:
                cvSession.put("thirdRow", rowID);
                break;
            case 3:
                cvSession.put("fourthRow", rowID);
                break;
            case 4:
                cvSession.put("fifthRow", rowID);
                break;
            case 5:
                cvSession.put("sixthRow", rowID);
                break;
            case 6:
                cvSession.put("seventhRow", rowID);
                break;
            case 7:
                cvSession.put("eighthRow", rowID);
                break;
            case 8:
                cvSession.put("ninthRow", rowID);
                break;
            case 9:
                cvSession.put("tenthRow", rowID);
                long sessionID = db.insert("sessionArrows", null, cvSession);
                Log.d(LOG_TAG, "session inserted, ID = " + sessionID);
                break;
            default:
                break;
        }


        Log.d(LOG_TAG, "row inserted, ID = " + rowID + "; counter =" + counter);


    }
}
