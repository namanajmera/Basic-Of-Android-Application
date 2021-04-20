package com.example.newapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class SQLiteActivity extends AppCompatActivity {


    ListView lv1;
    SQLiteDatabase db;
    //operations for updating,selecting,inserting the data from the table
    ArrayList<Studentss> al=new ArrayList<>();
    StudnetsAdapter ad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_s_q_lite);
        lv1=findViewById(R.id.lv1);
        ad=new StudnetsAdapter();
        lv1.setAdapter(ad);
    }

    public void createDB(View view) {
        db=openOrCreateDatabase("MyDB",MODE_PRIVATE,null);
        Toast.makeText(getBaseContext(),"DB Created",Toast.LENGTH_SHORT).show();
    }

    public void createTable(View view) {
        db.execSQL("CREATE TABLE IF NOT EXISTS student"+"(rollno number primary key,name varchar,marks real)");
        Toast.makeText(getBaseContext(),"Table Created",Toast.LENGTH_SHORT).show();
    }

    public void view_table_information(View view) {
        fetchDataFromDatabase();
        Toast.makeText(SQLiteActivity.this,"Data Fetched Successfully",Toast.LENGTH_SHORT).show();
    }

    public void insertRow(View view) {
        final Dialog d=new Dialog(this);
        d.setContentView(R.layout.layout_for_insert_row);
        d.setTitle("Insert Data");
        final EditText etRollno=d.findViewById(R.id.etrollno);
        final EditText etName=d.findViewById(R.id.etname);
        final EditText etMarks=d.findViewById(R.id.etmarks);
        Button btInsert=d.findViewById(R.id.btInsert);
        Button btCancel=d.findViewById(R.id.btCancel);

        btInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int rollno=Integer.parseInt(etRollno.getText().toString());
                String name=etName.getText().toString();
                double marks=Double.parseDouble(etMarks.getText().toString());
                ContentValues contentValues=new ContentValues();
                contentValues.put("name",name);
                contentValues.put("rollno",rollno);
                contentValues.put("marks",marks);
                db.insert("student",null,contentValues);
              //  String query="INSERT INTO student values("+rollno+","+name+","+marks+");";
              //  db.execSQL(query);
                //db.execSQL("INSERT INTO student VALUES(rollno,name,marks)");

                Toast.makeText(getBaseContext(),"Record Inserted",Toast.LENGTH_SHORT).show();
              //  fetchDataFromDatabase();
                d.dismiss();
            }
        });

        btCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                d.dismiss();
            }
        });
        d.show();
    }

    public void updateRow(View view) {
        db.execSQL("UPDATE student SET name='Hello' WHERE rollno=2");
        Toast.makeText(this,"RECORD UPDATED",Toast.LENGTH_LONG).show();
        fetchDataFromDatabase();
    }

    public void deleteRow(View view) {
        db.execSQL("DELETE FROM student WHERE rollno=1");
        Toast.makeText(this,"RECORD DELETED",Toast.LENGTH_LONG).show();
        fetchDataFromDatabase();
    }

    private void fetchDataFromDatabase() {
        al.clear();
        //point to a single of the result set
        Cursor c=db.query("student",null,null,null,null,null,"rollno desc");
        while (c.moveToNext()){
            //After fetching the values from row 1 of table
            int r=c.getInt(c.getColumnIndex("rollno"));
            String n=c.getString(c.getColumnIndex("name"));
            double m=c.getDouble(c.getColumnIndex("marks"));
            //for showing it in the list view we are adding it in the ArrayList
            al.add(new Studentss(r,n,m));
        }
        //refreshing the ArrayList if something is changed
        ad.notifyDataSetChanged();
    }

    public void clear(View view) {
        al.clear();
        ad.notifyDataSetChanged();
        Toast.makeText(getBaseContext(),"Recorded Clear form Screen",Toast.LENGTH_SHORT).show();
    }

    class Studentss{
        int rollno;
        String name;
        double marks;

        public Studentss(int rollno,String name,double marks){
            this.rollno=rollno;
            this.name=name;
            this.marks=marks;
        }
    }

    class StudnetsAdapter extends BaseAdapter{

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
        public View getView(int position, View singleView, ViewGroup parent) {
            LayoutInflater inflater=LayoutInflater.from(parent.getContext());
            singleView= inflater.inflate(R.layout.student_single_list_item,parent,false);
            TextView tvRollno=singleView.findViewById(R.id.tvrollno);
            TextView tvName=singleView.findViewById(R.id.tvname);
            TextView tvMarks=singleView.findViewById(R.id.tvmarks);

            tvRollno.setText(al.get(position).rollno+"");
            tvName.setText(al.get(position).name+"");
            tvMarks.setText(al.get(position).marks+"");

            return singleView;

        }
    }
}
