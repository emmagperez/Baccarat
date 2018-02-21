
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

// Specifying Baccarat so that this class doesn't get bogged down by details for other card games

public class BaccaratCard 
{
	int cardID; // A unique ID, mostly internal, to refer to the card by
	int value; // The worth of this card in a game of Baccarat
	
	String faceText; // What this card is called. Ace, 1,2,3, Jack, King, etc.
	String cardImageString; //Where to load this card's image file from. Not implemented yet
    String cardBackString = "http://i.imgur.com/OnHqgQg.jpg";
        final ImageView cardImage; // = new ImageView(new Image(BUTTON_ICON_LOC));
        final ImageView cardBackImage;
	
public BaccaratCard (int givenValue) //Initialize a card given a (probably random) value from main
{
	cardID = givenValue; //The value we got becomes this card's ID, which in turn informs the other variables.
	
	if (cardID == 1)
	{
		value = 1;
		faceText = "Ace"; // Aces are worth 1 point in Baccarat
		cardImageString = "http://i.imgur.com/vbqfCn3.png"; 
	}
	
	if (cardID == 2)
	{
		value = 2;
		faceText = "2";
		cardImageString = "http://i.imgur.com/Guvxoxk.png";
                
	}
	
	if (cardID == 3)
	{
		value = 3;
		faceText = "3";
		cardImageString = "http://i.imgur.com/sd4plYd.png";
	}
	
	if (cardID == 4)
	{
		value = 4;
		faceText = "4";
		cardImageString = "http://i.imgur.com/U8LxQ3J.png";
	}
	
	if (cardID == 5)
	{
		value = 5;
		faceText = "5";
		cardImageString = "http://i.imgur.com/Y3hRPLP.png";
	}
	
	if (cardID == 6)
	{
		value = 6;
		faceText = "6";
		cardImageString = "http://i.imgur.com/EZNXNAI.png";
	}
	
	if (cardID == 7)
	{
		value = 7;
		faceText = "7";
		cardImageString = "http://i.imgur.com/xZv62uL.png";
	}
	
	if (cardID == 8)
	{
		value = 8;
		faceText = "8";
		cardImageString = "http://i.imgur.com/JZURqdG.png";
	}
	
	if (cardID == 9)
	{
		value = 9;
		faceText = "9";
		cardImageString = "http://i.imgur.com/DqWQeL2.png";
	}
	
	if (cardID == 10)
	{
		value = 0; // Everything below is worth 0 points in Baccarat
		faceText = "10";
		cardImageString = "http://i.imgur.com/9zacNcm.png";
	}
	
	if (cardID == 11)
	{
		value = 0;
		faceText = "Jack"; // ID of 11 corresponds to a Jack
		cardImageString = "http://i.imgur.com/XbNhOU2.png";
	}
	
	if (cardID == 12)
	{
		value = 0;
		faceText = "Queen";// ID of 12 corresponds to a Queen
		cardImageString = "http://i.imgur.com/KyNQcEm.png";
	}
	
	if (cardID == 13)
	{
		value = 0;
		faceText = "King";// ID of 13 corresponds to a King
		cardImageString = "http://i.imgur.com/VhIXJfU.png";
	}
	
        cardImage = new ImageView(new Image(cardImageString));
        cardImage.setFitWidth(80);
        cardImage.setPreserveRatio(true);
        
        cardBackImage = new ImageView(new Image(cardBackString));
        cardBackImage.setFitWidth(80);
        cardBackImage.setFitHeight(116);
        //cardBackImage.setPreserveRatio(true);

	
}


public int getID() // As of now, this is only used for testing purposes. The player has no need to see ID.
{
	return cardID;
}

public int getValue() // Returns the worth of the card in Baccarat.
{
	return value;
}

public String getFaceText() // This will likely become obsolete once graphics are implemented
{
	return faceText;
}
}