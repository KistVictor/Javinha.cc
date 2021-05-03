public class Carro {
    public String modelo;
    public int ano;
    public String cor;

    public Carro(String modelo, int ano, String cor) {
        this.modelo = modelo;
        this.ano = ano;
        this.cor = cor;
    }

    public void mostrarCaracteristicas() {
        System.out.println(this.modelo);
        System.out.println(this.ano);
        System.out.println(this.cor);
    }
}