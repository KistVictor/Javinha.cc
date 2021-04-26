package Pessoas;

public class Funcionario extends Pessoa{
    String nome;
    int cpf;
    String funcao;
    int _salario;

    public Funcionario(String nome, int cpf, String funcao){
        super(nome, cpf);
        this._funcao = funcao;
    }

    public int salario() { //get
        return this._salario;
    }

    public void salario(int salario) { //set
        this._salario = salario;
    }
}
