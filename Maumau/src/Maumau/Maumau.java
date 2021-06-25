package Maumau;

import java.util.Scanner;

import Maumau.Cards.Card;
import Maumau.Cards.Deck;

public class Maumau {
    public static void main(String[] args) {
        Deck deck = new Deck();
        for(Card card: deck.getDeck()) {
            System.out.println(card.toString());
        }

        deck.shuffle();
        
        System.out.println("\n\n");
        for(Card card: deck.getDeck()) {
            System.out.println(card.toString());
        }
    }
}
