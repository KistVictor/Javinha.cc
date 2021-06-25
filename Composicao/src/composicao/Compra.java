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
public class Compra {

    private List<Pedido> pedidoList;
    private List<Pagamento> pagamentoList;
    private float valorTotal;
    private Boolean compraRealizada;

    public Compra() {
        this.pedidoList = new ArrayList<>();
        this.pagamentoList = new ArrayList<>();
    }
    
    public void adicionaPedido(Pedido pedido) {
        pedidoList.add(pedido);
    }
    
    public void adicionaPagamento(Pagamento pagamento) {
        pagamentoList.add(pagamento);
    }

    public void realizaCompra() {
        for(Pagamento pagamento: pagamentoList) {
            pagamento.setValorPago(pagamento.getValor());
        }
        compraRealizada = true;
    }

    public List<Pedido> getPedidoList() {
        return pedidoList;
    }

    public void setPedidoList(List<Pedido> pedidoList) {
        this.pedidoList = pedidoList;
    }

    public List<Pagamento> getPagamentoList() {
        return pagamentoList;
    }

    public void setPagamentoList(List<Pagamento> pagamentoList) {
        this.pagamentoList = pagamentoList;
    }

    public float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Boolean getCompraRealizada() {
        return compraRealizada;
    }

    public void setCompraRealizada(Boolean compraRealizada) {
        this.compraRealizada = compraRealizada;
    }
}
