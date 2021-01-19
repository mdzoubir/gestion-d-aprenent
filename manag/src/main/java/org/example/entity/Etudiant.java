package org.example.entity;

public class Etudiant {
    private int id;
    private String nom;
    private String prenom;
    private String email;
    private int telephone;
    private int id_spcialite;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    public int getId_spcialite() {
        return id_spcialite;
    }

    public void setId_spcialite(int id_spcialite) {
        this.id_spcialite = id_spcialite;
    }

}
