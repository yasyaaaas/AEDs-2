public class Is {
    private static boolean IsVog(String pal) {
        String vogal = "aeiouAEIOU"; // crio uma string de vogais
        for (int i = 0; i < pal.length(); i++) {
            boolean isVogal = false; // começamos com um false para o isVogal
            char charAtual = pal.charAt(i); // o charAtual nos mostra em qual char da string nos estamos

            for (int j = 0; j < vogal.length(); j++) { // criamos outro for só que com o tamanho da vogal
                if (charAtual == vogal.charAt(j)) { // se o char atual foi igual a algum do char da vogal
                    isVogal = true; // o isVogal é verdade
                    break; // e assim quebra o programa
                }
            }

            if (!isVogal) {
                return false; // se o char atual não for vogal, retorna falso
            }
        }
        return true; // no final se retorna o true
    }

    private static boolean IsConso(String pal) {
        String consoante = "bcdfghjklmnpqrstvwxyzBCDFGHJKLMNPQRSTWXYZ";
        for (int i = 0; i < pal.length(); i++) {
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
        }
        return true;
    }

    private static boolean IsInt(String pal) {
        for (int i = 0; i < pal.length(); i++) {
            char charAtual = pal.charAt(i); // char atual

            if (charAtual < '0' || charAtual > '9') { // olha se está entre fora de 0 e fora de 9, assim não sendo um
                                                      // char númerico
                return false; // Retorna false se encontrar um caractere não numérico
            }
        }
        return true;
    }

    private static boolean IsReal(String pal) {
        boolean pontoEncontrado = false; // olha se tem ponto
        int virgulaEncontrada = 0; // olha s etem virgula
        for (int i = 0; i < pal.length(); i++) {
            char c = pal.charAt(i); // char atual
            if (c >= '0' && c <= '9') { // olha se está entre fora de 0 e fora de 9, assim não sendo um
                                        // char númerico
                continue;
            } else if (c == '.' || c == ',' && !pontoEncontrado) { // se o c for um ponto ou uma virgula e o ponto não
                                                                   // for encontrado
                pontoEncontrado = true; // o ponto encontrado vira true
                virgulaEncontrada++; // adicionamos quantas virgulas achamos
            } else {
                return false; // Retorna false se encontrar um caractere não numérico
            }
        }
        if (virgulaEncontrada <= 1) { // se tiver apenas 1 virgula o programa aceita
            return true;
        }
        return true;
    }

    public static void main(String args[]) {
        String pal; // cria uma string
        while (true) {
            pal = MyIO.readLine(); // le a string
            if (pal.charAt(0) == 'F' && pal.charAt(1) == 'I' && pal.charAt(2) == 'M') {
                break;
            } // se for a palavra FIM encerra o programa
            boolean perg1 = IsVog(pal); // boolean para ver se é vogal
            boolean perg2 = IsConso(pal); // boolean para ver se é consoante
            boolean perg3 = IsInt(pal); // boolean para ver se é inteiro
            boolean perg4 = IsReal(pal); // boolean para ver se é real
            // aqui é uma sucessão de prints na tela se forem verdadeiros ou falsos os
            // booleans
            if (perg1) {
                MyIO.print("SIM");
            } else {
                MyIO.print("NAO");
            }
            if (perg2) {
                MyIO.print(" SIM");
            } else {
                MyIO.print(" NAO");
            }
            if (perg3) {
                MyIO.print(" SIM");
            } else {
                MyIO.print(" NAO");
            }
            if (perg4) {
                MyIO.print(" SIM\n");
            } else {
                MyIO.print(" NAO\n");
            }
        }
    }
}
