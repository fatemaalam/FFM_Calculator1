package com.example.ffmcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;


        import android.content.Intent;

        import android.os.Handler;



public class MainActivity extends AppCompatActivity {

    Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_page);

        handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(MainActivity.this,feature.class);
                startActivity(intent);
                finish();
            }
        },3000);

    }
}
