package com.example.hp.sqlite_akademik;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DataHelper extends SQLiteOpenHelper {

    private final static String DB_NAME = "akademik.db";
    private final static int DB_versi = 1;

    public DataHelper(Context context) {
        super(context, DB_NAME, null, DB_versi);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "create table course(courseid integer primary key, name text null);";
        Log.d("Data", "onCreate: " + sql);
        db.execSQL(sql);
        sql = "INSERT INTO course (courseid, name) VALUES ('77', 'Mobile Programming');";
        db.execSQL(sql);

        sql = "create table major(majorid integer primary key, name text null);";
        Log.d("Data1", "onCreate: " + sql);
        db.execSQL(sql);
        sql = "INSERT INTO major (majorid, name) VALUES ('69', 'Teknik Informatika');";
        db.execSQL(sql);

        sql = "create table student(studentid integer primary key, name text null, majorid integer);";
        Log.d("Data2", "onCreate: " + sql);
        db.execSQL(sql);
        sql = "INSERT INTO student (studentid, name, majorid) VALUES ('101', 'Fikri Aldi Nugraha', '69');";
        db.execSQL(sql);

        sql = "create table student_course(runningid integer primary key, studentid integer, courseid integer, grade text);";
        Log.d("Data3", "onCreate: " + sql);
        db.execSQL(sql);
        sql = "INSERT INTO student_course (runningid, studentid, courseid, grade) VALUES ('100', '101', '77', '5');";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
