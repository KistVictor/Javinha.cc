/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex1polimorfismo;
import java.util.ArrayList;
import java.util.Arrays;
/**
 *
 * @author Kist
 */
public class Zoologico {


    public static void main(String[] args) {
        Veterinario vet = new Veterinario();

        Cachorro ca = new Cachorro();
        Coruja co = new Coruja();
        Galinha ga = new Galinha();
        Gato gato = new Gato();
        Macaco ma = new Macaco();
        Pato pa = new Pato();
        Pombo po = new Pombo();
        Vaca va = new Vaca();
        Pombo pombo = new Pombo();
        PorquinhoDaIndia porquinho = new PorquinhoDaIndia();

        ArrayList<Animal> animalList = new ArrayList<Animal>();
        animalList.addAll(Arrays.asList(ca, co, ga, gato, ma, pa, po, va, pombo, porquinho));

        for(int i = 0; i < animalList.size(); i++){
            System.out.println(vet.examinar(animalList.get(i)));
        }

    }
}