package com.example.tp_v_final.classes;

import java.io.Serializable;
import java.time.format.DateTimeFormatter;
import java.time.*;
import java.util.*;
import java.time.temporal.ChronoUnit;

public class Créneaux implements Serializable {

    private LocalTime debut;
    private LocalTime fin;
    private Tache tacheAffectee;
    private boolean estLibre;
    private int dureeMin;

    public Créneaux(LocalTime debut, LocalTime fin, int dureeMin) {
        this.debut = debut;
        this.fin = fin;
        this.estLibre = true;
        this.tacheAffectee = null;
        this.dureeMin = dureeMin;
    }
/****************************************************************************************************/
    public LinkedList<Créneaux> decomposerCreneaux(Tache tache) {

        LinkedList<Créneaux> creneauxDecomp = new LinkedList<>();
        if (tache.getDuree() <= 0) {
            creneauxDecomp.add(this);
            return creneauxDecomp;
        }

        long creneauDuree = Duration.between(debut, fin).toMinutes();

        if (creneauDuree == tache.getDuree()) {
            creneauxDecomp.add(this);
            return creneauxDecomp;
        } else if (creneauDuree > tache.getDuree()) {
            LocalTime debutCreneau1 = debut;
            LocalTime finCreneau1 = debutCreneau1.plusMinutes(tache.getDuree());
            Créneaux creneau1 = new Créneaux(debutCreneau1, finCreneau1, this.dureeMin);
            creneau1.setEstLibre(false);
            creneau1.setTacheAffectee(tache);
            creneauxDecomp.add(creneau1);
            LocalTime debutCreneau2 = finCreneau1;
            LocalTime finCreneau2 = fin;
            Créneaux creneau2 = new Créneaux(debutCreneau2, finCreneau2, this.dureeMin);
            creneauxDecomp.add(creneau2);
            return creneauxDecomp;
        } else {
            this.setEstLibre(false);
            this.setTacheAffectee(tache);
            creneauxDecomp.add(this);
            return creneauxDecomp;
        }
    }

    /****************************************************************************************************/

    public int calculerDuree() {
        long minutes = ChronoUnit.MINUTES.between(debut, fin);
        return (int) minutes;
    }


    /********************************les seteur and Geteur***********************************************/
    public LocalTime getDebut() {
        return debut;
    }

    public void setDebut(LocalTime debut) {
        this.debut = debut;
    }

    public LocalTime getFin() {
        return fin;
    }


    public void setFin(LocalTime fin) {
        this.fin = fin;
    }

    public Tache getTacheAffectee() {
        return tacheAffectee;
    }

    public void setTacheAffectee(Tache tacheAffectee) {
        this.tacheAffectee = tacheAffectee;
    }

    public boolean isEstLibre() {
        return estLibre;
    }

    public void setEstLibre(boolean estLibre) {
        this.estLibre = estLibre;
    }
    public int getDureeMin() {
        return dureeMin;
    }

    public void setDureeMin(int dureeMin) {
        this.dureeMin = dureeMin;
    }
    public String toString() {
        String chaine;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        String debutHeureMinute = debut.format(formatter);
        String finHeureMinute = fin.format(formatter);
      //  chaine= "Début : " + debutHeureMinute + ", Fin : " + finHeureMinute;
        chaine= debutHeureMinute + " -> " + finHeureMinute;
        if ( tacheAffectee!=null ) chaine=chaine+" : "+tacheAffectee.getNom();
        return chaine;
    }
}
