package com.formation.hellospring.models;

import org.springframework.data.annotation.Id;

public class DessinModel {

    @Id
    long id;
    String nom;
    String auteur;
    String content;

    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Dessin{" +
        "id=" + id +
        ", nom='" + nom + '\'' +
        ", auteur='" + auteur + '\'' +
        ", content='" + content + '\'' +
        '}';
    }

}