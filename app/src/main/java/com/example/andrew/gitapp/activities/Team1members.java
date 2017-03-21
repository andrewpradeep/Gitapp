package com.example.andrew.gitapp.activities;

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
import com.example.andrew.gitapp.models.listteam1name;
import com.example.andrew.gitapp.models.team1names;

import java.util.List;

import static android.support.v7.recyclerview.R.styleable.RecyclerView;

public class Team1members extends AppCompatActivity {
    public String noplay;
    public  int numplay;
    public RecyclerView recyclerView;
    public team1adapter tadapter;
    private Button b1,b2;
    public List<listteam1name> pllist;



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team1members);
        noplay=getIntent().getExtras().getString("noplay");
        numplay=Integer.parseInt(noplay);


        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        team1names.setlistdata(numplay);

        tadapter = new team1adapter(team1names.getlistdata(),numplay);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(tadapter);

        b1=(Button)findViewById(R.id.team1_submit);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pllist = tadapter.retrieve_data();
                final listteam1name plname = pllist.get(1);
                Toast.makeText(Team1members.this,"the name is"+plname.getPlayername(),Toast.LENGTH_LONG).show();

                Intent intent = new Intent(Team1members.this,Teams.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                startActivity(intent);
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

