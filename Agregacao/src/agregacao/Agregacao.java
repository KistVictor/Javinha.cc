/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agregacao;

import java.util.Date;

/**
 *
 * @author eduardobastos
 */
public class Agregacao {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Pagamento pagamento = new Pagamento();
        pagamento.setValor(150);
        pagamento.setValorPago(100);
        pagamento.setTipoPagamento(new TipoPagamento(new Date(1625194800000L)));
        System.out.println(pagamento.getTipoPagamento().getDiasFaturamento());
        System.out.println(pagamento.getTipoPagamento().getPorcentagemFinanceiraPaga(pagamento.getValor(), pagamento.getValorPago()));
    }
    
}
