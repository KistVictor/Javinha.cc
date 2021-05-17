package agendaarray;

import java.util.ArrayList;

public class Agenda {

    private String nome;
    private String telefone;
    private String email;

    public Agenda() {

    }

    public void adicionar(String nome, String telefone, String email) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
    }

    public void editar(Integer opcao, String input) {
        if (opcao == 1) {
            this.nome = input;
        } else if (opcao == 2) {
            this.telefone = input;
        } else if (opcao == 3) {
            this.email = input;
        }
    }

    public void mostrar() {
        System.out.println("------------------------------");
        System.out.println("Nome: " + this.nome);
        System.out.println("Telefone: " + this.telefone);
        System.out.println("Email: " + this.email);
    }

    public ArrayList<Agenda> excluir(ArrayList<Agenda> contatoList, Integer index) {
        if (!contatoList.isEmpty()) {
            contatoList.remove(contatoList.get(index));
        }
        return contatoList;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
