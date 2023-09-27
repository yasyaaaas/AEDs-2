public class PalindromoMyIO {
    public static boolean ehPalin(String pal) {
        int left = 0; // esquerda comça com 0
        int right = pal.length() - 1; // direita começa no tamanho -1

        while (left < right) { // enquanto a esquerda for menor que a direita
            // Encontre o próximo caractere válido da esquerda
            while (left < right && !ehLetraouDig(pal.charAt(left))) {
                left++;
            }

            // Encontre o próximo caractere válido da direita
            while (left < right && !ehLetraouDig(pal.charAt(right))) {
                right--;
            }

            // Compare os caracteres sem considerar maiúsculas/minúsculas
            if ((pal.charAt(left)) != (pal.charAt(right))) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    public static boolean ehLetraouDig(char c) { // ve se o char é letra ou um dígito, e não um espaço
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9');
    }

    public static void main(String args[]) {
        String pal; // pega a string
        while (true) { // enquanto não for o break o código continua
            pal = MyIO.readLine(); // le a String que entra
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
