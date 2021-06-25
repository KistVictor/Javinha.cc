/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package composicao;

/**
 *
 * @author eduardobastos
 */
public class FichaCliente {

    private Cliente cliente;
    private Compra compra;

    public FichaCliente() {
    }

    public void inicia() {
        System.out.println("Ficha inicializada");
    }

    public void finaliza() {
        if (compra.getCompraRealizada()) {
            System.out.println("Ficha do cliente finalizada com sucesso!");
        } else {
            System.out.println("Impossível finalizar ficha do cliente com compra não realizada!");
        }
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Compra getCompra() {
        return compra;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }

}
