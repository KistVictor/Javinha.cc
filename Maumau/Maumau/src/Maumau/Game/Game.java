package Maumau.Game;

import Maumau.Cards.Card;
import Maumau.Cards.Deck;
import Maumau.Cards.Face;
import Maumau.Cards.Suit;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Maumau.Player.Player;

public class Game {

    private Integer numberPlayer;
    public Integer cardNumber = 0;
    public List<Player> playerList;
    private Deck deck;
    private List<Integer> wins;
    private Card lastCard;
    private boolean finalizar = false;
    Scanner scanner = new Scanner(System.in);

    public Game() {
        playerList = new ArrayList<>();
        numberPlayer = 0;
        deck = new Deck();
        deck.shuffle();
    }

    public void startGame() {
        while (numberPlayer < 3) {
            System.out.println("Informe a quantidade de jogadores (no mínimo 3 participantes): ");
            numberPlayer = scanner.nextInt();
        }
        for (Integer i = 1; i <= numberPlayer; i++) {
            System.out.println("Informe o nome do Jogador " + i + ":");
            playerList.add(new Player(scanner.next()));
        }
    }

    public void dealCards() {
        for (Card card : deck.getDeck()) {
            System.out.println(card.toString());
        }

        for (Integer i = 0; i < 2; i++) {
            for (Integer j = 0; j < numberPlayer; j++) {
                playerList.get(j).addCard(deck.getDeck().get(0));
                deck.getDeck().remove(0);
            }
        }

        playerList.get(0).addCard(new Card(Face.ACE, Suit.DIAMOND));
        playerList.get(0).addCard(new Card(Face.ACE, Suit.CLUB));
        playerList.get(0).addCard(new Card(Face.ACE, Suit.SPADE));
        playerList.get(0).addCard(new Card(Face.ACE, Suit.HEARTH));
        /* 
        playerList.get(1).addCard(new Card(Face.NINE, Suit.SPADE));
        playerList.get(2).addCard(new Card(Face.NINE, Suit.HEARTH));*/
        //    MOSTRA AS CARTAS DOS PLAYERS NO INICIO
        //    for(Integer j = 0; j < numberPlayer; j++){
        //        System.out.println("\n" + playerList.get(j).getNome());    
        //        System.out.println(playerList.get(j).getHand());
        //    }
    }

    public void play() {
        lastCard = deck.getDeck().get(0);
        while (finalizar == false && deck.getDeck().size() > 0) {
            for (Integer j = 0; j < numberPlayer; j++) {
                if (!verifyRules(playerList.get(j).getHand(), lastCard)) {
                    System.out.println("Jogador " + playerList.get(j).getNome() + " não possui nenhuma carta disponível, receba uma carta!");
                    playerList.get(j).addCard(deck.getDeck().get(0));
                    deck.getDeck().remove(0);
                } else {
                    j = playCard(j);
                }
            }
        }
    }

    public Integer playCard(int j) {
        Integer cardIndex;

        while (finalizar == false) {
            System.out.println("\n---------------------------\nAgora é a vez do jogador " + playerList.get(j).getNome());
            System.out.println("Última carta jogada: " + lastCard.toString());;
            System.out.println("Suas cartas: " + playerList.get(j).printCards());
            System.out.println("Menu de ajuda: [-1]\n---------------------------\n");
            System.out.println("Qual carta gostaria de jogar?");
            cardIndex = scanner.nextInt();
            if (cardIndex == -1) {
                help();
            } else {
                Card cardPlayed = playerList.get(j).getHand().get(cardIndex);
                if (verifyRules(cardPlayed, lastCard)) {
                    lastCard = cardPlayed;
                    playerList.get(j).getHand().remove(cardPlayed);

                    if (playerList.get(j).getHand().isEmpty()) {
                        System.out.println("O jogador " + playerList.get(j).getNome() + " ganhou a partida!");
                        playerList.get(j).setScoreBoard();
                        finalizar = true;
                    }

                    j = verifyEffect(cardPlayed, j);
                    return j;
                }
                System.out.println("Carta inválida, por favor tente novamente!");
            }
        }

        return j;
    }

