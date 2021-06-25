package Maumau.Game;

public class Game {

    private int numberPlayer;

    public Game(int numberPlayer) {
        this.numberPlayer = numberPlayer;
    }
    
    public void startGame() {
        
    }

    public void help() {
        System.out.println("você foi ajudado");
    }

    public void setScoreboard() {

    }

    public void getScoreboard() {

    }

    public int getNumberPlayer() {
        return numberPlayer;
    }

    public void setNumberPlayer(int numberPlayer) {
        this.numberPlayer = numberPlayer;
    }

}
