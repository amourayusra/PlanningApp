package com.example.tp_v_final.classes;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class User implements Serializable{
    private Calendrier calendrier;
    private Historique historique ;
    private List<Tache> taches_non_panifiées;
    private Badge[] badges;
    private Projet[] projet;

    public User() {
        taches_non_panifiées = new ArrayList<>();
    }

    public void planifier(Tache t){}
    public void planifierP(Projet p){}
    public void valider(){}
    public void replanifier ( Tache t){}
    public void fixer_periode(LocalDate dateD , LocalDate dateF){
        calendrier.setPeriode_debut(dateD);
        calendrier.setPeriode_fin(dateF);
    }
    public void supprimer(Tache t ){}
    public void annuler(){}
    public void ajouterProjet(){}

    /**************** l'utilisateur peut ajouter une instance de tache decomposable****************************/
    public void ajouterTacheDecomposable(String nom, int priorite, int duree, LocalDate deadline, String categorie){
            Tache nvTache = new Tache_decomposable(nom, priorite, duree, deadline, categorie);
            this.taches_non_panifiées.add(nvTache);
    }
    /**************** l'utilisateur peut ajouter une instance de tache simple (periodique ou pas)***************/
    public void ajouterTacheSimple(String nom, int priorite, int duree, LocalDate deadline, String categorie, boolean estPeriodique , int periode){
        Tache nvTache = new Tache_simple(nom, priorite, duree, deadline, categorie,estPeriodique,periode);
        this.taches_non_panifiées.add(nvTache);
    }
    public float calculRendement(){ return 0;}
/********************************************* Les seteur et les geteur**********************************************/
    public List<Tache> getTaches_non_panifiées() {
        return taches_non_panifiées;
    }
}
