import Pessoas.Motorista;
import Pessoas.Passageiro;

public class Carro {
    public Passageiro passageiro;
    public Motorista motorista;
    public int valor;

    public Carro(Motorista motorista, Passageiro passageiro) {
        this.passageiro = passageiro;
        this.motorista = motorista;
    }

    
}