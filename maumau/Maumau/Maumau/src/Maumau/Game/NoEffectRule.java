package Maumau.Game;

public class NoEffectRule extends CardEffectRules {

    public NoEffectRule() {
        super(null);
    }

    @Override
    public Integer validate(Game game) {
        return game.getJ();
    }

}
