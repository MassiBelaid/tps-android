package com.example.tp1exercice3;

import android.app.AlertDialog;
import android.app.Activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class WithXML extends Activity {

    public final static int REQUEST_CODE = 0;
    private Button bValider = null;
    AlertDialog.Builder ad = null;
    EditText etNom,etPrenom,etDC,etTel,etAge;
    private boolean isColored;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_with_xml);

        isColored = false;

        etNom = (EditText)findViewById(R.id.etNom);
        etDC = (EditText)findViewById(R.id.etDC);
        etPrenom = (EditText)findViewById(R.id.etPrenom);
        etAge = (EditText)findViewById(R.id.etAge);
        etTel = (EditText)findViewById(R.id.etTel);

        ad = new AlertDialog.Builder(this);

        ad.setCancelable(true);
        ad.setTitle(R.string.titreDialogBox);
        ad.setMessage(R.string.messageDialogBox);

        ad.setPositiveButton(R.string.textPositif, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (etNom.getText().toString().matches("") || etPrenom.getText().toString().matches("") ||
                    etDC.getText().toString().matches("") || etAge.getText().toString().matches("") || etTel.getText().toString().matches("")){

                    Toast.makeText(getApplicationContext(),R.string.reponsePositive,Toast.LENGTH_SHORT).show();}
                else{
                    String nom = etNom.getText().toString();
                    String prenom = etPrenom.getText().toString();
                    String dc = etDC.getText().toString();
                    int age = Integer.parseInt(etAge.getText().toString());
                    String tel = etTel.getText().toString();

                    Intent i = new Intent(WithXML.this,SecondActivity.class);
                    i.putExtra("nom",nom);
                    i.putExtra("prenom",prenom);
                    i.putExtra("age",age);
                    i.putExtra("dc",dc);
                    i.putExtra("tel",tel);

                    startActivityForResult(i,REQUEST_CODE);
                }
            }
        });

        ad.setNegativeButton(R.string.textNegatif, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(),R.string.reponseNegative,Toast.LENGTH_SHORT).show();
            }
        });

        ad.setNeutralButton(R.string.textNeutre, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (!isColored){
                    isColored = true;
                    etNom.setBackgroundColor(getResources().getColor(R.color.rougeEditText));
                    etAge.setBackgroundColor(getResources().getColor(R.color.rougeEditText));
                    etDC.setBackgroundColor(getResources().getColor(R.color.rougeEditText));
                    etTel.setBackgroundColor(getResources().getColor(R.color.rougeEditText));
                    etPrenom.setBackgroundColor(getResources().getColor(R.color.rougeEditText));
                }else{
                    isColored = false;
                    etNom.setBackgroundColor(getResources().getColor(R.color.couleurDeBase));
                    etAge.setBackgroundColor(getResources().getColor(R.color.couleurDeBase));
                    etDC.setBackgroundColor(getResources().getColor(R.color.couleurDeBase));
                    etTel.setBackgroundColor(getResources().getColor(R.color.couleurDeBase));
                    etPrenom.setBackgroundColor(getResources().getColor(R.color.couleurDeBase));
                }
            }
        });

        bValider = (Button) findViewById(R.id.bValider);

        bValider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ad.show();
            }
        });
    }
}
