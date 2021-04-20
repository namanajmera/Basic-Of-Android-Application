package com.example.newapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class grossSalary extends AppCompatActivity {

    EditText editText1,editText2,editText3,editText4,editText5;
    TextView textView1;
    int working,pay,ohrs,opay,num,total;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gross_salary);
        editText1=findViewById(R.id.ed1);
        editText2=findViewById(R.id.ed2);
        editText3=findViewById(R.id.ed3);
        editText4=findViewById(R.id.ed4);
        editText5=findViewById(R.id.ed5);
        textView1=findViewById(R.id.tv1);


    }

    public void total_salary(View view) {
        working=Integer.parseInt(editText1.getText().toString());
        pay=Integer.parseInt(editText2.getText().toString());
        ohrs=Integer.parseInt(editText3.getText().toString());
        opay=Integer.parseInt(editText4.getText().toString());
        num=Integer.parseInt(editText5.getText().toString());

        total=((working*pay)+(ohrs*opay))*31;

        if(num>=15)
        {
            textView1.setText("Congratulations!!!!1 You get rs 5000/- for your dedication\n Now your total Salary is:- "+(total+5000));
        }
        else
        {
            textView1.setText("Your month salary is :- "+total);
        }
    }

    public void Clear(View view) {
        editText1.setText("");
        editText2.setText("");
        editText3.setText("");
        editText4.setText("");
        editText5.setText("");
        textView1.setText("");
    }
}
