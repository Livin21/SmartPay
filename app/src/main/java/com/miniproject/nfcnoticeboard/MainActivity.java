package com.miniproject.nfcnoticeboard;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends Activity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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