/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex124;

/**
 *
 * @author eduardobastos
 */
public enum CamaroteEnum {
    CAMAROTE_SUPERIOR(50), CAMAROTE_INFERIOR(70);
    
    float percentual;
    
    CamaroteEnum(float percentual) {
        this.percentual = percentual;
    }
    
    public String getLocalizacao() {
        switch (this) {
            case CAMAROTE_SUPERIOR:
                return "Camarote Superior";
            case CAMAROTE_INFERIOR:
                return "Camarote Inferior";
            default:
                return "";
        }
    }
}
