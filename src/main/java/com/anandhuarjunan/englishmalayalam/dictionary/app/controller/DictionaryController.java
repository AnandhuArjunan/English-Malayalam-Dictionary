package com.anandhuarjunan.englishmalayalam.dictionary.app.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.anandhuarjunan.englishmalayalam.dictionary.app.Main;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class DictionaryController implements Initializable {

	@FXML
	private Button closeBtn;

	@FXML
	private AnchorPane container;

	@Override
	public void initialize(URL url, ResourceBundle resourceBundle) {

		try {
			AnchorPane searchUi = FXMLLoader.load(Main.class.getResource("fxml/SearcherGui.fxml"));
			setNode(searchUi);
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		closeBtn.setOnMouseClicked(e -> {
			System.exit(0);
		});
	}

	private void setNode(Node node) {
		container.getChildren().clear();
		container.getChildren().add(node);
		AnchorPane.setBottomAnchor(node, 0.0);
		AnchorPane.setLeftAnchor(node, 0.0);
		AnchorPane.setRightAnchor(node, 0.0);
		AnchorPane.setTopAnchor(node, 0.0);
	}

}
