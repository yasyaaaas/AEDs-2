public class PP2ver2 {
    // não da tem que mudar pra char
    public static void main(String[] args) {
        String frase;
        char[] auau = new char[1000];
        char[] resp = new char[1000]; // inicializa a resposta com nada
        while (true) {
            frase = MyIO.readLine();
            if (frase.charAt(0) == 'F' && frase.charAt(1) == 'I' && frase.charAt(2) == 'M') {
                break;
            }
            int gato = 0;
            for (int i = 0; i < frase.length(); i++) { // passa de string para char
                auau[i] = frase.charAt(i);
            }
            // for (int i = 0; i < frase.length(); i++) { NÃO TEM FOR BURRA SENÃO FICA
            // REPETINDO A INICIAL
            // !!!!!!!!!!
            if (auau[0] != ' ') {
                resp[gato] += auau[0];
                gato++;
            }
            // }
            for (int i = 0; i < frase.length(); i++) {
                if (auau[i] == ' ' && auau[i + 1] != ' ') {
                    resp[gato] += auau[i + 1];
                    gato++;
                }
            }
            for (int i = 0; i < gato; i++) {
                MyIO.print(resp[i]);
            }
            MyIO.print("\n");
        }
    }
}
