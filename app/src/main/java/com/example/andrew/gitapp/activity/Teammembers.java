package com.example.andrew.gitapp.activity;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.andrew.gitapp.R;
import com.example.andrew.gitapp.adapters.team1adapter;

public class Teammembers extends AppCompatActivity {
    public String overs,noplay,nowide;
    public int numplay;
    public RecyclerView recyclerView;
    public team1adapter tadapter;
    private String[] dataset = new String[14];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teammembers);
        overs=getIntent().getExtras().getString("overs");
        noplay=getIntent().getExtras().getString("noplay");
        nowide=getIntent().getExtras().getString("nowide");
        numplay=Integer.parseInt(noplay);
        for (int i=1;i<=numplay;i++)
            dataset[i]="player "+(i+1);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        tadapter = new team1adapter(dataset,numplay);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(tadapter);



    }


    }

