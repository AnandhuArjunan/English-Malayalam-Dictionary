package com.anandhuarjunan.englishmalayalam.dictionary.app.controller;



import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class AdditionController implements Initializable {

	// Alerts

	@Override
	public void initialize( URL url , ResourceBundle resourceBundle ) {

	}

	@FXML
	private void handleClickAddBtn() {

	}

	private void resetInput() {
		wordTargetInput.setText("");
		explanationInput.setText("");
	}
	private void showSuccessAlert(){

	}
	@FXML
	private Button addBtn;
	@FXML
	private TextField wordTargetInput;
	@FXML
	private TextArea explanationInput;
	@FXML
	private Label successAlert;
}