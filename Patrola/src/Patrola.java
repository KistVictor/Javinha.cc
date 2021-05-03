package src;

public class Patrola {
    private String cor;
    private String marca;
    private Boolean ligado;
    private int marcha;

    public Patrola(String cor, String marca, Float altura, Boolean ligado) {
        this.cor = cor;
        this.marca = marca;
        this.ligado = ligado;
        this.marcha = 0;
    }
    
    public void alternarMotor() {
        ligado = !ligado;
        String motor = ligado ? "ligado!" : "desligado!";
        System.out.println("O motor está " + motor);
    }
    
    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Boolean getLigado() {
        return ligado;
    }

    public void setLigado(Boolean ligado) {
        this.ligado = ligado;
    }
    
}
