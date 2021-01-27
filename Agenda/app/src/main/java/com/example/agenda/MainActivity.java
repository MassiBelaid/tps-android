package com.example.agenda;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends Activity {

    public final static int RESULT_CODE = 1;

    ListView listView;
    Button buttonAjouter;
    ListAdapter adapter;
    List<HashMap<String, String>> liste = new ArrayList <HashMap<String, String>>();
    HashMap<String, String> element ;
    AlertDialog.Builder ad = null;
    int pos = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listView);
        buttonAjouter = (Button) findViewById(R.id.buttonAjouter);





        final String[][] evens = new String[][]{
                {"12/FEVRIER/2020","Cours android au batiment 16"},
                {"14/MAI/2021","Mariage de John"},
                {"14/FEVRIER/2022","Coupe du monde au Qatar"},
                {"10/FEVRIER/2023","Fete des 10 ans de la chanson"}
        };
        for (int i=0; i<evens.length;i++){
            element = new HashMap<String, String>();
            element.put("v1",evens[i][0]);
            element.put("v2",evens[i][1]);
            liste.add(element);
            adapter = new SimpleAdapter(this,liste,android.R.layout.simple_list_item_2,
                    new String[]{"v1","v2"},new int[] {android.R.id.text1,android.R.id.text2});
        }

        listView.setAdapter(adapter);

        buttonAjouter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,AjoutActivity.class);
                startActivityForResult(i,RESULT_CODE);
            }
        });

        ad = new AlertDialog.Builder(this);

        ad.setCancelable(true);
        ad.setTitle("CONFIRMATION");


        ad.setPositiveButton("Confirmer", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                liste.remove(pos);
                adapter = new SimpleAdapter(MainActivity.this,liste,android.R.layout.simple_list_item_2,
                        new String[]{"v1","v2"},new int[] {android.R.id.text1,android.R.id.text2});
                listView.setAdapter(adapter);
                Toast.makeText(MainActivity.this,"élément supprimé",Toast.LENGTH_LONG).show();
            }
        });

        ad.setNegativeButton("Annuler", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this,"Opération annulée",Toast.LENGTH_LONG).show();
            }
        });


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                pos = position;
                ad.setMessage("Etes vous sur de vouloir supprimer l'événement : "+liste.get(pos).get("v2"));
                ad.show();
                //Toast.makeText(MainActivity.this,"élément "+liste.get(pos),Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == RESULT_CODE){
            if (resultCode == RESULT_OK){
                element = new HashMap<String, String>();
                element.put("v1",data.getStringExtra("date"));
                element.put("v2",data.getStringExtra("even"));
                liste.add(element);
                adapter = new SimpleAdapter(this,liste,android.R.layout.simple_list_item_2,
                        new String[]{"v1","v2"},new int[] {android.R.id.text1,android.R.id.text2});
                listView.setAdapter(adapter);
            }
        }
    }
}
