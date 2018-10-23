package com.ssndevelopers.betacas1;


import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

//helper class for storing and creating data from A3LOGIN CLASSS
public class dB2_HELPER extends SQLiteOpenHelper {
    static contact d = new contact();
    static final String NAME = d.getName();
    static final String MNO = d.getM_num();
    static final String db_n = NAME+"("+MNO+")"+".db";
    public static final String DATABASE_NAME = db_n;
    public static final String TABLE_NAME = "teacher";
    SQLiteDatabase db;

    public dB2_HELPER(Context context) {
        super(context, db_n, null, 1);
        SQLiteDatabase db = this.getWritableDatabase();

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}
