import java.util.*;

public class Deck2 {

    public static int numSuits = 4;
    public static int numRanks = 13;
    public static int numCards = numSuits * numRanks;

    private Card2[][] cards;

    public Deck2() {
        cards = new Card2[numSuits][numRanks];
        for (int suit = Card2.DIAMONDS; suit <= Card2.SPADES; suit++) {
            for (int rank = Card2.ACE; rank <= Card2.KING; rank++) {
                cards[suit-1][rank-1] = new Card2(rank, suit);
            }
        }
    }

    public Card2 getCard(int suit, int rank) {
        return cards[suit-1][rank-1];
    }
}
