package Maumau.Game;

import Maumau.Cards.Face;

public class NineEffectRule extends CardEffectRules {

    public NineEffectRule(CardEffectRules next) {
        super(next);
    }

    @Override
    public Integer validate(Game game) {
        if (Face.NINE == game.getCardPlayed().getFace()) {
            Integer index;
            if (game.getJ() == 0) {
                index = game.getNumberPlayer() - 1;
            } else {
                index = game.getJ() - 1;
            }
            game.getPlayerList().get(index).addCard(game.getDeck().getDeck().get(0));
            game.getDeck().getDeck().remove(0);
        }

        return next.validate(game);
    }

}
