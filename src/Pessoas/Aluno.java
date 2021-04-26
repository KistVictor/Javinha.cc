package Pessoas;

public class Aluno extends Pessoa{
    String _nome;
    int _cpf;
    int _ano;
    float[] _notas;
    float _media;

    public Aluno(String nome, int cpf, int ano, float[]notas){
        super(nome, cpf);
        this._notas = notas;
        this._ano = ano;
    }

    public float finalizarAno() {
        this._media = Nota.media(_notas);
    }
}