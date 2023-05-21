package com.example.tp_v_final.classes;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;

public class Tache_simple extends Tache implements Serializable {
    private boolean estPeriodique;
    private int periode;

    public Tache_simple(String nom, int priorite, int duree, LocalDate deadline, String categorie, boolean estPeriodique , int periode) {
        super(nom, priorite, duree, deadline, categorie);
        this.estPeriodique = estPeriodique;
        this.periode = periode;
    }

    public void planifier_auto(Jour jour) {
        List<Créneaux> creneauxLibres =   jour.ChercheCreneauLibre();
        if (creneauxLibres.isEmpty()) {
            //exeption unsheudeled
            System.out.println("Impossible de planifier la tâche " + this.nom + ". Aucun créneau libre n'a été trouvé.");
        } else {
            //cherchons un creneaux qui corespond
            for (Créneaux creneau : creneauxLibres) {
                //conditions de planification d'une tache
                if ((creneau.calculerDuree() >= this.getDuree())&&(this.duree > creneau.getDureeMin())) {
                    //si le creneau satisfait les condition on le decompose
                    LinkedList<Créneaux> creneauxDecomp = creneau.decomposerCreneaux(this);
                    // Décomposition du créneau du jour en deux
                    if (creneauxDecomp.size() == 2) {
                        // enlever l'ancien creneau de la liste des créneaux de la journée
                        jour.getCreneaux().remove(creneau);

                        // ajouter les deux nouveaux créneaux dans la liste des créneaux de la journée
                        jour.ajouterCreneau(creneauxDecomp.get(0));//occuper
                        jour.ajouterCreneau(creneauxDecomp.get(1));//libre
                    }

                    System.out.println("Tâche planifiée avec succès pour la date " + jour.getDate().toString());
                    break;
                }
            }
        }
    }

    public void planifier_manuel(Créneaux creneau){
        if((creneau.calculerDuree() >= this.getDuree())&&(this.duree > creneau.getDureeMin())){
            creneau.decomposerCreneaux(this);
        }else {
            //exception cette tache ne pas etre planifier dans ce creneau
        }
    }

    /*********************************les seteur et les geteur*******************************************/


}
