import java.util.Scanner;

public class CezarCifra {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int numCaso;
        String frase;
        int cif;
        numCaso = s.nextInt();
        for (int i = 0; i < numCaso; i++) {
            frase = s.next();
            cif = s.nextInt();
            String resp = "";
            for (int j = 0; j < frase.length(); j++) {
                if (frase.charAt(j) <= 90 && frase.charAt(j) >= 65) { // se o charAt(i) estiver entre a tabela ASCII
                    char nf = (char) (frase.charAt(j) + cif);
                    resp += nf;
                } else {
                    char nf = (char) (frase.charAt(j));
                    resp += nf;
                }
            }
            System.out.println(resp);
        }
        s.close();
    }
}
