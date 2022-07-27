package com.anandhuarjunan.englishmalayalam.dictionary.app.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class DictionaryController implements Initializable {

	private AnchorPane searchUi = null;

	@Override
	public void initialize( URL url , ResourceBundle resourceBundle ) {

		try {
			searchUi = FXMLLoader.load(getClass().getResource("/fxml/SearcherGui.fxml"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		showSearchUI();

		// set on click
		searchWordBtn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle( ActionEvent event ) {
				showSearchUI();
			}
		});
		addWordBtn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle( ActionEvent event ) {
				showComponent("/fxml/AdditionGui.fxml");
			}
		});
		translateBtn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle( ActionEvent event ) {
				showComponent("/fxml/TranslationGui.fxml");
			}
		});
		// initial state
		tooltip1.setShowDelay(Duration.seconds(0.5));
		tooltip2.setShowDelay(Duration.seconds(0.5));
		tooltip3.setShowDelay(Duration.seconds(0.5));
		// close app
		closeBtn.setOnMouseClicked(e -> {
			System.exit(0);
		});
	}

	private void setNode( Node node ) {
		container.getChildren().clear();
		container.getChildren().add(node);
		AnchorPane.setBottomAnchor(node, 0.0);
		AnchorPane.setLeftAnchor(node, 0.0);
		AnchorPane.setRightAnchor(node, 0.0);
		AnchorPane.setTopAnchor(node, 0.0);
	}
	@FXML
	private void showComponent( String path ) {
		try {
			AnchorPane Component = FXMLLoader.load(getClass().getResource(path));
			setNode(Component);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void showSearchUI() {

			setNode(searchUi);
	}

	@FXML
	private Tooltip tooltip1, tooltip2, tooltip3;

	@FXML
	private Button addWordBtn, translateBtn, searchWordBtn, closeBtn;

	@FXML
	private AnchorPane container;

}
