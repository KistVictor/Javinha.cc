package Maumau.Game;

import Maumau.Cards.Card;
import Maumau.Cards.Deck;
import Maumau.Cards.Face;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Maumau.Player.Player;

public class Game {

    private Integer numberPlayer;
    public Integer cardNumber = 0;
    private List<Player> playerList;
    private Deck deck;
    private Player winner;

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

    //    MOSTRA AS CARTAS DOS PLAYERS NO INICIO
    //    for(Integer j = 0; j < numberPlayer; j++){
    //        System.out.println("\n" + playerList.get(j).getNome());    
    //        System.out.println(playerList.get(j).getHand());
    //    }
    }

    public void play() {
        Card lastCard = deck.getDeck().get(0);
        int cardIndex;
        Scanner scanner = new Scanner(System.in);
        while (winner != null || deck.getDeck().size() > 0) {
            for (Integer j = 0; j < numberPlayer; j++) {
                System.out.println("\nAgora é a vez do jogador " + playerList.get(j).getNome());
                System.out.println("Última carta jogada: " + lastCard.toString());
                System.out.println("Suas cartas: " + playerList.get(j).printCards());

        //          VERIFICA SE O JOGADOR TEM A CARTA, SE NÃO, O JOGO COMPRA AUTO
                if(!verifyRules(playerList.get(j).getHand(), lastCard)){
                    System.out.println("Você não possui nenhuma carta disponível, receba uma carta!");
                    playerList.get(j).addCard(deck.getDeck().get(0));
                    deck.getDeck().remove(0);
                } else {
                    while(true) {
                        System.out.println("Qual carta gostaria de jogar?");
                        cardIndex = scanner.nextInt();
                        if (verifyRules(playerList.get(j).getHand().get(cardIndex), lastCard)) {
                            j = verifyEffect(playerList.get(j).getHand().get(cardIndex), j);

                            lastCard = playerList.get(j).getHand().get(cardIndex);
                            playerList.get(j).getHand().remove(cardIndex);

                            if (playerList.get(j).getHand().size() == 0) {
                                winner = playerList.get(j);
                            }
                            break;
                        }
                        System.out.println("Carta inválida, por favor tente novamente!");
                    }
                }
            }
        }
    }

    public Integer verifyEffect (Card card, Integer j) {
        if (card.getFace() == Face.ACE) {
            j++;
        }

        return j;
    }

    public Boolean verifyRules(List<Card> hand, Card lastCard) {
        for (Card card: hand) {
            if (lastCard.getSuit() == card.getSuit() || lastCard.getFace() == card.getFace()) {
                return true;
            }
        }
        return false;
    }

    public Boolean verifyRules(Card card, Card lastCard) {
        if (lastCard.getSuit() == card.getSuit() || lastCard.getFace() == card.getFace()) {
            return true;
        }
        return false;
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
