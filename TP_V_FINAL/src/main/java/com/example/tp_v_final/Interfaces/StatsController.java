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
public class StatsController  implements Initializable{
    @FXML
    Text rendement ;
    @FXML
    Text badge ;
    @FXML
    Text jour_rentable;
    @FXML
    Text encouragement;
    private User user;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        User user =new User(5);
       // badge.setText(String.valueOf(user.getNbBadges()));
       // jour_rentable.setText(String.valueOf(user.getCalendar().jourRentable()));
        encouragement.setText(String.valueOf(user.getEncouragement()));
      // rendement.setText(String.valueOf(user.getNbBadges()));
    }
}
