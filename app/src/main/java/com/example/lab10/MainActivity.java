package com.example.lab10;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
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

        //otification channel
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel channel = new NotificationChannel("You have a new message","You have a new message",NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }

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
//                        Intent intent = new Intent(MainActivity.this,student.class);
//                        intent.putExtra("user", userList.get(0).getUsername());
//                        startActivity(intent);

                        Intent intent = new Intent(MainActivity.this,student.class);
                        intent.putExtra("user", userList.get(0).getUsername());
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        PendingIntent pendingIntent = PendingIntent.getActivity(MainActivity.this,0,intent,0);

                        NotificationCompat.Builder builder = new NotificationCompat.Builder(MainActivity.this,"You have a new message").setSmallIcon(R.drawable.ic_launcher_background).setContentTitle("You have a new message").setContentText("you have a new message").setPriority(NotificationCompat.PRIORITY_DEFAULT).setContentIntent(pendingIntent).setAutoCancel(true);
                        NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(MainActivity.this);

                        notificationManagerCompat.notify(0,builder.build());
                    }
                }
            }
        });
    }
}