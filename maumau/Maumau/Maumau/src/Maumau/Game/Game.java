package Maumau.Game;

import Maumau.Cards.Card;
import Maumau.Cards.Deck;
import Maumau.Cards.Face;
import Maumau.Cards.Suit;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Maumau.Player.Player;
import java.util.Collections;

public class Game {

    private Integer numberPlayer;
    public Integer cardNumber = 0;
    public List<Player> playerList;
    private Deck deck;
    private List<Integer> wins;
    private Card lastCard;
    private boolean finish = false;
    Scanner scanner = new Scanner(System.in);

    public Game() {
        playerList = new ArrayList<>();
        numberPlayer = 0;
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

    public void setUp() {
        finish = false;
        deck = new Deck();
        deck.shuffle();
        for (Player player : playerList) {
            player.setHand(new ArrayList<Card>());
        }
    }

    public void dealCards() {
        for (Integer i = 0; i < 2; i++) {
            for (Integer j = 0; j < numberPlayer; j++) {
                playerList.get(j).addCard(deck.getDeck().get(0));
                deck.getDeck().remove(0);
            }
        }

        playerList.get(0).addCard(new Card(Face.SEVEN, Suit.DIAMOND));
        playerList.get(0).addCard(new Card(Face.SEVEN, Suit.CLUB));
        playerList.get(0).addCard(new Card(Face.SEVEN, Suit.SPADE));
        playerList.get(0).addCard(new Card(Face.SEVEN, Suit.HEARTH));
//        playerList.get(1).addCard(new Card(Face.NINE, Suit.SPADE));
//        playerList.get(2).addCard(new Card(Face.NINE, Suit.HEARTH));
    }

    public void play() {
        lastCard = deck.getDeck().get(0);
        while (finish == false && deck.getDeck().size() > 0) {
            for (Integer j = 0; j < numberPlayer; j++) {
                if (!verifyRules(playerList.get(j).getHand(), lastCard)) {
                    System.out.println("Jogador " + playerList.get(j).getName() + " não possui nenhuma carta disponível, receba uma carta!");
                    playerList.get(j).addCard(deck.getDeck().get(0));
                    deck.getDeck().remove(0);
                } else {
                    j = playCard(j);
                }

                if (finish == true) {
                    break;
                }
            }
        }
    }

    public Integer playCard(int j) {
        Integer cardIndex;

        while (finish == false) {
            System.out.println("\n---------------------------\nAgora é a vez do jogador " + playerList.get(j).getName());
            System.out.println("Última carta jogada: " + lastCard.toString());;
            System.out.println("Suas cartas: " + playerList.get(j).printCards());
            System.out.println("Menu de ajuda: [-1]\n---------------------------\n");
            System.out.println("Qual carta gostaria de jogar?");
            cardIndex = scanner.nextInt();
            System.out.println("\n");
            if (cardIndex == -1) {
                help();
            } else {
                Card cardPlayed = playerList.get(j).getHand().get(cardIndex);
                if (verifyRules(cardPlayed, lastCard)) {
                    lastCard = cardPlayed;
                    playerList.get(j).getHand().remove(cardPlayed);

                    if (playerList.get(j).getHand().isEmpty()) {
                        System.out.println("O jogador " + playerList.get(j).getName() + " ganhou a partida!");
                        playerList.get(j).setScoreBoard();
                        finish = true;
                    }

                    j = verifyEffect(cardPlayed, j);
                    break;
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
            System.out.println("\n");
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
        } else if (Face.SEVEN == card.getFace()) {
            if (j == numberPlayer - 1) {
                j = 0;
            } else {
                j = j + 1;
            }

            for (Integer i = 0; i < 2; i++) {
                playerList.get(j).addCard(deck.getDeck().get(0));
                deck.getDeck().remove(0);
            }
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
            System.out.println("\nMenu de ajuda:\n---------------------------\n[0] - Retornar\n[1] - Regras do Jogo\n[2] - Como jogar\n[3] - Descrição rápida\n---------------------------\nEscolha a opção desejada:");
            opcao = scanner.nextInt();
            System.out.println("\n");
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

    public void showScoreBoard() {
        if (playerList.isEmpty()) {
            System.out.println("Não há histórico de partidas");
        } else {
            Collections.sort(playerList);
            for (Integer i = 0; i < playerList.size(); i++) {
                System.out.println("-------------" + (i + 1) + "-------------");
                System.out.println("Jogador: " + playerList.get(i).getName() + "\nVitórias: " + playerList.get(i).getScoreBoard() + "\n");
            }
        }
    }

    public Integer getNumberPlayer() {
        return numberPlayer;
    }

    public void setNumberPlayer(Integer numberPlayer) {
        this.numberPlayer = numberPlayer;
    }

    public Integer getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(Integer cardNumber) {
        this.cardNumber = cardNumber;
    }

    public List<Player> getPlayerList() {
        return playerList;
    }

    public void setPlayerList(List<Player> playerList) {
        this.playerList = playerList;
    }

    public Deck getDeck() {
        return deck;
    }

    public void setDeck(Deck deck) {
        this.deck = deck;
    }

    public List<Integer> getWins() {
        return wins;
    }

    public void setWins(List<Integer> wins) {
        this.wins = wins;
    }

    public Card getLastCard() {
        return lastCard;
    }

    public void setLastCard(Card lastCard) {
        this.lastCard = lastCard;
    }

    public boolean isFinalizar() {
        return finish;
    }

    public void setFinalizar(boolean finalizar) {
        this.finish = finalizar;
    }

}
