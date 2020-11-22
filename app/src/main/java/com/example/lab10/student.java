package com.example.lab10;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.lab10.database.DBHandlerMessage;
import com.example.lab10.database.MessageData;

import java.util.ArrayList;

public class student extends AppCompatActivity {

    private TextView head;
    private ArrayList<MessageData> messageData = new ArrayList<MessageData>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);

        //get intent data
        Intent intent = getIntent();

        //findviewbyid
        head = findViewById(R.id.head4);

        //seting the values
        head.setText("Welcome " + intent.getStringExtra("user"));

        //getting the data from the helper class
        DBHandlerMessage dbHandlerMessage = new DBHandlerMessage(getApplicationContext());
        messageData = dbHandlerMessage.readAllMsgs();

        initRecyclerView();

    }

    private void initRecyclerView(){
        RecyclerView recyclerView = findViewById(R.id.rcview);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(messageData,student.this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(student.this));
    }
}