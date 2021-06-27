package Maumau.Game;

import Maumau.Cards.Face;

public class SevenEffectRule extends CardEffectRules {

    public SevenEffectRule(CardEffectRules next) {
        super(next);
    }

    @Override
    public Integer validate(Game game) {
        if (Face.SEVEN == game.getCardPlayed().getFace()) {
            Integer index;
            if (game.getJ() == game.getNumberPlayer() - 1) {
                index = 0;
            } else {
                index = game.getJ() + 1;
            }

            for (Integer i = 0; i < 2; i++) {
                game.getPlayerList().get(index).addCard(game.getDeck().getDeck().get(0));
                game.getDeck().getDeck().remove(0);
            }

            return index;
        }

        return next.validate(game);
    }

}
