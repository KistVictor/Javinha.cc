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
public class Teste {

    public static void main(String[] args) {

        Veterinario vet = new Veterinario();

        Macaco ma = new Macaco();
        Cachorro ca = new Cachorro();
        Pato pa = new Pato();

        System.out.println(vet.examinar(ca));

        System.out.println(vet.examinar(pa));

        System.out.println(vet.examinar(ma));
    }
}
