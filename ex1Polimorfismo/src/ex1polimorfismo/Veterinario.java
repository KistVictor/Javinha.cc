/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex1polimorfismo;

/**
 *
 * @author Kist
 */
public class Veterinario {

    String som;
    
    public String examinar(Animal animal){
        som = animal.getSom();
        if (animal.correr() == false)
            System.out.println("");
        return som;
    }
    
}