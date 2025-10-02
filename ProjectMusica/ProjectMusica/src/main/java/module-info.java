module co.edu.uniquindio.poo.projectmusica {
    requires javafx.controls;
    requires javafx.fxml;


    opens co.edu.uniquindio.poo.projectmusica to javafx.fxml;
    exports co.edu.uniquindio.poo.projectmusica;
}