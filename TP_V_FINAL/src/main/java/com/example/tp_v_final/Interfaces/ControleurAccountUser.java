package com.example.tp_v_final.Interfaces;
import com.example.tp_v_final.classes.Account_user;
import com.example.tp_v_final.classes.Calendrier;
import com.example.tp_v_final.classes.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDate;

import javafx.scene.control.Alert;

public class ControleurAccountUser {

    @FXML
    private Button btn_login;

    @FXML
    private TextField pseudo;

    @FXML
    void Authentification(ActionEvent event) {
        // Récupérer les valeurs saisies par l'utilisateur
        String username = pseudo.getText();
        // Vous pouvez également récupérer le mot de passe de la même manière

        // Créez une instance de la classe AccountUser
        Account_user accountUser = new Account_user();

        // Appelez la méthode Authentifier en lui passant les données saisies par l'utilisateur
        boolean isAuthenticated = accountUser.Authentification(pseudo.getText());

        if (isAuthenticated) {
            // Authentification réussie

            passerAPageSuivante(accountUser.getUser(pseudo.getText()));

        } else {
            // Authentification échouée et creation d'un compte
            accountUser.addUser(username,new User(2));
            //le mettre dans le fichier 
            try (FileOutputStream fileOut = new FileOutputStream("users.ser");
                 ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {

                objectOut.writeObject(accountUser);

                System.out.println("le fichier a ete cree");
            } catch (IOException e) {
                e.printStackTrace();
            }
            afficherMessageErreur("Vous n'etes pas inscrit, mais on vous a cree un nouveau compte");

        }
    }



    private void passerAPageSuivante(User user) {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Acceuil.fxml"));
            Parent root = loader.load();
            // Obtenez une référence au contrôleur de la page d'accueil
            ControleurAcceuil controleurAcceuil = loader.getController();

            // Transmettez l'objet User au contrôleur de la page d'accueil
            controleurAcceuil.setUser(user);
            controleurAcceuil.setPseudo(pseudo.getText());

            // Obtenez une référence au Stage actuel
            Stage stage = (Stage) btn_login.getScene().getWindow();

            // Créez une nouvelle scène avec la vue de la page d'accueil
            Scene scene = new Scene(root);

            // Remplacez la scène actuelle par la nouvelle scène
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void afficherMessageErreur(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erreur");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }


}
