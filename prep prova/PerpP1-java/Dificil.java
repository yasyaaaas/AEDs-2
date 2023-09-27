import java.util.Locale;
import java.util.Scanner;

public class Dificil {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US); // le ponto
        double num = 0.0;
        double margem;
        while (scanner.hasNext()) {
            num = scanner.nextDouble();
            int numInt = (int) (num);
            margem = scanner.nextDouble();
            num -= numInt;
            if (num > margem) {
                System.out.println(numInt + 1);
            } else if (num < margem) {
                System.out.println(numInt);
            }
        }
        scanner.close();
    }
}
