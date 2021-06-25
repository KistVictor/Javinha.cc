package Maumau.Cards;

public enum Face {
    ACE("Ace"), TWO("Two"), THREE("Three"), FOUR("Four"), FIVE("Five"), SIX ("Six"), SEVEN ("Seven"), EIGHT ("Eight"), NINE ("Nine"),
    TEN("Ten"), JACK("Jack"), QUEEN("Queen"), KING("King");
    
    String name;

    Face(String name) {
        this.name = name;
    }

    public static Face getFace(Integer number) {
        switch(number) {
            case 0:
                return Face.ACE;
            case 1:
                return Face.TWO;
            case 2:
                return Face.THREE;
            case 3:
                return Face.FOUR;
            case 4:
                return Face.FIVE;
            case 5:
                return Face.SIX;
            case 6:
                return Face.SEVEN;
            case 7:
                return Face.EIGHT;
            case 8:
                return Face.NINE;
            case 9:
                return Face.TEN;
            case 10:
                return Face.JACK;
            case 11:
                return Face.QUEEN;
            case 12:
                return Face.KING;
            default:
                return null;
        }
    }
}
