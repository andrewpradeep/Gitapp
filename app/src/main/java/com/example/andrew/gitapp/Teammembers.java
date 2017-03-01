package com.example.andrew.gitapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class Teammembers extends AppCompatActivity {
    public String overs,noplay,nowide;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teammembers);
        overs=getIntent().getExtras().getString("overs");
        noplay=getIntent().getExtras().getString("noplay");
        nowide=getIntent().getExtras().getString("nowide");
        Toast.makeText(Teammembers.this," "+overs+" "+noplay+" "+nowide+" ",Toast.LENGTH_LONG).show();
    }
}
