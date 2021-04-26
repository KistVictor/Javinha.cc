public class Nota {
    float _numero;

    public Nota(float numero) {
        this._numero = numero;
    }

    public float media(float[] notas) {
        //System.out.println(this._numero + " " + y);
        float soma;
        for (int i = 0; i < 3; i++)
            soma += notas[i];
        float media = soma/3;
        return media;
    }
}