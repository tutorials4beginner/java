import java.util.*;

public class Deck {
    private static final List<Card> protoDeck = new ArrayList<Card>();

    // Initialize prototype deck
    static {
	for (Suit suit : Suit.values())
	    for (Rank rank : Rank.values())
		protoDeck.add(new Card(rank, suit));
    }

    public static ArrayList<Card> newDeck() {
	// Return copy of prototype deck
	return new ArrayList<Card>(protoDeck);
    }

    public static void main(String[] args) {
	System.out.println(newDeck());
    }
}
