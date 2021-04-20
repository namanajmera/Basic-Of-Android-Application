package com.example.newapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class CB_RB_Demo extends AppCompatActivity {

    CheckBox checkBox1,checkBox2,checkBox3;
    RadioButton radioButton1,radioButton2,radioButton;
    RadioGroup radioGroup1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cb__rb__demo);
        checkBox1=findViewById(R.id.cb1);
        checkBox2=findViewById(R.id.cb2);
        checkBox3=findViewById(R.id.cb3);
        radioButton1=findViewById(R.id.rb1);
        radioButton2=findViewById(R.id.rb2);
        radioGroup1=findViewById(R.id.rg1);
    }

    public void show_bill(View view) {
        int pizza=300;
        int burger=150;
        int sandwich=150;
        int total=0;

        String details="Selected Items";

        if(checkBox1.isChecked())
        {
            total=total+pizza;
            details=details+"\n Pizza:"+pizza;
        }
        if (checkBox2.isChecked())
        {
            total=total+burger;
            details=details+"\n Burger:"+burger;
        }
        if (checkBox3.isChecked())
        {
            total=total+sandwich;
            details=details+"\n Sandwich:"+sandwich;
        }
        Toast.makeText(this,details+"\n Total Bill is:- Rs. "+total,Toast.LENGTH_SHORT).show();



    }

    public void submit(View view) {

        /*String details="Your Feedback:- ";
        if (radioButton1.isChecked())
        {
            Toast.makeText(this,details+"Good is submitted",Toast.LENGTH_SHORT).show();
        }
        if (radioButton2.isChecked())
        {
            Toast.makeText(this,details+"Average is submitted",Toast.LENGTH_SHORT).show();
        }*/
        int selectedId=radioGroup1.getCheckedRadioButtonId();
        radioButton=findViewById(selectedId);
        if (selectedId==-1)
        {
            Toast.makeText(this,"no Feedback is submitted by you",Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(this,"The food quality is "+radioButton.getText(),Toast.LENGTH_SHORT).show();
        }

    }

    public void clear(View view) {
        if (checkBox1.isChecked()) {
            checkBox1.setChecked(false);
        }
        if (checkBox2.isChecked()) {
            checkBox2.setChecked(false);
        }
        if (checkBox3.isChecked()) {
            checkBox3.setChecked(false);
        }
        radioGroup1.clearCheck();
    }
}
