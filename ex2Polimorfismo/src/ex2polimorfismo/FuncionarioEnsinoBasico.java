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
public class FuncionarioEnsinoBasico extends Funcionario {
    protected String escola;

    public FuncionarioEnsinoBasico() {
    }
    
    @Override
    public void setRendaBasica() {
        renda = renda * (float) 1.1;
    }
    
    public String getEscola() {
        return escola;
    }

    public void setEscola(String escola) {
        this.escola = escola;
    }
    
    
}
