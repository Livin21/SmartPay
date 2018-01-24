package com.lmntrx.android.smartpay;



import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;


public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Authentication.signIn(this, FirebaseAuth.getInstance());

    }


    public void callWriter(View view) {

        Intent intent=new Intent(this,NFCWriter.class);
        this.startActivity(intent);
    }


    public void callReader(View view) {

        Intent intent=new Intent(this,NFCReader.class);
        this.startActivity(intent);
    }




}