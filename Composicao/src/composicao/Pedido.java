/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package composicao;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author eduardobastos
 */
public class Pedido {

    private List<Produto> produtoList;

    public Pedido() {
    }

    public void iniciar() {
        produtoList = new ArrayList<>();
    }

    public void adicionarProduto(Produto produto) {
        produtoList.add(produto);
    }

    public float calclularValor() {
        float valor = 0;
        for (Produto produto : produtoList) {
            valor += produto.getPreco() * produto.getQuantidade();
        }
        return valor;
    }

    public List<Produto> getProdutoList() {
        return produtoList;
    }

    public void setProdutoList(List<Produto> produtoList) {
        this.produtoList = produtoList;
    }

}
