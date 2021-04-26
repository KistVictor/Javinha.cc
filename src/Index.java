import java.util.Scanner;

public class Index {
    public Index() {
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        float num1 = scan.nextInt();
        Nota x = new Nota(num1);
        float num2 = scan.nextInt();
        Nota y = new Nota(num2);
        //System.out.println(num1 + " " + num2);
        float media = x.media(y._numero);

        
    }
}