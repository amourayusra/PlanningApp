package com.example.tp_v_final;

import java.util.List;
public class Tache_decomposable extends Tache {

    private Tache[] sous_taches;

    public Tache_decomposable(String nom, int priorite, int duree, int deadline, Categorie categorie, Tache[] sous_taches) {
        super(nom, priorite, duree, deadline, categorie);
        this.sous_taches = sous_taches;
    }

    @Override
    public void planifier_auto(Jour jour) {
        int tempsRestant = this.duree;
        int i=1;
        List<Créneaux> creneauxLibres =   jour.ChercheCreneauLibre();
        for (Créneaux creneau : creneauxLibres) {
            if ((creneau.calculerDuree()>=duree ) && ( creneau.getFin() <= deadline ) && ( creneau.getDureeMin() <= duree ) {
                creneau.setTacheAffectee(this);
                break;
            } else {
                for (Créneaux creneau : creneauxLibres) {
                    (creneau.getFin() <= deadline) {
                        Tache nvl_tache=new Tache(this.nom+i, creneau.calculerDuree());
                        creneau.setTacheAffectee(nvl_tache);
                        sous_taches[i-1]=nvl_tache;
                        i++;
                        tempsRestant -= creneau.calculerDuree();
                    }
                }
            }
        }
    }
    /**************************seteur and geteur************************************************/
    public Tache[] getSous_taches() {
        return sous_taches;
    }

}
