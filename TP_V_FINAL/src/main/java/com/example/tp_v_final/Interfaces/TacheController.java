package com.example.tp_v_final.Interfaces;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import com.example.tp_v_final.classes.*;
import java.time.*;

import java.util.List;

public class TacheController {
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

    @FXML
    private ListView<String> taskListView;

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
        // cr.setText(jour.toString());
        Stats.setText(jour.toStats());
        date.setText(jour.getDate().toString());
        System.out.println(jour.getDate().toString());

        List<Tache> tasks = jour.getTaches();
        ObservableList<String> taskNames = FXCollections.observableArrayList();
        for (Tache task : tasks) {
            taskNames.add(task.getNom());
        }
        taskListView.setItems(taskNames);
        taskListView.setCellFactory(listView -> new ListCell<String>() {
            private final HBox hbox;
            private final CheckBox checkBox;
            private final Label label;

            {
                hbox = new HBox(5);
                checkBox = new CheckBox();
                checkBox.setOnAction(event -> onTaskCompleted(event));
                label = new Label();
                hbox.getChildren().addAll(checkBox, label);
            }

            @Override
            protected void updateItem(String taskName, boolean empty) {
                super.updateItem(taskName, empty);
                if (empty || taskName == null) {
                    setGraphic(null);
                } else {
                    label.setText(taskName);
                    checkBox.setSelected(getTaskCompletionStatus(taskName));
                    setGraphic(hbox);
                }
            }
        });

    }

    public void setUser(Jour jour) {
        this.jour = jour;
    }

    public void setMainController(CalendarController controleur) {
        this.controleur = controleur;
    }

    @FXML
    private void onTaskCompleted(ActionEvent event) {
        String taskName = taskListView.getSelectionModel().getSelectedItem();
        if (taskName != null) {
            Tache selectedTask = findTaskByName(taskName);
            boolean completed = selectedTask.isCompleted();
            selectedTask.setCompleted(!completed);
        }
    }

    @FXML
    private LocalTime LocalTime(int heure, int minutes, String ampm) {
        LocalTime localTime = LocalTime.of(heure, minutes);
        if (ampm.equals("PM") && heure < 12) {
            localTime = localTime.plusHours(12);
        }
        return localTime;
    }

    private Tache findTaskByName(String taskName) {
        List<Tache> tasks = jour.getTaches();
        for (Tache task : tasks) {
            if (task.getNom().equals(taskName)) {
                return task;
            }
        }
        return null; // Task not found
    }

    private boolean getTaskCompletionStatus(String taskName) {
        Tache task = findTaskByName(taskName);
        return task != null && task.isCompleted();
    }


    @FXML
    private void OnAddCr() {
        int hd = heure_debut.getValue();
        int hf = heure_fin.getValue();
        int mind = minutes_debut.getValue();
        int minf = minutes_fin.getValue();
        int dureeMin = minutes_duree.getValue();
        String amDebut = ampmDebut.getValue();
        String amFin = ampmFin.getValue();
        System.out.println(hd + " " + mind + " \n" + hf + " " + minf + " \n" + dureeMin);
        Créneaux cr = new Créneaux(LocalTime(hd, mind, amDebut), LocalTime(hf, minf, amFin), dureeMin);
        jour.ajouterCreneau(cr);
    }
}