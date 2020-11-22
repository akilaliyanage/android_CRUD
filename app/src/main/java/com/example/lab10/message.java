package com.example.lab10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class message extends AppCompatActivity {

    private EditText msg;
    private TextView head;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);

        //findviewbyid
        msg = findViewById(R.id.msgTxt2);
        head = findViewById(R.id.head5);

        //get data from the intent
        Intent intent = getIntent();

        head.setText(intent.getStringExtra("sub"));
        msg.setText(intent.getStringExtra("msg"));
    }
}