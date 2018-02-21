import java.util.concurrent.ThreadLocalRandom;
import javafx.scene.image.ImageView;



public class Hand {

	private int randomValue; // Reusable random int to be assigned to new cards

	//Begin by generating 2 arrays of 3 BaccaratCard objects each
	//These represent the hands of the Player and Banker
	private BaccaratCard[] cards = new BaccaratCard[3];
	private int twoCardScore; // The total value of the hand's first 2 cards
	private int threeCardScore; // The total value of the hand if the third card is drawn


	public Hand()
	{

	for (int i = 0; i < 3; i++) // Card-construction loop
	{

		//randomValue = rand.nextInt(13) + 1; // +1 so we get values of at least 1
		randomValue = ThreadLocalRandom.current().nextInt(1, 14);

		cards[i] = new BaccaratCard(randomValue);

		// Each number, 1-13, represents a face value of ace through king
		// Refer to notes in the BaccaratCard.java class for additional information
		
		// Note that we initialize 3 card values here
		// Baccarat hands begin with 2 cards, but a third may be drawn later
		// So the third card is constructed here as well, for simplicity
		
	} // End of card-construction for loop
	
	// Score is calculated by summing up the face value of both cards in the hand
	twoCardScore = (cards[0].getValue() + cards[1].getValue())%10;
	threeCardScore = (cards[0].getValue() + cards[1].getValue() + cards[2].getValue())%10;

	}
	
	public void newHand()
	{
		for (int i = 0; i < 3; i++) // Card-construction loop
		{

			//randomValue = rand.nextInt(13) + 1; // +1 so we get values of at least 1
			randomValue = ThreadLocalRandom.current().nextInt(1, 14);

			cards[i] = new BaccaratCard(randomValue);

			// Each number, 1-13, represents a face value of ace through king
			// Refer to notes in the BaccaratCard.java class for additional information
			
			// Note that we initialize 3 card values here
			// Baccarat hands begin with 2 cards, but a third may be drawn later
			// So the third card is constructed here as well, for simplicity
			
		} // End of card-construction for loop
		
		// Score is calculated by summing up the face value of both cards in the hand
		twoCardScore = (cards[0].getValue() + cards[1].getValue())%10;
		threeCardScore = (cards[0].getValue() + cards[1].getValue() + cards[2].getValue())%10;

	}
        
        public ImageView getImage(int cardNum)
{
    return cards[cardNum].cardImage;
}

        public ImageView getBackImage(int cardNum)
        {
            return cards[cardNum].cardBackImage;
        }
	
	public int getID(int cardNum) // As of now, this is only used for testing purposes. The player has no need to see ID.
	{
		return cards[cardNum].cardID;
	}
        
        

	public int getValue(int cardNum) // Returns the worth of the card in Baccarat.
	{
		return cards[cardNum].value;
	}

	public String getFaceText(int cardNum) // This will likely become obsolete once graphics are implemented
	{
		return cards[cardNum].faceText;
	}

	public  int getTwoCardScore()
	{
		return twoCardScore;
	}
	
	public  int getThreeCardScore()
	{
		return threeCardScore;
	}
	
	public void printCard(int cardNum)
	{
		System.out.print("Card " + (cardNum+1)); // i+1 gets us the more readable 1-3 instead of 0-2
		System.out.print(" (Card ID: " + cards[cardNum].getID());
		System.out.print(", Card Name: " + cards[cardNum].getFaceText());
		System.out.print(", Baccarat Value: " + cards[cardNum].getValue());
		System.out.print(")\n");

	}
	

	public  void printTwoCardHand()
	{

		for (int i = 0; i < 2; i++) //Player 2-card hand-printing loop
		{
			printCard(i);
		} // End of 2-card hand-printing loop
			
	}
public void printThreeCardHand()
{

	for (int i = 0; i < 3; i++) //Player 3-card hand-printing loop
	{
		printCard(i);
	} // End of 3-card hand-printing loop
		
}

}

	