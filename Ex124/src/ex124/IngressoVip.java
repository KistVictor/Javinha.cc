/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex124;

/**
 *
 * @author Carlos
 */
public class IngressoVip extends Ingresso {

    private String localizacao;
    private float percentual;

    public IngressoVip(Float valor, CamaroteEnum camarote) {
        super(valor);
        this.localizacao = camarote.getLocalizacao();
    }

    @Override
    public String toString() {
        return "Ingresso VIP - Valor: " + retornaValor();
    }

    public float retornaValor() {
        return this.valor + ((this.valor * this.percentual) / 100);
    }

    public String getLocalizacao() {
        return this.localizacao;
    }

    public void setLocalizacao(CamaroteEnum camarote) {
        this.localizacao = camarote.getLocalizacao();
        if (this.localizacao == CamaroteEnum.CAMAROTE_SUPERIOR.getLocalizacao()) {
            this.percentual = CamaroteEnum.CAMAROTE_SUPERIOR.percentual;
        } else {
            this.percentual = CamaroteEnum.CAMAROTE_INFERIOR.percentual;
        }
    }
//
}
