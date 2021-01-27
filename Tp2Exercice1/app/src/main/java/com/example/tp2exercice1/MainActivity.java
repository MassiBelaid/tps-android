package com.example.tp2exercice1;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.NonNull;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends Activity {

    public final static int RESULT_CODE = 1;
    public final static String FILE_NAME = "Info_file";
    contactDao cDAO = new contactDao(this);

    EditText eNom, ePrenom, eTel;
    TextView message,textCompteur;
    Button bValider;
    int compteur ;
    FileOutputStream output = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        compteur = 0;

        setContentView(R.layout.activity_main);

        eNom = (EditText) findViewById(R.id.eNom);
        ePrenom = (EditText) findViewById(R.id.ePrenom);
        eTel = (EditText) findViewById(R.id.eTel);
        message = (TextView) findViewById(R.id.textMessage);
        bValider = (Button) findViewById(R.id.bValider);
        textCompteur = (TextView) findViewById(R.id.textCompteur);

        Intent iService = new Intent(this, ServiceInitBDD.class);
        startService(iService);

        bValider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (eNom.getText().toString().equals("") || ePrenom.getText().toString().equals("") || eTel.getText().toString().equals("") ){
                    message.setVisibility(View.VISIBLE);
                }else{

                    //Ecriture des informations du contacte dans un fichier
                    String info_perso = eNom.getText().toString()+";"+ePrenom.getText().toString()+";"+eTel.getText().toString();
                    try {
                        output = openFileOutput(FILE_NAME,MODE_PRIVATE);
                        output.write(info_perso.getBytes());
                        if(output != null){
                            output.close();
                        }
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    Intent i = new Intent(MainActivity.this,Main2Activity.class);

                    startActivityForResult(i,RESULT_CODE);
                }
            }
        });
    }


    @Override
    protected void onResume() {
        super.onResume();
        compteur++;
        textCompteur.setText(compteur+"");
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("compteur",compteur);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if(savedInstanceState != null && savedInstanceState.containsKey("compteur")){
            compteur = savedInstanceState.getInt("compteur");
        }
    }
}
