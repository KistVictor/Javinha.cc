package Pessoas;

public class Funcionario extends Pessoa{
    public String funcao;
    public int _salario;

    public Funcionario(String nome, int cpf, String funcao){
        super(nome, cpf);
        this.funcao = funcao;
    }

    public int salario() { //get
        return this._salario;
    }

    public void salario(int salario) { //set
        this._salario = salario;
    }
}