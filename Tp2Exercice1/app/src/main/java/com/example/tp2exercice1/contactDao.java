package com.example.tp2exercice1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

public final class contactDao extends DAOBase{
    public static final String TABLE_NAME ="contact";
    public static final String KEY ="id";
    public static final String NOM ="nom";
    public static final String PRENOM ="prenom";
    public static final String TELEPHONE ="telephone";

    public static final String CREATE_TABLE ="CREATE TABLE"+TABLE_NAME+" ("+KEY +" INTEGER PRIMARY KEY AUTOINCREMENT, "+
            NOM+" TEXT, "+PRENOM+" TEXT, "+TELEPHONE+" TEXT);";

    public static final String TABLE_DROP = "DROP TABLE IF EXISTS "+TABLE_NAME+";";

    public contactDao(Context pContext) {
        super(pContext);
    }



    public void ajouter(Contact c){
        ContentValues value = new ContentValues();
        value.put(NOM,c.getNom());
        value.put(PRENOM,c.getPrenom());
        value.put(TELEPHONE,c.getTel());
        mDb.insert(TABLE_NAME,null,value);
    }

    public Cursor selectioner(){
        Cursor c = mDb.rawQuery("SELECT * FROM "+TABLE_NAME+";",null);
        return c;
    }

    public  Cursor selectContact(String nom, String prenom, String tel){
        Cursor c = mDb.rawQuery("select * from "+TABLE_NAME+" where "+NOM+" = ? and "+PRENOM+" = ? and "+TELEPHONE+" = ? ", new String[] {nom, prenom, tel});
        return c;
    }

    public void supprimer(long id){
        mDb.delete(TABLE_NAME, KEY +" = ?",new String[] {String.valueOf(id)});
    }
}
