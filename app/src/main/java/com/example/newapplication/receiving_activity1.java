package com.example.newapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class receiving_activity1 extends AppCompatActivity {

    TextView textView1;
    TextView textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receiving_activity1);

        textView1=findViewById(R.id.tv1);
        textView2=findViewById(R.id.tv2);

        Intent i1=getIntent();

        String name=i1.getStringExtra("Student_Name");
        Integer reg=i1.getIntExtra("Registration Number",0);
        Double cg=i1.getDoubleExtra("CGPA",0.0d);

        textView1.setText("Student Name:- "+name+"\n Registration Number:- "+reg+"\n CGPA:- "+cg);

        //getting data through bundle

        Bundle b1=i1.getBundleExtra("Bundle");
        String name1=b1.getString("Student_Name");
        Integer reg1=b1.getInt("Registration Number",0);
        Double cg1=b1.getDouble("CGPA",0.0d);
        Double fees=b1.getDouble("Fees",0.0d);
        Boolean status=b1.getBoolean("Status",true);

        textView2.setText("Student Name:- "+name1+"\n Registration Number:- "+reg1+"\n CGPA:- "+cg1+"\n Fees:- "+fees+"\n Status:- "+status);


    }
}
