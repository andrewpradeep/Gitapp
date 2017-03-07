package com.example.andrew.gitapp.adapters;

import android.content.Context;
import android.graphics.Movie;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.andrew.gitapp.R;

import java.util.List;

/**
 * Created by andrew on 6/3/17.
 */

public class team1adapter extends RecyclerView.Adapter<team1adapter.Myviewholder>
{
    private LayoutInflater layoutInflater;
    public  team1adapter(Context c)
    {
      this.layoutInflater = LayoutInflater.from(c);
    }
    @Override
    public Myviewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View setview= layoutInflater.inflate(R.layout.teammem1adapt,parent,false);
        return new team1adapter(setview);
    }

    @Override
    public void onBindViewHolder(Myviewholder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class Myviewholder extends RecyclerView.ViewHolder{
    public EditText e1;
    public Myviewholder(View view)
    {
        super(view);
        e1 =(EditText)view.findViewById(R.id.edit_playname);

    }
}

}
