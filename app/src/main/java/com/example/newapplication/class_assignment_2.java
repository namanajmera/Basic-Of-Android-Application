package com.example.newapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class class_assignment_2 extends AppCompatActivity {

    CheckBox shimlacb,manalicb,dalhousiecb;
    RadioButton yesrb,norb;
    EditText personed,daysed;
    TextView amounted;
    RadioGroup rg1;
    int person,days;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class_assignment_2);
        shimlacb=findViewById(R.id.shimla);
        manalicb=findViewById(R.id.manali);
        dalhousiecb=findViewById(R.id.dalhousie);
        yesrb=findViewById(R.id.yes);
        norb=findViewById(R.id.no);
        personed=findViewById(R.id.person);
        daysed=findViewById(R.id.days);
        amounted=findViewById(R.id.amount);
        rg1=findViewById(R.id.rbg1);
    }

    public void total_amount(View view) {
        person=Integer.parseInt(personed.getText().toString());
        days=Integer.parseInt(daysed.getText().toString());
        if (shimlacb.isChecked() && manalicb.isChecked() && dalhousiecb.isChecked()){
            if (yesrb.isChecked()){
                amounted.setText("Total amount is:- " + ((14000 * person * days) + 5000));
            }
            else
                amounted.setText("Total amount is:- " + 14000 * person * days);
        }
        else if(shimlacb.isChecked() && manalicb.isChecked()){
            if(yesrb.isChecked()){
                amounted.setText("Total amount is:- " + ((8000 * person * days) + 5000));
            }
            else
                amounted.setText("Total amount is:- " + 8000 * person * days);
        }
        else if(manalicb.isChecked() && dalhousiecb.isChecked()){
            if(yesrb.isChecked()){
                amounted.setText("Total amount is:- " + ((10000 * person * days) + 5000));
            }
            else
                amounted.setText("Total amount is:- " + 10000 * person * days);
        }
        else if (shimlacb.isChecked() && dalhousiecb.isChecked()) {
            if (yesrb.isChecked()) {
                amounted.setText("Total amount is:- " + ((6000 * person * days) + 5000));
            } else
                amounted.setText("Total amount is:- " + 6000 * person * days);
        }
        else if (shimlacb.isChecked()) {
            if (yesrb.isChecked()) {
                amounted.setText("Total amount is:- " + ((3000 * person * days)+5000));
            }
            else
                amounted.setText("Total amount is:- "+3000*person*days);
        }
        else if(manalicb.isChecked()) {
            if (yesrb.isChecked()) {
                amounted.setText("Total amount is:- "+((8000*person*days)+5000));
            }
            else
                amounted.setText("Total amount is:- "+8000*person*days);
        }
        else if (dalhousiecb.isChecked()) {
            if (yesrb.isChecked()) {
                amounted.setText("Total amount is:- " + ((5000 * person * days) + 5000));
            } else
                amounted.setText("Total amount is:- " + 5000 * person * days);
        }
    }

    public void clear(View view) {
        personed.setText("");
        daysed.setText("");
        amounted.setText("");
        if(shimlacb.isChecked())
            shimlacb.setChecked(false);
        if(manalicb.isChecked())
            manalicb.setChecked(false);
        if(dalhousiecb.isChecked())
            dalhousiecb.setChecked(false);
        rg1.clearCheck();
    }
}
