package com.example.tp2exercice1;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHandler extends SQLiteOpenHelper {

    public static final String TABLE_NAME ="contact";
    public static final String KEY ="id";
    public static final String NOM ="nom";
    public static final String PRENOM ="prenom";
    public static final String TELEPHONE ="telephone";
    public static final String TABLE_DROP = "DROP TABLE IF EXISTS "+TABLE_NAME+";";

    public static final String CREATE_TABLE ="CREATE TABLE "+TABLE_NAME+" ("+KEY +" INTEGER PRIMARY KEY AUTOINCREMENT, "+
            NOM+" TEXT, "+PRENOM+" TEXT, "+TELEPHONE+" TEXT);";

    public DatabaseHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(TABLE_DROP);
        onCreate(db);

    }

}
