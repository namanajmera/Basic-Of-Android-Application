package com.example.newapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class gstCalculator extends AppCompatActivity {

    EditText editText1;
    int product;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gst_calculator);
        editText1=findViewById(R.id.product1);
    }

    public void Show_tax_result(View view) {
        product=Integer.parseInt(editText1.getText().toString());
        float tax1=product*9/100;
        float tax2=product*9/100;
        float total=product+tax1+tax2;
        Toast.makeText(this,"Total Price is"+total,Toast.LENGTH_LONG).show();
    }
}
