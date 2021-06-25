/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package composicao;

import java.util.Date;

/**
 *
 * @author eduardobastos
 */
public class TipoPagamento {

    private Date dtVencimento;

    public TipoPagamento(Date dtVencimento) {
        this.dtVencimento = dtVencimento;
    }

    public int getDiasFaturamento() {
        Date hoje = new Date();
        System.out.println(hoje);
        long tempo = (dtVencimento.getTime() - hoje.getTime()) + 3600000L;
        long diasFaturamento = (tempo / 86400000L);
        return (int) diasFaturamento;
    }

    public float getPorcentagemFinanceiraPaga(float valor, float valorPago) {
        return valorPago * 100 / valor;
    }

    public Date getDtVencimento() {
        return dtVencimento;
    }

    public void setDtVencimento(Date dtVencimento) {
        this.dtVencimento = dtVencimento;
    }

}
