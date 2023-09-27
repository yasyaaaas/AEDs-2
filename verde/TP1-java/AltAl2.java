import java.util.Random;

// 76%
public class AltAl2 {
    public static void main(String args[]) {
        String frases;
        Random gerador = new Random();
        gerador.setSeed(4);
        while (true) {
            frases = MyIO.readLine();
            if (frases.equals("FIM")) {
                break;
            }
            String newFrase = trocaLet(frases, 0);
            MyIO.println(newFrase);
        }
    }

    private static String trocaLet(String frase, int i) {
        if (i >= frase.length()) {
            return frase; // Condição de parada da recursão
        }
        Random gerador = new Random();
        gerador.setSeed(4);
        char aleatorio1 = (char) ('a' + (Math.abs(gerador.nextInt()) % 26)); // gera letra aleatoria
        char aleatorio2 = (char) ('a' + (Math.abs(gerador.nextInt()) % 26)); // gera letra aleatoria
        StringBuilder result = new StringBuilder(); // cria a string so result
        char letra = frase.charAt(i); // ve se a letra da string é a letra a ser trocada
        if (letra == aleatorio1) {
            result.append(aleatorio2);
        } else {
            result.append(letra);
        }
        return trocaLet(frase, i + 1);
        /*
         * iterativo
         * for(int i=0; i<pal.length(); i++){
         * char letra = pal.charAt(i); // ve se a letra da string é a letra a ser
         * trocada
         * if (letra == aleat1) {
         * result.append(aleat2);
         * } else {
         * result.append(letra);
         * }
         * trocaLet(pal, i++);
         * }
         */
    }
}
