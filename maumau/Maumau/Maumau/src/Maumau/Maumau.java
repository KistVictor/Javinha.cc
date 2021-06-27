package Maumau;

import java.util.Scanner;

import Maumau.Cards.Card;
import Maumau.Cards.Deck;
import Maumau.Game.Game;
import Maumau.Player.Player;
import java.util.Collections;

public class Maumau {

    public static void main(String[] args) {
        Integer opcao = 1;
        Scanner scanner = new Scanner(System.in);

        Game game = new Game();
        game.startGame();
        while (opcao != 0) {
            System.out.println("\n\n\n---------------------------\nSeja Bem-vindo ao Mau-Mau");
            System.out.println("[1] - Iniciar novo jogo");
            System.out.println("[2] - Ver ScoreBoard");
            System.out.println("[3] - Ajuda sobre o jogo");
            System.out.println("[0] - Sair\n---------------------------\n");
            System.out.println("Digite a opção desejada:");
            opcao = scanner.nextInt();
            System.out.println("\n\n");
            switch (opcao) {
                case 0:
                    System.out.println("Até mais!");
                    game.showScoreBoard();
                    break;
                case 1:
                    game.setUp();
                    game.dealCards();
                    game.play();
                    break;
                case 2:
                    game.showScoreBoard();
                    break;
                case 3:
                    game.help();
                    break;
            }
        }
    }
}
