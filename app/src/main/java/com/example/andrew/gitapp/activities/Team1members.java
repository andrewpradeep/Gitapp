package com.example.andrew.gitapp.activities;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.andrew.gitapp.R;
import com.example.andrew.gitapp.adapters.team1adapter;
import com.example.andrew.gitapp.databases.team1_db;
import com.example.andrew.gitapp.models.listteam1name;
import com.example.andrew.gitapp.models.team1names;

import java.util.ArrayList;
import java.util.List;

import static android.support.v7.recyclerview.R.styleable.RecyclerView;

public class Team1members extends AppCompatActivity {
    public String noplay;
    String[] plalist;
    public  int numplay;
    public RecyclerView recyclerView;
    public team1adapter tadapter;
    private Button b1,b2;
    public List<listteam1name> pllist;
    public team1_db db;



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team1members);
        noplay=getIntent().getExtras().getString("noplay");
        numplay=Integer.parseInt(noplay);
        db = new team1_db(this);
        Log.e("error","error");


        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        Cursor res = db.getalldata();
        String dtcont =Integer.toString(res.getCount());

        Log.e("dtacount",dtcont);
        if(res.getCount()< numplay) {
            Log.e("error","no table found");

            team1names.setlistdata(numplay);

        }
        else{
            Log.e("error","data found");
             plalist = new String[numplay];
            res.moveToFirst();
            for(int i=0;i<numplay;i++)
            {

                plalist[i]=res.getString(1);
                Log.e("fromtab",plalist[i]);
                res.moveToNext();
            }
            team1names.setdatalist(plalist,numplay);
        }

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

                db.delete();
                for(int i=0;i<pllist.size();i++) {
                    listteam1name plname = pllist.get(i);

                    db.insertdata(plname.getPlayername().toString(), 0, 0, 0, 0, 0);
                }


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

