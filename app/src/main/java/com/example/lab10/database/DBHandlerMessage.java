package com.example.lab10.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public final class DBHandlerMessage extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "message.db";

    public DBHandlerMessage(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String SQL_CREATE_TABLE_MESSAGE = "CREATE TABLE " + MessageMaster.Message.TABLE_NAME + " (" + MessagesMaster.Message._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + MessageMaster.Message.COLUMN_NAME_SUBJECT + " TEXT, " + MessageMaster.Message.COLUMN_NAME_MESSAGE + " TEXT)";

        sqLiteDatabase.execSQL(SQL_CREATE_TABLE_MESSAGE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    //add new message
    public boolean addMessage(String subject, String message){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(MessageMaster.Message.COLUMN_NAME_SUBJECT,subject);
        values.put(MessageMaster.Message.COLUMN_NAME_MESSAGE,message);

        boolean newRowId = db.insert(MessageMaster.Message.TABLE_NAME,null,values) > 0;
        return  newRowId;
    }
}
