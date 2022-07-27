package com.anandhuarjunan.englishmalayalam.dictionary.app.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import org.apache.commons.lang3.tuple.Pair;

import com.anandhuarjunan.englishmalayalam.dictionary.app.Main;
import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class SearcherController implements Initializable {

	@FXML
	private TextField searchTerm;

	@FXML
	private ImageView clear;

	@FXML
	private TextArea explanation;

	@FXML
	private ListView<String> listResults;

	@FXML
	private Pane headerOfExplanation;

	private List<String[]> allData = null;
	private Set<String> setOfWords = null;

	@Override
	public void initialize(URL url, ResourceBundle resourceBundle) {
		try {
			addEventHandlers();
			getDictionaryData();
			fillListWithUniqueWords();
			findPartOfSpeech();

		} catch (IOException e) {
			e.printStackTrace();
		} catch (CsvException e) {
			e.printStackTrace();
		}

	}

	private void findPartOfSpeech() {
		listResults.getSelectionModel().selectedItemProperty().addListener((ob, old, newV) -> {
			if (Objects.nonNull(newV)) {
				explanation.clear();

				List<String[]> found = filterWithFullData(newV);

				List<String> nouns = new ArrayList<>();
				List<String> adjective = new ArrayList<>();
				List<String> idiom = new ArrayList<>();
				List<String> verb = new ArrayList<>();
				List<String> phrases = new ArrayList<>();
				List<String> adverb = new ArrayList<>();
				List<String> other = new ArrayList<>();

				groupResultBasedOnPartOfSpeech(found, Pair.of("idm", idiom), Pair.of("n", nouns),
						Pair.of("a", adjective), Pair.of("v", verb), Pair.of("phr", phrases), Pair.of("adv", adverb),
						Pair.of("-", other));

				showResultToTextArea(Pair.of("Nouns", nouns), Pair.of("Adjectives", adjective),
						Pair.of("Adverb", adverb), Pair.of("Phrases", phrases), Pair.of("Verb", verb),
						Pair.of("Idiom", idiom), Pair.of("-----", other));

			}

		});

	}

	@SafeVarargs
	private void groupResultBasedOnPartOfSpeech(List<String[]> data, Pair<String, List<String>>... pofDataPairs) {

		data.forEach(str -> {

			for (Pair<String, List<String>> pofDataPair : pofDataPairs) {
				if (str[2].equalsIgnoreCase(pofDataPair.getLeft())) {
					pofDataPair.getRight().add(str[3]);
				}
			}

		});
	}

	@SafeVarargs
	private void showResultToTextArea(Pair<String, List<String>>... pairs) {

		for (Pair<String, List<String>> pair : pairs) {
			if (!pair.getRight().isEmpty()) {
				explanation.setText(explanation.getText() + "\n" + pair.getLeft());
				pair.getRight().forEach(n -> explanation.setText(explanation.getText() + "\n" + "- " + n));
			}

		}
	}

	private List<String[]> filterWithFullData(String newV) {
		List<String[]> found = new ArrayList<>();
		allData.forEach(str -> {
			if (str[1].equalsIgnoreCase(newV)) {
				found.add(str);
			}
		});
		return found;
	}

	private void fillListWithUniqueWords() {
		setOfWords = new TreeSet<>();
		allData.forEach(str -> setOfWords.add(str[1]));
		listResults.getItems().addAll(setOfWords);

	}

	private void addEventHandlers() {
		searchTerm.textProperty().addListener((obs, oldText, newText) -> onSearch(newText)); // Search Action
		clear.setOnMouseClicked(ev -> searchTerm.clear());

	}

	private void getDictionaryData() throws IOException, CsvException {
		try (BufferedReader bufferedReader = new BufferedReader(
				new InputStreamReader(Main.class.getResourceAsStream("data/olam-enml.csv"), StandardCharsets.UTF_8));) {
			CSVParser parser = new CSVParserBuilder().withSeparator('\t').build();
			CSVReader csvReader = new CSVReaderBuilder(bufferedReader).withCSVParser(parser).withSkipLines(1).build();
			allData = csvReader.readAll();
		}

	}

	private void onSearch(String newText) {
		if (null != newText && !newText.isEmpty()) {
			Set<String> filterdSortedSet = setOfWords.stream()
					.filter(predicate -> predicate.toLowerCase().startsWith(newText.toLowerCase()))
					.collect(Collectors.toSet());
			addToListview(filterdSortedSet);
		} else {
			addToListview(setOfWords);
		}
	}

	public void addToListview(Collection<String> collection) {
		if (null != listResults) {
			listResults.getItems().clear();
			listResults.getItems().addAll(collection);
		}
	}
}