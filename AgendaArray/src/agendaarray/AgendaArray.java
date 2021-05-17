/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agendaarray;

import agendaarray.Agenda;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author eduardobastos
 */
public class AgendaArray {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String nome, telefone, email, input;
        Integer aux, opcao = 1;
        Agenda agenda;
        ArrayList<Agenda> contatoList = new ArrayList<Agenda>();

        while (opcao != 0) {
            System.out.println(
                    "Informe a operação desejada!\n"
                    + "[1]Adicionar\n[2]Mostrar\n"
                    + "[3]Editar\n[4]Excluir\n[0]Sair\n");

            opcao = scan.nextInt();
            scan.nextLine();
            switch (opcao) {

                case 1:
                    System.out.println("\nInforme o nome do contato: ");
                    nome = scan.nextLine();
                    System.out.println("\nInforme o telefone do contato: ");
                    telefone = scan.nextLine();
                    System.out.println("\nInforme o email do contato: ");
                    email = scan.nextLine();
                    
                    agenda = new Agenda();
                    agenda.adicionar(nome, telefone, email);
                    contatoList.add(agenda);
                    System.out.println("\nContato salvo com sucesso\n");

                    break;

                case 2:
                    if (!contatoList.isEmpty()) {
                        for (Agenda contato: contatoList) {
                            contato.mostrar();
                        }
                        System.out.println("\n\n");
                    } else {
                        System.out.println("\nNenhum contato salvo\n");
                    }
                    break;

                case 3:
                    System.out.println("\nInforme o index desejado");
                    aux = scan.nextInt();
                    if (aux < contatoList.size()) {
                        System.out.println("\nInforme qual opção gostaria de alterar:\n[1]Nome\n[2]Telefone\n[3]Email\n");
                        opcao = scan.nextInt();
                        System.out.println("\nInforme a alteração: ");
                        scan.nextLine();
                        input = scan.nextLine();
                        contatoList.get(aux).editar(opcao, input);
                        System.out.println("\nContato alterado com sucesso!\n");
                    } else {
                        System.out.println("\nContato não encontrado\n");
                    }
                    break;

                case 4:
                    System.out.println("\nInforme o index desejado");
                    aux = scan.nextInt();
                    if (aux < contatoList.size()) {
                        contatoList = new Agenda().excluir(contatoList, aux);
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
