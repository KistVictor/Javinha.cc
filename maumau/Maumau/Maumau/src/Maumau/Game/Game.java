package Maumau.Game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import Maumau.Cards.Card;
import Maumau.Cards.Deck;
import Maumau.Cards.Face;
import Maumau.Player.Player;

public class Game {

    private Integer numberPlayer;
    public Integer cardNumber = 0;
    private Integer j;
    public List<Player> playerList;
    private Deck deck;
    private List<Integer> wins;
    private Card lastCard;
    private boolean finish = false;
    Scanner scanner = new Scanner(System.in);
    private Card cardPlayed;

    // Inicia a estrutura do jogo adicionando os jogadores que participarão
    public Game() {
        playerList = new ArrayList<>();
        numberPlayer = 0;
        while (numberPlayer < 3) { // Não permite adicionar 
            System.out.println("Informe a quantidade de jogadores (no mínimo 3 participantes): ");
            numberPlayer = scanner.nextInt();
        }
        for (Integer i = 1; i <= numberPlayer; i++) {
            System.out.println("Informe o nome do Jogador " + i + ":");
            playerList.add(new Player(scanner.next()));
        }
    }

    // Prepara as variáveis para poder iniciar uma nova partida
    public void setUp() {
        finish = false;
        deck = new Deck();
        deck.shuffle();
        for (Player player : playerList) {
            player.setHand(new ArrayList<Card>());
        }
    }

    // Distriui 5 cartas para cada jogador
    public void dealCards() {
        for (Integer i = 0; i < 5; i++) {
            for (j = 0; j < numberPlayer; j++) {
                playerList.get(j).addCard(deck.getDeck().get(0));
                deck.getDeck().remove(0);
            }
        }
    }

    // Inicia a partida
    public void play() {
        lastCard = deck.getDeck().get(0);   // Pega a primeira carta do baralho e coloca na mesa para o primeiro jogador poder jogar
        while (finish == false && deck.getDeck().size() > 0) {  // O jogo termina apenas quando alguém fica sem cartas ou o baralho acaba
            for (j = 0; j < numberPlayer; j++) {
                if (!verifyRules(playerList.get(j).getHand(), lastCard)) {  // Verifica se o jogador possui alguma carta para jogar
                    System.out.println("Jogador " + playerList.get(j).getName() + " não possui nenhuma carta disponível, receba uma carta!");
                    playerList.get(j).addCard(deck.getDeck().get(0));   // Adiciona mais uma carta na mão do jogador
                    deck.getDeck().remove(0);   // Remove a carta do deck
                } else {
                    j = playCard(j);
                }

                if (finish == true) { // Termina imediatamente quando alguem ganha
                    break;
                }
            }
        }
    }

    // Inicia a rodada do jogador atual
    public Integer playCard(int j) {
        Integer cardIndex;

        while (true) {
            System.out.println("\n---------------------------\nAgora é a vez do jogador " + playerList.get(j).getName());
            System.out.println("Última carta jogada: " + lastCard.toString());
            System.out.println("Suas cartas: " + playerList.get(j).printCards());
            System.out.println("Menu de ajuda: [-1]\n---------------------------\n");
            System.out.println("Qual carta gostaria de jogar?");
            cardIndex = scanner.nextInt();
            System.out.println("\n");
            if (cardIndex == -1) { // Abre o menu de ajuda em qualquer rodada que o jogador desejar
                help();
            } else {
                cardPlayed = playerList.get(j).getHand().get(cardIndex);
                if (verifyRules(cardPlayed, lastCard)) {    // Verifica se a carta selecionada pelo jogador pode ser descartada nesta situação
                    lastCard = cardPlayed;
                    playerList.get(j).getHand().remove(cardPlayed); // Remove a carta da mão do jogador

                    CardEffectRules rule = new AceEffectRule(   // Verifica todos os efeitos de cartas
                            new JackEffectRule(
                                    new NineEffectRule(
                                            new SevenEffectRule(
                                                    new NoEffectRule()))));

                    j = rule.validate(this);

                    if (playerList.get(j).getHand().isEmpty()) {    // Finaliza o game quando algum jogador ficou totalmente sem cartas
                        System.out.println("O jogador " + playerList.get(j).getName() + " ganhou a partida!");
                        playerList.get(j).setScoreBoard();  // Aumenta a quantidade de vitórias deste jogador
                        finish = true;
                    }

                    break;
                }
                System.out.println("Carta inválida, por favor tente novamente!");
            }
        }

        return j;
    }

    // Verifica se será possível realizar alguma jogada com base na última carta jogada e nas cartas que estão na mão do jogador
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

    // Verifica se o jogador selecionou a carta correta para jogar
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
                    System.out.println("\nCartas Especiais:\nAce/Ás: Pula o próximo jogador\nJack/Valete: Seria a carta 'coringa', podendo ser utilizada em qualquer momento (exceto após o sete), após a jogada, pode-se escolher o naipe desejado\n9: Adiciona mais uma carta ao jogador anterior\n7: Adiciona duas cartas ao próximo jogador\n---------------------------\n");
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
        Collections.sort(playerList);   // Realiza uma nova ordenação nos players de acordo com a quantidade de vitórias e/ou alfabeticamente
        for (Integer i = 0; i < playerList.size(); i++) {
            System.out.println("-------------" + (i + 1) + "-------------");
            System.out.println("Jogador: " + playerList.get(i).getName() + "\nVitórias: " + playerList.get(i).getScoreBoard() + "\n");
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

    public Integer getJ() {
        return j;
    }

    public void setJ(Integer j) {
        this.j = j;
    }

    public boolean isFinish() {
        return finish;
    }

    public void setFinish(boolean finish) {
        this.finish = finish;
    }

    public Scanner getScanner() {
        return scanner;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    public Card getCardPlayed() {
        return cardPlayed;
    }

    public void setCardPlayed(Card cardPlayed) {
        this.cardPlayed = cardPlayed;
    }

}
