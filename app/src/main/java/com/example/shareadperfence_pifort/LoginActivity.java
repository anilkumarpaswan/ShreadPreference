package com.example.shareadperfence_pifort;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    Button btnLogin, btnNext;
    EditText etEmail, etPass;
    //    SQLiteDatabase db;
    MyDatabase objDb;

    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        etEmail = findViewById(R.id.etEmail);
        etPass = findViewById(R.id.etPass);
//        db = openOrCreateDatabase("my_db", MODE_PRIVATE, null);
        objDb = new MyDatabase(this);

    }

    public void loginUser (View view) {
        String Email = etEmail.getText().toString();
        String Pass = etPass.getText().toString();

//        Cursor c = db.rawQuery("select* from tblUser where email=? and password=?", new String[]{Email, Pass});

//        if (c.moveToFirst()) {
        if (objDb.loginUser(Email, Pass)) {
            Toast.makeText(this, "Login Success", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Login Failed", Toast.LENGTH_SHORT).show();


        }
    }

    public void gotoNextPage (View view) {
        Intent i = new Intent(this, SignupActivity.class);
        startActivity(i);
        finish();
    }
}
