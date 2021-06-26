package Maumau.Game;

import Maumau.Cards.Card;
import Maumau.Cards.Deck;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Maumau.Player.Player;

public class Game {

    private Integer numberPlayer;
    public Integer cardNumber = 0;
    private List<Player> playerList;
    private Card lastCard;
    public Deck deck;

    public Game() {
        playerList = new ArrayList<>();
        deck = new Deck();
        deck.shuffle();
    }

    public void startGame() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Informe a quantidade de jogadores: ");
        numberPlayer = scanner.nextInt();

        for (Integer i = 0; i < numberPlayer; i++) {
            System.out.println("Informe o nome do Jogador " + i + ":");
            playerList.add(new Player(scanner.next()));
        }

    }

    public void dealCards() {
        for (Card card : deck.getDeck()) {
            System.out.println(card.toString());
        }

        for (Integer i = 0; i < 5; i++) {
            for (Integer j = 0; j < numberPlayer; j++) {
                playerList.get(j).addCard(deck.getDeck().get(0));
                deck.getDeck().remove(0);
            }
        }

//        MOSTRA AS CARTAS DOS PLAYERS NO INICIO
//        for(Integer j = 0; j < numberPlayer; j++){
//            System.out.println("\n" + playerList.get(j).getNome());    
//            System.out.println(playerList.get(j).getHand());
//        }
    }

    public void Play() {
        lastCard = deck.getDeck().get(0);
        int jogarCarta;
        Scanner scanner = new Scanner(System.in);
        for (Integer j = 0; j < numberPlayer; j++) {
            System.out.println("\nAgora é a vez do jogador " + playerList.get(j).getNome());
            System.out.println("Última carta jogada: " + lastCard.toString());
            System.out.println("Suas cartas: " + playerList.get(j).getHand());

//          VERIFICA SE O JOGADOR TEM A CARTA, SE NÃO, O JOGO COMPRA AUTO
//            if(){
//            }
//            else{
            System.out.println("Qual carta gostaria de jogar?");
            jogarCarta = scanner.nextInt();
//            }
        }
    }

    public void help() {
        System.out.println("você foi ajudado");
    }

    public void setScoreboard() {

    }

    public void getScoreboard() {

    }

    public Integer getNumberPlayer() {
        return numberPlayer;
    }

    public void setNumberPlayer(Integer numberPlayer) {
        this.numberPlayer = numberPlayer;
    }

}
