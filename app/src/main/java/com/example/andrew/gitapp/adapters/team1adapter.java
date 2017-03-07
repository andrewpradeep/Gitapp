package com.example.andrew.gitapp.adapters;

import android.content.Context;
import android.graphics.Movie;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
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
{   private String[] dataset;
    private LayoutInflater layoutInflater;
    private int numplay;
    public  team1adapter(String[] dataset,int numplay)
    {
        this.dataset=dataset;
        this.numplay=numplay;

    }
    @Override
    public Myviewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View setview= LayoutInflater.from(parent.getContext()).inflate(R.layout.teammem1adapt,parent,false);
        Myviewholder viewh= new Myviewholder(setview);
        return viewh;
    }

    @Override
    public void onBindViewHolder(Myviewholder holder, final int position) {
        holder.e1.setText(dataset[position]);
        holder.e1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                dataset[position]=charSequence.toString();

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

    }

    @Override
    public int getItemCount() {
        return numplay;
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
