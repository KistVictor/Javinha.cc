package Maumau;

import java.util.Scanner;

import Maumau.Game.Game;

public class Maumau {

    public static void main(String[] args) {
        Integer opcao = 1;
        Scanner scanner = new Scanner(System.in);

        Game game = new Game();

        while (opcao != 0) {    // Menu do jogo
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
                    game.showScoreBoard();  // Mostra o placar após sair do jogo
                    break;
                case 1:
                    game.setUp();   // Reinicia as variáveis para inicializar um próximo jogo
                    game.dealCards();   // Distribui as cartas para os jogadores
                    game.play();    // Inicia o jogo
                    break;
                case 2:
                    game.showScoreBoard();  // Mostra o placar
                    break;
                case 3:
                    game.help(); // Mostra o menu de ajuda do game
                    break;
            }
        }
    }
}
