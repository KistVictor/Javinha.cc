package Pessoas;

public class Funcionario extends Pessoa{
    String _nome;
    int _cpf;
    int _salario;
    String _funcao;

    public Funcionario(String nome, int cpf, int salario, String funcao){
        super(nome, cpf);
        this._salario = salario;
        this._funcao = funcao;
    }
    
}