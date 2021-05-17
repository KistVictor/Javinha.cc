package pkgenum;

public enum Teste {
    JANEIRO, FEVEREIRO, MARCO, ABRIL, MAIO, JUNHO, JULHO, AGOSTO, SETEMBRO, OUTUBRO, NOVEMBRO, DEZEMBRO;

    public Integer getNumber() {
        switch (this) {
            case JANEIRO:
                return 1;
            case FEVEREIRO:
                return 2;
            case MARCO:
                return 3;
            case ABRIL:
                return 4;
            case MAIO:
                return 5;
            case JUNHO:
                return 6;
            case JULHO:
                return 7;
            case AGOSTO:
                return 8;
            case SETEMBRO:
                return 9;
            case OUTUBRO:
                return 10;
            case NOVEMBRO:
                return 11;
            case DEZEMBRO:
                return 12;
            default:
                return null;
        }
    }
    
    public Boolean getFerias() {
        switch (this) {
            case JANEIRO:
                return true;
            case FEVEREIRO:
                return true;
            case MARCO:
                return false;
            case ABRIL:
                return false;
            case MAIO:
                return false;
            case JUNHO:
                return false;
            case JULHO:
                return true;
            case AGOSTO:
                return false;
            case SETEMBRO:
                return false;
            case OUTUBRO:
                return false;
            case NOVEMBRO:
                return false;
            case DEZEMBRO:
                return true;
            default:
                return null;
        }
    }
}
