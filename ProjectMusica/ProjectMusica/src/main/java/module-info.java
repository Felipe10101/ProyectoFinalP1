module co.edu.uniquindio.poo.projectmusica {

    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires org.junit.jupiter.api;

    opens co.edu.uniquindio.poo.projectmusica to javafx.fxml;
    opens co.edu.uniquindio.poo.projectmusica.controller to javafx.fxml;
    opens co.edu.uniquindio.poo.projectmusica.viewcontroller to javafx.fxml;
    opens co.edu.uniquindio.poo.projectmusica.model to javafx.fxml;

    exports co.edu.uniquindio.poo.projectmusica;
    exports co.edu.uniquindio.poo.projectmusica.controller;
    exports co.edu.uniquindio.poo.projectmusica.viewcontroller;
    exports co.edu.uniquindio.poo.projectmusica.model;
}