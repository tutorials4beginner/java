import java.util.*;

public class Deal {
    public static void main(String[] args) {
	if (args.length < 2) {
	    System.out.println("Usage: Deal hands cards");
	    return;
	}
	int numHands = Integer.parseInt(args[0]);
	int cardsPerHand = Integer.parseInt(args[1]);
	List<Card> deck = Deck.newDeck();
	Collections.shuffle(deck);
	if (numHands * cardsPerHand > deck.size()) {
	    System.out.println("Not enough cards.");
	    return;
	}

	for (int i = 0; i < numHands; i++)
	    System.out.println(dealHand(deck, cardsPerHand));
    }

    public static ArrayList<Card> dealHand(List<Card> deck, int n) {
	int deckSize = deck.size();
	List<Card> handView = deck.subList(deckSize-n, deckSize);
	ArrayList<Card> hand = new ArrayList<Card>(handView);
	handView.clear();
	return hand;
    }
}
