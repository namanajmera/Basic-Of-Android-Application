package com.example.newapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class LifeCycleOfActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life_cycle_of);
        Log.d("MYMASSAGE","onCreate Called");
    }

    @Override
    protected void onStart(){
        super.onStart();
        Log.d("MYMASSAGE","onStart Called");
    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.d("MYMASSAGE","onStart Called");
    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.d("MYMASSAGE","onStart Called");
    }

    @Override
    protected void onStop(){
        super.onStop();
        Log.d("MYMASSAGE","onStart Called");
    }

    @Override
    protected void onRestart(){
        super.onRestart();
        Log.d("MYMASSAGE","onStart Called");
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.d("MYMASSAGE","onStart Called");
    }

    public void show_dialog_box(View view) {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle("My Alert Dialog");
        builder.setMessage("This is a dialog message");
        builder.setCancelable(false);
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.create().show();
    }

    public void other_activity(View view) {
        startActivity(new Intent(this,DigitalCalculator.class));
    }
}
