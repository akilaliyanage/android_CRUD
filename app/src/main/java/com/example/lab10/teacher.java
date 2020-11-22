package com.example.lab10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class teacher extends AppCompatActivity {

    private TextView head;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher);

        //get the intent values
        Intent intent = getIntent();

        //findViewById
        head = findViewById(R.id.head3);
        head.setText("Welcome " + intent.getStringExtra("user"));

    }
}