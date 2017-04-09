package com.example.andrew.gitapp.databases;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by andrew on 24/3/17.
 */

public class team2_db extends SQLiteOpenHelper {
    public static final String database_name="teams.db";
    public static final String table_name="team2";
    public static final String tab = "team1";
    public static final String column_name="name";
    public static final String column_runs="runs";
    public static final String column_ballsfaced="ballsfaced";
    public static final String column_wickets="wickets";
    public static final String column_oversbowled="oversbowled";
    public static final String column_runsconceded="runsconceded";


    public team2_db(Context context) {
        super(context, database_name, null, 1);

    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "+table_name+" (id integer primary key autoincrement,"+column_name+" text,"+column_runs+" integer,"+column_ballsfaced+" integer,"+column_wickets+" integer,"+column_oversbowled+" float,"+column_runsconceded+" integer);");
        Log.d("tab","table created");
        db.execSQL("create table "+tab+" (id integer primary key autoincrement,"+column_name+" text,"+column_runs+" integer,"+column_ballsfaced+" integer,"+column_wickets+" integer,"+column_oversbowled+" float,"+column_runsconceded+" integer);");
        Log.d("tab","table created");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists "+table_name);
        onCreate(db);

    }
    public boolean insertdata(String name,int runs,int ballsfaced,int wickets,float oversbowled,int runsconceded)
    {
        Log.e("name",name);

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(column_name,name);
        contentValues.put(column_runs,runs);
        contentValues.put(column_ballsfaced,ballsfaced);
        contentValues.put(column_wickets,wickets);
        contentValues.put(column_oversbowled,oversbowled);
        contentValues.put(column_runsconceded,runsconceded);
        long result = db.insert(table_name,null,contentValues);
        if(result == -1)
            return false;
        else {
            Log.e("insetr","table inserted");
            return true;
        }
    }
    public Cursor getalldata()
    {











        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from "+table_name,null);
        Log.e("get","data gotten");
        return res;
    }

    public void delete()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("delete from "+table_name);
    }
}

