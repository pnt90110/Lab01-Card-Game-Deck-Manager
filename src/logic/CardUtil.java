package logic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
public class CardUtil {
	
	public static boolean isExistsInList(UnitCard card, ArrayList<UnitCard> list) {
		
		//TODO: Fill Code
		for(UnitCard e:list) {
			if(e.equals(card))
				return true;
		}
		return false;

	}
	
	public static boolean isExistsInList(UnitDeck deck, ArrayList<UnitDeck> list) {

		for(UnitDeck e:list) {
			if(e.equals(deck))
				return true;
		}
		return false;

	}
	
	public static boolean cardExistsInDeckList(ArrayList<UnitDeck> deckList, UnitCard cardToTest) {
		
		//TODO: Fill Code
		for(UnitDeck e:deckList) {
			for(CardCounter ee: e.getCardsInDeck()) {
				if(ee.getCard().equals(cardToTest))
					return true;
			}
		}
		return false;
	}
	
	public static ArrayList<UnitCard> getCardsFromFile(String filename){
		
		File fileToRead = new File(filename);
		ArrayList<UnitCard> cardsFromFile = new ArrayList<UnitCard>();

		// Fill Code
		try (Scanner scanner = new Scanner(fileToRead)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] data = line.split(","); 

                if (data.length != 5) {
                    System.err.println("Invalid card data format in line: " + line);
                    return null; // Return null on invalid data format
                }
                
                String name = data[0];
                int bloodCost;
                int power;
                int health;
                String flavorText = data[4];

                try {
                    bloodCost = Integer.parseInt(data[1]);
                    power = Integer.parseInt(data[2]);
                    health = Integer.parseInt(data[3]);
                } catch (NumberFormatException e) {
                    System.err.println("Error parsing numbers in line: " + line);
                    return null; // Return null on number parsing error
                }
                
                UnitCard card = new UnitCard(name, bloodCost, power, health, flavorText);
                cardsFromFile.add(card);
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + filename);
            return null; // Return null on file not found
        }

        return cardsFromFile;

	}

	public static void printCardList(ArrayList<UnitCard> cardList, boolean verbose) {
		
		for(int i = 0; i < cardList.size(); i++) {
			System.out.println(i + ") " + cardList.get(i));
			if(verbose) {
				System.out.println("Blood Cost: " + cardList.get(i).getBloodCost());
				System.out.println(cardList.get(i).getFlavorText());
				if(i < cardList.size()-1) System.out.println("-----");
			}
		}
	}
	
	public static void printDeck(UnitDeck ud) {
		
		if(ud.getCardsInDeck().size() == 0) {
			System.out.println("EMPTY DECK");
		}else {
			for(CardCounter cc : ud.getCardsInDeck()) {
				System.out.println(cc);
			}
		}
		
		System.out.println("Total Cards: " + ud.cardCount());
	}
	
	public static void printDeckList(ArrayList<UnitDeck> deckList) {
		
		
		for(int i = 0; i < deckList.size(); i++) {
			System.out.println(i + ") " + deckList.get(i).getDeckName());
			printDeck(deckList.get(i));
			if(i < deckList.size()-1) System.out.println("-----");
		}
	}
}
