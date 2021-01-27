package com.example.horrairetrain;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.Toast;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class MainActivity extends Activity {

    ListView sHorraires;
    Button bValider;
    ListAdapter adapter;
    AutoCompleteTextView editDepart,editArrive;

    private static final String[] VILLES = new String[]{"Paris","Montpellier","Lyon","Nime","Lille","Strasbourg",
                                                            "Grenoble","Tours","Perpignan","Toulouse","Marseille",
                                                                "Nantes","Nice","Bordeaux","Rennes"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sHorraires = (ListView) findViewById(R.id.sHoraires);
        bValider = (Button) findViewById(R.id.bValider) ;
        editArrive = (AutoCompleteTextView) findViewById(R.id.edArrive);
        editDepart = (AutoCompleteTextView) findViewById(R.id.editDepart);

        List<HashMap<String, String>> liste = new ArrayList<HashMap<String, String>>();
        HashMap<String, String> element ;

        final String[][] hors = new String[][]{
                {"Lundi","8:00"},{"Lundi","9:00"},{"Lundi","10:00"},{"Lundi","11:00"},{"Lundi","12:00"},{"Lundi","13:00"},
                {"Mardi","8:00"},{"Mardi","9:00"},{"Mardi","10:00"},{"Mardi","11:00"},{"Mardi","12:00"},{"Mardi","13:00"},
                {"Mercredi","8:00"},{"Mercredi","9:00"},{"Mercredi","10:00"},{"Mercredi","11:00"},{"Mercredi","12:00"},{"Mercredi","13:00"},
                {"Jeudi","8:00"},{"Jeudi","9:00"},{"Jeudi","10:00"},{"Jeudi","11:00"},{"Jeudi","12:00"},{"Jeudi","13:00"},
                {"Vendredi","8:00"},{"Vendredi","9:00"},{"Vendredi","10:00"},{"Vendredi","11:00"},{"Vendredi","12:00"},{"Vendredi","13:00"},
                {"Samedi","8:00"},{"Samedi","9:00"},{"Samedi","10:00"},{"Samedi","11:00"},{"Samedi","12:00"},{"Samedi","13:00"},
                {"Dimanche","11:00"}
        };
        for (int i=0; i<hors.length;i++){
            element = new HashMap<String, String>();
            element.put("v1",hors[i][0]);
            element.put("v2",hors[i][1]);
            liste.add(element);
            adapter = new SimpleAdapter(this,liste,android.R.layout.simple_list_item_2,
                    new String[]{"v1","v2"},new int[] {android.R.id.text1,android.R.id.text2});
        }

        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, VILLES);
        editDepart.setAdapter(adapter2);
        editArrive.setAdapter(adapter2);

        bValider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (editArrive.getText().toString().equals("") || editDepart.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(),"Veuiller remplire tout les champs",Toast.LENGTH_LONG).show();
                    if (editArrive.getText().toString().equals("")){
                        editArrive.setHintTextColor(getResources().getColor(R.color.champVide));
                        editArrive.setHint("Veuiller remplir ce champs");
                    }
                    if (editDepart.getText().toString().equals("")){
                        editDepart.setHintTextColor(getResources().getColor(R.color.champVide));
                        editDepart.setHint("Veuiller remplir ce champs");
                    }
                }else{
                sHorraires.setAdapter(adapter);}

            }
        });
    }
}
