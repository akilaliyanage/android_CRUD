package com.example.lab10.database;

import android.provider.BaseColumns;

public final class MessageMaster {
   private MessageMaster(){

   }

    //inner class for the table structure
    public static class Message implements BaseColumns {
        public static  final String TABLE_NAME = "message";
        public static  final String COLUMN_NAME_SUBJECT = "subject";
        public static  final String COLUMN_NAME_MESSAGE = "message";
    }
}
