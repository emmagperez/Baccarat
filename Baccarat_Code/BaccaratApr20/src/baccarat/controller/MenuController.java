package baccarat.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import java.io.IOException;
import baccarat.model.BaccaratGUI;

/**
 * Created by emmaperez on 4/11/17.
 */
public class MenuController {

	@FXML
	private ImageView imageview;
	@FXML
	private javafx.scene.control.Button closeButton;
	@FXML
	private Button startGame;
	@FXML
	private Button rules;
	@FXML
	private Button stats;
	@FXML
	private CheckBox textGame;

	@FXML
	private void closeButtonAction() throws IOException {
		Stage stage = (Stage) closeButton.getScene().getWindow();
		stage.close();
	}

	@FXML
	private void goGameScreen() throws IOException {
		if (textGame.isSelected()) {
			new BaccaratGUI();
		} else {
			Stage stage = new Stage();
			Parent root = FXMLLoader.load(getClass().getResource("gameScreen.fxml"));

			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.initStyle(StageStyle.UNDECORATED);
			stage.show();
		}
	}

	@FXML
	private void goRules() throws IOException {
		Stage stage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("rules.fxml"));

		Scene scene = new Scene(root);
		stage.initStyle(StageStyle.UNDECORATED);
		stage.setScene(scene);
		stage.show();
	}

	@FXML
	private void goStats() throws IOException {
		Stage stage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("stats.fxml"));

		Scene scene = new Scene(root);
		stage.initStyle(StageStyle.UNDECORATED);
		stage.setScene(scene);
		stage.show();
	}
}
