package com.example.tp_v_final.Interfaces;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
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
import com.example.tp_v_final.classes.User;
import com.example.tp_v_final.classes.Tache_simple;
public class StatsController{
    @FXML
    private Text Excellent;

    @FXML
    private Text Good;


    @FXML
    private Text Nbmin;


    @FXML
    private Text VerGood;

    @FXML
    private Text encouragement;

    @FXML
    private TextField inputNbmin;

    @FXML
    private Text jour_rentable;

    @FXML
    private Text rendement;


    private User user;


    public void initialize(User user) {
        this.user=user;
       int[] badges=user.getBadges();
        Good.setText(String.valueOf(badges[0]));
        VerGood.setText(String.valueOf(badges[1]));
        Excellent.setText(String.valueOf(badges[2]));
        Nbmin.setText(String.valueOf(user.getNbmin()));
      // jour_rentable.setText(String.valueOf(user.getCalendar().jourRentable()));
        encouragement.setText(String.valueOf(user.getEncouragement()));
        rendement.setText(String.valueOf(user.getNbBadges()));

    }
    public void setUser(User user){this.user=user;}
    @FXML
    void ModifierNbmin(ActionEvent event) {
           user.setNbmin(Integer.parseInt(inputNbmin.getText()));
           Nbmin.setText(String.valueOf(user.getNbmin()));
    }
}
