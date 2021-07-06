package prova;

// classe q herdou de FiguraGeometrica e implementar ICalculos2D
public class Circulo extends FiguraGeometrica implements ICalculos2D {
    private float raio;
    private int centroX;
    private int centroY;
    protected float pi = (float) 3.14159;

    // constructor
    public Circulo(float raio) {
        super();
        this.centroX = centroX;
        this.centroY = centroY;
        this.raio = raio;
    }

    // calculos
    @Override
    public float calcularArea() {

        float area = pi * (raio * raio);

        return area;
    }

    @Override
    public float calcularPerimentro() {

        float perimentro = 2 * pi * raio;

        return perimentro;
    }

    public float getRaio() {
        return raio;
    }

    // override do toString
    @Override
    public String toString() {
        return  super.toString() + "\n" +
                "-=Círculo=-\n" + 
                "centroX = " + centroX + "\n" +
                "centroX = " + centroX + "\n\n";
    }
}