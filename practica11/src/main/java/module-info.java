module com.example.sistemaestudiantila1945 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.sistemaestudiantila1945 to javafx.fxml;
    exports com.example.sistemaestudiantila1945;
}