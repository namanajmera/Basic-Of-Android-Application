package com.example.newapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Customized_Grid_View extends AppCompatActivity {

    GridView gv1;
    ArrayList<Students> al=new ArrayList<Students>();
    StudentAdapter ad;
    int[] imgid={R.drawable.photo,R.drawable.dalhousie,R.drawable.ic_launcher_background,R.drawable.ic_launcher_foreground};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customized__grid__view);
        al.add(new Students(1,"Naman",100,imgid));
        al.add(new Students(2,"hello",90,imgid));
        al.add(new Students(3,"Naman",70,imgid));
        al.add(new Students(4,"hello",60,imgid));

        gv1=findViewById(R.id.gridView);
        ad=new StudentAdapter();
        gv1.setAdapter(ad);
        gv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Students st=al.get(position);
                Toast.makeText(Customized_Grid_View.this,"Rollno: "+st.rollno + "\nName : " + st.name + "\nMarks : " + st.marks, Toast.LENGTH_SHORT).show();
            }
        });
    }
    class StudentAdapter extends BaseAdapter{
        @Override
        public int getCount() {
            return al.size();
        }

        @Override
        public Object getItem(int position) {
            return al.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }
        @Override
        public View getView(int position, View singleView, ViewGroup parent)
        {
            LayoutInflater inflater=getLayoutInflater();
            singleView=inflater.inflate(R.layout.student_details_grid_view,parent,false);
            TextView rollno=singleView.findViewById(R.id.rollno);
            TextView name=singleView.findViewById(R.id.name);
            TextView marks=singleView.findViewById(R.id.marks);
            ImageView imageView=singleView.findViewById(R.id.image);

            rollno.setText(al.get(position).rollno+"");
            name.setText(al.get(position).name+"");
            marks.setText(al.get(position).marks+"");
            imageView.setImageResource(imgid[position]);
            return singleView;
        }
    }
}
class Students{
    int rollno;
    String name;
    double marks;
    int imgId[];

    public Students(int r,String n,double m,int[] id)
    {
        rollno=r;
        name=n;
        marks=m;
        imgId=id;
    }
}
