package com.example.newapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class BMICalculator extends AppCompatActivity {

    EditText editText1,editText2,editText3;
    TextView textView1;
    float age,height,weight,bmi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmicalculator);
        editText1=findViewById(R.id.ed1);
        editText2=findViewById(R.id.ed2);
        editText3=findViewById(R.id.ed3);
        textView1=findViewById(R.id.tv1);
    }

    public void bmi_calculator(View view) {
        age=Float.parseFloat(editText1.getText().toString());
        height=Float.parseFloat(editText2.getText().toString());
        weight=Float.parseFloat(editText3.getText().toString());

        if (age<18)
        {
            textView1.setText("BMI is Not Calculated Because your age is below 18");
        }
        else
        {
            bmi=weight/(height*height);
            if (bmi>=25.0)
            {
                textView1.setText("Overweight!!! \n Need to WorkOut");
            }
            else if (bmi>18.5 && bmi<24.9)
                    {
                        textView1.setText("Healthy!!!");
                    }
            else
            {
                textView1.setText("Underweight!!! Take healthy Diet");
            }
        }

    }

    public void clear(View view) {
        editText1.setText("");
        editText2.setText("");
        editText3.setText("");
        textView1.setText("");

    }
}
