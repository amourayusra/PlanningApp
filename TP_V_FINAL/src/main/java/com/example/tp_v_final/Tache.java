package com.example.tp_v_final;

import java.time.LocalDate;
public abstract class Tache {
    protected String nom;
    protected int priorite;
    protected int duree;
    protected LocalDate deadline;
    protected Categorie categorie;
    protected int bloque;

    public Tache(String nom, int priorite, int duree, LocalDate deadline, Categorie categorie) {
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

    public Categorie getCategorie() {
        return categorie;
    }

    public void effectuer() {
    }
    public abstract void planifier_auto(Jour jour);
    public abstract void planifier_manuel(Créneaux creneau);
    public Tache getPriorite() { return priorite ;}
    /*
    public void modifier(){}
    public void evaluer()
    public void planifier()
    public void replanifier()
    public void setDeadline()
    public void */
}


