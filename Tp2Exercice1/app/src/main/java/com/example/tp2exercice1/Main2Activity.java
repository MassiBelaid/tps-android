package com.example.tp2exercice1;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends Activity {

    public final static String FILE_NAME = "Info_file";
    ListView listView = null;
    contactDao cDAO = new contactDao(this);
    FileInputStream input = null;
    StringBuilder sb;
    String[] info;
    AlertDialog.Builder ad = null;
    int pos = 0;
    Contact c1;
    List<String> contacts;
    ArrayAdapter<String> adapter;
    Cursor c;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        listView = (ListView) findViewById(R.id.idList);
         contacts = new ArrayList<String>();

         //On récupére le contacte dans le fichier ou il a été ajouté dans la premiére activité
        try {
            input = openFileInput(FILE_NAME);
            InputStreamReader inputStreamReader = new InputStreamReader(input);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            sb = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                sb.append(line);
            }
            inputStreamReader.close();

            if(input != null){
                input.close();

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        info = sb.toString().split(";");

        cDAO.open();
        //On ajoute le premier que   contacte récupéré du fichié dans la base de données
        c1 = new Contact(info[0],info[1],info[2]);
        cDAO.ajouter(c1);
        c = cDAO.selectioner();
        while (c.moveToNext()){
            //On ajoute tout les contactes de la base de données dans une liste afin de les afficher avec des adapter et listadapter
            contacts.add(c.getLong(0)+"_"+c.getString(1)+"_"+c.getString(2)+"_"+c.getString(3));

        }
        cDAO.close();



        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,contacts);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                pos = position;
                ad.setMessage("Supprimer le contacte : "+contacts.get(pos)+" ?");
                ad.show();
            }
        });

        ad = new AlertDialog.Builder(this);

        ad.setCancelable(true);
        ad.setTitle("CONFIRMATION");


        ad.setPositiveButton("Confirmer", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                cDAO.open();
                String[] identifiant = contacts.get(pos).split("_");
                //On supprime le contacte séléctioné si l'utilisateur clique sur confirmer
                cDAO.supprimer(Long.parseLong(identifiant[0]));
                cDAO.close();

                cDAO.open();

                contacts = new ArrayList<>();
                Cursor c2= cDAO.selectioner();

                while (c2.moveToNext()){
                    contacts.add(c2.getLong(0)+"_"+c2.getString(1)+"_"+c2.getString(2)+"_"+c2.getString(3));
                }
                adapter = new ArrayAdapter<String>(Main2Activity.this,android.R.layout.simple_list_item_1,contacts);
                listView.setAdapter(adapter);
                cDAO.close();
                Toast.makeText(Main2Activity.this,"élément supprimé",Toast.LENGTH_LONG).show();
            }
        });

        ad.setNegativeButton("Annuler", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(Main2Activity.this,"Opération annulée",Toast.LENGTH_LONG).show();
            }
        });

    }
}
