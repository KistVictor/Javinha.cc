package Maumau.Player;

import java.util.ArrayList;
import java.util.List;

import Maumau.Cards.Card;

public class Player {
    
    private List<Card> hand;
    private String nome;
    private Integer wins;

    public Player() {    
        this.hand = new ArrayList<>();
    }

    public Player(String nome) {
        this.hand = new ArrayList<>();
        this.nome = nome;
        this.wins = 0;
    }

    public void addCard(Card card) {
        hand.add(card);
    }

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

    public void setHand( List<Card> hand) {
        this.hand = hand;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public void setScoreBoard() {
        this.wins++;
    }

    public int getScoreBoard() {
        return wins;
    }
    
    
}