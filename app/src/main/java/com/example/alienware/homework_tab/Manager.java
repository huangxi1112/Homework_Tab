package com.example.alienware.homework_tab;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by alienware on 2016/12/2.
 */

public class Manager {
    public DBHelper dbHelper;
    public Manager(Context context){
        dbHelper=new DBHelper(context);
    }


    public boolean addPerson(Person person){
        SQLiteDatabase db=dbHelper.getWritableDatabase();
        String sql="insert into person(name,number) values(?,?)";
        Object object[]={person.getName(),person.getNumber()};
        db.execSQL(sql,object);
        return true;
    }
}
