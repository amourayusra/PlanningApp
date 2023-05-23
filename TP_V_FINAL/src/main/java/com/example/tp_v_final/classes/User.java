package com.example.tp_v_final.classes;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class User implements Serializable {
    public final static String[] badgeNames = {"Good", "VeryGood", "Excellent"};
    public final static int[] badgeThresholds = {5, 3, 3};
    private Calendrier calendrier;
    private Historique historique;
    private List<Tache> taches_non_panifiées;
    private List<Projet> projet;
    private int nb_encouragement;
    public  int nbmin;
    public  int consecutive;
    public int nbBadges;
    public  int[] nb_badges = new int[]{0, 0, 0};

    public User(int nb_encouragement) {
        this.nb_encouragement = 0;
        taches_non_panifiées = new ArrayList<>();
        calendrier = new Calendrier(LocalDate.now().minusMonths(2), LocalDate.now().plusMonths(2));
        calendrier.initJours();
        nbmin = 2;
        consecutive = 0;
        nbBadges = 0;
        projet = new ArrayList<>();
    }

    public float calculRendement() {
        return 0;
    }

    public int getNbBadges() {
        return nbBadges;
    }

    public Calendrier getCalendar() {
        return calendrier;
    }

    public int getEncouragement() {
        return nb_encouragement;
    }


    public void planifier(Tache t) {
    }

    public void planifierP(Projet p) {
    }

    public void valider() {
    }

    public void replanifier(Tache t) {
    }

    public void fixer_periode(LocalDate dateD, LocalDate dateF) {
        calendrier.fixer_periode(dateD, dateF);
    }

    public void supprimer(Tache t) {
    }

    public void annuler() {
    }


    /**************** l'utilisateur peut ajouter une instance de tache decomposable****************************/
    public void ajouterTacheDecomposable(String nom, int priorite, int duree, LocalDate deadline, String categorie) {

        Tache nvTache = new Tache_decomposable(nom, priorite, duree, deadline, categorie);
        this.taches_non_panifiées.add(nvTache);
         /*   Tache nvTache = new Tache_decomposable(nom, priorite, duree, deadline, categorie);
            this.taches_non_panifiées.add(nvTache);*/

    }

    /**************** l'utilisateur peut ajouter une instance de tache simple (periodique ou pas)***************/
    public void ajouterTacheSimple(String nom, int priorite, int duree, LocalDate deadline, String categorie, boolean estPeriodique, int periode) {
        Tache nvTache = new Tache_simple(nom, priorite, duree, deadline, categorie, estPeriodique, periode);
        this.taches_non_panifiées.add(nvTache);
    }

    /********************************************* Les seteur et les geteur**********************************************/
    public List<Tache> getTaches_non_panifiées() {
        return taches_non_panifiées;
    }

    public void setCalendar(Calendrier calendar) {
        this.calendrier = calendar;
    }

    public void setNbmin (int nbmin){
        this.nbmin=nbmin;
    }
    public int getNbmin(){ return nbmin;}
    public int[] getBadges(){ return nb_badges;}
    public List<Projet> getProjet() {
        return projet;
    }

    public void addProjet(Projet nvprojet) {
        projet.add(nvprojet);
    }

}
