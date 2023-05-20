package com.example.tp_v_final.classes;

import java.util.*;
import java.time.*;

public class Jour {
    private LocalDate date;
    private LinkedList<Créneaux> creneaux;
    private int nbmin ;
    private int progress=5;
    private int prevu=2;

    public Jour(LocalDate date) {
        this.date = date;
        this.creneaux = new LinkedList<Créneaux>();
    }

    /***************************************************************************************/
    public List<Créneaux> ChercheCreneauLibre(){
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
        if (this.creneaux.isEmpty()) {
            this.creneaux.add(nouveauCreneau);
        } else {
            ListIterator<Créneaux> iter = this.creneaux.listIterator();
            while (iter.hasNext()) {
                Créneaux creneauCourant = iter.next();
                if (nouveauCreneau.getFin().isBefore(creneauCourant.getDebut())) {
                    // nouveau créneau avant créneau courant
                    iter.previous();
                    iter.add(nouveauCreneau);
                    return;
                } else if (nouveauCreneau.getDebut().isAfter(creneauCourant.getFin())) {
                    // nouveau créneau après créneau courant
                    continue;
                } else {
                    // chevauchement entre les créneaux
                    throw new IllegalArgumentException("Le créneau à ajouter chevauche un créneau existant.");
                }
            }
            // nouveau créneau après tous les créneaux existants
            this.creneaux.add(nouveauCreneau);
        }
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
    public LinkedList getCreneaux () { return creneaux;}
    /***************************************************************************************/
    public String toString() {
        String chaine = "Taches affectées : \n";
        for (Créneaux creneau : this.creneaux) {
            chaine = chaine.concat(creneau.toString()+"\n");
        }
        chaine=chaine+"\n \n Quelques Statistiques du jour :\n- Son rendement journalier de ce jour : "+String.valueOf(progress/prevu );
        return chaine;
    }
    /***************************************************************************************/
    public void setCreneaux(LinkedList<Créneaux> objects) {
        this.creneaux=objects;

    }
    /***************************************************************************************/
    public void setProgress(int p){
        this.progress=p;
    }
    /***************************************************************************************/
    public int calculRentabilite() {return 0;}
}





