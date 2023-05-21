package com.example.tp_v_final.Interfaces;
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
    Text date;
    @FXML
    Text cr;
    @FXML
    Text Stats;
    @FXML
    TextField cr_debut;
    @FXML
    TextField cr_fin;
    @FXML
    TextField dureeMin;
    private Jour jour;
    private CalendarController controleur;

    public void initialize(Jour jour) {
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
    public void OnAddCr(){

       // Créneaux cr=new Créneaux(Integer.parseInt(cr_debut.getText()),Integer.parseInt(cr_fin.getText()),2);
       // jour.ajouterCreneau(cr);
}

}
