package com.example.andrew.gitapp;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

public class Teammembers extends AppCompatActivity {
    public String overs,noplay,nowide;
    public int numplay;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teammembers);
        overs=getIntent().getExtras().getString("overs");
        noplay=getIntent().getExtras().getString("noplay");
        nowide=getIntent().getExtras().getString("nowide");
        numplay=Integer.parseInt(noplay);
        GridView gridview = (GridView) findViewById(R.id.gridview);
        gridview.setAdapter(new ImageAdapter(this));

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                Toast.makeText(Teammembers.this, "" + position,
                        Toast.LENGTH_SHORT).show();
            }
        });



    }
    public class ImageAdapter extends BaseAdapter {
        private Context mContext;

        public ImageAdapter(Context c) {
            mContext = c;
        }

        public int getCount() {
            return numplay;
        }

        public Object getItem(int position) {
            return null;
        }

        public long getItemId(int position) {
            return 0;
        }

        // create a new ImageView for each item referenced by the Adapter
        public View getView(int position, View convertView, ViewGroup parent) {


            LinearLayout row = (LinearLayout) (convertView == null
                    ? LayoutInflater.from(mContext).inflate(R.layout.teammem1grid, parent, false)
                    : convertView);
            return  row;
        }


    }
}
