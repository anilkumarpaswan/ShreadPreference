package com.example.shareadperfence_pifort;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.sql.Array;
import java.sql.DatabaseMetaData;
import java.util.ArrayList;

public class MyDatabase extends SQLiteOpenHelper {
    public MyDatabase (Context context) {
        super(context, "my_db", null, 1);
    }

    @Override
    public void onCreate (SQLiteDatabase db) {
        db.execSQL("create table tblUser(id integer primary key autoincrement ,Email varchar,Name varchar,addr varchar,Password varchar,Age integer,gender varchar)");

    }

    @Override
    public void onUpgrade (SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE tblUser;");
        onCreate(db);
    }

    public boolean loginUser (String email, String password) {
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery("select* from tblUser where email=? and password=?", new String[]{email, password});

        if (c.moveToFirst()) {
            return true;
        } else {
            return false;


        }
    }

    public boolean signupUser (String name, String email, String password, int age, String address, String gender) {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("insert into tblUser(name,email,password,age,addr,gender)values(?,?,?,?,?,?)", new Object[]{name, email, password, age, address, gender});
        return true;
    }


    public ArrayList<User> loadAllUsers () {
        ArrayList<User> list = new ArrayList<User>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery("select* from tblUser", null);
        c.moveToFirst();
        while (c.moveToNext()) {
            User obj = new User();
            obj.setId(c.getInt(c.getColumnIndex("id")));
            obj.setName(c.getString(c.getColumnIndex("name")));
            obj.setEmail(c.getString(c.getColumnIndex("email")));
            obj.setPassword(c.getString(c.getColumnIndex("password")));
            obj.setAge(c.getInt(c.getColumnIndex("age")));
            obj.setGender(c.getString(c.getColumnIndex("gender")));
            obj.setAddress(c.getString(c.getColumnIndex("address")));

            list.add(obj);
        }
        return list;
    }
}