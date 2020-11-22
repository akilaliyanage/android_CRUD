package com.example.lab10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.lab10.database.DBHandler;
import com.example.lab10.database.UserData;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private Button regBtn,loginBtn;
    private EditText username,password;
    private String useName,passWord;
    private ArrayList<UserData> userList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //findviewbyid
        regBtn = findViewById(R.id.regBtn);
        loginBtn = findViewById(R.id.LoginBtn);
        username = findViewById(R.id.usernameTxt);
        password = findViewById(R.id.passwordTxt);


        //onclick listners

        regBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent intent = new Intent(MainActivity.this,reg.class);
               startActivity(intent);

            }
        });

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                useName = username.getText().toString();
                passWord = password.getText().toString();

                DBHandler dbHandler = new DBHandler(getApplicationContext());
                userList = (ArrayList<UserData>) dbHandler.loginUser(useName,passWord);

                //checkig the arralist
                if(userList.size() > 0 && userList.size() < 2){
                    if(userList.get(0).getType().equals("teacher")){
                        Intent intent = new Intent(MainActivity.this,teacher.class);
                        intent.putExtra("user", userList.get(0).getUsername());
                        startActivity(intent);
                    }else if(userList.get(0).getType().equals("student")){
                        Intent intent = new Intent(MainActivity.this,student.class);
                        intent.putExtra("user", userList.get(0).getUsername());
                        startActivity(intent);
                    }
                }
            }
        });
    }
}