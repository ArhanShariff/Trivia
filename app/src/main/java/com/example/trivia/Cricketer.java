package com.example.trivia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Cricketer extends AppCompatActivity {
    Button nextBtn;
    RadioGroup radioGroup;
    RadioButton radioButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cricketer);

        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        nextBtn = (Button) findViewById(R.id.nextBtnCricketer);
        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent getIntent = getIntent();
                String name = getIntent.getStringExtra("name"); //get name from previous activity
                int selectedId = radioGroup.getCheckedRadioButtonId();
                radioButton = (RadioButton) findViewById(selectedId);
                if(selectedId==-1){ //Check if one of the option is selected
                    Toast.makeText(Cricketer.this,"Nothing selected", Toast.LENGTH_SHORT).show();
                }
                else{ //Go to the next question
                    Intent intent = new Intent(Cricketer.this, NationalFlag.class);
                    intent.putExtra("cricketer", radioButton.getText().toString());
                    intent.putExtra("name", name);
                    startActivity(intent);
                }
            }
        });
    }
}
