module presentation.proyecto2nd50 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    requires com.google.gson;


    opens presentation.proyecto2nd50 to javafx.fxml;
    exports presentation.proyecto2nd50;

    opens logic.admin to com.google.gson;
    exports logic.admin;

    opens logic.model to javafx.base;
    exports logic.model;
}