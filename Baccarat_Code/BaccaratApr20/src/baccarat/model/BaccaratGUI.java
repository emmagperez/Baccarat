package baccarat.model;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class BaccaratGUI extends Stage {
    int randomValue; // Reusable random int to be assigned to new cards
	int playerScore; // The total value of the player's hand
	int bankerScore; // The total value of the banker's hand
	int wins = 0; // The player's win count
	int losses = 0; // The player's loss count
	int ties = 0;
	int gamesPlayed = 0; // The player's total games this session
	int cardsRevealed = 0; // The number of player cards that have been revealed
	boolean playerThirdCard = false; //If this becomes true, the player draws a third card
	boolean bankerThirdCard = false; //If this becomes true, the banker draws a third card
	boolean playAgain = true; // The game ends when the player sets this to false
	boolean card1Revealed = false; // Has the player's first card flipped face-up?
	boolean card2Revealed = false; // Has the player's second card flipped face-up?
	// The below code sets up several labels. 
	// Labels are text strings that appear at specified coordinates in a window.
	// They are initialized as a default string to be overwritten with the appropriate values later
	Label displayText = new Label("Default String: This message should not be seen.");
	Label playerFinalScore = new Label("Default String: This message should not be seen.");
	Label bankerFinalScore = new Label("Default String: This message should not be seen.");
	Label winOrLose = new Label("Default String: This message should not be seen.");

	// All cards start out with this error image, which should be overwritten with the correct image
String errorImageString = "http://i.imgur.com/MhGLiy8.png"; 
ImageView errorImage = new ImageView(new Image(errorImageString));

// All cards are declared as buttons
Button playerCard1 = new Button(null, errorImage);
Button playerCard2 = new Button(null, errorImage);
Button playerCard3 = new Button(null, errorImage);
Button bankerCard1 = new Button(null, errorImage);
Button bankerCard2 = new Button(null, errorImage);
Button bankerCard3 = new Button(null, errorImage);

// This button appears when a game is over. Clicking it will begin a new round
Button newGame = new Button("New Game");


// The pane is the format that all elements of a window adhere to.
// The basic pane layout we're using allows for the most flexibility,
// But requires all coordinates for buttons, images, and text to be manually specified.
Pane layout = new Pane();



public BaccaratGUI(){

	this.setScene(new Scene(layout, 320, 480)); 
	// Specifies that a new scene 320 pixels wide and 480 tall is to be made
	
	//The format for the lines below are:
	// 1) Add an "child" element to the window - a button, an image, or some text.
	// 2) Position it. Some of these are negative values - these are off-screen for now.
	// The coordinate system places 0,0 in the top left, and 320, 480 in the bottom right
  
    layout.getChildren().add(playerCard1);
    playerCard1.relocate(10,340);
    
    layout.getChildren().add(playerCard2);
    playerCard2.relocate(110,340);
    
    layout.getChildren().add(playerCard3);
    playerCard3.relocate(-1000, -1000);
    
    layout.getChildren().add(bankerCard1);
    bankerCard1.relocate(10,10);
    
    layout.getChildren().add(bankerCard2);
    bankerCard2.relocate(110,10);
    
    layout.getChildren().add(bankerCard3);
    bankerCard3.relocate(-1000, -1000);
    
    layout.getChildren().add(displayText);
    displayText.relocate(-100, -100);
    
    layout.getChildren().add(playerFinalScore);
    playerFinalScore.relocate(-100, -100);
    
    layout.getChildren().add(bankerFinalScore);
    bankerFinalScore.relocate(-100, -100);
    
    layout.getChildren().add(winOrLose);
    winOrLose.relocate(-100, -100);
    
    layout.getChildren().add(newGame);
    newGame.relocate(-1000, -1000);
    
    playAgain = true; //As long as this is true, the game continues
    
			//Begin by generating 2 Hand objects
			// A Hand object is basically an array of 3 BaccaratCard objects each, 
		    // Plus some added features (can find the score of the sum of the cards in a hand, print card or hand, etc)
			//These represent the hands of the Player and Banker
				
			final Hand playerHand = new Hand();
		
			final Hand bankerHand = new Hand();
			
			// The below code handles what happens when the new game button is pressed
			// In short, new cards are randomly generated, flipped over,
			// and may elements (including the new game button itself) are sent off-screen.
			
			newGame.setOnAction(new EventHandler<ActionEvent>() {
		        public void handle(ActionEvent event) {
		        	playerCard1.setGraphic(playerHand.getBackImage(0));
		        	playerCard2.setGraphic(playerHand.getBackImage(1));
		        	bankerCard1.setGraphic(bankerHand.getBackImage(0));
		        	bankerCard2.setGraphic(bankerHand.getBackImage(1));
		        	cardsRevealed = 0;
		        	card1Revealed = false;
		        	card2Revealed = false;
		            displayText.relocate(-100, -100);
		            playerFinalScore.relocate(-100, -100);
		            bankerFinalScore.relocate(-100, -100);
		            winOrLose.relocate(-100, -100);
		            newGame.relocate(-1000, -1000);
		            playerCard3.relocate(-1000, -1000);
		            bankerCard3.relocate(-1000, -1000);
		            playerThirdCard = false;
		            bankerThirdCard = false;

		        	 playerHand.newHand();
		        	 bankerHand.newHand();
		        	 
		        	 playerScore = playerHand.getTwoCardScore();
				     bankerScore = bankerHand.getTwoCardScore();
				     
			        playerCard3.setGraphic(playerHand.getImage(2));
			        bankerCard3.setGraphic(bankerHand.getImage(2));
 
 
		        }  }); //End of new game button

			playerCard1.setGraphic(playerHand.getBackImage(0)); //Set card graphic to face-down
			playerCard1.setOnAction(new EventHandler<ActionEvent>() {
		        public void handle(ActionEvent event) {
		        	 playerCard1.setGraphic(playerHand.getImage(0)); //Reveal the player card
		             bankerCard1.setGraphic(bankerHand.getImage(0)); //Reveal the banker card
		             if (card1Revealed == false) //If card1 hasn't already been flipped over
		             {
		             cardsRevealed++; 
		             card1Revealed = true;
		             }
		             if (cardsRevealed > 1) // If both starting cards have been flipped
 		 			{
 		            	    displayText.relocate(0,160);
 		            	    
 		 			}
		 
		        			 
		        }  });                              
                         playerCard2.setGraphic(playerHand.getBackImage(1));
                         playerCard2.setOnAction(new EventHandler<ActionEvent>() {
             		        public void handle(ActionEvent event) {
             		        	 playerCard2.setGraphic(playerHand.getImage(1));
             		        	 bankerCard2.setGraphic(bankerHand.getImage(1));
            		             if (card2Revealed == false)
            		             {
            		             cardsRevealed++;
            		             card2Revealed = true;
            		             }            		             
            		             if (cardsRevealed > 1) // If both starting cards have been flipped
            		 			{
            		            	    displayText.relocate(10,160);
            		            	    playerFinalScore.relocate(10,200);
            		            	    bankerFinalScore.relocate(10,220);
            		            	    winOrLose.relocate(10,240);

            		            	    if (playerScore >= 8) // Since score is mod 10, this includes only 8 or 9
            		        			{
            		            	    	displayText.setText("Player has a natural " + playerScore);
            		        			}
            		        	
            		        			if (bankerScore >= 8)
            		        			{
            		        				displayText.setText("Banker has a natural " + bankerScore);
            		        			}
            		        			
            		        			// If either player has a score of 8 or 9, no cards are drawn
            		        			// The nested if statements below all begin with "else if" statements
            		        			// So they cannot happen if bankerScore >= 8
            		        			// And since the if statements check for a player score of varying values below 8
            		        			// They implicitly cannot occur if the player has a natural 8 or 9
            		        			
            		        			else if (playerScore == 6 || playerScore == 7)
            		        			{
            		        				// A lot of the printed text serves to explain the rules to the player
            		        				// I'll try not to repeat myself too much in these comments, 
            		        				// So read the print statements if necessary 
            		        				displayText.setText("Player stands due to a score of 6 or 7.");
            		        				
            		        				if (bankerScore <= 5) // 1,2,3, or 4
            		        				{
            		        					displayText.setText("Player stands and Banker's score is 5 or less, \n so Banker draws again:");
            		        					bankerThirdCard = true; 
            		        					// Below, the value of bankerThirdCard is checked
            		        					// If it is set to true by any of these conditions, the banker draws a third card
            		        				}
            		        			}
            		        			 
            		        			else if (playerScore <= 5) //1,2,3, 4, or 5
            		        			{		
            		        				displayText.setText("Player's score is 5 or less, \n and so draws a third card:");
            		        				playerThirdCard = true;
            		        				// Below, the value of playerThirdCard is checked
            		        				// If it is set to true by this condition, the player draws a third card
            		        				
            		        				// The number of permutations below is rather silly,
            		        				// But each individual outcome is self-explanatory if you've understood the code up to now 
            		        				if (bankerScore <= 2)
            		        				{
            		        					displayText.setText("Player drew a third card and Banker's score is 2 or less, \n so Banker draws a third card.");
            		        					bankerThirdCard = true;
            		        				}
            		        				
            		        				// Reminder that playerHand[2] is a reference to the player's freshly-drawn 3rd card
            		        				if (bankerScore == 3 && playerHand.getValue(2) != 8)
            		        				{
            		        					displayText.setText("Player drew a third card that is not 8, and Banker's score is 3,\n so Banker draws a third card.");
            		        					bankerThirdCard = true;
            		        				}
            		        				
            		        				if (bankerScore == 4 && playerHand.getValue(2) >= 2 && playerHand.getValue(2) <= 7)
            		        				{
            		        					displayText.setText("Player drew a third card between 2 and 7, and Banker's score is 4,\n so Banker draws a third card.");
            		        					bankerThirdCard = true;
            		        				}
            		        				
            		        				if (bankerScore == 5 && playerHand.getValue(2) >= 4 && playerHand.getValue(2) <= 7)
            		        				{
            		        					
            		        					displayText.setText("Player drew a third card between 4 and 7, and Banker's score is 5,\n so Banker draws a third card.");
            		        					bankerThirdCard = true;
            		        					
            		        				}
            		        				
            		        				if (bankerScore == 6 && playerHand.getValue(2) >= 6 && playerHand.getValue(2) <= 7)
            		        				{
            		        					displayText.setText("Player drew a third card that is either 6 or 7,\n and Banker's score is 6, so Banker draws a third card.");
            		        					bankerThirdCard = true;
            		        				}
            		        				
            		        				if (bankerScore == 7) // In this case, the banker does not draw a third card.
            		        				{
            		        					displayText.setText("Player drew a third card, but Banker's score is 7,\n so Banker stands.");
            		        				}
            		        			}
            		        			
            		        			// The syntax for the two if statements below 
            		        			// Is essentially identical to the "hand-printing" loops above,
            		        			// Just for printing info on the third card alone, this time
            		        			
            		        			
            		        	
            		        			if (playerThirdCard == true)
            		        			{            		        				
            		        				// We update the score, taking into account the third card
            		        				playerScore = playerHand.getThreeCardScore();
            		        			    playerCard3.relocate(210,340);

            		        			}
            		        	
            		        			if (bankerThirdCard == true)
            		        			{
            		        				//First print the value of the third card
            		        	
            		        				// We update the score, taking into account the third card
            		        				bankerScore = bankerHand.getThreeCardScore();
            		        				 bankerCard3.relocate(210,10);
            		        			}
            		        			
            		        			// Final results are printed
            		        			playerFinalScore.setText("Player's Final Score: " + playerScore);
            		        			bankerFinalScore.setText("Banker's Final Score: " + bankerScore);
            		        			
            		        			// A victory or defeat message is displayed
            		        			// And the appropriate counters are incremented 
            		        			if (playerScore > bankerScore)
            		        			{
            		        				winOrLose.setText("Congrats, Player wins!");
            		        				wins++;
            		        				gamesPlayed++;
            		        			}
            		        			
            		        			if (playerScore < bankerScore)
            		        			{
            		        				winOrLose.setText("Banker wins ...");
            		        				losses++;
            		        				gamesPlayed++;
            		        			}
            		        			
            		        			if (playerScore == bankerScore)
            		        			{
            		        				winOrLose.setText("Tie game");
            		        				ties++;
            		        				gamesPlayed++;
            		        			}
            		        			newGame.relocate(120, 280);
            		 			}
             		        }  });    
                                 
                         playerCard3.setGraphic(playerHand.getImage(2));
      
                        bankerCard1.setGraphic(bankerHand.getBackImage(0));
            
                       bankerCard2.setGraphic(bankerHand.getBackImage(1));
                                          
                      bankerCard3.setGraphic(bankerHand.getImage(2));
                     
                        this.show(); // Display the window

                        
                       			
			playerScore = playerHand.getTwoCardScore();
			bankerScore = bankerHand.getTwoCardScore();
	
			//System.out.println("Wins: " + wins + ", Losses: " + losses);
			//System.out.println("Play again? Y/N"); // Dirty secret: it only checks if the player presses n specifically
		
	}
   }    