package com.example.tp1exercice3;

import android.app.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends Activity {
    TextView tNom, tPrenom, tAge, tDC, tTel;
    Button bOk, bRetour;
    String telephone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        tNom = (TextView) findViewById(R.id.tNom);
        tPrenom = (TextView) findViewById(R.id.tPrenom);
        tAge = (TextView) findViewById(R.id.tAge);
        tDC = (TextView) findViewById(R.id.tDC);
        tTel = (TextView) findViewById(R.id.tTel);
        bOk = (Button) findViewById(R.id.bOk);
        bRetour = (Button) findViewById(R.id.bRetour);

        Intent i = getIntent();

        tNom.setText(i.getStringExtra("nom"));
        tPrenom.setText(i.getStringExtra("prenom"));
        tAge.setText(i.getIntExtra("age",0)+"");
        tDC.setText(i.getStringExtra("dc"));
        tTel.setText(i.getStringExtra("tel"));
        telephone = i.getStringExtra("tel");

        bOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SecondActivity.this,ThirdActivity.class);
                i.putExtra("tel",telephone);
                startActivity(i);
            }
        });

        bRetour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(RESULT_OK);
                finish();
            }
        });
    }
}
