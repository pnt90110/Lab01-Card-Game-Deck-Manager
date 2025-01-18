package logic;

import java.util.ArrayList;

public class UnitDeck {
	ArrayList<CardCounter> cardsInDeck;
	String deckName;
	
	UnitDeck(String deckName) {
		setCardsInDeck(null);
		setDeckName(deckName);
	}
	
	void addCard(UnitCard newCard, int count) {
		
	}

	public ArrayList<CardCounter> getCardsInDeck() {
		return cardsInDeck;
	}

	public void setCardsInDeck(ArrayList<CardCounter> cardsInDeck) {
		this.cardsInDeck = cardsInDeck;
	}

	public String getDeckName() {
		return deckName;
	}

	public void setDeckName(String deckName) {
		if (deckName == "") deckName = "Untitled Deck";
		this.deckName = deckName;
	}
	
}
