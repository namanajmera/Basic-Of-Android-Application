package com.example.newapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class DigitalCalculator extends AppCompatActivity {

    EditText editText;
    Button button1,button2,button3,button4,button5,button6,button7,button8,button9,button0,button00,
            add,subtract,multiply,divide,percentage,clear,clear1value,equals,point;

    float valueOne,valueTwo;
    boolean Addition,Subtraction,Multiply,Divide,Percentage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_digital_calculator);
        editText=findViewById(R.id.input);
        button0=findViewById(R.id.button0);
        button00=findViewById(R.id.button00);
        button1=findViewById(R.id.button1);
        button2=findViewById(R.id.button2);
        button3=findViewById(R.id.button3);
        button4=findViewById(R.id.button4);
        button5=findViewById(R.id.button5);
        button6=findViewById(R.id.button6);
        button7=findViewById(R.id.button7);
        button8=findViewById(R.id.button8);
        button9=findViewById(R.id.button9);
        add=findViewById(R.id.add);
        subtract=findViewById(R.id.subtract);
        multiply=findViewById(R.id.multiply);
        divide=findViewById(R.id.divide);
        percentage=findViewById(R.id.percentage);
        clear=findViewById(R.id.clear);
        clear1value=findViewById(R.id.clear1value);
        equals=findViewById(R.id.equals);
        point=findViewById(R.id.point);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText()+"1");
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText()+"2");
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText()+"3");
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText()+"4");
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText()+"5");
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText()+"6");
            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText()+"7");
            }
        });

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText()+"8");
            }
        });

        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText()+"9");
            }
        });

        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText()+"0");
            }
        });

        button00.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText()+"00");
            }
        });

        point.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText()+".");
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText("");
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                valueOne=Float.parseFloat(editText.getText()+"");
                Addition=true;
                editText.setText(null);
            }
        });

        subtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                valueOne=Float.parseFloat(editText.getText()+"");
                Subtraction=true;
                editText.setText(null);
            }
        });

        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                valueOne=Float.parseFloat(editText.getText()+"");
                Multiply=true;
                editText.setText(null);
            }
        });

        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                valueOne=Float.parseFloat(editText.getText()+"");
                Divide=true;
                editText.setText(null);
            }
        });

        percentage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                valueOne=Float.parseFloat(editText.getText()+"");
                Percentage=true;
                editText.setText(null);
            }
        });

        equals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                valueTwo=Float.parseFloat(editText.getText()+"");

                if (Addition==true){
                    editText.setText(valueOne+valueTwo+"");
                    Addition=false;
                }
                else if (Subtraction==true){
                    editText.setText(valueOne-valueTwo+"");
                    Subtraction=false;
                }
                else if (Multiply==true){
                    editText.setText(valueOne*valueTwo+"");
                    Multiply=false;
                }
                else if(Divide==true){
                    editText.setText(valueOne/valueTwo+"");
                    Divide=false;
                }
                else if (Percentage==true){
                    editText.setText(valueOne*(valueTwo/100)+"");
                    Percentage=false;
                }
            }
        });

        clear1value.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String  value=editText.getText().toString();
                editText.setText(value.substring(0,value.length()-1));
            }
        });
    }
}
