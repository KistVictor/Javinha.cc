/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex124;

/**
 *
 * @author Carlos
 */
public class IngressoNormal extends Ingresso{
    
    public IngressoNormal(float valor) {
        super(valor);
    }
    
    @Override
    public String toString(){
        return "Ingresso Normal: " + super.retornaValor();
    
    }
}
