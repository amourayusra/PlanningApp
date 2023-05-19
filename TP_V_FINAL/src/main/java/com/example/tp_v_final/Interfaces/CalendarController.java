package com.example.tp_v_final.Interfaces;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Text;
import javafx.scene.control.Button;
import javafx.fxml.Initializable;
import java.net.URL;
import java.util.ResourceBundle;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.LinkedList;
import java.net.URL;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ResourceBundle;

import com.example.tp_v_final.classes.Créneaux;
import com.example.tp_v_final.classes.Calendrier;
import com.example.tp_v_final.classes.Jour;
import com.example.tp_v_final.classes.Tache;
import com.example.tp_v_final.classes.Tache_simple;

public class CalendarController implements Initializable {

    @FXML
    private FlowPane calendar;
    @FXML
    private YearMonth displayedMonth;
  /*  @FXML
    private ListView<Créneaux> listView;*/

    private Calendrier calendrier;
/*
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Initialize the calendar with a date
        Text year = new Text();
        Text month = new Text();
        LocalDate currentDate = LocalDate.now();
        Jour[] j=new Jour[31];
        j[0] =new Jour(currentDate);
        j[1]=new Jour(currentDate);
        Tache Tache1=new Tache_simple("yusra",2,12,currentDate);
        Tache Tache2=new Tache_simple("amina",2,12,currentDate);
        Créneaux creneau1=new Créneaux(LocalDateTime.now(),LocalDateTime.now(),2);
        creneau1.setTacheAffectee(Tache1);
        Créneaux creneau2=new Créneaux(LocalDateTime.now(),LocalDateTime.now(),2);
        creneau2.setTacheAffectee(Tache2);
        LinkedList<Créneaux> cr=new LinkedList<Créneaux>();
        cr.add(creneau1);
        cr.add(creneau2);
        j[0].setCreneaux(cr);
        j[1].setCreneaux(cr);
        calendrier = new Calendrier(currentDate,currentDate,j);
        year.setText(String.valueOf(currentDate.getYear()));
        month.setText(currentDate.getMonth().toString());

        // Simulate créneaux for the day
        Jour[] jours = calendrier.getJours();
        Jour selectedDay = null;

        for (Jour jour : jours) {
            if (jour.getDate().equals(currentDate)) {
                selectedDay = jour;
                break;
            }
        }

        // Show the créneaux in the ListView
        if (selectedDay != null) {
            afficherCréneaux(selectedDay);
        }
    }

    private void afficherCalendrier() {
        // Clear the existing calendar content
        calendar.getChildren().clear();

        // Add the days to the calendar
        for (Jour jour : calendrier.getJours()) {
            Button dayButton = createDayButton(jour);
            calendar.getChildren().add(dayButton);
        }
    }

    private Button createDayButton(Jour jour) {
        Button dayButton = new Button(jour.getDate().toString());
        dayButton.setOnAction(event -> {
            afficherCréneaux(jour);
        });
        return dayButton;
    }

    private void afficherCréneaux(Jour jour) {
        // Clear the existing list view content
        listView.getItems().clear();

        // Add the créneaux for the selected day to the list view
        List<Créneaux> créneaux = jour.getCreneaux();
        for (Créneaux créneau : créneaux) {
            listView.getItems().add(créneau);
        }
    }
   private void showMonth(YearMonth month) {
        // Clear the existing calendar content
        calendar.getChildren().clear();

        // Set the year and month text
        Text year = new Text();
        Text monthText = new Text();
        year.setText(String.valueOf(month.getYear()));
        monthText.setText(month.getMonth().toString());

        // Add the year and month text to the calendar
        calendar.getChildren().addAll(year, monthText);

        // Add the days to the calendar
        for (Jour jour : calendrier.getJours()) {
            Button dayButton = createDayButton(jour);
            calendar.getChildren().add(dayButton);
        }
    }
    @FXML
    private void backOneMonth(ActionEvent event) {
        displayedMonth = displayedMonth.minusMonths(1);
        showMonth(displayedMonth);
    }

    @FXML
    private void forwardOneMonth(ActionEvent event) {
        displayedMonth = displayedMonth.plusMonths(1);
        showMonth(displayedMonth);
    }

 */
@Override
public void initialize(URL location, ResourceBundle resources) {
    // Initialize the calendar with a date
    int i;
    Text year = new Text();
    Text month = new Text();
    displayedMonth = YearMonth.now();
    LocalDate currentDate = LocalDate.now();
    LocalDate DayOfMonth = currentDate.withDayOfMonth(1);
    Jour[] j=new Jour[31];
    /*
    Tache Tache1=new Tache_simple("yusra",2,12,currentDate);
    Tache Tache2=new Tache_simple("amina",2,12,currentDate);
    Créneaux creneau1=new Créneaux(LocalTime.now(),LocalTime.now(),2);
    creneau1.setTacheAffectee(Tache1);
    Créneaux creneau2=new Créneaux(LocalTime.now(),LocalTime.now(),2);
    creneau2.setTacheAffectee(Tache2);
    LinkedList<Créneaux> cr=new LinkedList<Créneaux>();
    cr.add(creneau1);
    cr.add(creneau2);*/
    for (i = 0; i < displayedMonth.lengthOfMonth(); i++) {
        j[i] = new Jour(DayOfMonth);
       //j[0].setCreneaux(cr);

        System.out.println(j[i].toString());
        Button button = new Button(j[i].toString());
        button.setPrefWidth(100);
        button.setPrefHeight(100);
        calendar.getChildren().add(button);
        DayOfMonth = DayOfMonth.plusDays(1);
    }
    calendrier = new Calendrier(currentDate,currentDate,j);
    year.setText(String.valueOf(currentDate.getYear()));
    month.setText(currentDate.getMonth().toString());
}
/*-------------------------------------------------------------------------------------------------------------------*/
    @FXML
    private void backOneMonth(ActionEvent event) {

    }

    @FXML
    private void forwardOneMonth(ActionEvent event) {

    }
}