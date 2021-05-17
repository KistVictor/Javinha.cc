package agendavetor;

import agendavetor.Agenda;
import java.util.Scanner;

public class AgendaVetor {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String nome, telefone, email, input;
        Integer tamanho, aux, opcao = 1, index = 0;

        System.out.println("\nInforme o tamanho da lista: ");
        tamanho = scan.nextInt();
        Agenda contato[] = new Agenda[tamanho];
        
        while (opcao != 0) {
            System.out.println(
                    "Informe a operação desejada!\n"
                    + "[1]Adicionar\n[2]Mostrar\n"
                    + "[3]Editar\n[4]Excluir\n[0]Sair\n");

            opcao = scan.nextInt();
            scan.nextLine();
            switch (opcao) {

                case 1:
                    if (index < tamanho) {
                        System.out.println("\nInforme o nome do contato: ");
                        nome = scan.nextLine();
                        System.out.println("\nInforme o telefone do contato: ");
                        telefone = scan.nextLine();
                        System.out.println("\nInforme o email do contato: ");
                        email = scan.nextLine();
                        contato[index] = new Agenda();
                        contato[index].adicionar(nome, telefone, email);
                        index += 1;
                        System.out.println("\nContato salvo com sucesso\n");
                    } else {
                        System.out.println("\nLista cheia\n");
                    }

                    break;

                case 2:
                    if (index != 0) {
                        for (int i = 0; i <= index; i++) {
                            if (contato[i] == null) {
                                break;
                            }
                            contato[i].mostrar();
                        }
                        System.out.println("\n\n");
                    } else {
                        System.out.println("\nNenhum contato salvo\n");
                    }
                    break;

                case 3:
                    System.out.println("\nInforme o index desejado");
                    aux = scan.nextInt();
                    if (contato[aux] != null) {
                        System.out.println("\nInforme qual opção gostaria de alterar:\n[1]Nome\n[2]Telefone\n[3]Email\n");
                        opcao = scan.nextInt();
                        System.out.println("\nInforme a alteração: ");
                        scan.nextLine();
                        input = scan.nextLine();
                        contato[aux].editar(opcao, input);
                        System.out.println("\nContato alterado com sucesso!\n");
                    } else {
                        System.out.println("\nContato não encontrado\n");
                    }
                    break;

                case 4:
                    System.out.println("\nInforme o index desejado");
                    aux = scan.nextInt();
                    if (contato[aux] != null) {
                        contato = new Agenda().excluir(contato, aux, tamanho);
                        index -= 1;
                        System.out.println("\nContato exlcuído com sucesso!\n");
                    } else {
                        System.out.println("\nContato não encontrado\n");
                    }
                    break;

                default:
                    opcao = 0;
                    break;
            }
        }
    }

}
