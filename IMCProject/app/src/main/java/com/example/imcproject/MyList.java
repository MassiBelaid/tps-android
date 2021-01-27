package com.example.imcproject;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class MyList extends BaseAdapter {

    LayoutInflater mInflater;
    String[] mListe;

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView vue = null;

        if(convertView != null){
            vue = (TextView) convertView;
        }
        else{
         vue = (TextView) mInflater.inflate(R.layout.ligne,null);}

        vue.setText(mListe[position]);
        return vue;
    }
}
