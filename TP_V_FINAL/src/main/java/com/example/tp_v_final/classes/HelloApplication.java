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
public class HelloApplication extends Application {
  /*  @Override

        public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/example/tp_v_final/interfaces/hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 900, 500);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
<<<<<<< HEAD
    }
=======
    }*/
   public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/example/tp_v_final/Interfaces/hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

>>>>>>> 406bd012889fd6e72310ee6f5b1f3d3af521b1a1
    public static void main(String[] args) {
        try (FileOutputStream fileOut = new FileOutputStream("user.ser");
             ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {

            // Sauvegarde des objets dans le fichier
            objectOut.writeObject(new Account_user("User3", new User(6)));
            objectOut.writeObject(new Account_user("User2", new User()));
            System.out.println("Les objets ont été sauvegardés dans le fichier " + "user.ser");
        } catch (IOException e) {
            e.printStackTrace();
        }
        launch(args);
    }
}