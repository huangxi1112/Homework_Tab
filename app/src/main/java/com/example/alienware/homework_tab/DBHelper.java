package com.example.alienware.homework_tab;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by alienware on 2016/12/1.
 */

public class DBHelper extends SQLiteOpenHelper {


    public DBHelper(Context context) {
        super(context, "person.db", null,1);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql="create table person(id integer primary key autoincrement,name varchar(20),number varchar(20))";
        db.execSQL(sql);
    }


}
