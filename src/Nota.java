public class Nota {
    float _numero;

    public Nota(float numero) {
        this._numero = numero;
    }

    public float media(float y) {
        //System.out.println(this._numero + " " + y);
        return (this._numero + y) / 2;
    }
}