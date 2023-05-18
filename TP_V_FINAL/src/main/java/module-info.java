module com.example.tp_v_final {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.tp_v_final to javafx.fxml;
    exports com.example.tp_v_final;
}