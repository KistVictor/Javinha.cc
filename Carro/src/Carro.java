public class Carro {
    public String modelo;
    public String ano;
    public String cor;

    public Carro(String modelo, String ano, String cor) {
        this.modelo = modelo;
        this.ano = ano;
        this.cor = cor;
    }

    public void mostrarCaracteristicas() {
        System.out.println(this.modelo);
        System.out.println(this.ano);
        System.out.println(this.cor);
    }

    public void demolir() {
        this.modelo = "demolido";
        this.ano = "01100101 01111000 01110000 01101100 01101111 01100100 01101001 01100100 01101111";
        this.cor = "demolido";
    }
}