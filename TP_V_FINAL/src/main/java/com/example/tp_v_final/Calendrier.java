package com.example.tp_v_final;
import java.time.LocalDate;
import java.util.PriorityQueue;

public class Calendrier {

    private Jour[] jours;
    private LocalDate periode_debut;
    private LocalDate periode_fin;


    public void fixer_periode( ){}

    public void ajouter_tache(Jour j){
    }

    public void replanifier () {
        PriorityQueue<Tache> fileAttente = new PriorityQueue<>();
        for ( Jour jour : jours ) {
            for ( Créneaux creneau : Jour.getCreneaux()) {
                fileAttente.add((creneau.getTacheAffectee().getPriorite()));
            }
        }
        while (!fileAttente.isEmpty()) {
            Tache tache = fileAttente.poll();
            tache.planifier_auto();
        }
    }
