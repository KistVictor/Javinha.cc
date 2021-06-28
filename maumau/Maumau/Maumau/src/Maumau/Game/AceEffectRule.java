package Maumau.Game;

import Maumau.Cards.Face;

public class AceEffectRule extends CardEffectRules {

    public AceEffectRule(CardEffectRules next) {
        super(next);
    }

    @Override
    public Integer validate(Game game) {
        if (Face.ACE == game.getCardPlayed().getFace()) {   // Verifica se a carta jogada é um Ás
            if (game.getJ() == game.getNumberPlayer() - 1) {    // Passa o próximo jogador, verificando se este que jogou é o último da rodada ou não
                return 0;
            } else {
                return game.getJ() + 1;
            }
        }

        return next.validate(game); // Se não validar, passa para a próxima regra de validação
    }

}
