package com.example.newapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv1=findViewById(R.id.tv1);
    }

    public void Show_Toast(View view) {
        Toast.makeText(this,"This is my first Application",Toast.LENGTH_LONG).show();
    }

    public void show_calculator_activity(View view) {
        Intent i1=new Intent(this,calculatorActivity.class);
        startActivity(i1);
    }

    public void show_class_assignment1(View view) {
        Intent i2=new Intent(this,ClassAssignment1.class);
        startActivity(i2);
    }
    //sending the data to another activity
    public void receiving_data(View view) {
        Intent i3=new Intent(this,receiving_activity1.class);
        i3.putExtra("Student_Name","Naman Ajmera");
        i3.putExtra("Registration Number",11908483);
        i3.putExtra("CGPA",8.67);

     //store data in bundle and passing into multiple activity and text views
        Bundle b=new Bundle();
        b.putString("Student_Name","Naman Ajmera");
        b.putInt("Registration Number",11908483);
        b.putDouble("CGPA",8.67);
        b.putDouble("Fees",50000.0);
        b.putBoolean("Status",true);
        i3.putExtra("Bundle",b);
        startActivity(i3);
    }

    public void lab_evaluation_1(View view) {
        Intent i4=new Intent(this,BMICalculator.class);
        startActivity(i4);
    }

    public void lab_evaluation_1_1(View view) {
        Intent i5=new Intent(this,grossSalary.class);
        startActivity(i5);
    }

    public void web_page_view(View view) {
        Intent i6=new Intent(this,webView.class);
        startActivity(i6);
    }

    public void CB_RB_Demo(View view) {
        Intent i7=new Intent(this,CB_RB_Demo.class);
        startActivity(i7);
    }

    public void save_details(View view) {
        Intent i8=new Intent(this,save_user_data.class);
        startActivity(i8);
    }

    public void class_assignment_2(View view) {
        Intent i9=new Intent(this,class_assignment_2.class);
        startActivity(i9);
    }

    public void lab_evaluation_2(View view) {
        Intent i10=new Intent(this,Job_Application_Form.class);
        startActivity(i10);
    }

    public void open_media_player(View view) {
        Intent i11=new Intent(this,Media_Player_Activity.class);
        startActivity(i11);
    }

    public void customized_view(View view) {
        Intent i12=new Intent(this,StudentRecord.class);
        startActivity(i12);
    }

    public void grid_view(View view) {
        Intent i13=new Intent(this,SimpleGridView.class);
        startActivity(i13);
    }

    public void customized_grid_view(View view) {
        Intent i14=new Intent(this,Customized_Grid_View.class);
        startActivity(i14);
    }

    public void menu_item(View view) {
        Intent i15=new Intent(this,OpenMenuOptionsActivity.class);
        startActivity(i15);
    }

    public void all_apps(View view) {
        Intent i16=new Intent(this,All_Apps_Activity.class);
        startActivity(i16);
    }

    public void implicit(View view) {
        Intent i17=new Intent(this,Implicit_Intents.class);
        startActivity(i17);
    }

    public void getting_result_back(View view) {
        Intent i18=new Intent(this,Second_Activity.class);
        startActivityForResult(i18,70);
    }
    @Override
    protected void onActivityResult(int requestCode,int resultCode, Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        if (requestCode==70 && resultCode==RESULT_OK){
            String name=data.getStringExtra("name");
            tv1.setText("Receiving data:- "+name);
        }
        else if (requestCode==70 && resultCode==RESULT_CANCELED){
            Toast.makeText(getBaseContext(),"Nothing Input",Toast.LENGTH_LONG).show();
        }
    }

    public void clear(View view) {
        tv1.setText("Code will be display here after we click below button:- ");
    }

    public void digital_calculator(View view) {
        Intent i19=new Intent(this,DigitalCalculator.class);
        startActivity(i19);
    }

    public void firebase(View view) {
        Intent i20=new Intent(this,FirebaseActivity.class);
        startActivity(i20);
    }


    public void sqlite(View view) {
        Intent i21=new Intent(this,SQLiteActivity.class);
        startActivity(i21);
    }

    public void life_cycle(View view) {
        Intent i22=new Intent(this,LifeCycleOfActivity.class);
        startActivity(i22);
    }

    public void sqlite_assignment(View view) {
        Intent i23=new Intent(this,SQLite_Assignment.class);
        startActivity(i23);
    }
}
