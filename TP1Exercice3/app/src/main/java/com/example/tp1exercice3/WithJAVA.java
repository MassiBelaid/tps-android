package com.example.tp1exercice3;


import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import static android.text.InputType.TYPE_CLASS_NUMBER;
import static android.text.InputType.TYPE_CLASS_PHONE;

public class WithJAVA extends Activity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Layout qui va contenir toute l'interface
        LinearLayout ll = new LinearLayout(this);
        ll.setOrientation(LinearLayout.VERTICAL);
        ll.setPadding(50,100,50,100);

        //Layout pour le label nom et son chaps d'entrée
        LinearLayout lnom = new LinearLayout(this);
        lnom.setOrientation(LinearLayout.HORIZONTAL);



        TextView tNom = new TextView(this);
        tNom.setText(R.string.tvNom);
        tNom.setTextSize(20);

        EditText eNom = new EditText(this);
        eNom.setHint(R.string.edNom);

        lnom.addView(tNom);
        lnom.addView(eNom);
        ll.addView(lnom);

        //Layout pour le label prenom et son chaps d'entrée
        LinearLayout lprenom = new LinearLayout(this);
        lprenom.setOrientation(LinearLayout.HORIZONTAL);

        TextView tPrenom = new TextView(this);
        tPrenom.setText(R.string.tvPrenom);
        tPrenom.setTextSize(20);

        EditText ePrenom = new EditText(this);
        ePrenom.setHint(R.string.edPrenom);

        lprenom.addView(tPrenom);
        lprenom.addView(ePrenom);
        ll.addView(lprenom);


        //Layout pour le label age et son chaps d'entrée
        LinearLayout lAge  = new LinearLayout(this);
        lAge.setOrientation(LinearLayout.HORIZONTAL);

        TextView tAge = new TextView(this);
        tAge.setText(R.string.tvAge);
        tAge.setTextSize(20);

        EditText eAge= new EditText(this);
            eAge.setInputType(TYPE_CLASS_NUMBER);


        eAge.setHint(R.string.edAge);

        lAge.addView(tAge);
        lAge.addView(eAge);
        ll.addView(lAge);



        //Layout pour le label compétences et son chaps d'entrée
        LinearLayout lDC = new LinearLayout(this);
        lDC.setOrientation(LinearLayout.HORIZONTAL);

        TextView tDC = new TextView(this);
        tDC.setText(R.string.tvCompetence);
        tDC.setTextSize(20);


        EditText eDC = new EditText(this);
        eDC.setHint(R.string.edCompetence);

        lDC.addView(tDC);
        lDC.addView(eDC);
        ll.addView(lDC);


        //Layout pour le label numero de telephone et son chaps d'entrée
        LinearLayout lTel = new LinearLayout(this);
        lTel.setOrientation(LinearLayout.HORIZONTAL);

        TextView tTel = new TextView(this);
        tTel.setText(R.string.tvTel);
        tTel.setTextSize(20);

        EditText eTel= new EditText(this);
            eTel.setInputType(TYPE_CLASS_PHONE);

        eTel.setHint(R.string.edTel);

        lTel.addView(tTel);
        lTel.addView(eTel);
        ll.addView(lTel);


        Button bValider = new Button(this);
        bValider.setText(R.string.textButon);
        ll.addView(bValider);



        setContentView(ll);
    }
}
