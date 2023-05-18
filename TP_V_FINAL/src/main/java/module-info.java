module com.example.tp_v_final {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.tp_v_final to javafx.fxml;
    exports com.example.tp_v_final;
    exports com.example.tp_v_final.classes;
    opens com.example.tp_v_final.classes to javafx.fxml;
}