import java.util.Scanner;

public class pp2ot {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while (s.hasNext()) {
            int n = Integer.parseInt(s.nextLine());
            int tempoTotal = 0;
            int tempoAtual = 1;
            int resp = 0;
            for (int x = 0; x < n; x++) {
                String linha = s.nextLine();
                String[] linha2 = linha.split(" ");
                int t = Integer.parseInt(linha2[0]);
                int c = Integer.parseInt(linha2[1]);

                int espera = tempoAtual - t;
                if (espera < 0) {
                    espera = 0; // espera
                }
                tempoTotal += espera + c;

                // Atualiza o tempo atual para o próximo processo
                tempoAtual += c;

                if (n == t) {
                    tempoTotal = 0;
                    resp = tempoTotal;
                } else {
                    resp = tempoTotal;
                }
            }
            System.out.println(resp);
        }
        s.close();
    }
}
