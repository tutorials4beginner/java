import java.util.*;

public class DisplayDeck2 {
    public static void main(String[] args) {
        Deck2 deck = new Deck2();
        for (int suit = Card2.DIAMONDS; suit <= Card2.SPADES; suit++) {
            for (int rank = Card2.ACE; rank <= Card2.KING; rank++) {
                Card2 card = deck.getCard(suit, rank);
                System.out.format("%s of %s%n",
                    card.rankToString(card.getRank()),
                    card.suitToString(card.getSuit()));
            }
        }
    }
}
