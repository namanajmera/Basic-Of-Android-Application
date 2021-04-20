package com.example.newapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class FirebaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firebase);
    }

    public void login(View view) {
        Intent login=new Intent(this,LoginActivity.class);
        startActivity(login);
    }

    public void registration(View view) {
        Intent registration=new Intent(this,RegistrationActivity.class);
        startActivity(registration);
    }
}
