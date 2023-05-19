package com.example.tp_v_final.classes;
import com.example.tp_v_final.classes.Jour;
import java.util.LinkedList;

import java.time.LocalDate;

public class Calendrier {

    private Jour[] jours;
    private LocalDate periode_debut;
    private LocalDate periode_fin;

    public Calendrier( LocalDate debut, LocalDate fin , Jour[] jours){
    this.periode_debut=debut;
    this.periode_fin=fin;
    this.jours=jours;
    }
    public void fixer_periode(LocalDate debut, LocalDate fin ){
        this.periode_debut=debut;
        this.periode_fin=fin;
    }
    public void ajouter_tache_simple_manuelle(LocalDate date,Tache tache){
        for (Jour jour : jours) {
            if (jour.getDate().equals(date)) {
                tache.planifier_auto(jour);
                break;
            }
        }
    }

    public LinkedList getCréneauxForDay(LocalDate date) {
        LinkedList<Créneaux> result=new LinkedList<>();
        for (Jour jour : jours) {
            if (jour.getDate().equals(date)) {
              result=jour.getCreneaux();
            }
        }
        return result;
    }
    public Jour[] getJours(){ return jours; }
    public void replanifier () {
       /* PriorityQueue<Tache> fileAttente = new PriorityQueue<>();
        for ( Jour jour : jours ) {
            for ( Créneaux creneau : Jour.getCreneaux()) {
                fileAttente.add((creneau.getTacheAffectee().getPriorite()));
            }
        }
        while (!fileAttente.isEmpty()) {
            Tache tache = fileAttente.poll();
            tache.planifier_auto();*/
        }
/*******************************************************************/
        public LocalDate jourRentable(){
       LocalDate dateMax=jours[0].getDate();
       long max =jours[0].calculRentabilite();
        for ( int i=0;i<jours.length;i++ ){
            if ( jours[i].calculRentabilite()>max){
                max=jours[i].calculRentabilite();
                dateMax=jours[i].getDate();
            }
        }
          return dateMax;
    }

    /*******************************************************************/
    }
