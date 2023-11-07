import java.util.Scanner;

public class BalancoPar {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while (s.hasNext()) {
            String linha = s.nextLine();
            int cont1 = 0;
            int cont2 = 0;
            for (int i = 0; i < linha.length(); i++) {
                if (linha.charAt(i) == '(') {
                    cont1++;
                }
                if (linha.charAt(i) == ')') {
                    cont2++;
                }
            }
            if (cont1 == cont2) {
                System.out.println("correct");
            } else {
                System.out.println("incorrect");
            }
        }
        s.close();
    }
}
