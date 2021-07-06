package prova;

// classe abstrata q serve de base para circulo
abstract class FiguraGeometrica {

    private int larguraLinha;

    // constructor
    public FiguraGeometrica() {
        this.larguraLinha = 0;
    }

    // override do toString
    @Override
    public String toString() {
        return  "-=FiguraGeometrica=-\n" + 
                "larguraLinha = " + larguraLinha + "\n\n";
    }
}