package com.example.tp_v_final.Interfaces;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.util.LinkedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import com.example.tp_v_final.classes.*;
import java.time.*;

import java.util.List;

import static com.example.tp_v_final.classes.Jour.progress;
import static com.example.tp_v_final.classes.User.*;

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
    @FXML
    private ListView<String> taskListView1;
    private User user;
    private Jour jour;
    private CalendarController controleur;
@FXML
    public void initialize(Jour jour,User user) {
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
        this.user=user;
        setUser(jour);
        Stats.setText(String.valueOf(user.getComp()));
        date.setText(jour.getDate().toString());
        System.out.println(jour.getDate().toString());
/*
        Tache Tache1=new Tache_simple("asma",2,12,LocalDate.now(),"",false,2);
        Tache Tache2=new Tache_simple("amina",2,12,LocalDate.now(),"",false,3);
        Tache Tache3=new Tache_simple("yusra",2,12,LocalDate.now(),"",false,3);
        Créneaux creneau1=new Créneaux(LocalTime.now(),LocalTime.now(),2);
        creneau1.setTacheAffectee(Tache1);
        Créneaux creneau2=new Créneaux(LocalTime.now(),LocalTime.now(),2);
        creneau2.setTacheAffectee(Tache2);
        Créneaux creneau3=new Créneaux(LocalTime.now(),LocalTime.now(),2);
        creneau3.setTacheAffectee(Tache3);
        LinkedList<Créneaux> crn=new LinkedList<Créneaux>();
        crn.add(creneau1);
        crn.add(creneau2);
        crn.add(creneau3);
        jour.setCreneaux(crn);
        System.out.println("heu  "+jour.getTaches());*/
        List<Tache> tasks = jour.getTaches();
        taskListView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                Tache selectedTask = findTaskByName(newValue);
                if (selectedTask != null) {
                    boolean completed = selectedTask.isCompleted();
                    selectedTask.setCompleted(!completed); // Toggle the completed value
                }
            }
        });

        ObservableList<String> taskNames = FXCollections.observableArrayList();
        for (Tache task : tasks) {
            taskNames.add(task.getNom());
        }
        taskListView.setItems(taskNames);

        List<Créneaux> creneauxList = jour.ChercheCreneauLibre();
        if (creneauxList!=null){
        ObservableList<String> creneauxNames = FXCollections.observableArrayList();
        for (Créneaux creneau : creneauxList) {
            creneauxNames.add(creneau.toString());
        }
        taskListView1.setItems(creneauxNames);}

        taskListView.setCellFactory(listView -> new ListCell<String>() {
            private final HBox hbox;
            private final CheckBox checkBox;
            private final Label label;

            {
                hbox = new HBox(5);
                checkBox = new CheckBox();
                checkBox.setOnAction(event -> onTaskCompleted(event));
                label = new Label();
                hbox.getChildren().addAll(checkBox,
                        label);
            }


            @Override
            protected void updateItem(String taskName, boolean empty) {
                super.updateItem(taskName, empty);
                if (empty || taskName == null) {
                    setGraphic(null);
                } else {
                    label.setText(taskName);
                    Tache task = findTaskByName(taskName);
                    if (task != null) {
                        // Save the current checkbox value before updating it
                        boolean checkboxValue = checkBox.isSelected();
                        checkBox.setSelected(task.isCompleted() == true);
                        // Restore the previous checkbox value
                        checkBox.setSelected(checkboxValue);
                    } else {
                        checkBox.setSelected(false);
                    }
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

        private void onTaskCompleted (ActionEvent event){
            String taskName = taskListView.getSelectionModel().getSelectedItem();
            user.setComp(user.getComp()+1);
        Stats.setText(String.valueOf(user.getComp()));


            if (taskName != null) {
                Tache selectedTask = findTaskByName(taskName);
                if (selectedTask != null) {
                    boolean completed = selectedTask.isCompleted();
                    selectedTask.setCompleted(true);

                    if (progress >= user.nbmin) {
                        Alert alert = new Alert(AlertType.INFORMATION);
                        alert.setTitle("Félicitations!");
                        alert.setHeaderText(null);
                        alert.setContentText("Tu as atteint le nombre maximal de taches à faire ce jour.");
                        alert.showAndWait();

                        user.consecutive++;

                        // Check if a badge is achieved
                        int currentBadgeLevel = user.nbBadges;
                        if (currentBadgeLevel < badgeThresholds.length) {
                            int requiredThreshold = badgeThresholds[currentBadgeLevel];
                            if (user.consecutive == requiredThreshold) {
                                String currentBadgeName = badgeNames[currentBadgeLevel];
                                Alert badgeAlert = new Alert(AlertType.INFORMATION);
                                badgeAlert.setTitle("Badge atteint");
                                badgeAlert.setHeaderText(null);
                                badgeAlert.setContentText("Badge achieved: " + currentBadgeName);
                                badgeAlert.showAndWait();

                                user.nb_badges[currentBadgeLevel]++;
                                user.nbBadges++;

                                // Reset the consecutive achievements
                                user.consecutive = 0;
                            }
                        }
                    } else {
                        // Reset the consecutive achievements
                        user.consecutive = 0;
                    }
                }
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
        return task != null && task.isCompleted() == true;
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