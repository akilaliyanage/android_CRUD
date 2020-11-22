package com.example.lab10.database;

import android.provider.BaseColumns;

public final class UsersMaster {

    private UsersMaster(){
    }

    //inner class for the table structure
    public static class Users implements BaseColumns{
        public static  final String TABLE_NAME = "users";
        public static  final String COLUMN_NAME_USERNAME = "username";
        public static  final String COLUMN_NAME_PASSWORD = "password";
        public static  final String COLUMN_NAME_TYPE = "type";
    }
}
