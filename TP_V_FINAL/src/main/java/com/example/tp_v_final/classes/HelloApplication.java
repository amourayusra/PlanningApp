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
        public void start(Stage stage) throws IOException {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/example/tp_v_final/interfaces/Stats.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 320, 240);
            stage.setTitle("Hello!");
            stage.setScene(scene);
            stage.show();
        }


    public static void main(String[] args) {
        launch(args);
    }
}