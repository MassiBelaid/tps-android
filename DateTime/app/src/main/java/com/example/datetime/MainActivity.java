package com.example.datetime;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.DatePicker;

public class MainActivity extends AppCompatActivity {

    DatePicker maDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        maDate = (DatePicker) findViewById(R.id.date);
        maDate.updateDate(maDate.getYear(), 0, 1);
    }
}
