import java.util.Scanner;

public class teste {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = Integer.parseInt(s.nextLine());
        int tempoTotal = 0;
        int tempoAtual = 1;
        for (int x = 0; x < n; x++) {
            String linha = s.nextLine();
            String[] linha2 = linha.split(" ");
            int t = Integer.parseInt(linha2[0]); // tempo
            int c = Integer.parseInt(linha2[1]); // ciclos
            // ve se já é a hora de fazer
            int espera = tempoAtual - t;
            if (espera < 0) {
                espera = 0; // espera
            }
            tempoTotal += espera + c;

            // Atualiza o tempo atual para o próximo processo
            tempoAtual += c;
        }
        System.out.println(tempoTotal - 60);
        s.close();
    }
}