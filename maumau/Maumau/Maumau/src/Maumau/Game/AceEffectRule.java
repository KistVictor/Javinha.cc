package Maumau.Game;

import Maumau.Cards.Face;

public class AceEffectRule extends CardEffectRules {

    public AceEffectRule(CardEffectRules next) {
        super(next);
    }

    @Override
    public Integer validate(Game game) {
        if (Face.ACE == game.getCardPlayed().getFace()) {
            if (game.getJ() == game.getNumberPlayer() - 1) {
                return 0;
            } else {
                return game.getJ() + 1;
            }
        }

        return next.validate(game);
    }

}
