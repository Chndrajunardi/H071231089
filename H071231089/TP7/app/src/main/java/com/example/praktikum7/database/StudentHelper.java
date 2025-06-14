package com.example.praktikum7.database;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class StudentHelper {
    private static final String DATABASE_TABLE = DatabaseContract.TABLE_NAME;
    private static DatabaseHelper databaseHelper;
    private static SQLiteDatabase db;
    private static volatile StudentHelper INSTANCE;

    public StudentHelper(Context context) {
        databaseHelper = new DatabaseHelper(context);
    }


    public static StudentHelper getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (SQLiteOpenHelper.class) {
                if (INSTANCE == null) {
                    INSTANCE = new StudentHelper(context);
                }
            }
        }
        return INSTANCE;
    }

    public void open() throws SQLException {
        db = databaseHelper.getWritableDatabase();
    }

    public void close() {
        databaseHelper.close();
        if (db.isOpen()) {
            db.close();
        }
    }

    public Cursor queryAll() {
        return db.query(DATABASE_TABLE,
                null,
                null,
                null,
                null,
                null,
                DatabaseContract.StudentColumns.NAME + " ASC",
                null);
    }

    public Cursor queryById(String id){
        return db.query(
                DATABASE_TABLE,
                null,
                DatabaseContract.StudentColumns._ID + " = ?",
                new String[]{id},
                null,
                null,
                null,
                null
        );
    }

    public long insert(ContentValues values){
        return db.insert(DATABASE_TABLE, null, values);
    }

    public int update(String id, ContentValues values){
        return db.update(DATABASE_TABLE, values,
                DatabaseContract.StudentColumns._ID + " = ?",
                new String[]{id});
    }

    public int deleteById(String id){
        return db.delete(DATABASE_TABLE, DatabaseContract.StudentColumns._ID + " = ?",
                new String[]{id});
    }

}
