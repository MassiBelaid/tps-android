package com.example.tp1exercice3;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.app.Activity;

import android.os.Bundle;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ThirdActivity extends Activity {

    TextView tTel;
    Button bTel;
    String tel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        tTel = (TextView) findViewById(R.id.tTel);
        bTel = (Button) findViewById(R.id.bTel);

        Intent i = getIntent();
        tel = i.getStringExtra("tel");
        tTel.setText(tel);



        bTel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uTel = Uri.parse("tel:"+tel);
                Intent call = new Intent(Intent.ACTION_DIAL,uTel);
                startActivity(call);


            }
        });
    }
}
