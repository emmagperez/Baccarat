package baccarat.controller;

import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Spinner;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

//Class imports
import baccarat.model.Hand;
import baccarat.model.Player;
import javafx.stage.StageStyle;

public class GameScreenController implements Initializable {

	@FXML private ImageView imageview;
	@FXML private javafx.scene.control.Button closeButton;
	@FXML private Button playerCard1;
	@FXML private Button playerCard2;
	@FXML private Button playerCard3;
	@FXML private Button bankerCard1;
	@FXML private Button bankerCard2;
	@FXML private Button bankerCard3;
	@FXML private Button newGameButton;
	@FXML private Label winMessage;
	@FXML private Label lossMessage;
	@FXML private Label tieMessage;
	@FXML private RadioButton playerBet;
	@FXML private RadioButton bankerBet;
	@FXML private RadioButton tieBet;
	@FXML private Label balance;
	@FXML private Label betLabel;
	@FXML private Spinner<Integer> bet;
	@FXML private Label pScore;
	@FXML private Label bScore;
	@FXML private AnchorPane betLayout;
	@FXML private ToggleGroup toggleGroup;
	@FXML private Label numWins;
	@FXML private Label numLoses;
	@FXML private Label numGames;

	DoubleProperty startingBalance = new SimpleDoubleProperty(5000);
	IntegerProperty playerScoreTrack = new SimpleIntegerProperty(0);
	IntegerProperty bankerScoreTrack = new SimpleIntegerProperty(0);
	double winnings;
	
	int wins;
	int loses;
	int games;
	
