module com.anandhuarjunan.englishmalayalam.dictionary.app {
    requires javafx.controls;
    requires javafx.graphics;
    requires javafx.fxml;
    requires javafx.web;
    requires com.jfoenix;
	requires javafx.base;
	requires com.opencsv;
	requires org.apache.commons.lang3;

    opens com.anandhuarjunan.englishmalayalam.dictionary.app.controller to javafx.fxml;

    exports com.anandhuarjunan.englishmalayalam.dictionary.app;
}