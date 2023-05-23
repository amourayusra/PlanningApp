 package com.example.tp_v_final.classes;
import javafx.application.Application;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import com.example.tp_v_final.Interfaces.CalendarController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.time.LocalDate;
import java.util.HashMap;

 public class HelloApplication extends Application {
 @Override
   public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/example/tp_v_final/Interfaces/hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 900, 500);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        // Création de la HashMap avec des utilisateurs et des pseudonymes
      /*  HashMap<String, User> userMap = new HashMap<>();
        userMap.put("User1", new User(6));
        userMap.put("User2", new User(6));
        try (FileOutputStream fileOut = new FileOutputStream("users.ser");
             ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {
            objectOut.writeObject(userMap);
            System.out.println("le fichier a ete cree");
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        launch(args);

    }
}