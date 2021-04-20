package com.example.newapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class All_Apps_Activity extends AppCompatActivity {


    GridView gv1;
    AppsAdapter appsAdapter;
    ArrayList<Apps> arrayList=new ArrayList<Apps>();

    int[] imgid={R.drawable.calculatoricon,R.drawable.job_application_form,R.drawable.media_player,
            R.drawable.student_record,R.drawable.web_view,R.drawable.image,
            R.drawable.shared_preferences,R.drawable.option_menu,R.drawable.grid_view};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all__apps_);
        arrayList.add(new Apps("Calculator",imgid));
        arrayList.add(new Apps("Job Application Form",imgid));
        arrayList.add(new Apps("Media Player",imgid));
        arrayList.add(new Apps("Student Record",imgid));
        arrayList.add(new Apps("Web View",imgid));
        arrayList.add(new Apps("Splash Screen",imgid));
        arrayList.add(new Apps("Shared Preferences",imgid));
        arrayList.add(new Apps("Option Menu",imgid));
        arrayList.add(new Apps("Grid View",imgid));

        gv1=findViewById(R.id.gridView);
        appsAdapter=new AppsAdapter();
        gv1.setAdapter(appsAdapter);
        gv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Apps apps=arrayList.get(position);
                if(position==0)
                {
                    Intent i=new Intent(getApplicationContext(),calculatorActivity.class);
                    startActivity(i);
                }
                else if(position==1)
                {
                    Intent i=new Intent(getApplicationContext(),Job_Application_Form.class);
                    startActivity(i);
                }
                else if(position==2)
                {
                    Intent i=new Intent(getApplicationContext(),Media_Player_Activity.class);
                    startActivity(i);
                }
                else if(position==3)
                {
                    Intent i=new Intent(getApplicationContext(),StudentRecord.class);
                    startActivity(i);
                }
                else if(position==4)
                {
                    Intent i=new Intent(getApplicationContext(),webView.class);
                    startActivity(i);
                }
                else if(position==5)
                {
                    Intent i=new Intent(getApplicationContext(),SplashScreenActivity.class);
                    startActivity(i);
                }
                else if(position==6)
                {
                    Intent i=new Intent(getApplicationContext(),save_user_data.class);
                    startActivity(i);
                }
                else if(position==7)
                {
                    Intent i=new Intent(getApplicationContext(),OpenMenuOptionsActivity.class);
                    startActivity(i);
                }
                else if(position==8) {
                    Intent i = new Intent(getApplicationContext(),Customized_Grid_View.class);
                    startActivity(i);
                }
            }
        });
    }

    class AppsAdapter extends BaseAdapter{
        @Override
        public int getCount(){
            return arrayList.size();
        }
        @Override
        public Object getItem(int position){
            return arrayList.get(position);
        }
        @Override
        public long getItemId(int position){
            return position;
        }
        @Override
        public View getView(int position,View singleView, ViewGroup parent)
        {
            LayoutInflater layoutInflater=getLayoutInflater();
            singleView=layoutInflater.inflate(R.layout.all_apps,parent,false);
            TextView name=singleView.findViewById(R.id.name);
            ImageView imageView=singleView.findViewById(R.id.image);

            name.setText(arrayList.get(position).name+"");
            imageView.setImageResource(imgid[position]);
            return singleView;
        }
    }
}


class Apps{
    String name;
    int imgId[];

    public Apps(String n,int[] id)
    {
        name=n;
        imgId=id;
    }
}