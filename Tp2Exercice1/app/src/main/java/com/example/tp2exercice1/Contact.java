package com.example.tp2exercice1;

public class Contact {

    private long id;
    private String nom;
    private String prenom;
    private String telephone;

    public Contact(long id, String nom, String prenom, String telephone){
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.telephone = telephone;
    }
    public Contact( String nom, String prenom, String telephone){
        this.nom = nom;
        this.prenom = prenom;
        this.telephone = telephone;
    }

    public long getId (){
        return  this.id;
    }
    public void setId(long id){
        this.id = id;
    }

    public String getNom (){
        return  this.nom;
    }
    public void setNom(String nom){
        this.nom = nom;
    }

    public String getPrenom (){
        return  this.prenom;
    }
    public void setPrenom(String prenom){
        this.prenom = prenom;
    }

    public String getTel (){
        return  this.telephone;
    }
    public void setTel(String tel){
        this.telephone = tel;
    }
}
