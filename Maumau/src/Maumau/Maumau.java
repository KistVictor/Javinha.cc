package Maumau;

import java.util.Scanner;

import Maumau.Cards.Card;
import Maumau.Cards.Deck;
import Maumau.Game.Game;

public class Maumau {
    public static void main(String[] args) {


//        Scanner scanner = new Scanner(System.in);
//        Integer numberPlayer = scanner.nextInt();

        Game game = new Game();
        game.startGame();
        game.dealCards();
        game.play();
    }
}
