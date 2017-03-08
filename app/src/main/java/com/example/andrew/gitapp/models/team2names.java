package com.example.andrew.gitapp.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by andrew on 8/3/17.
 */

public class team2names {

    private  static String[] playername;
    private  static int numplayer;
    public  static void setlistdata(int numplay)
    {
        numplayer=numplay;
        playername =new String[numplay];
        for(int i=0;i<numplay;i++)
            playername[i]="player "+(i+1);
    }
    public static List<listteam2name> getlistdata()
    {
        List<listteam2name> data = new ArrayList<>();
        for(int i=0;i<numplayer;i++)
        {
            listteam2name pname = new listteam2name();
            pname.setPlayername(playername[i]);
            data.add(pname);
        }
        return data;
    }
}
