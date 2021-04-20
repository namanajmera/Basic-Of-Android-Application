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


public class LoginActivity extends AppCompatActivity {

    private EditText emailedv,passwordedv;
    private Button loginbtn;
    private ProgressBar progressBar;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mAuth=FirebaseAuth.getInstance();
        emailedv=findViewById(R.id.email);
        passwordedv=findViewById(R.id.password);
        loginbtn=findViewById(R.id.login);
        progressBar=findViewById(R.id.progressbar);

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginUserAccount();
            }
        });
    }

    private void loginUserAccount(){
        progressBar.setVisibility(View.VISIBLE);

        String email=emailedv.getText().toString();
        String passowrd=passwordedv.getText().toString();

        if (TextUtils.isEmpty(email)){
            Toast.makeText(getApplicationContext(),"Please enter email",Toast.LENGTH_LONG).show();
            return;
        }
        if (TextUtils.isEmpty(passowrd)){
            Toast.makeText(getApplicationContext(),"Please enter password",Toast.LENGTH_LONG).show();
            return;
        }

        mAuth.signInWithEmailAndPassword(email,passowrd).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    Toast.makeText(getApplicationContext(),"Login Successful!!!",Toast.LENGTH_LONG).show();

                    progressBar.setVisibility(View.GONE);

                    Intent successfull=new Intent(LoginActivity.this,LoginSuccessfullActivity.class);
                    startActivity(successfull);
                }
                else {
                    Toast.makeText(getApplicationContext(),"Login Failed!!!",Toast.LENGTH_LONG).show();

                    progressBar.setVisibility(View.GONE);
                }
            }
        });
    }
}
