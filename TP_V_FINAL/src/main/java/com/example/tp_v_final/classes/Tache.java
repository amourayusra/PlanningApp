package com.example.tp_v_final.classes;

import java.time.LocalDate;
public abstract class Tache {
    protected String nom;
    protected int priorite;
    protected int duree;
    protected LocalDate deadline;
    protected String categorie;
    protected int bloque;

    public Tache(String nom, int priorite, int duree, LocalDate deadline, String categorie) {
        this.nom = nom;
        this.priorite = priorite;
        this.duree = duree;
        this.deadline = deadline;
        this.categorie = categorie;
    }

    public String getNom() {
        return nom;
    }

    /*public Priorite getPriorite() {
        return priorite;
    }*/

    public int getDuree() {
        return duree;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public String getCategorie() {
        return categorie;
    }

    public void effectuer() {
    }

    public abstract void planifier_auto(Jour jour);

    public abstract void planifier_manuel(Créneaux creneau);

    public int getPriorite() {
        return priorite;
    }
}