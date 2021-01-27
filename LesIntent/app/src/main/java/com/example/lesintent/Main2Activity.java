package com.example.lesintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        text = (TextView) findViewById(R.id.text1);

        Intent i = getIntent();
        Personne p = i.getParcelableExtra("p1");

        String info = p.getInfo();
        text.setText(info);
    }
}
