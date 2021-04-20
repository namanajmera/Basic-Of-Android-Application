package com.example.newapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;

public class webView extends AppCompatActivity {

    WebView webView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        webView1=findViewById(R.id.wv1);
    }

    public void show_web_page(View view)
    {
        webView1.loadUrl("https://www.w3schools.com");
    }

    public void show_web_code(View view) {
        String data="<html><body><h1>This is my Web Page</h1></body></html>";
        webView1.loadData(data,"text/html","UTF-8");
    }

    public void clear(View view) {
        webView1.clearView();
    }

    public void show_local_page(View view) {
        webView1.loadUrl("file:///android_asset/index.html");
    }
}
