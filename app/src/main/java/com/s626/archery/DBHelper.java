package com.s626.archery;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


class DBHelper extends SQLiteOpenHelper {

    final String LOG_TAG = "myLogs";
    public static final int DATABASE_VERSION = 6;
    public static final String DATABASE_NAME = "results";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d(LOG_TAG, "--- onCreate database ---");

        //Table for one row
        db.execSQL("create table rowArrows ("
                + "id integer primary key autoincrement,"
                + "first text,"
                + "second text,"
                + "third text,"
                + "fourth text,"
                + "fifth text,"
                + "sixth text,"
                + "rowTotal text,"
                + "allTotal text" + ");");

        db.execSQL("create table sessionArrows ("
                + "id integer primary key autoincrement,"
                + "firstRow int references rowArrows (ID),"
                + "secondRow int references rowArrows (ID),"
                + "thirdRow int references rowArrows (ID),"
                + "fourthRow int references rowArrows (ID),"
                + "fifthRow int references rowArrows (ID),"
                + "sixthRow int references rowArrows (ID),"
                + "seventhRow int references rowArrows (ID),"
                + "eighthRow int references rowArrows (ID),"
                + "ninthRow int references rowArrows (ID),"
                + "tenthRow int references rowArrows (ID)" + ");");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table rowArrows;");
        db.execSQL("drop table sessionArrows;");
        onCreate(db);
    }
}
