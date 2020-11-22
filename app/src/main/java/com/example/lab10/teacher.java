package com.example.lab10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lab10.database.DBHandlerMessage;

public class teacher extends AppCompatActivity {

    private TextView head;
    private EditText sub,message;
    private Button save;

    private String subTxt,msgTxt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher);

        //get the intent values
        Intent intent = getIntent();

        //findViewById
        head = findViewById(R.id.head3);
        sub = findViewById(R.id.subTxt);
        message = findViewById(R.id.msgTxt);
        save= findViewById(R.id.sendBtn);

        //setting the text to the head...
        head.setText("Welcome " + intent.getStringExtra("user"));

        //onclick list
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                subTxt = sub.getText().toString();
                msgTxt = message.getText().toString();

                if(subTxt.equals("") || msgTxt.equals("")){
                    Toast.makeText(getApplicationContext(),"invalid action",Toast.LENGTH_LONG).show();

                }else{
                    DBHandlerMessage dbHandlerMessage = new DBHandlerMessage(getApplicationContext());
                    boolean result = dbHandlerMessage.addMessage(subTxt,msgTxt);

                    Toast.makeText(getApplicationContext(),String.valueOf(result),Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}