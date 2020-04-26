package com.example.trivia;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "TriviaDB.db";
    public static final String TABLE_NAME = "trivia";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_DATE_TIME = "date";
    public static final String COLUMN_CRICKETER = "cricketer";
    public static final String COLUMN_FLAG_COLORS = "colors";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME , null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub
        db.execSQL(
                "create table " + TABLE_NAME  +
                        "(id integer primary key, name text,date text,cricketer text, colors text)"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
        db.execSQL("DROP TABLE IF EXISTS trivia");
        onCreate(db);
    }

    public void insertTrivia (String name, String date, String cricketer, String colors) { //Insert trivia into DB
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("date", date);
        contentValues.put("cricketer", cricketer);
        contentValues.put("colors", colors);
        db.insert("trivia", null, contentValues);
    }

    public Cursor getAllTrivia() { //Get all the trivia from DB
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from trivia ", null );

        return res;
    }
}
