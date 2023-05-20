package com.example.tp_v_final.Interfaces;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Font;
import java.time.*;
import javafx.scene.text.Text;
import javafx.fxml.Initializable;
import java.net.URL;
import java.util.*;
import java.net.URL;
import java.time.LocalDate;
import com.example.tp_v_final.classes.*;

public class CalendarController implements Initializable {
    @FXML
    DatePicker debut;
    @FXML
    DatePicker fin;
    @FXML
    private Text cr;
    @FXML
    private FlowPane calendar;
    @FXML
    private Text year;
    @FXML
    private Text month;

    private Calendrier calendrier;

/*-------------------------------------------------------------------------------------------------------------------*/
@Override
public void initialize(URL location, ResourceBundle resources) {
  // calendrier=new Calendrier(LocalDate.now().minusMonths(2),LocalDate.now().plusMonths(6));
   // setUser(new Calendrier(LocalDate.now().minusMonths(2),LocalDate.now().plusMonths(6)));
    showMonth(YearMonth.now());
}

/*-------------------------------------------------------------------------------------------------------------------*/
public void setUser(Calendrier calendar){ this.calendrier=calendar;}
    /*-------------------------------------------------------------------------------------------------------------------*/
public void showMonth(YearMonth displayedMonth){
    int i;
    LocalDate currentDate = displayedMonth.atDay(1);
    year.setText(String.valueOf(currentDate.getYear()));
    month.setText(currentDate.getMonth().toString());
    LocalDate DayOfMonth = currentDate.withDayOfMonth(1);
    Jour[] j=new Jour[31];
    DayOfWeek firstDayOfWeek = DayOfMonth.getDayOfWeek();
    for (int k = 1; k < firstDayOfWeek.getValue()+1; k++) {
        Label emptyLabel = new Label(" ");
        emptyLabel.setPrefHeight(50);
        emptyLabel.setPrefWidth(80);
        calendar.getChildren().add(emptyLabel);
    }
    for (i = 0; i < displayedMonth.lengthOfMonth(); i++) {
        if (DayOfMonth.isAfter(calendrier.getFin()) || DayOfMonth.isBefore(calendrier.getDebut())) break;
        j[i] = calendrier.getDayOfMonth(DayOfMonth);
        Button button = new Button(String.valueOf(j[i].getDate().getDayOfMonth()));
        final int index = i; // Crea
        // te a final copy of i
        button.setOnAction(event -> {
            cr.setText(j[index].toString());
        });
        button.setPrefWidth(80);
        button.setPrefHeight(50);
        calendar.getChildren().add(button);
        DayOfMonth = DayOfMonth.plusDays(1);
    }

}
/*-------------------------------------------------------------------------------------------------------------------*/
    @FXML
    private void backOneMonth(ActionEvent event) {
        int yearValue = Integer.parseInt(year.getText());
        String monthText = month.getText();
        YearMonth displayedMonth = YearMonth.of(yearValue, Month.valueOf(monthText.toUpperCase()));
        displayedMonth = displayedMonth.minusMonths(1);
        calendar.getChildren().clear(); // Clear the calendar before updating year and month
        showMonth(displayedMonth);
    }
/*-------------------------------------------------------------------------------------------------------------------*/        /*-------------------------------------------------------------------------------------------------------------------*/
    @FXML
        private void forwardOneMonth(ActionEvent event) {
        int yearValue = Integer.parseInt(year.getText());
        String monthText = month.getText();
        YearMonth displayedMonth = YearMonth.of(yearValue, Month.valueOf(monthText.toUpperCase()));
        displayedMonth = displayedMonth.plusMonths(1);
        calendar.getChildren().clear();
        showMonth(displayedMonth);
        }
    /*-------------------------------------------------------------------------------------------------------------------*/
    @FXML
    private void OnFixPeriod( ActionEvent event){
    calendrier.fixer_periode(debut.getValue(), fin.getValue());
        calendar.getChildren().clear();
        showMonth(YearMonth.from(calendrier.getDebut()));
    }
}