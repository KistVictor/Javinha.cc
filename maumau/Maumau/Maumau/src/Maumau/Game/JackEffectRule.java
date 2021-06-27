package Maumau.Game;

import Maumau.Cards.Card;
import Maumau.Cards.Face;
import Maumau.Cards.Suit;
import java.util.Scanner;

public class JackEffectRule extends CardEffectRules {

    public JackEffectRule(CardEffectRules next) {
        super(next);
    }

    @Override
    public Integer validate(Game game) {
        if (Face.JACK == game.getCardPlayed().getFace()) {
            System.out.println("Selecione o naipe desejeado: [0]Club [1]Diamond [2]Spade [3]Hearth");
            Scanner scanner = new Scanner(System.in);
            Integer suitIndex = scanner.nextInt();
            System.out.println("\n");
            game.setLastCard(new Card(Face.JACK, Suit.getSuit(suitIndex)));

            return game.getJ();
        }

        return next.validate(game);
    }

}
