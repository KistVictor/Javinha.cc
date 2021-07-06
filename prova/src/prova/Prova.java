package prova;

import java.util.ArrayList;

public class Prova {

    public static void main(String[] args) {
        // lista que suporta Círculos e Esferas
        ArrayList<FiguraGeometrica> lst = new ArrayList();

        // somente o raio é passado no construtor
        // X, Y, Z e largura da linha permanecem zerados
        lst.add(new Esfera(2439.7f));       // Planeta Mercúrio
        lst.add(new Esfera(6051.8f));       // Planeta Vênus
        lst.add(new Esfera(6371f));         // Planeta Terra
        lst.add(new Circulo(149597870f));   // Órbita da Terra
        lst.add(new Esfera(3389.5f));       // Planeta Marte

        float somaVolume = 0;
        for (int i = 0; i < lst.size(); i++) {
            FiguraGeometrica f = lst.get(i);    // obtendo o planeta em questão
            System.out.println(f.toString());   // imprimindo suas características

            if (f instanceof ICalculos3D)       // se é dessa interface posso fazer o CAST e calcular
            {
                somaVolume += ((ICalculos3D) f).calcularVolume();
            }

            System.out.println("----------------------------");
        }
        System.out.printf("\nA soma do volume dos planetas é: %.2f\n", somaVolume);
    }
}