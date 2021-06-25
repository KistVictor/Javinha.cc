/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package composicao;

import java.util.Date;

/**
 *
 * @author eduardobastos
 */
public class Composicao {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Cliente cliente = new Cliente();
        cliente.setId("123456789");
        
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
        
        Pagamento pagamento = new Pagamento();
        pagamento.setValor(pedido.calclularValor());
        pagamento.setTipoPagamento(new TipoPagamento(new Date(1625194800000L)));
        
        Compra compra = new Compra();
        compra.adicionaPedido(pedido);
        compra.adicionaPagamento(pagamento);
        
        FichaCliente fichaCliente = new FichaCliente();
        fichaCliente.inicia();
        fichaCliente.setCliente(cliente);
        fichaCliente.setCompra(compra);
        compra.realizaCompra();
        fichaCliente.finaliza();
    }
    
}
