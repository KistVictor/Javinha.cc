package Maumau.Cards;

public enum Suit {
    CLUB("Club"), DIAMOND("Diamond"), SPADE("Spade"), HEARTH("Hearth");
    String name;

    Suit(String name) {
        this.name = name;
    }

    public static Suit getSuit(Integer number) {
        switch(number) {
            case 0:
                return Suit.CLUB;
            case 1:
                return Suit.DIAMOND;
            case 2:
                return Suit.SPADE;
            case 3:
                return Suit.HEARTH;
            default:
                return null;
        }
    }
}
