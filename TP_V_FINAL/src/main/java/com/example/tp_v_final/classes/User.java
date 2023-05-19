package com.example.tp_v_final.classes;
import java.io.Serializable;
<<<<<<< HEAD
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
=======
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
>>>>>>> 347ad27ebf76d460e0e746d5c6e3780453d38143

public class User implements Serializable{
    private Calendrier calendrier;
    private Historique historique ;
    private List<Tache> taches_non_panifiées;
    private Badge[] badges;
    private Projet[] projet;
    private int nb_encouragement;

<<<<<<< HEAD
public User (int nb_encouragement){
   this.nb_encouragement=nb_encouragement;// bach ntesti stats
    taches_non_panifiées = new ArrayList<>();
}

    public float calculRendement(){ return 0;}
    public int getNbBadges(){ return badges.length;}
    public Calendrier getCalendar(){ return calendrier;}
    public int getEncouragement(){ return nb_encouragement;}
=======
    public User() {
        taches_non_panifiées = new ArrayList<>();
    }
>>>>>>> 347ad27ebf76d460e0e746d5c6e3780453d38143

    public void planifier(Tache t){}
    public void planifierP(Projet p){}
    public void valider(){}
    public void replanifier ( Tache t){}
    public void fixer_periode(LocalDate dateD , LocalDate dateF){
<<<<<<< HEAD
        calendrier.fixer_periode(dateD,dateF);
=======
        calendrier.setPeriode_debut(dateD);
        calendrier.setPeriode_fin(dateF);
>>>>>>> 347ad27ebf76d460e0e746d5c6e3780453d38143
    }
    public void supprimer(Tache t ){}
    public void annuler(){}
    public void ajouterProjet(){}

    /**************** l'utilisateur peut ajouter une instance de tache decomposable****************************/
    public void ajouterTacheDecomposable(String nom, int priorite, int duree, LocalDate deadline, String categorie){
<<<<<<< HEAD
        Tache nvTache = new Tache_decomposable(nom, priorite, duree, deadline, categorie);
        this.taches_non_panifiées.add(nvTache);
=======
            Tache nvTache = new Tache_decomposable(nom, priorite, duree, deadline, categorie);
            this.taches_non_panifiées.add(nvTache);
>>>>>>> 347ad27ebf76d460e0e746d5c6e3780453d38143
    }
    /**************** l'utilisateur peut ajouter une instance de tache simple (periodique ou pas)***************/
    public void ajouterTacheSimple(String nom, int priorite, int duree, LocalDate deadline, String categorie, boolean estPeriodique , int periode){
        Tache nvTache = new Tache_simple(nom, priorite, duree, deadline, categorie,estPeriodique,periode);
        this.taches_non_panifiées.add(nvTache);
    }
<<<<<<< HEAD
    /********************************************* Les seteur et les geteur**********************************************/
    public List<Tache> getTaches_non_panifiées() {
        return taches_non_panifiées;
    }


=======
    public float calculRendement(){ return 0;}
/********************************************* Les seteur et les geteur**********************************************/
    public List<Tache> getTaches_non_panifiées() {
        return taches_non_panifiées;
    }
>>>>>>> 347ad27ebf76d460e0e746d5c6e3780453d38143
}
