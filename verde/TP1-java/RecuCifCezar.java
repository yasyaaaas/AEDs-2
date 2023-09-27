public class RecuCifCezar {
    private static String cifCezRecu(String cif, int i, String fraseNova) {
        if (i >= cif.length()) { // condição de parada para a nova frase
            return fraseNova; // quando chega na condição de parada retorna a fraseNova
        }
        if (cif.charAt(i) <= 127 && cif.charAt(i) >= 0) {// se o charAt(i) estiver entre a tabela ASCII
            char xifrado = (char) (cif.charAt(i) + 3);// pula 3 casas
            fraseNova += xifrado; // adiciona a fraseNova o char cifrado
        } else {// se não estiver entre a tabela ASCII
            char xifrado = (char) (cif.charAt(i));// não pula 3 casas
            fraseNova += xifrado; // adiciona a fraseNova o char cifrado
        }
        return cifCezRecu(cif, ++i, fraseNova); // chama recursivamnete a função
    }

    public static void main(String args[]) {
        String cif;// pegando a frase
        while (true) {
            cif = MyIO.readLine();
            if (cif.charAt(0) == 'F' && cif.charAt(1) == 'I' && cif.charAt(2) == 'M') {
                break;
            } // lendo a frase
            String resp = cifCezRecu(cif, 0, ""); // cria uma String para a resposta e coloca nessa string uma função
                                                  // que leva a frase o 0 para o i, e o início de uma fraseNova
            MyIO.println(resp);
        }
    }

}
