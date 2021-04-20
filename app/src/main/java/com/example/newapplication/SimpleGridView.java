package com.example.newapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

public class SimpleGridView extends AppCompatActivity {

    ArrayList<String> arrayList=new ArrayList<>();
    GridView gv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        arrayList.add("John");
        arrayList.add("Paul");
        arrayList.add("Taylor");
        arrayList.add("Kristen");
        arrayList.add("Mitchelle");
        arrayList.add("Maggie");
        arrayList.add("Tweety");
        arrayList.add("Maria");
        arrayList.add("John");
        arrayList.add("Paul");
        arrayList.add("Taylor");
        arrayList.add("Kristen");
        arrayList.add("Mitchelle");
        arrayList.add("Maggie");
        arrayList.add("Tweety");
        arrayList.add("Maria");
        arrayList.add("Mario");
        arrayList.add("Marie");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_grid_view);
        gv1=findViewById(R.id.gridView);

        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(getBaseContext(),android.R.layout.simple_gallery_item,arrayList);
        gv1.setAdapter(arrayAdapter);
        gv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(SimpleGridView.this,arrayList.get(position),Toast.LENGTH_SHORT).show();
            }
        });
    }
}
