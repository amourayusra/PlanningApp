package com.example.tp_v_final.classes;

import java.util.ArrayList;
import java.util.List;

public class Projet {
    private List<Tache> listeDeTaches;
    private String nomP;
    private String discription;

    public Projet(String nomP, String discription) {
        this.nomP = nomP;
        this.discription = discription;
        listeDeTaches = new ArrayList<>();
    }

    public List<Tache> getListeDeTaches() {
        return listeDeTaches;
    }

    public String getNomP() {
        return nomP;
    }

    public void setListeDeTaches(List<Tache> listeDeTaches) {
        this.listeDeTaches = listeDeTaches;
    }

    public void setNomP(String nomP) {
        this.nomP = nomP;
    }

    public void addTache(Tache tache) {
        listeDeTaches.add(tache);
    }
}