    public Integer verifyEffect(Card card, Integer j) {
        if (Face.ACE == card.getFace()) {
            if (j == numberPlayer - 1) {
                j = 0;
            } else {
                j++;
            }
        } else if (Face.JACK == card.getFace()) {
            System.out.println("Selecione o naipe desejeado: [0]Club [1]Diamond [2]Spade [3]Hearth");
            Integer suitIndex = scanner.nextInt();
            lastCard = new Card(Face.JACK, Suit.getSuit(suitIndex));
        } else if (Face.NINE == card.getFace()) {
            Integer index;
            if (j == 0) {
                index = numberPlayer - 1;
            } else {
                index = j - 1;
            }
            playerList.get(index).addCard(deck.getDeck().get(0));
            deck.getDeck().remove(0);
        }

        return j;
    }

    public Boolean verifyRules(List<Card> hand, Card lastCard) {
        for (Card card : hand) {
            if (lastCard.getSuit() == card.getSuit() || lastCard.getFace() == card.getFace()) {
                return true;
            }
            if (Face.JACK == card.getFace() && Face.SEVEN != lastCard.getFace()) {
                return true;
            }
        }
        return false;
    }

    public Boolean verifyRules(Card card, Card lastCard) {
        if (lastCard.getSuit() == card.getSuit() || lastCard.getFace() == card.getFace()) {
            return true;
        }
        if (Face.JACK == card.getFace() && Face.SEVEN != lastCard.getFace()) {
            return true;
        }
        return false;
    }

    public void help() {
        int opcao = 1;
        while (opcao != 0) {
            System.out.println("\nMenu de ajuda:\n---------------------------\n[0] - Retornar ao jogo\n[1] - Regras do Jogo\n[2] - Como jogar\n[3] - Descrição rápida\n---------------------------\nEscolha a opção desejada:");
            opcao = scanner.nextInt();
            switch (opcao) {
                case 0:
                    break;
                case 1:
                    System.out.println("\nRegras:\n---------------------------\nCada jogador irá descartar UMA carta por vez. O jogo será finalizado quando um jogador jogar sua última carta.\nDeve-se jogar uma carta com o mesmo número ou naipe da carta jogada pelo ultimo jogador.");
                    System.out.println("\nCartas Especiais:\nAce: Pula o próximo jogador\nJack: Seria a carta 'coringa', podendo ser utilizada em qualquer momento, após a jogada, pode-se escolher o naipe desejado\n9: Adiciona mais uma carta ao jogador anterior\n---------------------------\n");
                    System.out.println("Pressione [1] para continuar!");
                    scanner.nextInt();
                    break;
                case 2:
                    System.out.println("\nComo jogar:\n---------------------------\nApós a distribuição das cartas, a primeira carta a ser descartada na mesa é retirada do topo do monte.\nApós essa jogada, o próximo jogador deve descartar uma carta do mesmo naipe ou mesmo número da carta no topo da mesa.");
                    System.out.println("Caso você não tenha uma carta que atenda as regras para jogar, o jogo comprará UMA carta automaticamente e pulará para a vez do próximo jogador.\nPara jogar as cartas, veja qual foi a última carta jogada e pressione o número de sua carta que gostaria de descartar.\n---------------------------\n");
                    System.out.println("Pressione [1] para continuar!");
                    scanner.nextInt();
                    break;
                case 3:
                    System.out.println("\nDescrição:\n---------------------------\nJogadores recomendados: 4 à 8\nBaralhos: 2 baralhos (com algumas cartas especiais, veja nas regras)\nDistribuição: cada jogador recebe 5 cartas\nObjetivo: descartar todas as cartas\n---------------------------");
                    System.out.println("Pressione [1] para continuar!");
                    scanner.nextInt();
                    break;
            }
        }
    }

    public Integer getNumberPlayer() {
        return numberPlayer;
    }

    public void setNumberPlayer(Integer numberPlayer) {
        this.numberPlayer = numberPlayer;
    }

}
