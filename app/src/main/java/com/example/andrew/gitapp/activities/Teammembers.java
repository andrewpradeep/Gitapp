package com.example.andrew.gitapp.activities;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.andrew.gitapp.R;
import com.example.andrew.gitapp.adapters.team1adapter;
import com.example.andrew.gitapp.models.listteamname;
import com.example.andrew.gitapp.models.teamnames;

import java.util.List;

public class Teammembers extends AppCompatActivity {
    public String overs,noplay,nowide;
    public  int numplay;
    public RecyclerView recyclerView;
    public team1adapter tadapter;
    private Button b1,b2;
    public List<listteamname> pllist;



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teammembers);
        overs=getIntent().getExtras().getString("overs");
        noplay=getIntent().getExtras().getString("noplay");
        nowide=getIntent().getExtras().getString("nowide");
        numplay=Integer.parseInt(noplay);


        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        teamnames.setlistdata(numplay);

        tadapter = new team1adapter(teamnames.getlistdata(),numplay);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(tadapter);

        b1=(Button)findViewById(R.id.team1_submit);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pllist = tadapter.retrieve_data();
                final listteamname plname = pllist.get(1);
                Toast.makeText(Teammembers.this,"the name is"+plname.getPlayername(),Toast.LENGTH_LONG).show();
            }
        });
        b2=(Button)findViewById(R.id.team1_back);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });



    }


    }

