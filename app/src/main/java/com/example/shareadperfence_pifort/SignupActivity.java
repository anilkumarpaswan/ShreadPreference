package com.example.shareadperfence_pifort;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class SignupActivity extends AppCompatActivity {
    Button btnSave, btnNext;
    EditText etEmail, etAge, etAddr, etName, etPass;
    RadioButton rbMale, rbFemale;

    //    SQLiteDatabase db;
    MyDatabase objDb;

    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        etName = findViewById(R.id.etName);
        etAddr = findViewById(R.id.etAddr);
        etAge = findViewById(R.id.etAge);
        etEmail = findViewById(R.id.etEmail);
        etPass = findViewById(R.id.etPass);
        rbMale = findViewById(R.id.rbMale);
        rbFemale = findViewById(R.id.rbFemale);
//        db = openOrCreateDatabase("my_db", MODE_PRIVATE, null);
        objDb = new MyDatabase(this);

//        if (isTableCreate() == false) {
//            db.execSQL("create table tbUser(id integer primary key autoincrement ,Email varchar,Name varchar,addr varchar,Password varchar,Age integer,gender varchar)");
//            setTableCreated();
//
//        }


    }


//    private void setTableCreated () {
//        SharedPreferences perf = getSharedPreferences("myPref", MODE_PRIVATE);
//        SharedPreferences.Editor edt = perf.edit();
//        edt.putBoolean("tableCreated", true);
//        edt.commit();
//    }
//
//    private boolean isTableCreate () {
//        SharedPreferences pref = getSharedPreferences("myPref", MODE_PRIVATE);
//        return pref.getBoolean("tableCreated", false);
//    }

    public void singupUser (View view) {
        String Email = etEmail.getText().toString();
        String Age = etAge.getText().toString();
        String Name = etName.getText().toString();
        String Pass = etPass.getText().toString();
        String Addr = etAddr.getText().toString();
        String gender = rbMale.isChecked() ? "MALE" : "FEMALE";

//        db.execSQL("insert into tblUser(name,email,password,age,addr,gender)values(?,?,?,?,?,?)", new Object[]{Name, Email, Pass, Age, Addr, gender});
        if (objDb.signupUser(Name, Email, Pass, Integer.parseInt(Age), Addr, gender)) {
            Toast.makeText(this, "Signup successfully", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Signup failed", Toast.LENGTH_SHORT).show();

        }
    }

//    public void setTabletCreate() {
//
//    }

//    public void loginup(View view) {
//        validationSingup();
//
//    }

//    private void loginUser (View view) {
//        String Email = etEmail.getText().toString();
//        String Pass = etPass.getText().toString();
//
//        Cursor c = db.rawQuery("select* from tblUser where email=? and password=?", new String[]{Email, Pass});
//
//        if (c.moveToFirst()) {
//            Toast.makeText(this, "Login Success", Toast.LENGTH_SHORT).show();
//        } else {
//            Toast.makeText(this, "Login Failed", Toast.LENGTH_SHORT).show();
//
//
//        }
//    }

    public void gotoNextPage (View view) {
        Intent i = new Intent(this, LoginActivity.class);
        startActivity(i);
        finish();
    }
}
