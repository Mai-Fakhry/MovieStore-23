module com.example.movie {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;
    requires java.sql;
    requires java.desktop;

    opens com.example.movie to javafx.fxml;
    exports com.example.movie;
}