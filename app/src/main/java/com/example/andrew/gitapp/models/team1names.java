package com.example.andrew.gitapp.models;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by andrew on 7/3/17.
 */

public class team1names {

    private  static String[] playername;
    private  static int numplayer;
    public  static void setlistdata(int numplay )
    {
        numplayer=numplay;
        playername =new String[numplay];
        for(int i=0;i<numplay;i++)
            playername[i]="player "+(i+1);
        Log.e("idiot","you are an idiot");
    }
    public static void setdatalist(String[] pllist,int numplay)
    {
        numplayer = numplay;
        playername = new String[numplay];
        for(int i=0;i<numplay;i++) {
            playername[i] = pllist[i];
            Log.e("error", pllist[i].toString());
        }

    }
     public static List<listteam1name>getlistdata()
     {
         List<listteam1name> data = new ArrayList<>();
         for(int i=0;i<numplayer;i++)
         {
             listteam1name pname = new listteam1name();
             pname.setPlayername(playername[i]);
             data.add(pname);
         }
         return data;
     }
}
