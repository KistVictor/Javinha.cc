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
        return this._media;
    }
    //tentar remover \/ e/ou usar o metodo de baixo
    public String nome() {
        return this.nome;
    }
    /*
    public void nome() {
        return this.nome;
    }
    */
    public void finalizarAno(float nota1, float nota2, float nota3) {
        float media = (nota1+nota2+nota3) / 3;
        this._media = media;
    }
}
