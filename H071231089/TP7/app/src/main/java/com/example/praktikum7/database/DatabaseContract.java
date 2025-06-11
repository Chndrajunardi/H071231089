package com.example.praktikum7.database;
import android.provider.BaseColumns;

public class DatabaseContract {
    public static String TABLE_NAME = "mahasiswa";

    public static final class StudentColumns implements BaseColumns {
        public static String NAME = "nama";
        public static String NIM = "nim";
    }
}