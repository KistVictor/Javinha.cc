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
public class Funcionario {
    protected String nome;
    protected String codigoFuncional;
    protected float renda;
    protected Cargo cargo;
    protected Comissao comissao;

    public Funcionario() {
        renda = 1000;
    }
    
    public void setRendaBasica() {
        renda = 1000;
    }
    
    public void setComissao() {
        comissao = new Comissao();
        if (cargo == Cargo.GERENTE) {
            comissao = new Gerente();
            comissao.setComissao();
        } else if (cargo == Cargo.SUPERVISOR) {
            comissao = new Supervisor();
            comissao.setComissao();
        } else if (cargo == Cargo.VENDEDOR) {
            comissao = new Vendedor();
            comissao.setComissao();
        }
    }
    
    @Override
    public String toString() {
        String retorno = "Nome do funcionario: " + nome;
        retorno += "\nComissão: " + comissao.getValor();
        retorno += "\nSalário Total: " + (renda + comissao.getValor());
        return retorno;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodigoFuncional() {
        return codigoFuncional;
    }

    public void setCodigoFuncional(String codigoFuncional) {
        this.codigoFuncional = codigoFuncional;
    }

    public Float getRenda() {
        return renda;
    }

    public void setRenda(Float renda) {
        this.renda = renda;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public Comissao getComissao() {
        return comissao;
    }

    public void setComissao(Comissao comissao) {
        this.comissao = comissao;
    }
    
}
