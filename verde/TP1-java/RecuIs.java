public class RecuIs {
    private static boolean IsVog(String pal, int i) {
        String vogal = "aeiouAEIOU"; // crio uma string de vogais
        if (i >= pal.length()) {
            return true; // condição de parada: todos os caracteres verificados são vogais
        }
        char charAtual = pal.charAt(i); // cria um char atual que é aonde char da palavra está
        boolean isVogal = false; // // começamos com um false para o isVogal
        for (int j = 0; j < vogal.length(); j++) { // criamos outro for só que com o tamanho da vogal
            if (charAtual == vogal.charAt(j)) { // se o char atual foi igual a algum do char da vogal
                isVogal = true; // o isVogal é verdade
                break; // e assim quebra o programa
            }
        }
        if (!isVogal) {
            return false; // se o char atual não for vogal, retorna falso
        }
        return IsVog(pal, ++i); // chama recursivamente a função
    }

    private static boolean IsConso(String pal, int i) {
        String consoante = "bcdfghjklmnpqrstvwxyzBCDFGHJKLMNPQRSTWXYZ";
        if (i >= pal.length()) { // condição de parada
            return true;
        }
        boolean isConso = false; // começamos com um false para o isConso
        char charAtual = pal.charAt(i); // o charAtual nos mostra em qual char da string nos estamos
        for (int j = 0; j < consoante.length(); j++) { // criamos outro for só que com o tamanho da consoante
            if (charAtual == consoante.charAt(j)) { // se o char atual foi igual a algum do char da consoante
                isConso = true; // o isConso é verdade
                break; // e assim quebra o programa
            }
        }
        if (!isConso) {
            return false; // se o char atual não for consoante, retorna falso
        }
        return IsConso(pal, ++i); // chama recursivamente a função
    }

    private static boolean IsInt(String pal, int i) {
        if (i >= pal.length()) {
            return true;
        }
        char charAtual = pal.charAt(i); // char atual
        if (charAtual < '0' || charAtual > '9') { // olha se está entre fora de 0 e fora de 9, assim não sendo um
                                                  // char númerico
            return false; // Retorna false se encontrar um caractere não numérico
        }
        return IsInt(pal, ++i); // chama recursivamente a função
    }

    private static boolean IsReal(String pal, int i) {
        boolean pontoEncontrado = false; // olha se tem ponto
        int virgulaEncontrada = 0; // olha s etem virgula
        if (i >= pal.length()) {
            return true;
        }
        char c = pal.charAt(i); // char atual
        if (c >= '0' && c <= '9') { // se o c for um ponto ou uma virgula e o ponto não for encontrado
            // continue;
        } else if (c == '.' || c == ',' && !pontoEncontrado) { // se o c for um ponto ou uma virgula e o ponto não for
                                                               // encontrado
            pontoEncontrado = true; // o ponto encontrado vira true
            virgulaEncontrada++; // adicionamos quantas virgulas achamos
        } else {
            return false; // Retorna false se encontrar um caractere não numérico
        }
        if (virgulaEncontrada <= 1) { // se tiver apenas 1 virgula o programa aceita
            return true;
        }
        return IsReal(pal, ++i); // chama recursivamente a função
    }

    public static void main(String args[]) {
        String pal; // cria uma string
        while (true) {
            pal = MyIO.readLine(); // le a string
            if (pal.charAt(0) == 'F' && pal.charAt(1) == 'I' && pal.charAt(2) == 'M') {
                break;
            } // se for a palavra FIM encerra o programa
            boolean perg1 = IsVog(pal, 0); // boolean para ver se é vogal
            boolean perg2 = IsConso(pal, 0); // boolean para ver se é consoante
            boolean perg3 = IsInt(pal, 0); // boolean para ver se é inteiro
            boolean perg4 = IsReal(pal, 0); // boolean para ver se é real
            // aqui é uma sucessão de prints na tela se forem verdadeiros ou falsos os
            // booleans
            if (perg1) {
                System.out.print("SIM");
            } else {
                System.out.print("NAO");
            }
            if (perg2) {
                System.out.print(" SIM");
            } else {
                System.out.print(" NAO");
            }
            if (perg3) {
                System.out.print(" SIM");
            } else {
                System.out.print(" NAO");
            }
            if (perg4) {
                System.out.print(" SIM\n");
            } else {
                System.out.print(" NAO\n");
            }
        }
    }
}
