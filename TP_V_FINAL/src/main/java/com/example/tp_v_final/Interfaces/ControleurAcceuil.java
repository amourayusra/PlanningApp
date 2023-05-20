package com.example.tp_v_final.Interfaces;

import com.example.tp_v_final.classes.*;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.ListView;
import javafx.collections.FXCollections;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ControleurAcceuil {

    @FXML
    private Tab AfficherTache;

    @FXML
    private ComboBox<String> CategorieBox;

    @FXML
    private Button Creer_tache;

    @FXML
    private Button creer_tache_decomp;

    @FXML
    private DatePicker deadline;

    @FXML
    private Spinner<Integer> duree;

    @FXML
    private Tab form_ajout_tache;

    @FXML
    private TextField nom_tache;

    @FXML
    private Spinner<Integer> periode;

    @FXML
    private RadioButton periodique;

    @FXML
    private Spinner<Integer> priorite;

    @FXML
    private Tab tache_decomposable;

    @FXML
    private Tab tache_simple;

    @FXML
    private ListView<String> listeTaches;
    private User user;

    public void setUser(User user) {
        this.user = user;
    }

    @FXML
    void initialize() {
        // Initialise la ComboBox avec les types de catégories existantes
       /* CategorieBox.setItems(FXCollections.observableArrayList(Categorie.getTypeList()));

        // Configuration du Spinner pour le champ 'duree'
        SpinnerValueFactory<Integer> dureeValueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 100, 1);
        duree.setValueFactory(dureeValueFactory);

        // Configuration du Spinner pour le champ 'periode'
        SpinnerValueFactory<Integer> periodeValueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 10, 1);
        periode.setValueFactory(periodeValueFactory);

        // Configuration du Spinner pour le champ 'priorite'
        SpinnerValueFactory<Integer> prioriteValueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 10, 1);
        priorite.setValueFactory(prioriteValueFactory);
        // Activer l'éditeur pour le champ 'duree'
        duree.setEditable(true);

        // Activer l'éditeur pour le champ 'periode'
        periode.setEditable(true);

        // Activer l'éditeur pour le champ 'priorite'
        priorite.setEditable(true);
        AfficherTache.setOnSelectionChanged(event -> {
            if (AfficherTache.isSelected()) {
                // L'onglet "Afficher Tache" a été sélectionné

                // Récupérer toutes les tâches non planifiées de l'utilisateur
                List<Tache> tachesNonPlanifiees = user.getTaches_non_panifiées();

                // Créer une liste de noms de tâches
                List<String> nomsTaches = new ArrayList<>();
                for (Tache tache : tachesNonPlanifiees) {
                    nomsTaches.add(tache.getNom()); // Ajouter le nom de la tâche à la liste
                }

                // Afficher les noms des tâches dans la ListView
                listeTaches.setItems(FXCollections.observableArrayList(nomsTaches));

            }
        });*/
    }

    @FXML
    void AjoterTacheSimple(ActionEvent event) {
        String selectedCategorie = CategorieBox.getValue();
        boolean estPeriodique = periodique.isSelected();
        user.ajouterTacheSimple(nom_tache.getText(), priorite.getValue(), duree.getValue(), deadline.getValue(), selectedCategorie,estPeriodique,periode.getValue());

    }

    @FXML
    void AjouterTacheDecomposable(ActionEvent event) {
        String selectedCategorie = CategorieBox.getValue();
        user.ajouterTacheDecomposable(nom_tache.getText(), priorite.getValue(), duree.getValue(), deadline.getValue(), selectedCategorie);

    }
    @FXML
    void onCalendrier () throws IOException { //nouvelle partie
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/example/tp_v_final/interfaces/Calendar.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 500);
        Stage stage = new Stage();
        stage.setTitle("Calendrier");
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    void onStats () throws IOException { //nouvelle partie
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/example/tp_v_final/interfaces/Stats.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 500);
        Stage stage = new Stage();
        stage.setTitle("Statistiques");
        stage.setScene(scene);
        stage.show();
    }
}
