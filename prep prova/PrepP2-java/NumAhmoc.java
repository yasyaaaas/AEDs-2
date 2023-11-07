import java.util.Scanner;

public class NumAhmoc {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int h = 1; // contador (instancia 1, 2...)
        String instancia;
        while (true) {
            instancia = s.nextLine();
            if (instancia.charAt(0) == '0') {
                break;
            }
            String seq = s.nextLine();
            if (seq.contains(instancia)) {
                System.out.println("Instancia " + h);
                System.out.println("verdadeira");
            } else {
                System.out.println("Instancia " + h);
                System.out.println("falsa");
            }
            h++;
        }
        s.close();
    }
}
