package Maumau;

import java.util.Scanner;

import Maumau.Cards.Card;
import Maumau.Cards.Deck;
import Maumau.Game.Game;

public class Maumau {
    public static void main(String[] args) {
        Integer opcao = 1;
        Scanner scanner = new Scanner(System.in);

//        Scanner scanner = new Scanner(System.in);
//        Integer numberPlayer = scanner.nextInt();
        while(opcao != 0){
            System.out.println("\n---------------------------\nSeja Bem-vindo ao Mau-Mau");
            System.out.println("[1] - Iniciar novo jogo");
            System.out.println("[2] - Ver ScoreBoard");
            System.out.println("[3] - Ajuda sobre o jogo");
            System.out.println("[0] - Sair\n---------------------------\n");
            System.out.println("Digite a opção desejada:");
            opcao = scanner.nextInt();
            switch(opcao){
                case 0:
                    System.out.println("Até mais!");
                    break;
                case 1:
                    Game game = new Game();
                    game.startGame();
                    game.dealCards();
                    game.play();
                    break;
                case 2:
                    /*
                    if(game.playerList.isEmpty()){
                        System.out.println("Não há histórico de partidas");
                    }
                    else{
                        for(int i=0;i<game.playerList.size();i++){
                            System.out.println("Jogador: " + game.playerList.get(i).getNome() + "\nVitórias: " + game.playerList.get(i).getScoreBoard());
                        }
                    }*/
                case 3:
//                    game.help();
                }
            }
        }
}
