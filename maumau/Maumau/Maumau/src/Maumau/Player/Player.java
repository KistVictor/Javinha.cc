package Maumau.Player;

import java.util.ArrayList;
import java.util.List;

import Maumau.Cards.Card;

public class Player implements Comparable<Player> {

    private List<Card> hand;
    private String name;
    private Integer wins;

    public Player() {
        this.hand = new ArrayList<>();
    }

    public Player(String nome) {
        this.hand = new ArrayList<>();
        this.name = nome;
        this.wins = 0;
    }

    // Método para ordenação da leaderboard
    public int compareTo(Player player) {
        if (this.wins > player.wins) {
            return -1;
        } else if (this.wins < player.wins) {
            return 1;
        }
        return this.getName().compareToIgnoreCase(player.getName());
    }

    public void addCard(Card card) {
        hand.add(card);
    }

    // Retorna as cartas na mão do jogador
    public String printCards() {
        String cards = "";
        for (Integer i = 0; i < hand.size(); i++) {
            cards += "[" + String.valueOf(i) + "]" + hand.get(i).toString() + " ";
        }
        return cards;
    }

    public List<Card> getHand() {
        return hand;
    }

    public void setHand(List<Card> hand) {
        this.hand = hand;
    }

    public String getName() {
        return name;
    }

    public void setName(String nome) {
        this.name = nome;
    }

    public void setScoreBoard() {
        this.wins++;
    }

    public int getScoreBoard() {
        return wins;
    }

    public Integer getWins() {
        return wins;
    }

    public void setWins(Integer wins) {
        this.wins = wins;
    }

}
