package com.example.lab10;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.lab10.database.DBHandler;

public class reg extends AppCompatActivity {

    private EditText username,passowrd;
    private Button register;
    private CheckBox teacher,student;

    private String userVal,passVal,typeVal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);

        //findviewbyid
        username = findViewById(R.id.usernameTxt2);
        passowrd = findViewById(R.id.passwordTxt2);
        register = findViewById(R.id.regBtn2);
        teacher = findViewById(R.id.teacherChk);
        student = findViewById(R.id.studentChk);



        //sending the data to the db function

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //settinf the values
                userVal = username.getText().toString();
                passVal = passowrd.getText().toString();

                if(teacher.isChecked()){
                    typeVal = "teacher";
                }else if(student.isChecked()){
                    typeVal = "student";
                }else{
                    Toast.makeText(getApplicationContext(),"Please select the type of the user",Toast.LENGTH_LONG).show();
                }


                if(userVal.equals("") || passVal.equals("") || typeVal.equals("")){
                    Toast.makeText(getApplicationContext(),"Fields are empty",Toast.LENGTH_LONG).show();
                }else{
                    DBHandler dbHandler = new DBHandler(getApplicationContext());
                    boolean result = dbHandler.addUser(userVal,passVal,typeVal);

                    Toast.makeText(getApplicationContext(),String.valueOf(result),Toast.LENGTH_LONG).show();

                }
            }
        });
    }
}