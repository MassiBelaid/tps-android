package com.example.bloc_notes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.Html;
import android.text.Spanned;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText eE = null;
    private TextView tE = null;
    private Button bGras = null;
    private Boolean grasC = false;
    private Boolean italiqueC = false;
    private Boolean souligneC = false;
    Html.ImageGetter imageGetter = null;
    private Button bItalique = null;
    private Button bSouligne = null;
    private Button bS1 = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eE = (EditText) findViewById(R.id.eE);
        tE = (TextView) findViewById(R.id.tE);
        bGras = (Button) findViewById(R.id.bGras);
        bItalique = (Button) findViewById(R.id.bItalique);
        bSouligne = (Button) findViewById(R.id.bSouligné);
        bS1 = (Button) findViewById(R.id.bS1);

        eE.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Spanned monS = Html.fromHtml(eE.getText().toString(),imageGetter,null);
                tE.setText(monS);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        /*eE.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if(keyCode == 66){
                    tE.setText(eE.getText()+"</br>");
                }
                return false;
            }
        });*/

        bGras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(grasC == false){

                    grasC = true;
                    eE.setText(eE.getText()+"<b>");
                    Spanned monS = Html.fromHtml(eE.getText().toString(),imageGetter,null);
                    tE.setText(monS);
                }else{
                    grasC = false;
                    eE.setText(eE.getText()+"</b>");
                    Spanned monS = Html.fromHtml(eE.getText().toString(),imageGetter,null);
                    tE.setText(monS);
                }

            }
        });


        bItalique.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(italiqueC == false){

                    italiqueC = true;
                    eE.setText(eE.getText()+"<i>");
                    Spanned monS = Html.fromHtml(eE.getText().toString(),imageGetter,null);
                    tE.setText(monS);
                }else{
                    italiqueC = false;
                    eE.setText(eE.getText()+"</i>");
                    Spanned monS = Html.fromHtml(eE.getText().toString(),imageGetter,null);
                    tE.setText(monS);
                }
            }
        });


        bSouligne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(souligneC == false){

                    souligneC = true;
                    eE.setText(eE.getText()+"<u>");
                    Spanned monS = Html.fromHtml(eE.getText().toString(),imageGetter,null);
                    tE.setText(monS);
                }else{
                    souligneC = false;
                    eE.setText(eE.getText()+"</u>");
                    Spanned monS = Html.fromHtml(eE.getText().toString(),imageGetter,null);
                    tE.setText(monS);
                }

            }
        });

        bS1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eE.setText(eE.getText()+"<u>");
                Spanned monS = Html.fromHtml(eE.getText().toString(),imageGetter,null);
                tE.setText(monS);
            }
        });
    }
}
