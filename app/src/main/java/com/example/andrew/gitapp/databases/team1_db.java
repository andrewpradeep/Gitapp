package com.example.andrew.gitapp.databases;

import android.content.ContentValues;
import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by andrew on 20/3/17.
 */

public class team1_db extends SQLiteOpenHelper {
    public static final String database_name="teams.db";
    public static final String table_name="team1";
    public static final String column_name="name";
    public static final String column_runs="runs";
    public static final String column_ballsfaced="ballsfaced";
    public static final String column_wickets="wickets";
    public static final String column_oversbowled="oversbowled";
    public static final String column_runsconceded="runsconceded";


    public team1_db(Context context) {
        super(context, database_name, null, 1);

    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "+table_name+" (id INTEGER PRIMARY KEY AUTOINCREMENT,name TEXT,runs INTEGER,ballsffaced INTEGER,wickets INTEGER,oversbowled FLOAT,runsconceded INTEGER");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists "+table_name);
        onCreate(db);

    }
    public boolean insertdata(String name,String runs,String ballsfaced,String wickets,String oversbowled,String runsconceded)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(column_name,name);
        contentValues.put(column_runs,runs);
        contentValues.put(column_ballsfaced,ballsfaced);
        contentValues.put(column_wickets,wickets);
        contentValues.put(column_oversbowled,oversbowled);
        contentValues.put(column_runsconceded,runsconceded);
        db.insert(table_name,null,contentValues);

    }
}
