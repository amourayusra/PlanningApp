package com.example.tp_v_final.classes;

import javafx.scene.control.Alert;

import java.io.Serializable;
import java.util.*;
import java.time.*;

public class Jour implements Serializable {
    private LocalDate date;
    private LinkedList<Créneaux> creneaux;

    public static int progress = 5;
    public static int prevu = 2;

    public Jour(LocalDate date) {
        this.date = date;
        this.creneaux = new LinkedList<Créneaux>();
    }

    /***************************************************************************************/
    public List<Créneaux> ChercheCreneauLibre() {
        List<Créneaux> creneauxLibres = new ArrayList<>();
        for (Créneaux creneau : this.creneaux) {
            if (creneau.isEstLibre()) {
                creneauxLibres.add(creneau);
            }
        }
        return creneauxLibres;
    }

    /***************************************************************************************/
    public void ajouterCreneau(Créneaux nouveauCreneau) {
        LinkedList<Créneaux> sortedCreneaux = new LinkedList<>();

        boolean isInserted = false;
        for (Créneaux creneau : this.creneaux) {
            if (nouveauCreneau.getFin().isBefore(creneau.getDebut())) {
                // nouveau creneau before current creneau
                sortedCreneaux.add(nouveauCreneau);
                isInserted = true;
            }
            sortedCreneaux.add(creneau);
        }

        if (!isInserted) {
            // nouveau creneau after all existing creneaux
            sortedCreneaux.add(nouveauCreneau);
        }

        this.creneaux = sortedCreneaux;
    }

    /***************************************************************************************/

    public LocalDate getDate() {
        return date;
    }
    /***************************************************************************************/
   /* public Collection<? extends String> getCreneaux() {
        return creneaux;
    }*/

    /***************************************************************************************/
    public LinkedList getCreneaux() {
        return creneaux;
    }

    /***************************************************************************************/
    public String toString() {
        String chaine = "";
        for (Créneaux creneau : this.creneaux) {
            chaine = chaine.concat(creneau.toString() + "\n");
        }

        return chaine;
    }

    public String toStats() {
        return "";
    }

    /***************************************************************************************/
    public void setCreneaux(LinkedList<Créneaux> objects) {
        this.creneaux = objects;
    }

    /***************************************************************************************/
    public void setProgress(int p) {
        this.progress = p;
    }

    /***************************************************************************************/
    public int calculRentabilite() {
        return 0;
    }

    public List getTaches() {

        List<Tache> liste =  new ArrayList<>();
        for (Créneaux creneau : this.creneaux) {
            if (creneau.getTacheAffectee()!=null)
                liste.add(creneau.getTacheAffectee());
        }
        return liste;
    }
}


