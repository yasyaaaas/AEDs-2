public class RecuPal {
    public static boolean ehPalinRecu(String pal, int i, int end) {
        if (i >= end) {
            return true; // condição de parada
        }
        if (pal.charAt(i) != pal.charAt(end)) {
            return false; // se o char do início não foi igual o char do final para
        }
        return ehPalinRecu(pal, ++i, --end); // chama recursivamente a função
    }

    public static boolean ehPalin(String pal) {
        String mod = removeESpacoEtracos(pal, 0); // Usa a função para remover espaços e traços
        return ehPalinRecu(mod, 0, mod.length() - 1); // chama recursivamente a função
    }

    private static String removeESpacoEtracos(String pal, int i) {
        if (i >= pal.length()) {
            return ""; // condição de parada = string vazia
        }
        char c = pal.charAt(i); // criamos um char parea ver o char está agora
        if (c != ' ' && c != '-') { // se o char for ' ' ou '-'
            return c + removeESpacoEtracos(pal, i + 1); // chamamos recursivamente mais um c par irmos para o proximo
                                                        // char e a função e vamos para o proximo char
        }
        return removeESpacoEtracos(pal, i + 1); // chamamos recursivamente a função e vamos para o proximo char
    }

    public static void main(String args[]) {
        String pal; // pega uma string
        while (true) {
            pal = MyIO.readLine(); // le a string
            if (pal.charAt(0) == 'F' && pal.charAt(1) == 'I' && pal.charAt(2) == 'M') {
                break;
            } // se for a palavra FIM encerra o programa

            if (ehPalin(pal)) { // se a palavra for um palindromo printa SIM
                System.out.println("SIM");
            } else { // se a palavra não for um palindromo printa NAO
                System.out.println("NAO");
            }
        }
    }
}
