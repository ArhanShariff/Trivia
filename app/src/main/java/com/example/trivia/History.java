package com.example.trivia;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;

import java.util.ArrayList;

import static com.example.trivia.DBHelper.COLUMN_NAME;

public class History extends AppCompatActivity {
private DBHelper dbHelper;
private ArrayList<DataModel> data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        dbHelper = new DBHelper(this);
        data = new ArrayList<DataModel>();
        Cursor cursor = dbHelper.getAllTrivia(); //Get data from DB
        cursor.moveToFirst();
//
        while(!cursor.isAfterLast()){
            //Add data to the data model
            data.add(new DataModel(cursor.getString(cursor.getColumnIndex(DBHelper.COLUMN_NAME)),cursor.getString(cursor.getColumnIndex(DBHelper.COLUMN_DATE_TIME)),
                            cursor.getString(cursor.getColumnIndex(DBHelper.COLUMN_CRICKETER)), cursor.getString(cursor.getColumnIndex(DBHelper.COLUMN_FLAG_COLORS))));
            cursor.moveToNext();
        }

        //  call the adapter and pass data
        MyAdapter myAdapter = new MyAdapter(History.this, data);
        recyclerView.setAdapter(myAdapter); // set the Adapter to RecyclerView
    }
}
