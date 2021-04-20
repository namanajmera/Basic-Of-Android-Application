package com.example.newapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SQLite_Assignment extends AppCompatActivity {

    EditText etUsername,etPassword,etCurrentName,etNewName,etDeleteName;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_s_q_lite__assignment);
        etUsername=findViewById(R.id.username);
        etPassword=findViewById(R.id.password);
        etCurrentName=findViewById(R.id.currentName);
        etNewName=findViewById(R.id.newName);
        etDeleteName=findViewById(R.id.deleteName);
    }

    public void createDB(View view) {
        db=openOrCreateDatabase("MyNewDB",MODE_PRIVATE,null);
        Toast.makeText(getBaseContext(),"Created",Toast.LENGTH_SHORT).show();
    }

    public void createTable(View view) {
        db.execSQL("CREATE TABLE IF NOT EXISTS users(username varchar primary key,password varchar)");
        Toast.makeText(getBaseContext(),"Table Created",Toast.LENGTH_SHORT).show();
    }

    public void addUser(View view) {
        String username=etUsername.getText().toString();
        String password=etPassword.getText().toString();
        ContentValues contentValues=new ContentValues();
        contentValues.put("username",username);
        contentValues.put("password",password);
        db.insert("users",null,contentValues);
        Toast.makeText(getBaseContext(),"User Inserted",Toast.LENGTH_SHORT).show();
        clearAll();
    }

    public void viewData(View view) {
        Cursor c=db.query("users",null,null,null,null,null,"username desc");
        while (c.moveToNext()){
            String user=c.getString(0);
            String pass=c.getString(1);
            Toast.makeText(this,"Username:- "+user+" Password:-"+pass+".",Toast.LENGTH_LONG).show();
        }
    }

    public void update(View view) {
        String userOld=etCurrentName.getText().toString();
        String userNew=etNewName.getText().toString();
        db.execSQL("UPDATE users SET username='"+userNew+"'  WHERE username='"+userOld+"'");
        Toast.makeText(getBaseContext(),"Record Updated",Toast.LENGTH_SHORT).show();
        clearAll();
    }

    public void delete(View view) {
        String deleteUser=etDeleteName.getText().toString();
        Toast.makeText(getBaseContext(),"Record Deleted",Toast.LENGTH_SHORT).show();
        db.execSQL("DELETE FROM users WHERE username='"+deleteUser+"'");
        clearAll();
    }

    public void clear(View view) {
        etUsername.setText("");
        etPassword.setText("");
        etCurrentName.setText("");
        etDeleteName.setText("");
        etNewName.setText("");
    }

    public void clearAll(){
        etUsername.setText("");
        etPassword.setText("");
        etCurrentName.setText("");
        etDeleteName.setText("");
        etNewName.setText("");
    }
}
