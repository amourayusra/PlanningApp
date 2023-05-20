package com.example.tp_v_final.Interfaces;

import javafx.event.ActionEvent;

import javafx.fxml.FXML;

import javafx.scene.text.Text;

import javafx.fxml.Initializable;

import java.net.URL;

import java.util.ResourceBundle;

import com.example.tp_v_final.classes.User;

public class StatsController implements Initializable {


    @FXML
    private Text rendement;


    @FXML
    private Text badge;


    @FXML
    private Text jour_rentable;

    @FXML
    private Text encouragement;

    private User user;


    @Override

    public void initialize(URL url, ResourceBundle resourceBundle) {
// Initialise les valeurs des composants Text avec les données de l'utilisateur
        afficherDonnees();

    }


    public void setUser(User user) {

        this.user = user;
// Met à jour les valeurs des composants Text avec les nouvelles données de l'utilisateur
        afficherDonnees();
    }

    private void afficherDonnees() {

        if (user != null) {
            badge.setText(String.valueOf(user.getNbBadges()));
            jour_rentable.setText(String.valueOf(user.getCalendar().jourRentable()));
            encouragement.setText(String.valueOf(user.getEncouragement()));
            rendement.setText(String.valueOf(user.getNbBadges()));

        }

    }

}

