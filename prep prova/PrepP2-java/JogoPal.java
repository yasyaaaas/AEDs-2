import java.util.Scanner;

public class JogoPal {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String linha;
        while (s.hasNext()) {
            linha = s.nextLine();
            int tam = linha.length();
            int dif = 0;
            int i = 0;
            int j = tam - 1;
            while (i < j) {
                if (linha.charAt(i) == linha.charAt(j)) {
                    i++;
                    j--;
                } else {
                    dif++;
                    j--;
                }
            }
            System.out.println(dif);
        }
        s.close();
    }
}
