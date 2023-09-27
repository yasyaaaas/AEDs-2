public class CifraCezar {
    public static void main(String args[]) {
        String cif;// pegando a frase
        while (true) {
            cif = MyIO.readLine(); // lendo a frase
            if (cif.charAt(0) == 'F' && cif.charAt(1) == 'I' && cif.charAt(2) == 'M') {
                break;
            } // se for a palavra FIM encerra o programa
            String fraseNova = ""; // cria uma nova string de frase
            for (int i = 0; i < cif.length(); i++) {
                if (cif.charAt(i) <= 127 && cif.charAt(i) >= 0) { // se o charAt(i) estiver entre a tabela ASCII
                    char xifrado = (char) (cif.charAt(i) + 3);// pula 3 casas
                    fraseNova += xifrado; // adiciona a fraseNova o char cifrado
                } else { // se não estiver entre a tabela ASCII
                    char xifrado = (char) (cif.charAt(i));// não pula 3 casas
                    fraseNova += xifrado; // adiciona a fraseNova o char cifrado
                }
            }
            MyIO.println(fraseNova); // printa frase nova
        }
    }
}
