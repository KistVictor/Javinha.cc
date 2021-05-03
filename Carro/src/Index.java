import java.util.Scanner;

public class Index {

    public static void main(String[] args) {

        System.out.println("Digite quantos carros deseja adicionar: ");
        Scanner scan = new Scanner(System.in);
        int tamanho = scan.nextInt();
        Carro[] vet;
        vet = new Carro[tamanho];

        for (int i = 0; i < vet.length; i++) {

            /*System.out.println("Digite o modelo do carro: ");
            String tempModelo = scan.next();

            System.out.println("Digite o ano do carro: ");
            int tempAno = scan.nextInt();

            System.out.println("Digite a cor do carro: ");
            String tempCor = scan.next();
            
            vet[i] = new carro(tempModelo, tempAno, tempCor)*/

            System.out.println("Digite o modelo do carro: ");
            vet[i].modelo = scan.next();

            System.out.println("Digite o ano do carro: ");
            vet[i].ano = scan.next();

            System.out.println("Digite a cor do carro: ");
            vet[i].cor = scan.next();

            vet[i].mostrarCaracteristicas();
        }
    }
}