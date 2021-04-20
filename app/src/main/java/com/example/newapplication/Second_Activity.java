package com.example.newapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Second_Activity extends AppCompatActivity {

    EditText et1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_);
        et1=findViewById(R.id.et1);
    }

    public void send_input(View view) {
        String text=et1.getText().toString();
        Intent intent=new Intent();
        if (text.equals("")){
            setResult(RESULT_CANCELED);
        }
        else {
            intent.putExtra("name",text);
            setResult(RESULT_OK,intent);
        }
        finish();
    }
}
