package com.example.trivia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class NationalFlag extends AppCompatActivity {
    Button button;
    CheckBox white, yellow, orange, green;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_national_flag);

        button = (Button) findViewById(R.id.nextBtnFlag);
        white = (CheckBox) findViewById(R.id.white);
        yellow = (CheckBox) findViewById(R.id.yellow);
        orange = (CheckBox) findViewById(R.id.orange);
        green = (CheckBox) findViewById(R.id.green);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent getIntent = getIntent(); //get data from previous activities/pages
                String colors = "";
                String name = getIntent.getStringExtra("name");
                String cricketer = getIntent.getStringExtra("cricketer");
                if (white.isChecked()){ //if white option is checked
                    colors = "White";
                }
                if (yellow.isChecked()){ //if yellow is checked
                    if (colors.equals("")){
                        colors = "Yellow";
                    }else {
                        colors = colors + ", Yellow"; //white + yellow
                    }
                }
                if (orange.isChecked()){ //if orange is checked
                    if (colors.equals("")){
                        colors = "Orange";
                    }else {
                        colors = colors + ", Orange";
                    }
                }

                if (green.isChecked()){ // if green option is checked
                    if (colors.equals("")){
                        colors = "Green";
                    }else {
                        colors = colors + ", Green";
                    }
                }

                if (colors.equals("")){ //if nothing is selected
                    Toast.makeText(NationalFlag.this, "Nothing selected", Toast.LENGTH_LONG).show();
                }else {
                    Intent intent = new Intent(NationalFlag.this, Summary.class); //Go to the summary page
                    intent.putExtra("colors", colors);
                    intent.putExtra("name", name);
                    intent.putExtra("cricketer", cricketer);
                    startActivity(intent);
                }
            }
        });
    }
}
