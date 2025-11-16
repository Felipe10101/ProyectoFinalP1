module co.edu.uniquindio.poo.projectmusica {

    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;

    opens co.edu.uniquindio.poo.projectmusica to javafx.fxml;
    opens co.edu.uniquindio.poo.projectmusica.controller to javafx.fxml;
    opens co.edu.uniquindio.poo.projectmusica.viewcontroller to javafx.fxml;

    exports co.edu.uniquindio.poo.projectmusica;
    exports co.edu.uniquindio.poo.projectmusica.controller;
    exports co.edu.uniquindio.poo.projectmusica.viewcontroller;
}