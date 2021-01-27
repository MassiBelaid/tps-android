package com.example.imcproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button bCalculer = null;
    private Button bRAZ = null;
    private EditText poid = null;
    private EditText taille = null;
    private TextView resultat = null;
    private RadioGroup radioGroup;
    private RadioButton bm, bcm;
    private CheckBox cbMegaFonction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bCalculer = (Button) findViewById(R.id.bCalculer);
        bRAZ = (Button) findViewById(R.id.bRAZ);
        poid = (EditText) findViewById(R.id.poid);
        taille = (EditText) findViewById(R.id.taille);
        resultat = (TextView) findViewById(R.id.result);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        bm = (RadioButton) findViewById(R.id.bm);
        bcm = (RadioButton) findViewById(R.id.bcm);
        cbMegaFonction = (CheckBox) findViewById(R.id.cbMegaFonction);

        Animation anim = AnimationUtils.loadAnimation(this,R.anim.my_anim);
        bRAZ.startAnimation(anim);

        bRAZ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                poid.setText(null);
                taille.setText(null);
                resultat.setText(R.string.resultat);
                bcm.setChecked(true);
                cbMegaFonction.setChecked(false);
            }
        });

        bCalculer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String resul = "Votre IMC est : ";
                float t = Float.parseFloat(taille.getText().toString());
                int p = Integer.parseInt(poid.getText().toString());

                if(t == 0){
                    Toast.makeText(MainActivity.this,"Taille invalide",Toast.LENGTH_LONG).show();
                }else{
                    if(radioGroup.getCheckedRadioButtonId() == R.id.bcm){
                      t = t/100;
                     }

                    float r = p / (t*t);
                    resul = resul+r;

                    if(cbMegaFonction.isChecked()){
                        resul += " Et ouep frérot";
                    }

                    resultat.setText(resul);
            }}
        });
    }
}
