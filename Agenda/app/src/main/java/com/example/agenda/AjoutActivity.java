package com.example.agenda;


import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormatSymbols;
import java.util.Calendar;

public class AjoutActivity extends Activity {

    Button buttonDate,bAjouter;
    DatePickerDialog.OnDateSetListener mD;
    String dateChoisie = "";
    EditText editEven;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajout);

        buttonDate = (Button) findViewById(R.id.buttonDate);
        bAjouter = (Button) findViewById(R.id.idAjouter);
        editEven = (EditText) findViewById(R.id.editEven);


        buttonDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(AjoutActivity.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        mD,year,month,day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        mD = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                //month++;
                String monthS = new DateFormatSymbols().getMonths()[month];
                dateChoisie = dayOfMonth+"/"+monthS+"/"+year;
                buttonDate.setText(dateChoisie);
            }
        };

        bAjouter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editEven.getText().toString().equals("") || dateChoisie.equals("")){
                    Toast.makeText(AjoutActivity.this,"Veuillez remplire tout les champs et choisire une date",Toast.LENGTH_LONG).show();
                }else{
                Intent add = new Intent();
                add.putExtra("date",dateChoisie);
                add.putExtra("even",editEven.getText().toString());
                setResult(RESULT_OK,add);
                finish();}
            }
        });
    }
}
