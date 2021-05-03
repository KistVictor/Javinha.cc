public class Patrola {
    private String cor;
    private String marca;
    private Boolean ligado = false;
    private int marcha = 0;

    public Patrola(String cor, String marca) {
        this.cor = cor;
        this.marca = marca;
    }

    public void mostrarCaracteristicas() {
        System.out.println(this.cor);
        System.out.println(this.marca);
        System.out.println(this.ligado);
        System.out.println(this.marcha);
    }

    public void ligar() {
        if (this.ligado == false) {
            this.ligado = true;
            Systen.out.println("Motor liga");
        } else {
            Systen.out.println("Nada acontece");
        }
    }

    public void andar() {
        if (this.ligado == true)
            this.marcha = 1;
        else
            Systen.out.println("Nada acontece");
    }

    public void reduzirMarcha() {
        if (this.marcha != 1 && this.ligado == true && this.marcha != 0) {
            this.marcha = this.marcha - 1;
            Systen.out.println("Marcha: " + this.marcha);
        } else {
            Systen.out.println("Nada acontece");
        }
    }

    public void subirMarcha() {
        if (this.marcha != 3 && this.ligado == true && this.marcha != 0) {
            this.marcha = this.marcha + 1;
            Systen.out.println("Marcha: " + this.marcha);
        } else {
            Systen.out.println("Nada acontece");
        }
    }

    public void desligar() {
        if (this.ligado == true) {
            this.ligado = false;
            this.marcha = 0;
            Systen.out.println("Motor desliga");
        } else {
            Systen.out.println("Nada acontece");
        }
    }
    
}
