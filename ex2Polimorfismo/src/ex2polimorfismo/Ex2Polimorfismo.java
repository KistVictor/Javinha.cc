/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex2polimorfismo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author eduardobastos
 */
public class Ex2Polimorfismo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<Funcionario> empresa = new ArrayList<>();
        Funcionario funcionario = new Funcionario();
        float gastoFuncionario = 0;
        float gastoFuncionarioEnsinoBasico = 0;
        float gastoFuncionarioEnsinoMedio = 0;
        float gastoFuncionarioGraduacao = 0;

        for (int i = 0; i < 10; i++) {
            if (i < 4) {
                funcionario = new FuncionarioEnsinoBasico();
                funcionario.setCargo(Cargo.VENDEDOR);
            } else if (i < 8) {
                funcionario = new FuncionarioEnsinoMedio();
                funcionario.setCargo(Cargo.SUPERVISOR);
            } else {
                funcionario = new FuncionarioGraduacao();
                funcionario.setCargo(Cargo.GERENTE);
            }
            funcionario.setRendaBasica();
            funcionario.setComissao();
            empresa.add(funcionario);
        }

        for (Funcionario func : empresa) {
            if (func instanceof FuncionarioGraduacao) {
                gastoFuncionarioGraduacao += func.getRenda();
            } else if (func instanceof FuncionarioEnsinoMedio) {
                gastoFuncionarioEnsinoMedio += func.getRenda();
            } else if (func instanceof FuncionarioEnsinoBasico) {
                gastoFuncionarioEnsinoBasico += func.getRenda();
            } else if (func instanceof Funcionario) {
                gastoFuncionario += func.getRenda();
            }
        }

        System.out.println("Gastos com funcionários sem estudo: " + gastoFuncionario);
        System.out.println("Gastos com funcionários com ensino basico: " + gastoFuncionarioEnsinoBasico);
        System.out.println("Gastos com funcionários com ensino fundamental: " + gastoFuncionarioEnsinoMedio);
        System.out.println("Gastos com funcionários com graduação: " + gastoFuncionarioGraduacao);
        
        
        
        System.out.println("\n\n");
        for (Funcionario func : empresa) {
            System.out.println(func.toString());
        }
    }

}
