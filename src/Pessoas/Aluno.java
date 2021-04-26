package Pessoas;

public class Aluno extends Pessoa{
    String nome;
    int cpf;
    int ano;
    float _media;

    public Aluno(String nome, int cpf, int ano){
        super(nome, cpf);
        this.ano = ano;
    }

    public float media() {
        return _media;
    }

    public String nome() {
        return nome;
    }

    public void finalizarAno(float nota1, float nota2, float nota3) {
        float media = (nota1+nota2+nota3) / 3;
        _media = media;
    }
}