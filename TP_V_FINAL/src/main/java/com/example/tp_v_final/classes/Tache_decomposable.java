package com.example.tp_v_final.classes;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Tache_decomposable extends Tache implements Serializable {

    private List<Tache> sous_taches;

    public Tache_decomposable(String nom, int priorite, int duree, LocalDate deadline, String categorie) {
        super(nom, priorite, duree, deadline, categorie);
        this.sous_taches = null;
    }

    @Override
    public boolean planifier_auto(Jour jour) {
        sous_taches =  new ArrayList<>();
        int tempsRestant = this.duree;
        int i = 1;
        List<Créneaux> creneauxLibres = jour.ChercheCreneauLibre();
        boolean tachePlanifiee = false;

        for (Créneaux creneau : creneauxLibres) {
            if ((creneau.calculerDuree() >= duree) && (creneau.getDureeMin() <= duree)) {
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
                    sous_taches.add(nvl_tache);
                    tempsRestant = 0;
                    creneau.setEstLibre(false);
                    tachePlanifiee = true;
                    break;
                } else {
                    Tache nvl_tache = new Tache_decomposable(this.nom+i ,this.getPriorite(),creneau.calculerDuree(),this.getDeadline(),this.categorie);
                    creneau.setTacheAffectee(nvl_tache);
                    sous_taches.add(nvl_tache);
                    tempsRestant -= creneauDuree;
                    creneau.decomposerCreneaux(nvl_tache);
                    i++;
                }
            }
        }
        return tachePlanifiee;
    }

   @Override
   public boolean planifier_manuel(Créneaux creneau){
return true;
   }

    /**************************seteur and geteur************************************************/
    public List<Tache> getSous_taches() {
        return sous_taches;
    }
}
