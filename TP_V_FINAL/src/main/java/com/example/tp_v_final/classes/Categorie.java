package com.example.tp_v_final.classes;

import java.util.ArrayList;
import java.util.*;

public class Categorie {
    private static List<String> type =new ArrayList<>(Arrays.asList("work"));
    private static List<String> color = new ArrayList<>(Arrays.asList("red"));

    public Categorie(String typee, String coulor) {
        type.add(typee);
        color.add(coulor);
    }

    public static List<String> getTypeList() {
        return type;
    }

    public static List<String> getColorList() {
        return color;
    }

    public static void addCategorie(String typee, String coulor) {
        type.add(typee);
        color.add(coulor);
    }

    public static void removeCategorie(String typee) {
        int index = type.indexOf(typee);
        if (index != -1) {
            type.remove(index);
            color.remove(index);
        }
    }
}

