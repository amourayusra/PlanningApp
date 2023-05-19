 package com.example.tp_v_final.classes;
import javafx.application.Application;
import com.example.tp_v_final.Interfaces.CalendarController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
public class HelloApplication extends Application {
    @Override
<<<<<<< HEAD
        public void start(Stage stage) throws IOException {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/example/tp_v_final/interfaces/Stats.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 320, 240);
            stage.setTitle("Hello!");
            stage.setScene(scene);
            stage.show();
=======
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/example/tp_v_final/Interfaces/hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        try (FileOutputStream fileOut = new FileOutputStream("user.ser");
             ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {

            // Sauvegarde des objets dans le fichier
            objectOut.writeObject(new Account_user("User1", new User()));
            objectOut.writeObject(new Account_user("User2", new User()));

            System.out.println("Les objets ont été sauvegardés dans le fichier " + "user.ser");
        } catch (IOException e) {
            e.printStackTrace();
>>>>>>> 347ad27ebf76d460e0e746d5c6e3780453d38143
        }


    public static void main(String[] args) {
        launch(args);
    }
}