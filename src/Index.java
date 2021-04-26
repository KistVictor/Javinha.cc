import Pessoas.Aluno;
import Pessoas.Funcionario;

public class Index {
    public Index() {
    }

    public static void main(String[] args) {
        /*
        Aluno aluno1 = new Aluno("Victor", 123, 3);
        aluno1.finalizarAno(8, 9, 7);
        System.out.println(aluno1.media());

        Aluno aluno2 = new Aluno("Bastos", 321, 3);
        aluno2.finalizarAno(5, 6, 5);
        System.out.println(aluno2.media());
        */
        Aluno aluno3 = new Aluno("Carlos", 213, 3);
        aluno3.finalizarAno(7, 9, 6);
        System.out.println(aluno3);
        System.out.println("Nota aluno " + aluno3.nome() + "é: " + aluno3.media());



    }
}