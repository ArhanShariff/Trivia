package com.example.trivia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Summary extends AppCompatActivity {
    TextView name, cricketer, flagColors;
    String userName, bestCricketer, colorFlag;
    Button finish, history;
    private DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        name = (TextView) findViewById(R.id.summaryName);
        cricketer = (TextView) findViewById(R.id.summaryCricketer);
        flagColors = (TextView) findViewById(R.id.summaryFlag);
        finish = (Button) findViewById(R.id.buttonFinish);
        history = (Button) findViewById(R.id.buttonHistory);

        Intent getIntent = getIntent(); //Get data from previous activities
        userName = getIntent.getStringExtra("name");
        bestCricketer = getIntent.getStringExtra("cricketer");
        colorFlag = getIntent.getStringExtra("colors");

        name.setText("Hello " + userName);
        cricketer.setText(bestCricketer);
        flagColors.setText(colorFlag);

        dbHelper = new DBHelper(this);

        buttonClickEvents();
        insertIntoDB();
    }

    private void buttonClickEvents(){
        finish.setOnClickListener(new View.OnClickListener() { //when finish button is clicked
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Summary.this, MainActivity.class); // go to first page
                startActivity(intent);
            }
        });

        history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Summary.this, History.class); //show history
                startActivity(intent);
            }
        });
    }

    private void insertIntoDB(){ //Insert data into DB
        String currentDate = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(new Date()); //get current date
        String currentTime = new SimpleDateFormat("HH:mm", Locale.getDefault()).format(new Date()); //get current time
        String date = currentDate + " " + currentTime; // Date and time
        dbHelper.insertTrivia(userName,date,bestCricketer, colorFlag); //Call the DB insert function
    }
}
