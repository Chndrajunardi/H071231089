package com.example.praktikum7.database;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "Student.db";

    private static final int DATABASE_VERSION = 1;
    private static final String SQL_CREATE_TABLE_STUDENT = String.format(
            "CREATE TABLE %s"
                    + "(%s INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + "%s TEXT NOT NULL, "
                    + "%s TEXT NOT NULL)",
            DatabaseContract.TABLE_NAME,
            DatabaseContract.StudentColumns._ID,
            DatabaseContract.StudentColumns.NIM,
            DatabaseContract.StudentColumns.NAME
    );


    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_TABLE_STUDENT);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + DatabaseContract.TABLE_NAME);
        onCreate(db);
    }
}