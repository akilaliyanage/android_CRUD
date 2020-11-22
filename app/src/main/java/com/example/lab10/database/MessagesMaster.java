package com.example.lab10.database;

import android.provider.BaseColumns;

public final class MessagesMaster {

    private MessagesMaster(){

    }

    //inner class for the table structure
    public static class Message implements BaseColumns{
        public static  final String TABLE_NAME = "message";
        public static  final String COLUMN_NAME_USERNAME = "user";
        public static  final String COLUMN_NAME_PASSWORD = "subject";
        public static  final String COLUMN_NAME_TYPE = "message";
    }
}
