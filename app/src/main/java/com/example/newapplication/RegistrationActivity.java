package com.example.newapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class RegistrationActivity extends AppCompatActivity {

    private EditText emailedv,passwordedv;
    private Button registerbtn;
    private ProgressBar progressBar;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        //taking Firebase Auth instance
        mAuth=FirebaseAuth.getInstance();

        emailedv=findViewById(R.id.email);
        passwordedv=findViewById(R.id.password);
        registerbtn=findViewById(R.id.registerbtn);
        progressBar=findViewById(R.id.progressbar);


        registerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerNewUser();
            }
        });
    }

    private void registerNewUser(){
        //show the visibility of progressbar to show loading
        progressBar.setVisibility(View.VISIBLE);

        //Takking two values of edit txt in string
        String email=emailedv.getText().toString();
        String password=passwordedv.getText().toString();

        //Validations for input email and password
        if (TextUtils.isEmpty(email)){
            Toast.makeText(getApplicationContext(),"Please enter email!!!!",Toast.LENGTH_LONG).show();
            return;
        }
        if (TextUtils.isEmpty(password)){
            Toast.makeText(getApplicationContext(),"Please enter password",Toast.LENGTH_LONG).show();
            return;
        }

        mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    Toast.makeText(getApplicationContext(),"Registration Successfull",Toast.LENGTH_LONG).show();
                    //hide the progress bar
                    progressBar.setVisibility(View.GONE);
                    Intent login=new Intent(RegistrationActivity.this,LoginActivity.class);
                    startActivity(login);
                }
                else {
                    Toast.makeText(getApplicationContext(),"Registration Failed",Toast.LENGTH_LONG).show();

                    progressBar.setVisibility(View.GONE);
                }
            }
        });
    }
}
