import java.util.Scanner;

class prova1 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String frase;
        char[] fraseC = new char[100];
        char[] resp = new char[100];
        int contador = 0;
        while (s.hasNext()) {
            frase = s.nextLine();
            int index = 0;
            if (fraseC[0] != ' ') {
                resp[index] = fraseC[0];
                index++;
            }
            for (int i = 0; i < frase.length(); i++) {
                fraseC[i] = frase.charAt(i);
            }
            for (int i = 0; i < frase.length(); i++) {
                if (fraseC[i] == ' ') {
                    resp[index] = fraseC[i + 1];
                    index++;
                }
            }
            for (int i = 0; i < index; i++) {
                if (resp[i] == resp[i + 1] && resp[i + 1] == resp[i + 2]) {
                    contador++;
                } else if (resp[i] != resp[i + 1] && resp[i + 1] != resp[i + 2]) {
                    contador = 0;
                } else if (resp[i] == resp[i + 1] && resp[i] != resp[i - 1]) {
                    contador++;
                }
            }
            if (contador == 1) {
                contador++;
            }
            System.out.println(contador);
        }
        s.close();
    }
}