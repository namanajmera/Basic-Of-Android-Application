package com.example.newapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class StudentRecord extends AppCompatActivity {

    ListView lv;
    ArrayList<Student> arrayList=new ArrayList<>();
    StudentAdapter ad;
    int imageid[]={R.drawable.photo,R.mipmap.ic_launcher};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_record);
        lv=findViewById(R.id.listView);
        arrayList.add(new Student(11908483,"Naman Ajmera",100,imageid));
        arrayList.add(new Student(11908481,"Nipun Agarwal",100,imageid));
        ad=new StudentAdapter();
        lv.setAdapter(ad);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Student st=arrayList.get(position);
                Toast.makeText(StudentRecord.this,"Rollno: "+ st.rollno+"\nName: "+st.name+ "\nMarks: "+st.marks,Toast.LENGTH_SHORT).show();
            }
        });
    }
        class StudentAdapter extends BaseAdapter {

            @Override
            public int getCount() {
                return arrayList.size();
            }

            @Override
            public Object getItem(int position) {
                return arrayList.get(position);
            }

            @Override
            public long getItemId(int position) {
                return position;
            }
            @Override
            public View getView(int position, View singleView, ViewGroup parent) {

                LayoutInflater inflater = LayoutInflater.from(parent.getContext());
                singleView = inflater.inflate(R.layout.student_details,parent, false);

                TextView tvRollno = (TextView) singleView.findViewById(R.id.roll);
                TextView tvName = (TextView) singleView.findViewById(R.id.name);
                TextView tvMarks = (TextView) singleView.findViewById(R.id.marks);
                ImageView imageView = (ImageView) singleView.findViewById(R.id.image);

                tvRollno.setText(arrayList.get(position).rollno + "");
                tvName.setText(arrayList.get(position).name);
                tvMarks.setText(arrayList.get(position).marks + "");
                imageView.setImageResource(imageid[position]);

                return singleView;
            }
        }
}

class Student{
    int rollno;
    String name;
    double marks;
    int image[];

    Student(int r,String n,double m,int id[])
    {
        rollno=r;
        name=n;
        marks=m;
        image=id;
    }
}