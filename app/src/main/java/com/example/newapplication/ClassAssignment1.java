package com.example.newapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ClassAssignment1 extends AppCompatActivity {

    EditText editText1,editText2,editText3,editText4;
    TextView textView1;
    int n1,n2,n3,n2rs,n5rs,n10rs,product;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class_assignment1);
        editText1=findViewById(R.id.num1);
        editText2=findViewById(R.id.num2);
        editText3=findViewById(R.id.num3);
        editText4=findViewById(R.id.product1);
        textView1=findViewById(R.id.result);
    }

    public void Total(View view) {
            n1=Integer.parseInt(editText1.getText().toString());
            n2=Integer.parseInt(editText2.getText().toString());
            n3=Integer.parseInt(editText3.getText().toString());
            n2rs=n1*2;
            n5rs=n2*5;
            n10rs=n3*10;

            int sum=n2rs+n5rs+n10rs;
            textView1.setText("The total Rs is = "+sum);
    }
    public void Show_tax_result(View view) {
        product=Integer.parseInt(editText4.getText().toString());
        double tax1=product*9/100;
        double tax2=product*9/100;
        double total=product+tax1+tax2;
        Toast.makeText(this,"Total Price is:- "+total,Toast.LENGTH_LONG).show();
    }

    public void Clear(View view) {
        editText1.setText("");
        editText2.setText("");
        editText3.setText("");
        editText4.setText("");
        textView1.setText("");
    }

    public void GST_Calculator(View view) {
        Intent it=new Intent(this,gstCalculator.class);
        startActivity(it);
    }
}
