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
public class FuncionarioEnsinoMedio extends FuncionarioEnsinoBasico {

    public FuncionarioEnsinoMedio() {
    }
    
    @Override
    public void setRendaBasica() {
        renda = renda * (float) 1.5;
    }
}
