/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex2polimorfismo;

/**
 *
 * @author eduardobastos
 */
public class Gerente extends Comissao {

    public Gerente() {
    }
    
    @Override
    public void setComissao() {
        valor = 1500;
    }
}
