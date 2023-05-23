package com.example.tp_v_final.classes;

import java.io.Serializable;
import java.time.LocalDate;

public abstract class Tache implements Serializable {
    protected String nom;
    protected int priorite;
    protected int duree;
    protected LocalDate deadline;
    protected String categorie;
    private boolean completed;

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

    public abstract boolean planifier_auto(Jour jour);

    public abstract boolean planifier_manuel(Créneaux creneau);

    public int getPriorite() {
        return priorite;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public boolean isCompleted() {
        return completed;
    }
}