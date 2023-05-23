package com.example.tp_v_final.classes;
import com.example.tp_v_final.classes.*;
import java.time.temporal.ChronoUnit;
import java.io.Serializable;
import java.util.LinkedList;

import java.time.*;

public class Calendrier implements Serializable {

    private Jour[] jours;
    private LocalDate periode_debut;
    private LocalDate periode_fin;

    public Calendrier(LocalDate debut, LocalDate fin) {
        this.periode_debut = debut;
        this.periode_fin = fin;
        initJours();
    }


    public void fixer_periode(LocalDate debut, LocalDate fin) {
        this.periode_debut = debut;
        this.periode_fin = fin;
    }

    public void ajouter_tache_simple_manuelle(LocalDate date, Tache tache) {
        for (Jour jour : jours) {
            if (jour.getDate().equals(date)) {
                tache.planifier_auto(jour);
                break;
            }
        }
    }

    public LinkedList getCréneauxForDay(LocalDate date) {
        LinkedList<Créneaux> result = new LinkedList<>();
        for (Jour jour : jours) {
            if (jour.getDate().equals(date)) {
                result = jour.getCreneaux();
            }
        }
        return result;
    }
    public void planifierAuto(Tache tache) {


        LocalDate currentDate = LocalDate.now();
        while (!currentDate.isAfter(tache.getDeadline())) {
            for (Jour jour : jours) {
                if (jour.getDate().equals(currentDate)) {
                    tache.planifier_auto(jour);
                    System.out.println("psssk");
                    break;
                }
            }
            currentDate = currentDate.plusDays(1);
        }
    }

    public Jour[] getJours() {
        return jours;
    }

    public void replanifier() {
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
    public LocalDate jourRentable() {
        LocalDate dateMax = jours[0].getDate();
        long max = jours[0].calculRentabilite();
        for (int i = 0; i < jours.length; i++) {
            if (jours[i].calculRentabilite() > max) {
                max = jours[i].calculRentabilite();
                dateMax = jours[i].getDate();
            }
        }
        return dateMax;
    }

    /*******************************************************************/

    public LocalDate getDebut() {
        return periode_debut;
    }
    public LocalDate getFin() {
        return periode_fin;
    }
    public Jour getDayOfMonth(LocalDate DayOfMonth) {
        Jour selectedDay=null;
        for (Jour jour : jours) {
            if (jour.getDate().equals(DayOfMonth)) {
                selectedDay = jour;
                break;
            }
        }
        return selectedDay;
    }

    public void initJours() {
        LocalDate periode_debut = LocalDate.of(LocalDate.now().getYear(), 1, 1);
        LocalDate periode_fin = LocalDate.of(LocalDate.now().getYear(), 12, 31);
        long daysBetween = ChronoUnit.DAYS.between(periode_debut, periode_fin);
        jours = new Jour[(int) daysBetween + 1];
        LocalDate currentDate = periode_debut;
        for (int i = 0; i < jours.length; i++) {
            jours[i] = new Jour(currentDate);
            currentDate = currentDate.plusDays(1);
        }

        for (int i = 0; i < jours.length; i++) {
            System.out.println(jours[i].getDate()+"\n");
        }
    }

    public void addLibresAll(LocalTime debut, LocalTime fin, int min){
        for (int i = 0; i < jours.length; i++) {
                Créneaux cr=new Créneaux(debut,fin,min);
            jours[i].ajouterCreneau(cr);
        }
    }
}




