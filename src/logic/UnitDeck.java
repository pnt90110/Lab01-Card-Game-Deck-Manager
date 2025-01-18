package logic;

import java.util.ArrayList;

public class UnitDeck {
	ArrayList<CardCounter> cardsInDeck;
	String deckName;
	
	public UnitDeck(String deckName) {
		setCardsInDeck(null);
		setDeckName(deckName);
	}
	
	public void addCard(UnitCard newCard, int count) {
		if(count<=0)return;
		boolean found=false;
		for(CardCounter e:cardsInDeck) {
			if(newCard.equals(e.getCard()))
			{
				e.setCount(e.getCount()+count);
				found=true;
				break;
			}
			if(found==false) {
				CardCounter c=new CardCounter (newCard,count);
				this.cardsInDeck.add(c);
			}
		}
	}
	
	public void removeCard(UnitCard toRemove,int count) {
		if(count<=0)return;
		for(CardCounter e:cardsInDeck) {
			if(toRemove.equals(e.getCard()))
			{
				e.setCount(e.getCount()-count);
				if(e.getCount()==0) {
					cardsInDeck.remove(e);
				}
				break;
			}
		}
	}
	
	public int cardCount() {
		int sum=0;
		for(CardCounter e:this.getCardsInDeck()) {
			sum+=e.getCount();
		}
		return sum;
	}

	public boolean existsInDeck(UnitCard card) {
		for(CardCounter e:this.getCardsInDeck()) {
			if(e.getCard()==card&e.getCount()>0)
				return true;
		}
		return false;
	}
	
	public boolean equals(UnitDeck other) {
		return this.getDeckName()==other.getDeckName();
	}
	
	public ArrayList<CardCounter> getCardsInDeck() {
		return cardsInDeck;
	}

	public void setCardsInDeck(ArrayList<CardCounter> cardsInDeck) {
		this.cardsInDeck = cardsInDeck;
		if(cardsInDeck.size()==0)
			this.cardsInDeck=new ArrayList<>();
	}

	public String getDeckName() {
		return deckName;
	}

	public void setDeckName(String deckName) {
		if (deckName.isBlank()) deckName = "Untitled Deck";
		this.deckName = deckName;
	}
	
}
