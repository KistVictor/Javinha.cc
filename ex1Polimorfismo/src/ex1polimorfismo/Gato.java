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
public class Gato extends Animal{
    String som = "Miau Miaaaau";
    
    @Override
    public String getSom() {
        return som;
    }
    public boolean correr() {
        System.out.println("O Gato saiu correndo...");
        return true;
    }
}
