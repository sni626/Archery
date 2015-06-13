package com.s626.archery;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.Vector;


public class ViewResults extends ActionBarActivity implements View.OnClickListener {


    Vector<ListRow6> listRow6s = new Vector<ListRow6>();
    CustomAdapter adapter;
    Button btnAdd, btnRead, btnClear;
    EditText etID;
    DBHelper dbHelper;
    final String LOG_TAG = "myLogs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_results);

        btnRead = (Button) findViewById(R.id.btnRead);
        btnRead.setOnClickListener(this);

        btnClear = (Button) findViewById(R.id.btnClear);
        btnClear.setOnClickListener(this);

        etID = (EditText) findViewById(R.id.etID);

        ListView lvTarget = (ListView) findViewById(R.id.listResult);
        adapter = new CustomAdapter(ViewResults.this, R.layout.list_item_row, listRow6s);
        lvTarget.setAdapter(adapter);
        dbHelper = new DBHelper(this);
    }



    @Override
    public void onClick(View v) {

        // создаем объект для данных
        ContentValues cv = new ContentValues();

        // получаем данные из полей ввода
        String ID = etID.getText().toString();

        // подключаемся к БД
        SQLiteDatabase db = dbHelper.getWritableDatabase();


        switch (v.getId()) {
            case R.id.btnRead:
                Log.d(LOG_TAG, "--- Rows in mytable: ---");
                // делаем запрос данных из таблицы, получаем Cursor
                Cursor c = db.rawQuery("select * from sessionArrows where ID=" + ID  , null);

                // ставим позицию курсора на первую строку выборки
                // если в выборке нет строк, вернется false
                if (c.moveToFirst()) {

                    // определяем номера столбцов по имени в выборке
                    int idColIndex = c.getColumnIndex("id");
                    Vector<ListRow6> listRow6s = new Vector<ListRow6>();
                    int RIndex[]=new int[10];
                    RIndex[0]= c.getColumnIndex("firstRow");
                    RIndex[1]= c.getColumnIndex("secondRow");
                    RIndex[2]= c.getColumnIndex("thirdRow");
                    RIndex[3]= c.getColumnIndex("fourthRow");
                    RIndex[4]= c.getColumnIndex("fifthRow");
                    RIndex[5]= c.getColumnIndex("sixthRow");
                    RIndex[6]= c.getColumnIndex("seventhRow");
                    RIndex[7]= c.getColumnIndex("eighthRow");
                    RIndex[8]= c.getColumnIndex("ninthRow");
                    RIndex[9]= c.getColumnIndex("tenthRow");


                    for (int i=0; i<=9; i++){
                        Cursor c2 = db.rawQuery("select * from rowArrows where ID=" + c.getInt(RIndex[i])  , null);
                        if (c2.moveToFirst()) {
                            String[] arrows = new String[7];
                            int[] arrowIndex = new int[7];
                            arrowIndex[0] = c2.getColumnIndex("first");
                            arrowIndex[1] = c2.getColumnIndex("second");
                            arrowIndex[2] = c2.getColumnIndex("third");
                            arrowIndex[3] = c2.getColumnIndex("fourth");
                            arrowIndex[4] = c2.getColumnIndex("fifth");
                            arrowIndex[5] = c2.getColumnIndex("sixth");
                            arrowIndex[6] = c2.getColumnIndex("allTotal");
                            c.moveToFirst();

                            for (int j = 0; j <= 6; j++) {
                                Log.d("====LOGS====", String.valueOf(j) + " = " + String.valueOf(arrowIndex[j]));
                                Log.d("==c2.getStr(arInd[j])=", c2.getString(arrowIndex[j]));
                                arrows[j] = c2.getString(arrowIndex[j]);
                            }
                            listRow6s.add(i, new ListRow6(arrows));
                        }
                        else
                            Log.d(LOG_TAG, "c2 FAIL");
                        c2.close();
                        Log.d("====LOGS====  STEP", ""+i);
                    }

                    // Присоединяем адаптер к ListView
                    ListView lvTarget = (ListView) findViewById(R.id.listResult);
                    adapter = new CustomAdapter(ViewResults.this, R.layout.list_item_unclicable, listRow6s);
                    lvTarget.setAdapter(adapter);


                } else
                    Log.d(LOG_TAG, "0 rows");
                c.close();

                break;


            case R.id.btnClear:
                Log.d(LOG_TAG, "--- Clear mytable: ---");
                // удаляем все записи
                int clearCount = db.delete("sessionArrows", null, null);
                Log.d(LOG_TAG, "deleted rows count = " + clearCount);
                break;
        }
        // закрываем подключение к БД
        dbHelper.close();
    }
}
