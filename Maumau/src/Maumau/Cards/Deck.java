package Maumau.Cards;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Deck {

    private List<Card> deck;
    private final int NUMBER_OF_CARDS = 52;
    private Random random;

    public Deck() {
        deck = new ArrayList<>();
        random = new Random();

        for (int count = 0; count < NUMBER_OF_CARDS; count++) {
            deck.add(new Card(Face.getFace(count % 13), Suit.getSuit(count / 13)));
        }
    }

    public void shuffle() {
        for (int first = 0; first < NUMBER_OF_CARDS; first++) {
            int second = random.nextInt(NUMBER_OF_CARDS);

            Card temp = deck.get(first);
            deck.set(first, deck.get(second));
            deck.set(second, temp);
        }
    }

    public List<Card> getDeck() {
        return deck;
    }
}
