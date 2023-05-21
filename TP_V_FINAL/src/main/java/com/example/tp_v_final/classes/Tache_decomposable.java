package com.example.tp_v_final.classes;

import java.time.LocalDate;
import java.util.List;

public class Tache_decomposable extends Tache {

    private Tache[] sous_taches;

    public Tache_decomposable(String nom, int priorite, int duree, LocalDate deadline, String categorie) {
        super(nom, priorite, duree, deadline, categorie);
        this.sous_taches = null;
    }

    @Override
    public void planifier_auto(Jour jour) {
        int tempsRestant = this.duree;
        int i = 1;
        List<Créneaux> creneauxLibres = jour.ChercheCreneauLibre();
        boolean tachePlanifiee = false;

        for (Créneaux creneau : creneauxLibres) {
            if (creneau.calculerDuree() >= duree && creneau.getDureeMin() <= duree) {
                creneau.setTacheAffectee(this);
                tachePlanifiee = true;
                break;
            }
        }

        if (!tachePlanifiee) {
            for (Créneaux creneau : creneauxLibres) {
                int creneauDuree = creneau.calculerDuree();
                if (tempsRestant <= creneauDuree) {
                    Tache nvl_tache = new Tache_decomposable(this.nom,this.getPriorite(),this.getDuree(),this.getDeadline(),this.categorie);
                    creneau.setTacheAffectee(nvl_tache);
                    sous_taches[i - 1] = nvl_tache;
                    tempsRestant = 0;
                    creneau.setEstLibre(false);
                    break;
                } else {
                    Tache nvl_tache = new Tache_decomposable(this.nom+i ,this.getPriorite(),creneau.calculerDuree(),this.getDeadline(),this.categorie);
                    creneau.setTacheAffectee(nvl_tache);
                    sous_taches[i - 1] = nvl_tache;
                    tempsRestant -= creneauDuree;
                    creneau.decomposerCreneaux(nvl_tache);
                    i++;
                }
            }
        }
    }

   @Override
   public void planifier_manuel(Créneaux creneau){

   }

    /**************************seteur and geteur************************************************/
    public Tache[] getSous_taches() {
        return sous_taches;
    }

}
