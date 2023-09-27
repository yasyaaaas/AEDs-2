public class PP2 {
    public static void main(String[] args) {
        String frase;
        char[] resp = new char[1000];
        char[] conteudo = new char[1000];
        while (true) {
            frase = MyIO.readLine();
            if (frase.charAt(0) == 'F' && frase.charAt(1) == 'I' && frase.charAt(2) == 'M') {
                break;
            }
            for (int i = 0; i < frase.length(); i++) {
                conteudo[i] = frase.charAt(i);
            }
            int entrada = 0; // cooca na ordem dentro do array
            if (frase.length() > 0 && conteudo[0] != ' ') {
                resp[entrada] += conteudo[0];
                entrada++;
            }
            for (int i = 0; i < frase.length(); i++) {
                if (conteudo[i] == ' ' && conteudo[i + 1] != ' ') {
                    resp[entrada] += conteudo[i + 1];
                    entrada++;
                }
            }
            for (int i = 0; i < entrada; i++) {
                MyIO.print(resp[i]);
            }
            MyIO.print("\n");

        }
    }
}