package com.example.newapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Job_Application_Form extends AppCompatActivity {

    EditText name,email,city,org,yrs;
    CheckBox ch1,ug,pg;
    RadioGroup rg1;
    RadioButton manager,hr,clerk;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job__application__form);
        name=findViewById(R.id.name);
        email=findViewById(R.id.email);
        city=findViewById(R.id.city);
        org=findViewById(R.id.org);
        yrs=findViewById(R.id.yrs);
        ch1=findViewById(R.id.ch1);
        ug=findViewById(R.id.ug);
        pg=findViewById(R.id.pg);
        rg1=findViewById(R.id.rg1);
        manager=findViewById(R.id.manager);
        hr=findViewById(R.id.hr);
        clerk=findViewById(R.id.clerk);

        ch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    clerk.setChecked(true);
                    ug.setChecked(false);
                    pg.setChecked(false);
                }
                else
                    clerk.setChecked(false);
            }
        });
        ug.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    manager.setChecked(true);
                    ch1.setChecked(false);
                    pg.setChecked(false);
                }
                else
                    manager.setChecked(false);
            }
        });
        pg.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    hr.setChecked(true);
                    ch1.setChecked(false);
                    ug.setChecked(false);
                }
                else
                    hr.setChecked(false);
            }
        });



    }

    public void submit(View view) {
            String fullname=name.getText().toString();
            String emailid=email.getText().toString();
            String citys=city.getText().toString();
            String worked=org.getText().toString();
            String years=yrs.getText().toString();
            if(ch1.isChecked()) {
                Toast.makeText(this, "Name:- " + fullname + " Position:- Clerk\nYour Request is accepted. You can apply for the job.",Toast.LENGTH_LONG).show();
            }
            else if(ug.isChecked()) {
                Toast.makeText(this, "Name:- " + fullname + " Position:- Manager\nYour Request is accepted. You can apply for the job.",Toast.LENGTH_LONG).show();
            }
            else if(pg.isChecked()) {
                Toast.makeText(this, "Name:- " + fullname + " Position:- HR\nYour Request is accepted. You can apply for the job.",Toast.LENGTH_LONG).show();
            }
    }

    public void clear(View view) {
        name.setText("");
        email.setText("");
        org.setText("");
        yrs.setText("");
        city.setText("");
        if (ch1.isChecked())
            ch1.setChecked(false);
        if (ug.isChecked())
            ug.setChecked(false);
        if (pg.isChecked())
            pg.setChecked(false);
        rg1.clearCheck();
    }
}