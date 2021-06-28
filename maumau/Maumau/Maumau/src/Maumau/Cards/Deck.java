package Maumau.Cards;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Deck {

    private List<Card> deck;
    private final Integer NUMBER_OF_DECKS = 2;  //Seguimos o padrão das regras, 
    private final Integer CARDS_OF_DECK = 52;   //sendo necessário 2 baralhos de 52 cartas para o jogo.
    private final Integer NUMBER_OF_CARDS = NUMBER_OF_DECKS * CARDS_OF_DECK;
    private Random random;

    // Faz a criação do baralho com base nos parâmetros acima
    public Deck() { //Inicializa o deck
        deck = new ArrayList<>();
        random = new Random();

        for (int count = 0; count < NUMBER_OF_CARDS; count++) {
            deck.add(new Card(Face.getFace(count % 13), Suit.getSuit(count / (13 * NUMBER_OF_DECKS))));
        }
    }

    // Embaralha as cartas
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
