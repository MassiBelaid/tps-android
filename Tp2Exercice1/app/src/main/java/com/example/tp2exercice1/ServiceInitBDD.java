package com.example.tp2exercice1;

import android.app.IntentService;
import android.content.Intent;
import android.database.Cursor;

import androidx.annotation.Nullable;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class ServiceInitBDD extends IntentService {

    private final String[] contacts = {"Bil GATES 0761589232","Stive JOBS 0651243589","Marc ZUKERBERG 0431254869"};
    public final static String FILE_NAME = "contact_init";
    FileOutputStream output = null;
    FileInputStream input = null;
    StringBuilder sb;
    contactDao cDAO = new contactDao(this);

    @Override
    public int onStartCommand(@Nullable Intent intent, int flags, int startId) {
            //On Simule un fichier plein de contacte en créant un fichier et enregistrant quelque contactes.
        try {
            output = openFileOutput(FILE_NAME,MODE_PRIVATE);
            for (int i = 0; i<contacts.length ;i++){
                contacts[i] += ";";
                output.write(contacts[i].getBytes());
            }
            if(output != null){
                output.close();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return super.onStartCommand(intent, flags, startId);

    }

    public ServiceInitBDD() {
        super("ThisService");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {

        try {
            //On récupére tout les contacte du fichier
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

        String cons = sb.toString();
        String [] tCons = cons.split(";");
        //Pour chaque contacte dans notre fichier, on vérifie si ce contacte existe dans la BDD
        for (int j=0 ; j< tCons.length ; j++){
            cDAO.open();
            String[] info = tCons[j].split(" ");
            Cursor c = cDAO.selectContact(info[0],info[1],info[2]);
            if(!c.moveToNext()){
                //Si ce contacte existe pas, nous l'joutons a la BDD
                cDAO.ajouter(new Contact(info[0],info[1],info[2]));
            }

        }
        //On arrete le Service
        stopSelf();
    }
}
