package com.example.testekamba.controllers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.testekamba.R;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        getSupportActionBar().hide();
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                showActivity();
            }
        }, 5000);
    }

    private void showActivity() {
       startActivity(new Intent(this, DescUser.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK));
       MainActivity.this.finish();
    }


}


//startActivity(new Intent(this, DescUser.class).
//                    addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK));