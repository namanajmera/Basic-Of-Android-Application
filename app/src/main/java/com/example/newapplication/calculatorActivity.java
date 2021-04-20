package com.example.newapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class calculatorActivity extends AppCompatActivity {

    EditText editText1,editText2;
    TextView TextView1;
    int n1,n2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        editText1=findViewById(R.id.num1);
        editText2=findViewById(R.id.num2);
        TextView1=findViewById(R.id.result);
    }
    public void input() {
        n1=Integer.parseInt(editText1.getText().toString());
        n2=Integer.parseInt(editText2.getText().toString());
    }

    public void add(View view) {

        input();
        int sum=n1+n2;
        TextView1.setText("The Sum is :- "+sum);
    }

    public void sub(View view) {
        input();
        int sum=n1-n2;
        TextView1.setText("The Sum is :- "+sum);
    }

    public void mul(View view) {
        input();
        int sum=n1*n2;
        TextView1.setText("The Sum is :- "+sum);
    }

    public void div(View view) {
        input();
        int sum=n2/n1;
        TextView1.setText("The Sum is :- "+sum);
    }

    public void clear(View view){
        editText1.setText("");
        editText2.setText("");
        TextView1.setText("");
    }
}
