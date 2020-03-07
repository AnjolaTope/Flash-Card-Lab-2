package com.example.flashcard;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        findViewById(R.id.question).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                findViewById(R.id.question).setVisibility(View.INVISIBLE);
                findViewById(R.id.answer).setVisibility(View.VISIBLE);
            }
        });

        findViewById(R.id.answer).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                findViewById(R.id.question).setVisibility(View.VISIBLE);
                findViewById(R.id.answer).setVisibility(View.INVISIBLE);
            }
        });

        findViewById(R.id.myBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, AddcardActivity.class);
                MainActivity.this.startActivityForResult(intent,100);
            }
        });



    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 100) {
            String string1 = data.getExtras().getString("string1");
            String string2 = data.getExtras().getString("string2");

            ((TextView) findViewById(R.id.question)).setText(string1);
            ((TextView) findViewById(R.id.answer)).setText(string2);
        }
    }
}
