package com.example.newapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Media_Player_Activity extends AppCompatActivity {

    ListView lv;
    String song[]={"Animals","Waada","Yaadein"};
    Integer songId[]={R.raw.animals,R.raw.waada,R.raw.yaadein};
    MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media__player_);
        lv = findViewById(R.id.listView1);
        mp = new MediaPlayer();

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, song);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                playSong(position);
            }
        });
    }
    public void playSong(int songIndex)
    {
        mp.reset();
        mp= MediaPlayer.create(this,songId[songIndex]);
        mp.start();
    }

    public void onDestroy()
    {
        super.onDestroy();
        mp.release();
    }
}

