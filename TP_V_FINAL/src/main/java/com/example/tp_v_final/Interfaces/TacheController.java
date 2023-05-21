package com.example.tp_v_final.Interfaces;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Font;
import java.io.IOException;
import java.time.*;
import javafx.scene.text.Text;
import javafx.fxml.Initializable;
import java.net.URL;
import java.util.*;
import java.net.URL;
import java.time.LocalDate;
import com.example.tp_v_final.classes.*;
import javafx.stage.Stage;
public class TacheController  {
    @FXML
    private Text Stats;

    @FXML
    private ComboBox<String> ampmDebut;

    @FXML
    private ComboBox<String> ampmFin;

    @FXML
    private Text cr;

    @FXML
    private Text date;

    @FXML
    private ComboBox<Integer> heure_debut;

    @FXML
    private ComboBox<Integer> heure_fin;

    @FXML
    private ComboBox<Integer> minutes_debut;

    @FXML
    private ComboBox<Integer> minutes_duree;

    @FXML
    private ComboBox<Integer> minutes_fin;

    private Jour jour;
    private CalendarController controleur;

    public void initialize(Jour jour) {
        ObservableList<Integer> hoursList = FXCollections.observableArrayList();
        for (int i = 1; i <= 12; i++) {
            hoursList.add(i);
        }
        heure_debut.setItems(hoursList);
        heure_fin.setItems(hoursList);

        // Initialize the minutes ComboBox
        ObservableList<Integer> minutesList = FXCollections.observableArrayList();
        for (int i = 0; i <= 59; i++) {
            minutesList.add(i);
        }
        minutes_debut.setItems(minutesList);
        minutes_fin.setItems(minutesList);
        minutes_duree.setItems(minutesList);
        ObservableList<String> ampm = FXCollections.observableArrayList();
        ampm.add("am");
        ampm.add("pm");
        ampmDebut.setItems(ampm);
        ampmFin.setItems(ampm);
        setUser(jour);
        cr.setText(jour.toString());
        Stats.setText(jour.toStats());
        date.setText(jour.getDate().toString());
        System.out.println(jour.getDate().toString());
    }
    public void setUser(Jour jour ){ this.jour=jour;}
    public void setMainController(CalendarController controleur) {
        this.controleur = controleur;
    }

    @FXML
    private void OnAddCr(){
        int hd=heure_debut.getValue();
        int hf=heure_fin.getValue();
        int mind=minutes_debut.getValue();
        int minf=minutes_fin.getValue();
        int dureeMin=minutes_duree.getValue();
        String amDebut=ampmDebut.getValue();
        String amFin=ampmFin.getValue();
        System.out.println(hd+" "+mind+" \n"+hf+" "+minf+" \n"+dureeMin);
        Créneaux cr=new Créneaux(LocalTime(hd,mind,amDebut),LocalTime(hf,minf,amFin),dureeMin);
        jour.ajouterCreneau(cr);
    }
    @FXML
    private LocalTime LocalTime(int heure,int minutes, String ampm) {
        LocalTime localTime = LocalTime.of(heure, minutes);
        if (ampm.equals("PM") && heure < 12) {
            localTime = localTime.plusHours(12);
        }
        return localTime;
    }

}
