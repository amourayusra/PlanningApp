package com.example.tp_v_final.classes;

import java.util.*;
import java.time.*;

public class Jour {
    private LocalDateTime date;
    private LinkedList<Créneaux> creneaux;

    public Jour(LocalDateTime date) {
        this.date = date;
        this.creneaux = new LinkedList<Créneaux>();
    }

    public List<Créneaux> ChercheCreneauLibre(){
        List<Créneaux> creneauxLibres = new ArrayList<>();

        for (Créneaux creneau : this.creneaux) {
            if (creneau.isEstLibre()) {
                creneauxLibres.add(creneau);
            }
        }
        return creneauxLibres;
    }

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
    /********************************les seteur and Geteur***********************************************/

    public LocalDateTime getDate() {
        return date;
    }

    public LinkedList<Créneaux> getCreneaux() {
        return creneaux;
    }




}
