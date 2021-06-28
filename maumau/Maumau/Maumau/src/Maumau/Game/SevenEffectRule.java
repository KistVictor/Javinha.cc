package Maumau.Game;

import Maumau.Cards.Face;

public class SevenEffectRule extends CardEffectRules {

    public SevenEffectRule(CardEffectRules next) {
        super(next);
    }

    @Override
    public Integer validate(Game game) {
        
        if (Face.SEVEN == game.getCardPlayed().getFace()) {     // Verifica se a carta jogada é um sete
            Integer index;
            if (game.getJ() == game.getNumberPlayer() - 1) {    // Passa para o próximo jogador
                index = 0;
            } else {
                index = game.getJ() + 1;
            }
            
            for (Integer i = 0; i < 2; i++) {   // Adiciona 2 cartas para o próximo jogador
                game.getPlayerList().get(index).addCard(game.getDeck().getDeck().get(0));
                game.getDeck().getDeck().remove(0);
            }

            return index;   // Retorna a posição do próximo jogador para o jogo continuar
        }

        return next.validate(game); // Se não validar, passa para a próxima regra de validação
    }

}
