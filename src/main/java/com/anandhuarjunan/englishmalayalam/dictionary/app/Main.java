package com.anandhuarjunan.englishmalayalam.dictionary.app;

import java.io.IOException;
import java.util.Objects;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {
    private double xOffset = 0;
    private double yOffset = 0;
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
    	loadCustomFonts();
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        primaryStage.setTitle("English Malayalam Dictionary");
        primaryStage.getIcons().add(new Image(Main.class.getResourceAsStream("icons/icon.png")));
        Parent root = FXMLLoader.load(getClass().getResource("fxml/DictionaryGui.fxml"));
        Scene scene = new Scene(root);
        scene.setFill(Color.TRANSPARENT);

        primaryStage.setScene(scene);
        primaryStage.show();

        Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
        primaryStage.setX((screenBounds.getWidth() - primaryStage.getWidth()) / 2);
        primaryStage.setY((screenBounds.getHeight() - primaryStage.getHeight()) / 2);

        root.setOnMousePressed(event-> {
                xOffset = event.getSceneX();
                yOffset = event.getSceneY();
        });

        root.setOnMouseDragged(event-> {
                primaryStage.setX(event.getScreenX() - xOffset);
                primaryStage.setY(event.getScreenY() - yOffset);
        });
    }

    private void loadCustomFonts() {
        Font.loadFont(Main.class.getResourceAsStream("fonts/VisbyRoundCF-ExtraBold.ttf"),10);
        Font.loadFont(Main.class.getResourceAsStream("fonts/VisbyRoundCF-Regular.ttf"),10);

    }
}