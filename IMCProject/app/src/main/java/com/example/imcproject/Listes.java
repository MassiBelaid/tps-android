package com.example.imcproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Listes extends AppCompatActivity {

    ListView myList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listes);

        myList = (ListView) findViewById(R.id.listView);

        String[][] repertoire  = new String[][] {
                {"Bill Gates","0661145929"},
                {"Pablo Escobar","0665548925"},
                {"Booba","0751659856"}
        };


        List<HashMap<String,String>> list = new ArrayList<HashMap<String, String>>();

        HashMap<String,String> element;

        for(int i=0; i<repertoire.length; i++){
            element = new HashMap<String, String>();
            element.put("text1",repertoire[i][0]);
            element.put("text2",repertoire[i][1]);
            list.add(element);
        }


        ListAdapter listAdap = new SimpleAdapter(this,list,android.R.layout.simple_list_item_2,new String[] {"text1","text2"},
                new int[] {android.R.id.text1,android.R.id.text2}
                );


        //Liste avec choix multiple
        /*ListAdapter listAdap = new SimpleAdapter(this,list,android.R.layout.simple_list_item_multiple_choice,new String[] {"text1","text2"},
                new int[] {android.R.id.text1,android.R.id.text2}
        );*/


        element = new HashMap<String, String>();
        element.put("text1","Emanuel Macron");
        element.put("text2","0548253659");






        myList.setAdapter(listAdap);
    }
}
