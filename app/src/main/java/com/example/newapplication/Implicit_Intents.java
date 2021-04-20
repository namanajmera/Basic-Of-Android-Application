package com.example.newapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class Implicit_Intents extends AppCompatActivity {

    EditText editTextReceipient,editTextSubject,editTextMessage;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_implicit__intents);
        editTextReceipient=findViewById(R.id.receipient);
        editTextSubject=findViewById(R.id.subject);
        editTextMessage=findViewById(R.id.message);
        imageView=findViewById(R.id.image);
    }

    public void open_camera(View view) {
        Intent cameraIntent=new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(cameraIntent,1);
    }

    protected void onActivityResult(int requestCode,int resultCode,Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            imageView.setImageBitmap(photo);
        }
    }

    public void send_email(View view) {
        String to=editTextReceipient.getText().toString();
        String subject=editTextSubject.getText().toString();
        String message=editTextMessage.getText().toString();
        Intent email=new Intent(Intent.ACTION_SEND);
        email.putExtra(Intent.EXTRA_EMAIL,new String[]{to});
        email.putExtra(Intent.EXTRA_SUBJECT,subject);
        email.putExtra(Intent.EXTRA_TEXT,message);

        email.setType("message/rfc822");
        startActivity(Intent.createChooser(email,"Choose an Email client:"));
    }

    public void web_page(View view) {
        Intent webpage=new Intent(Intent.ACTION_VIEW);
        webpage.setData(Uri.parse("http://www.w3schools.com"));
        startActivity(webpage);
    }

    public void open_dialer(View view) {
        Intent call=new Intent(Intent.ACTION_DIAL);
        call.setData(Uri.parse("tel:"+8696696426L));
        startActivity(call);
    }

    public void clear(View view) {
        editTextMessage.setText("");
        editTextSubject.setText("");
        editTextReceipient.setText("");
        imageView.setImageDrawable(null);
        imageView.setImageResource(R.drawable.ic_launcher_background);
    }
}
