package Maumau.Game;

import Maumau.Cards.Face;

public class NineEffectRule extends CardEffectRules {

    public NineEffectRule(CardEffectRules next) {
        super(next);
    }

    @Override
    public Integer validate(Game game) {
        if (Face.NINE == game.getCardPlayed().getFace()) {  // Verifica se a carta jogada é um nove
            Integer index;
            if (game.getJ() == 0) { // Passa para o jogador anterior
                index = game.getNumberPlayer() - 1;
            } else {
                index = game.getJ() - 1;
            }
            game.getPlayerList().get(index).addCard(game.getDeck().getDeck().get(0));   // Adiciona 1 carta para o jogador anterior
            game.getDeck().getDeck().remove(0);

            return game.getJ(); // Retorna a posição do jogador para o jogo continuar
        }

        return next.validate(game); // Se não validar, passa para a próxima regra de validação
    }

}
