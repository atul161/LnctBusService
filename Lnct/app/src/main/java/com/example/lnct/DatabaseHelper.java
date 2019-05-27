package com.example.lnct;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

//import androidx.annotation.Nullable;

/*
This class will be used to store student data i.e. NAME, MOBILE, YEAR, ROUTE
Database name : student_info
Table name : student_info_table
Primary Key : ID (Auto Incremented)
*/

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "student_info.db";
    public static final String TABLE_NAME = "student_info_table";

    public static final String COL_1 = "ID";
    public static final String COL_2 = "NAME";
    public static final String COL_3 = "MOBILE";
    public static final String COL_4 = "YEAR";
    public static final String COL_5 = "ROUTE";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    //To create table
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT, MOBILE TEXT, YEAR TEXT, ROUTE TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    //method to insert data into the database
    public boolean insertStudentData(String name, String mobile, String year, String route){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, name);
        contentValues.put(COL_3, mobile);
        contentValues.put(COL_4, year);
        contentValues.put(COL_5, route);
        long result = db.insert(TABLE_NAME, null, contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }

    //method to get student data from the table
    public Cursor getStudentData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM "+ TABLE_NAME, null);
        return res;
    }
}
