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
import com.example.andrew.gitapp.adapters.team2adapter;
import com.example.andrew.gitapp.databases.team1_db;
import com.example.andrew.gitapp.databases.team2_db;
import com.example.andrew.gitapp.models.listteam2name;
import com.example.andrew.gitapp.models.team1names;
import com.example.andrew.gitapp.models.team2names;

import java.util.List;

public class Team2members extends AppCompatActivity {

    public String noplay;
    public String[] plalist;
    public  int numplay;
    public RecyclerView recyclerView;
    public team2adapter tadapter;
    private Button b1,b2;
    public List<listteam2name> pllist;
    public team2_db db;



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team2members);
        noplay=getIntent().getExtras().getString("noplay");
        numplay=Integer.parseInt(noplay);
        db = new team2_db(this);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        Cursor res = db.getalldata();
        String dtcont =Integer.toString(res.getCount());

        Log.e("dtacount",dtcont);
        if(res.getCount()< numplay) {
            Log.e("error","no table found");

            team2names.setlistdata(numplay);

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
            team2names.setdatalist(plalist,numplay);
        }
        tadapter = new team2adapter(team2names.getlistdata(),numplay);
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
                    listteam2name plname = pllist.get(i);
                    db.insertdata(plname.getPlayername().toString(),0,0,0,0,0);
                }
                Intent intent = new Intent(Team2members.this,Teams.class);
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

