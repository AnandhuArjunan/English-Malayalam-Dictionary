module com.anandhuarjunan.englishmalayalam.dictionary.app {
    requires javafx.controls;
    requires javafx.graphics;
    requires javafx.fxml;
    requires javafx.web;
    requires com.jfoenix;
    opens com.anandhuarjunan.englishmalayalam.dictionary.app.controller to javafx.fxml;

    exports com.anandhuarjunan.englishmalayalam.dictionary.app;
}