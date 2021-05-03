import java.text.DecimalFormat;
import java.util.Scanner;

public class Index {

    public static void main(String[] args) {

        System.out.println("Digite quantos carros deseja adicionar: ");
        Scanner scan = new Scanner(System.in);
        int valor = scan.nextInt();
        Carro[] vet;
        vet = new Carro[valor];

        for (int i = 0; i < vet.length; i++) {

            System.out.println("Digite o modelo do carro: ");
            vet[i].modelo = scan.next();

            /*System.out.println("Digite o ano do carro: ");
            vet[i].ano = scan.next();

            System.out.println("Digite o ano do carro: ");
            vet[i].cor = scan.next();*/

            System.out.println(vet[i].modelo);
            //System.out.println(vet[i].ano);
            //System.out.println(vet[i].cor);
        }
        
    }
}