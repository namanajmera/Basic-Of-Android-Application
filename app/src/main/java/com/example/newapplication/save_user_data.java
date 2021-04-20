package com.example.newapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.InputType;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

public class save_user_data extends AppCompatActivity {

    EditText editText1,editText2;
    CheckBox checkBox1,checkBox2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save_user_data);
        editText1=findViewById(R.id.user);
        editText2=findViewById(R.id.pwrd);
        checkBox1=findViewById(R.id.save);
        checkBox2=findViewById(R.id.show);

        checkBox2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    editText2.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                }
                else
                {
                    editText2.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                }
            }
        });
    }

    public void save_details(View view) {
        String username=editText1.getText().toString();
        String pwd=editText2.getText().toString();
        if(checkBox1.isChecked())
        {
            SharedPreferences sharedPreferences= PreferenceManager.getDefaultSharedPreferences(this);
            SharedPreferences.Editor editor=sharedPreferences.edit();
            editor.putString("username",username);
            editor.putString("password",pwd);
            editor.commit();
            Toast.makeText(this,"Username and Password Save",Toast.LENGTH_LONG).show();
            editText1.setText("");
            editText2.setText("");
            checkBox1.setChecked(false);
            if (checkBox2.isChecked()) {
                checkBox2.setChecked(false);
            }
        }
        else
            Toast.makeText(this,"User not opted for string",Toast.LENGTH_LONG).show();
    }

    public void retrieve_data(View view) {
        SharedPreferences sharedPreferences=PreferenceManager.getDefaultSharedPreferences(this);
        String username=sharedPreferences.getString("username","No Data");
        editText1.setText(username);
        String pwd=sharedPreferences.getString("password","No Data");
        editText2.setText(pwd);
        //Toast.makeText(this,"",Toast.LENGTH_LONG).show();

    }

    public void clear_data(View view) {
        editText1.setText("");
        editText2.setText("");
        if(checkBox1.isChecked())
            checkBox1.setChecked(false);
        if(checkBox2.isChecked())
            checkBox2.setChecked(false);
    }

    public void clear_preferences(View view) {
        SharedPreferences sharedPreferences=PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.clear();
        editor.commit();
        Toast.makeText(this,"Cleared all the save data",Toast.LENGTH_LONG).show();
        editText1.setText("");
        editText2.setText("");
        if(checkBox1.isChecked())
            checkBox1.setChecked(false);
        if(checkBox2.isChecked())
            checkBox2.setChecked(false);

    }
}
