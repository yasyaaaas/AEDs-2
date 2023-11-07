import java.util.Scanner;

public class Bhaskara {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        double num1, num2, num3;
        while (s.hasNext()) {
            num1 = s.nextDouble();
            num2 = s.nextDouble();
            num3 = s.nextDouble();
            if (num1 == 0 || num2 == 0 || num3 == 0) {
                System.out.println("Impossivel calcular");
            } else {
                double delta = num2 * num2 - 4 * num1 * num3;
                if (delta < 0) {
                    System.out.println("Impossivel calcular");
                } else {
                    double root1 = (-num2 + Math.sqrt(delta)) / (2 * num1);
                    double root2 = (-num2 - Math.sqrt(delta)) / (2 * num1);
                    System.out.printf("R1 = %.5f%n", root1);
                    System.out.printf("R2 = %.5f%n", root2);
                }
            }
        }
        s.close();
    }
}
