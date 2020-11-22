package com.example.lab10.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.sql.PreparedStatement;
import java.sql.Struct;
import java.util.ArrayList;
import java.util.List;

public class DBHandler extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "user.db";

    public DBHandler(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 3);

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String SQL_CREATE_TABLE_USER = "CREATE TABLE " + UsersMaster.Users.TABLE_NAME + " (" + UsersMaster.Users._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + UsersMaster.Users.COLUMN_NAME_USERNAME + " TEXT, " + UsersMaster.Users.COLUMN_NAME_PASSWORD + " TEXT, " + UsersMaster.Users.COLUMN_NAME_TYPE + " TEXT )";

        sqLiteDatabase.execSQL(SQL_CREATE_TABLE_USER);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    //add new user
    public boolean addUser(String userName, String password, String type){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(UsersMaster.Users.COLUMN_NAME_USERNAME,userName);
        values.put(UsersMaster.Users.COLUMN_NAME_PASSWORD,password);
        values.put(UsersMaster.Users.COLUMN_NAME_TYPE,type);

        boolean newRowId = db.insert(UsersMaster.Users.TABLE_NAME,null,values) > 0;
        return  newRowId;
    }

    //login function

    public List loginUser(String username, String password){
        SQLiteDatabase db = getWritableDatabase();

        String[] Projection = {
                UsersMaster.Users._ID,
                UsersMaster.Users.COLUMN_NAME_USERNAME,
                UsersMaster.Users.COLUMN_NAME_PASSWORD,
                UsersMaster.Users.COLUMN_NAME_TYPE
        };

        String selection = UsersMaster.Users.COLUMN_NAME_USERNAME +  " = ? AND " + UsersMaster.Users.COLUMN_NAME_PASSWORD + " = ?";
        String[] selectionArgs = {username,password};

        Cursor cursor = db.query(
                UsersMaster.Users.TABLE_NAME,
                Projection,
                selection,
                selectionArgs,
                null,
                null,
                null
        );

        ArrayList<UserData> users = new ArrayList<UserData>();

        while(cursor.moveToNext()){
            String userName = cursor.getString(cursor.getColumnIndexOrThrow(UsersMaster.Users.COLUMN_NAME_USERNAME));
            String passWord = cursor.getString(cursor.getColumnIndexOrThrow(UsersMaster.Users.COLUMN_NAME_PASSWORD));
            String type = cursor.getString(cursor.getColumnIndexOrThrow(UsersMaster.Users.COLUMN_NAME_TYPE));

            UserData userData = new UserData(userName,passWord,type);
            users.add(userData);
        }

        cursor.close();

        return users;
    }
}
