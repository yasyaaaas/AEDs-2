import java.util.Scanner;

// Exception in thread "main" java.lang.NumberFormatException: For input string: "100 80 90"
// pq nao pode converter a string p/ inteiros
// espqco em branco, ler a string (linha) e depois fazer String[] arr = linha.split(" ")

public class WU1ver2 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int numTest = 0;
        numTest = Integer.parseInt(s.nextLine());
        for (int k = 0; k < numTest; k++) {
            int numCri = Integer.parseInt(s.nextLine());
            int[] posi = new int[numCri];

            int[] posi2 = new int[numCri];
            // String crianca = s.nextLine();
            int dif = 0;
            // String[] arr = crianca.split(" ");
            for (int i = 0; i < numCri; i++) {
                posi[i] = Integer.parseInt(s.nextLine());
            }
            for (int i = 0; i < numCri; i++) {
                posi2[i] = posi[i];
            }
            for (int i = 0; i < (posi.length - 1); i++) {
                int menor = i;
                for (int j = (i + 1); j < posi.length; j++) {
                    if (posi[menor] < posi[j]) {
                        menor = j;
                    }
                }
                int temp = posi[menor];
                posi[menor] = posi[i];
                posi[i] = temp;
            }
            for (int i = 0; i < posi.length; i++) {
                if (posi[i] == posi2[i]) {
                    dif++;
                }
            }
            System.out.println(dif);
        }
        s.close();
    }
}
