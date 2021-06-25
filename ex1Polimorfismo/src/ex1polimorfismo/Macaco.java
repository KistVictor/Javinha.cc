/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex1polimorfismo;

/**
 *
 * @author Carlos
 */
public class Macaco extends Animal{
    String som = "Uh Uh Ah Ah";
    
    @Override
    public String getSom() {
        return som;
    }
    public boolean correr() {
        System.out.println("O Macaco saiu correndo...");
        return true;
    }
}
