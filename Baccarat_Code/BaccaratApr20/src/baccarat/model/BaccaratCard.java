package baccarat.model;


import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

// Specifying Baccarat so that this class doesn't get bogged down by details for other card games

public class BaccaratCard
{
	int cardID; // A unique ID, mostly internal, to refer to the card by
	int value; // The worth of this card in a game of Baccarat

	String faceText; // What this card is called. Ace, 1,2,3, Jack, King, etc.
	Image cardFront; //Where to load this card's image file from. Not implemented yet
	Image cardBack = new Image("http://i.imgur.com/OnHqgQg.jpg");
	ImageView cardFrontImage = new ImageView();
	ImageView cardBackImage = new ImageView();

	public BaccaratCard (int givenValue) //Initialize a card given a (probably random) value from main
	{
		cardID = givenValue; //The value we got becomes this card's ID, which in turn informs the other variables.

		//SPADES

		if (cardID == 1)
		{
			value = 1;
			faceText = "Ace"; // Aces are worth 1 point in Baccarat
			cardFront = new Image("http://i.imgur.com/vbqfCn3.png");
		}

		if (cardID == 2)
		{
			value = 2;
			faceText = "2";
			cardFront = new Image("http://i.imgur.com/Guvxoxk.png");

		}

		if (cardID == 3)
		{
			value = 3;
			faceText = "3";
			cardFront = new Image("http://i.imgur.com/sd4plYd.png");
		}

		if (cardID == 4)
		{
			value = 4;
			faceText = "4";
			cardFront = new Image("http://i.imgur.com/U8LxQ3J.png");
		}

		if (cardID == 5)
		{
			value = 5;
			faceText = "5";
			cardFront = new Image("http://i.imgur.com/Y3hRPLP.png");
		}

		if (cardID == 6)
		{
			value = 6;
			faceText = "6";
			cardFront = new Image("http://i.imgur.com/EZNXNAI.png");
		}

		if (cardID == 7)
		{
			value = 7;
			faceText = "7";
			cardFront = new Image("http://i.imgur.com/xZv62uL.png");
		}

		if (cardID == 8)
		{
			value = 8;
			faceText = "8";
			cardFront = new Image("http://i.imgur.com/JZURqdG.png");
		}

		if (cardID == 9)
		{
			value = 9;
			faceText = "9";
			cardFront = new Image("http://i.imgur.com/DqWQeL2.png");
		}

		if (cardID == 10)
		{
			value = 0; // Everything below is worth 0 points in Baccarat
			faceText = "10";
			cardFront = new Image("http://i.imgur.com/9zacNcm.png");
		}

		if (cardID == 11)
		{
			value = 0;
			faceText = "Jack"; // ID of 11 corresponds to a Jack
			cardFront = new Image("http://i.imgur.com/XbNhOU2.png");
		}

		if (cardID == 12)
		{
			value = 0;
			faceText = "Queen";// ID of 12 corresponds to a Queen
			cardFront = new Image("http://i.imgur.com/KyNQcEm.png");
		}

		if (cardID == 13)
		{
			value = 0;
			faceText = "King";// ID of 13 corresponds to a King
			cardFront = new Image("http://i.imgur.com/VhIXJfU.png");
		}

		//CLUBS

		if (cardID == 14)
		{
			value = 1;
			faceText = "Ace"; // Aces are worth 1 point in Baccarat
			cardFront = new Image("http://i.imgur.com/FSLgmLO.png");
		}

		if (cardID == 15)
		{
			value = 2;
			faceText = "2";
			cardFront = new Image("http://i.imgur.com/wyyD9GG.png");

		}

		if (cardID == 16)
		{
			value = 3;
			faceText = "3";
			cardFront = new Image("http://i.imgur.com/JBL1OYr.png");
		}

		if (cardID == 17)
		{
			value = 4;
			faceText = "4";
			cardFront = new Image("http://i.imgur.com/VKOIuV1.png");
		}

		if (cardID == 18)
		{
			value = 5;
			faceText = "5";
			cardFront = new Image("http://i.imgur.com/eJtLEr6.png");
		}

		if (cardID == 19)
		{
			value = 6;
			faceText = "6";
			cardFront = new Image("http://i.imgur.com/U2JBZ7R.png");
		}

		if (cardID == 20)
		{
			value = 7;
			faceText = "7";
			cardFront = new Image("http://i.imgur.com/fX5b7uR.png");
		}

		if (cardID == 21)
		{
			value = 8;
			faceText = "8";
			cardFront = new Image("http://i.imgur.com/NE2ct20.png");
		}

		if (cardID == 22)
		{
			value = 9;
			faceText = "9";
			cardFront = new Image("http://i.imgur.com/kaYHgPi.png");
		}

		if (cardID == 23)
		{
			value = 0;
			faceText = "10";
			cardFront = new Image("http://i.imgur.com/rN2cw43.png");
		}

		if (cardID == 24)
		{
			value = 0;
			faceText = "Jack";
			cardFront = new Image("http://i.imgur.com/Bi15wdr.png");
		}

		if (cardID == 25)
		{
			value = 0;
			faceText = "Queen";
			cardFront = new Image("http://i.imgur.com/ivWkn1d.png");
		}

		if (cardID == 26)
		{
			value = 0;
			faceText = "King";
			cardFront = new Image("http://i.imgur.com/I5IV9xx.png");
		}

		//DIAMONDS

		if (cardID == 27)
		{
			value = 1;
			faceText = "Ace"; // Aces are worth 1 point in Baccarat
			cardFront = new Image("http://i.imgur.com/CKwwKCm.png");
		}

		if (cardID == 28)
		{
			value = 2;
			faceText = "2";
			cardFront = new Image("http://i.imgur.com/uzSpKNd.png");

		}

		if (cardID == 29)
		{
			value = 3;
			faceText = "3";
			cardFront = new Image("http://i.imgur.com/YhCURsV.png");
		}

		if (cardID == 30)
		{
			value = 4;
			faceText = "4";
			cardFront = new Image("http://i.imgur.com/eUzOPsU.png");
		}

		if (cardID == 31)
		{
			value = 5;
			faceText = "5";
			cardFront = new Image("http://i.imgur.com/gEkMyrP.png");
		}

		if (cardID == 32)
		{
			value = 6;
			faceText = "6";
			cardFront = new Image("http://i.imgur.com/ifVURCq.png");
		}

		if (cardID == 33)
		{
			value = 7;
			faceText = "7";
			cardFront = new Image("http://i.imgur.com/Mi6wvkR.png");
		}

		if (cardID == 34)
		{
			value = 8;
			faceText = "8";
			cardFront = new Image("http://i.imgur.com/8oMnd65.png");
		}

		if (cardID == 35)
		{
			value = 9;
			faceText = "9";
			cardFront = new Image("http://i.imgur.com/PSfZIi0.png");
		}

		if (cardID == 36)
		{
			value = 0;
			faceText = "10";
			cardFront = new Image("http://i.imgur.com/4X2CKdd.png");
		}

		if (cardID == 37)
		{
			value = 0;
			faceText = "Jack";
			cardFront = new Image("http://i.imgur.com/6ouXpXK.png");
		}

		if (cardID == 38)
		{
			value = 0;
			faceText = "Queen";
			cardFront = new Image("http://i.imgur.com/eKn2Ex9.png");
		}

		if (cardID == 39)
		{
			value = 0;
			faceText = "King";
			cardFront = new Image("http://i.imgur.com/nmoyr0u.png");
		}
		//HEARTS

		if (cardID == 40)
		{
			value = 1;
			faceText = "Ace"; // Aces are worth 1 point in Baccarat
			cardFront = new Image("http://i.imgur.com/PdbnP9p.png");
		}

		if (cardID == 41)
		{
			value = 2;
			faceText = "2";
			cardFront = new Image("http://i.imgur.com/RviIx5u.png");

		}

		if (cardID == 42)
		{
			value = 3;
			faceText = "3";
			cardFront = new Image("http://i.imgur.com/4tFLRot.png");
		}

		if (cardID == 43)
		{
			value = 4;
			faceText = "4";
			cardFront = new Image("http://i.imgur.com/Pbg6eZS.png");
		}

		if (cardID == 44)
		{
			value = 5;
			faceText = "5";
			cardFront = new Image("http://i.imgur.com/PgMrkmY.png");
		}

		if (cardID == 45)
		{
			value = 6;
			faceText = "6";
			cardFront = new Image("http://i.imgur.com/FDnGPYj.png");
		}

		if (cardID == 46)
		{
			value = 7;
			faceText = "7";
			cardFront = new Image("http://i.imgur.com/2EXykXe.png");
		}

		if (cardID == 47)
		{
			value = 8;
			faceText = "8";
			cardFront = new Image("http://i.imgur.com/WjMv7v7.png");
		}

		if (cardID == 48)
		{
			value = 9;
			faceText = "9";
			cardFront = new Image("http://i.imgur.com/fAoSVEB.png");
		}

		if (cardID == 49)
		{
			value = 0;
			faceText = "10";
			cardFront = new Image("http://i.imgur.com/ENDMsBe.png");
		}

		if (cardID == 50)
		{
			value = 0;
			faceText = "Jack";
			cardFront = new Image("http://i.imgur.com/vBtV3pr.png");
		}

		if (cardID == 51)
		{
			value = 0;
			faceText = "Queen";
			cardFront = new Image("http://i.imgur.com/jYZJMl0.png");
		}

		if (cardID == 52)
		{
			value = 0;
			faceText = "King";
			cardFront = new Image("http://i.imgur.com/7EJ0YkU.png");
		}

		cardFrontImage.setImage(cardFront);
		cardFrontImage.setFitHeight(150);
		cardFrontImage.setPreserveRatio(true);

		cardBackImage.setImage(cardBack);
		cardBackImage.setFitHeight(150);
		cardBackImage.setPreserveRatio(true);


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