package Pessoas;

public class Aluno extends Pessoa{
    public int matricula;
    public float _media;

    public Aluno(String nome, int cpf, int matricula){
        super(nome, cpf);
        this.matricula = matricula;
    }

    public float media() {
        return this._media;
    }

    public void finalizarAno(float nota1, float nota2, float nota3) {
        float media = (nota1+nota2+nota3) / 3;
        this._media = media;
    }
}