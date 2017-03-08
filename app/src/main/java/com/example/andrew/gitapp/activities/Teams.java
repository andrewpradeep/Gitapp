package com.example.andrew.gitapp.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.andrew.gitapp.R;

public class Teams extends AppCompatActivity {
    private String overs,noplay,nowide;
    private Button b1,b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teams);
        overs=getIntent().getExtras().getString("overs");
        noplay=getIntent().getExtras().getString("noplay");
        nowide=getIntent().getExtras().getString("nowide");
        b1=(Button)findViewById(R.id.team1_button);
        b2=(Button)findViewById(R.id.team2_button);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Teams.this,Team1members.class);
                intent.putExtra("noplay",noplay);
                startActivity(intent);

            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(Teams.this,Team2members.class);
                intent.putExtra("noplay",noplay);
                startActivity(intent);
            }
        });
    }
}
