package com.example.imcproject;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DialogBox extends AppCompatActivity {

    private Button button;
    private final static int NERF = 4;
    private int compteur = 0;

    private final static int ID_ENERV_DIALOG = 1;
    private final static int ID_NORMAL_DIALOG = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog_box);

        button = (Button) findViewById(R.id.button);

        button.setOnClickListener(boutonClick);
    }

    private View.OnClickListener boutonClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            if (compteur < NERF){
                compteur++;
                showDialog(ID_NORMAL_DIALOG);
            }else {
                showDialog(ID_ENERV_DIALOG);
            }
        }
    };




    @Override
    public Dialog onCreateDialog(int id){
        Dialog box = null;
        switch (id){
            case ID_NORMAL_DIALOG:
                box = new Dialog(this);
                box.setTitle("Je viens tout juste de naitre");
                break;

            case ID_ENERV_DIALOG:
                box = new Dialog(this);
                box.setTitle("Et moi alors ??!");
        }

        return box;
    }

    @Override
    public void onPrepareDialog(int id,Dialog box){
        if(id == ID_NORMAL_DIALOG && compteur > 1){
            box.setTitle("On est au "+compteur+"ème lancement");
        }
    }
}
