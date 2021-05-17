package agendavetor;

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

    public Agenda[] excluir(Agenda contato[], Integer index, Integer tamanho) {
        if (contato[index] != null) {
            for (int i = index; i < tamanho - 1; i++) {
                if (contato[i] == null) {
                    break;
                }
                contato[i] = contato[i + 1];
            }
        }
        return contato;
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
