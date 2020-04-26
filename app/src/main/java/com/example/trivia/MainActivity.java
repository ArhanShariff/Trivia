package com.example.trivia;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText name;
    Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = (EditText) findViewById(R.id.userName);
        next = (Button) findViewById(R.id.nextBtnName);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!name.getText().toString().trim().equals("")){ //Check if name is entered
                    Intent intent = new Intent(MainActivity.this, Cricketer.class);
                    intent.putExtra("name", name.getText().toString());
                    startActivity(intent);
                }else { //If the name is not entered
                    Toast.makeText(MainActivity.this, "Please enter your name", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
