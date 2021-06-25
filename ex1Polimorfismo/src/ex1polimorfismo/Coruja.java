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
public class Coruja extends Animal{
    String som = "UUUUUHHHH UHHHH";
    
    @Override
    public String getSom() {
        return som;
    }
}
