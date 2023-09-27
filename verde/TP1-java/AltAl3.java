import java.util.Random;

public class AltAl3 {
    public static void main(String args[]) {
        String frases; // cria uma string frase
        Random gerador = new Random(); // gera um novo Random
        gerador.setSeed(4); // seed = 4
        while (true) {
            frases = MyIO.readLine(); // lê a frase colocada
            if (frases.charAt(0) == 'F' && frases.charAt(1) == 'I' && frases.charAt(2) == 'M') {
                break;
            } // se for a palavra FIM encerra o programa
            char aleatorio1 = (char) ('a' + (Math.abs(gerador.nextInt()) % 26)); // gera letra aleatoria
            char aleatorio2 = (char) ('a' + (Math.abs(gerador.nextInt()) % 26)); // gera letra aleatoria
            char[] result = new char[frases.length()]; // cria um char para o resultado
            for (int i = 0; i < frases.length(); ++i) {
                char letra = frases.charAt(i); // ve se a letra da string é a letra a ser trocada
                if (letra == aleatorio1) { // se for
                    result[i] = aleatorio2;
                    ; // coloca a letra2 na frase
                } else { // se não
                    result[i] = letra;
                    ; // coloca a letra normal na frase
                }
            }
            String trocaFrase = new String(result); // cria uma string de troca de frase contemdo uma string do
                                                    // resultado
            MyIO.println(trocaFrase); // printa o resultado
        }
    }
}