/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assossiacao;

/**
 *
 * @author eduardobastos
 */
public class Assossiacao {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Frios mortadela = new Frios();
        mortadela.setPreco(5);
        mortadela.setQuantidade(2);
        
        Paozinho cacetinho = new Paozinho();
        cacetinho.setPreco(4);
        cacetinho.setQuantidade(10);
        
        Doces brigadeiro = new Doces();
        brigadeiro.setPreco(10);
        brigadeiro.setQuantidade(5);
        
        Pedido pedido = new Pedido();
        pedido.iniciar();
        pedido.adicionarProduto(mortadela);
        pedido.adicionarProduto(cacetinho);
        pedido.adicionarProduto(brigadeiro);
        
        System.out.println("O valor final do pedido é R$ " + pedido.calclularValor());
    }
    
}
