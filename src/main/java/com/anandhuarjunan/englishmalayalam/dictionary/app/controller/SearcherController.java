package com.anandhuarjunan.englishmalayalam.dictionary.app.controller;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import com.opencsv.CSVReader;


public class SearcherController implements Initializable {




	// click search button
	@FXML
	private void handleOnKeyTyped() {

	}

	// click a word in word list is found
	@FXML
	private void handleMouseClickAWord( MouseEvent arg0 ) {
		// search binary

	}

	@FXML
	private void handleClickEditBtn() {

	}
	@FXML
	private void handleClickSoundBtn() {

	}

	@FXML
	private void handleClickSaveBtn() {

	}

	@FXML
	private void handleClickDeleteBtn() {

	}

	private void refreshAfterDeleting() {

	}
	private void setListDefault(int index){

	}
	// FXML elements
	@FXML
	private TextField searchTerm;

	@FXML
	private Button  cancelBtn, saveBtn, volumeBtn;

	@FXML
	private Label englishWord, headerList, notAvailableAlert;

	@FXML
	private TextArea explanation;

	@FXML
	private ListView<String> listResults;

	@FXML
	private Pane headerOfExplanation;

		@Override
		public void initialize( URL url , ResourceBundle resourceBundle ) {
			//Build reader instance

			CSVReader reader = null;
			try {
				reader = new CSVReader(new FileReader("data.csv"), ',', '"', 1);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}

			//Read all rows at once
			List<String[]> allRows = reader.readAll();

			//Read CSV line by line and use the string array as you want
			for(String[] row : allRows){
				System.out.println(Arrays.toString(row));
			}
		}
}