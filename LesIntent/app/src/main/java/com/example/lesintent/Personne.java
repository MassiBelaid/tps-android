package com.example.lesintent;

import android.os.Parcel;
import android.os.Parcelable;

public class Personne implements Parcelable {

    private String nom;
    private int age;

    public Personne(String nom, int age){
        this.nom = nom;
        this.age = age;
    }

    public String getInfo(){
        return this.nom + " " + this.age + " ans";
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nom);
        dest.writeInt(age);
    }

    public static final Parcelable.Creator<Personne> CREATOR = new Creator<Personne>() {
        @Override
        public Personne createFromParcel(Parcel source) {
            return new Personne(source);
        }

        @Override
        public Personne[] newArray(int size) {
            return new Personne[size];
        }
    };

    public Personne(Parcel source){
        nom = source.readString();
        age = source.readInt();
    }
}
