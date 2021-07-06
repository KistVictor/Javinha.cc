package prova;

// classe q herdou de Circulo e implementar ICalculos3D
public class Esfera extends Circulo implements ICalculos3D {

    private int centroZ = 0;

    // constructor
    public Esfera (float raio) {
        super(raio);
        this.centroZ = centroZ;
    }

    // calculo
    @Override
    public float calcularVolume() {

        float volume = 4/3 * pi * (this.getRaio() * this.getRaio() * this.getRaio());

        return volume;
    }

    // override do toString
    @Override
    public String toString() {
        return  super.toString() + "\n" +
                "-=Esfera=-\n" + 
                "centroZ = " + centroZ;
    }
}