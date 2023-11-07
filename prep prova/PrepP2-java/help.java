import java.util.Scanner;

public class help {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = 0;
        while (true) {
            n = Integer.parseInt(s.nextLine());
            if (n == 0) {
                break;
            }
            int sa = 0; // correto
            int p = 0; // num tempo + vinte se for incorreto
            for (int k = 0; k < n; k++) {
                String linha = s.nextLine();
                String[] array = linha.split(" ");
                // String iden = array[0];
                int tempo = Integer.parseInt(array[1]);
                String j = array[2];
                if (j.equals("correct")) {
                    sa++;
                    p += tempo;
                } else if (j.equals("incorrect")) {
                    p -= 20;
                }
                if (p < 0) {
                    p = 0;
                }
            }
            System.out.println(sa + " " + p);
        }
        s.close();
    }
}
