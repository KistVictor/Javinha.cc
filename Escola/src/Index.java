import java.text.DecimalFormat;
import Pessoas.Aluno;
import Pessoas.Funcionario;

public class Index {

    public static void main(String[] args) {
        DecimalFormat f = new DecimalFormat("##.00");
        
        Aluno aluno1 = new Aluno("Victor", 123, 513246);
        aluno1.finalizarAno(8, 9, 7);
        System.out.println("A média do aluno " + aluno1.nome + " inscrito sob a matrícula " + aluno1.matricula + " é: " + f.format(aluno1.media()));

        Aluno aluno2 = new Aluno("Bastos", 321, 123456);
        aluno2.finalizarAno(5, 6, 5);
        System.out.println("A média do aluno " + aluno2.nome + " inscrito sob a matrícula " + aluno2.matricula + " é: " + f.format(aluno2.media()));
        
        Aluno aluno3 = new Aluno("Carlos", 213, 654321);
        aluno3.finalizarAno(7, 9, 6);
        System.out.println("A média do aluno " + aluno3.nome + " inscrito sob a matrícula " + aluno3.matricula + " é: " + f.format(aluno3.media()));

        

    }
}