	Player player = new Player();
	final Hand playerHand = new Hand();
	final Hand bankerHand = new Hand();
	int playerScore; // The total value of the player's hand
	int bankerScore; // The total value of the banker's hand
	boolean playerThirdCard; // If this becomes true, the player draws a third
								// card
	boolean bankerThirdCard; // If this becomes true, the banker draws a third
								// card
	boolean playerWins = false;
	boolean bankerWins = false;
	boolean tieGame = false;

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		balance.textProperty().bind(Bindings.format("$%.2f", startingBalance));
		pScore.textProperty().bind(Bindings.format("%d", playerScoreTrack));
		bScore.textProperty().bind(Bindings.format("%d", bankerScoreTrack));
	}

	public double calculateWinnings() {
		

		if (playerWins) {
			winnings = bet.getValue() * 2;
		} else if (bankerWins) {
			winnings = (bet.getValue() * 2) - (bet.getValue() * 2 * 0.05);
		} else if (tieGame) {
			winnings = bet.getValue() * 8;
		} else {
			winnings = 0;
		}

		return winnings;
	}

	@FXML
	private void closeButtonAction() throws IOException {
		Stage stage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("Score.fxml"));

		Scene scene = new Scene(root);
		stage.initStyle(StageStyle.UNDECORATED);
		stage.setScene(scene);
		stage.show();

		Stage stage2 = (Stage) closeButton.getScene().getWindow();
		stage2.close();
	}

	@FXML
	private void playerCard1Action() throws IOException {
		playerCard1.setGraphic(playerHand.getImage(0)); // Reveal the player card

		bankerCard1.setDisable(false);
		bankerCard1.setGraphic(bankerHand.getImage(0)); // Reveal the banker card

		
		playerCard2.setVisible(true);
		bankerCard2.setVisible(true);
	
		playerCard2.setGraphic(playerHand.getImage(1)); // Reveal the player card
		

		bankerCard2.setGraphic(bankerHand.getImage(1)); // Reveal the banker card
		
		
		playerScore = playerHand.getTwoCardScore();
		bankerScore = bankerHand.getTwoCardScore();
		playerScoreTrack.setValue(playerScore);
		bankerScoreTrack.setValue(bankerScore);
		
		if(playerScore > 7 || bankerScore > 7) {
			determineWinner();
		}
		else {
			dealThirdCard();
		}
	}
	public void dealThirdCard() throws IOException {
		// Determine Player's third card draw
		if ((playerScore < 6)) {
			playerHand.dealPlayerCard();
			playerCard3.setVisible(true);
			playerCard3.setGraphic(playerHand.getImage(2)); // Reveal the player card
			playerThirdCard = true;
			playerScore = playerHand.getThreeCardScore();
			playerScoreTrack.setValue(playerScore);
		} else
			playerThirdCard = false;

		// Determine Banker's third card draw
		if (playerThirdCard == false) {
			if (bankerScore < 6)
				bankerThirdCard = true;
		} else {
			if (bankerScore < 3)
				bankerThirdCard = true;
			else {
				switch (bankerScore) {
				case 3:
					if (playerHand.getThirdCard() != 8)
						bankerThirdCard = true;
					break;
				case 4:
					if (playerHand.getThirdCard() > 1 && playerHand.getThirdCard() < 8)
						bankerThirdCard = true;
					break;
				case 5:
					if (playerHand.getThirdCard() > 3 && playerHand.getThirdCard() < 8)
						bankerThirdCard = true;
					break;
				case 6:
					if (playerHand.getThirdCard() > 5 && playerHand.getThirdCard() < 8)
						bankerThirdCard = true;
					break;
				default:
					bankerThirdCard = false;
				}
			}
		}
		

		// Deal banker's third card
		if (bankerThirdCard == true)
			bankerHand.dealBankerCard();
			bankerCard3.setVisible(true);
			bankerScore = bankerHand.getThreeCardScore();
			bankerCard3.setGraphic(bankerHand.getImage(2)); // Reveal the player card
			bankerScoreTrack.setValue(bankerScore);
		determineWinner();
	}

	public void determineWinner() throws IOException {
		int signum = Long.signum((long) playerScore - bankerScore);
		// A victory or defeat message is displayed
		// And the appropriate counters are incremented
		File totalWins = new File("src/baccarat/controller/totalWins.txt");
		FileWriter writer = new FileWriter(totalWins);
		switch (signum) {
		case 1:
			System.out.println("Player: " + playerScore + " " + bankerScore);
			wins = player.setTotalWins(player.getTotalWins() + 1);
			games = player.setTotalGames(player.getTotalGames() + 1);
			winMessage.setVisible(true);
			newGameButton.setVisible(true);
			playerWins = true;
			balance.textProperty().bind(Bindings.format("$%.2f", startingBalance.add(calculateWinnings())));
			numWins.textProperty().bind(new SimpleIntegerProperty(wins).asString());
			numGames.textProperty().bind(new SimpleIntegerProperty(games).asString());

			break;
		case -1:
			System.out.println("Banker: " + playerScore + " " + bankerScore);
			loses = player.setTotalLosses(player.getTotalLosses() + 1);
			games = player.setTotalGames(player.getTotalGames() + 1);
			lossMessage.setVisible(true);
			newGameButton.setVisible(true);
			bankerWins = true;
			balance.textProperty().bind(Bindings.format("$%.2f", startingBalance.add(calculateWinnings())));
			numLoses.textProperty().bind(new SimpleIntegerProperty(loses).asString());
			numGames.textProperty().bind(new SimpleIntegerProperty(games).asString());
			break;
		case 0:
			System.out.println("Tie:" + playerScore + " " + bankerScore);
			player.setTotalTies(player.getTotalTies() + 1);
			games = player.setTotalGames(player.getTotalGames() + 1);
			tieMessage.setVisible(true);
			newGameButton.setVisible(true);
			tieGame = true;
			balance.textProperty().bind(Bindings.format("$%.2f", startingBalance.add(calculateWinnings())));
			numGames.textProperty().bind(new SimpleIntegerProperty(games).asString());
			break;
		default:
		}
		writer.write(wins+System.getProperty("line.separator"));
		writer.close();
	}

	public double getBet() {
		double betAmount = 0;
		betAmount = bet.getValue();
		toggleGroup.selectToggle(null);
		bet.getValueFactory().setValue(0);

		return betAmount;
	}

	@FXML
	private void newGameButtonAction() throws IOException {
		playerCard1.setGraphic(playerHand.getBackImage(0));
		playerCard2.setGraphic(playerHand.getBackImage(1));
		playerCard2.setVisible(false);
		playerCard3.setGraphic(playerHand.getBackImage(2));
		playerCard3.setVisible(false);
		bankerCard1.setGraphic(bankerHand.getBackImage(0));
		bankerCard1.setDisable(true);
		bankerCard2.setGraphic(bankerHand.getBackImage(1));
		bankerCard2.setVisible(false);
		bankerCard3.setGraphic(bankerHand.getBackImage(2));
		bankerCard3.setVisible(false);
		newGameButton.setVisible(false);
		playerThirdCard = false;
		bankerThirdCard = false;
		playerScore = 0;
		bankerScore = 0;
		playerHand.newHand();
		bankerHand.newHand();
		winMessage.setVisible(false);
		lossMessage.setVisible(false);
		tieMessage.setVisible(false);
		toggleGroup.selectToggle(null);
		playerWins = false;
		bankerWins = false;
		tieGame = false;
	}
}
