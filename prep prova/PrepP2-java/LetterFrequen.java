import java.util.Scanner;

// parece uma que eles pediriam
// OLHAR ANTES DA PROVA!!!!!
public class LetterFrequen {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int numCaso = s.nextInt();
        s.nextLine();
        String linha;
        for (int j = 0; j < numCaso; j++) {
            linha = s.nextLine().toLowerCase();
            int[] cont = new int[26]; // aray de contadores (seria o contA, contB)
            for (int i = 0; i < linha.length(); i++) {
                char carac = linha.charAt(i); // carac vai ser a atual letra da string frase
                if (carac >= 'a' && carac <= 'z') {
                    int index = carac - 'a'; // vai vendo cala letra da string
                    // a vira 0, b vira 1
                    cont[index]++; // qabdo aparece a o index de aumenta...
                }
            }
            // olha maior
            int maxCount = 0;
            for (int i = 0; i < 26; i++) {
                if (cont[i] > maxCount) {
                    maxCount = cont[i];
                }
            }
            // resultado
            String result = "";
            for (int i = 0; i < 26; i++) {
                if (cont[i] == maxCount) {
                    char letra = (char) ('a' + i);
                    result += letra;
                }
            }
            System.out.println(result);
        }
        s.close();
    }
}
