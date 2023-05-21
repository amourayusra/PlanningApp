package com.example.tp_v_final.Interfaces;
import com.example.tp_v_final.classes.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.collections.FXCollections;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ControleurAcceuil {

    @FXML
    private ColorPicker Color;

    @FXML
    private TextField Type;

    @FXML
    private Button AjoutCatB;

    @FXML
    private Button save;

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
    private Tab Calendar;
    @FXML
    private Tab Stats;

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
    private TableView<Tache> listeTaches;

    @FXML
    private Button planifierButton;


    @FXML
    private TableColumn<Tache, String> ColmC;

    @FXML
    private TableColumn<Tache, Integer> ColmD;

    @FXML
    private TableColumn<Tache, Integer> ColmDu;

    @FXML
    private TableColumn<Tache, String> ColmN;

    @FXML
    private TableColumn<Tache, Integer> ColmP;

    @FXML
    private TableColumn<Tache, String> ColmT;

    private User user;
    private String pseudo;

    public void setUser(User user) {
        this.user = user;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    @FXML
    void initialize() {
        // Initialise la ComboBox avec les types de catégories existantes
        CategorieBox.setItems(FXCollections.observableArrayList(Categorie.getTypeList()));

        // Configuration du Spinner pour le champ 'duree'
        SpinnerValueFactory<Integer> dureeValueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 10000, 1);
        duree.setValueFactory(dureeValueFactory);

        // Configuration du Spinner pour le champ 'periode'
        SpinnerValueFactory<Integer> periodeValueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 10, 1);
        periode.setValueFactory(periodeValueFactory);

        // Configuration du Spinner pour le champ 'priorite'
        SpinnerValueFactory<Integer> prioriteValueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 3, 1);
        priorite.setValueFactory(prioriteValueFactory);
        // Activer l'éditeur pour le champ 'duree'
        duree.setEditable(true);

        // Activer l'éditeur pour le champ 'periode'
        periode.setEditable(true);

        // Activer l'éditeur pour le champ 'priorite'
        priorite.setEditable(true);

        //Afficher les Tache non planifier
        AfficherTache.setOnSelectionChanged(event -> {
            if (AfficherTache.isSelected()) {
                // Configurez les cellules des colonnes pour afficher les données de la tâche
                ColmN.setCellValueFactory(new PropertyValueFactory<>("nom"));
                ColmP.setCellValueFactory(new PropertyValueFactory<>("priorite"));
                ColmDu.setCellValueFactory(new PropertyValueFactory<>("duree"));
                ColmC.setCellValueFactory(new PropertyValueFactory<>("categorie"));
                ColmD.setCellValueFactory(new PropertyValueFactory<>("deadline"));
                ColmT.setCellValueFactory(new PropertyValueFactory<>("deadline"));
                // Configurez d'autres colonnes avec les attributs correspondants de la tâche
                // Récupérez toutes les tâches non planifiées de l'utilisateur
                List<Tache> tachesNonPlanifiees = user.getTaches_non_panifiées();

                // Ajoutez les tâches à la TableView
                listeTaches.setItems(FXCollections.observableArrayList(tachesNonPlanifiees));

                // Définissez la sélection multiple dans la TableView
                listeTaches.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
            }
        });
        /*
        Calendar.setOnSelectionChanged(event -> {
            if (Calendar.isSelected()) {
                try{
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("Calendar.fxml"));
                    Parent root = loader.load();
                    CalendarController controleurCalendrier = loader.getController();
                    controleurCalendrier.setUser(user.getCalendar());
                    Stage stage = new Stage();
                    Scene scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();
            catch(IOException e) {
                        e.printStackTrace();}}
            }

            });
        Stats.setOnSelectionChanged(event -> {
            if (Stats.isSelected()) {
                try{
                FXMLLoader loader = new FXMLLoader(getClass().getResource("Calendar.fxml"));
                Parent root = loader.load();
                CalendarController controleurCalendrier = loader.getController();
                controleurCalendrier.setUser(user.getCalendar());
                Stage stage = new Stage();
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }catch(IOException e) {
                    e.printStackTrace();}}

        });*/
    }

    @FXML
    void AjoterTacheSimple(ActionEvent event) {
        String selectedCategorie = CategorieBox.getValue();
        boolean estPeriodique = periodique.isSelected();
        user.ajouterTacheSimple(nom_tache.getText(), priorite.getValue(), duree.getValue(), deadline.getValue(), selectedCategorie, estPeriodique, periode.getValue());

    }

    @FXML
    void AjouterTacheDecomposable(ActionEvent event) {
        String selectedCategorie = CategorieBox.getValue();
        user.ajouterTacheDecomposable(nom_tache.getText(), priorite.getValue(), duree.getValue(), deadline.getValue(), selectedCategorie);

    }

    @FXML
    void PlanifierTache(ActionEvent event) {

    }
    @FXML
    void onCalendrier () throws IOException {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Calendar.fxml"));
            Parent root = loader.load();
            CalendarController controleurCalendrier = loader.getController();
            controleurCalendrier.setUser(user.getCalendar());
            Stage stage = new Stage();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    void onStats () throws IOException {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Stats.fxml"));
            Parent root = loader.load();
            StatsController controleurStats = loader.getController();
            controleurStats.setUser(user);
            Stage stage = new Stage();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    void addCategorie(ActionEvent event) {
        Categorie.addCategorie(Type.getText(),Color.getValue());
        initialize();
    }

    @FXML
    void sauvgarder(ActionEvent event) {
        Account_user account = new Account_user();
        account.save(user, pseudo);
    }
}
