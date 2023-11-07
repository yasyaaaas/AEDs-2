import java.util.Scanner;

public class umkk {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int numCasos = Integer.parseInt(s.nextLine());
        for (int x = 0; x < numCasos; x++) {
            int numCri = Integer.parseInt(s.nextLine());
            String linha = s.nextLine();
            int[] arrInt = new int[numCri];
            int[] arrInt2 = new int[numCri];
            int dif = 0;
            String[] arrays = linha.split(" ");
            // passa o snumeros do arrai linha para u arr de inteios
            for (int i = 0; i < numCri; i++) {
                arrInt[i] = Integer.parseInt(arrays[i]);
                arrInt2[i] = Integer.parseInt(arrays[i]);
            }
            for (int i = 0; i < numCri - 1; i++) {
                int menor = i;
                for (int j = i + 1; j < numCri; j++) {
                    if (arrInt[menor] < arrInt[j]) { // decrescente
                        menor = j;
                    }
                }
                int temp = arrInt[menor];
                arrInt[menor] = arrInt[i];
                arrInt[i] = temp;
            }
            // não precisam ser trocados = igual a original
            for (int i = 0; i < numCri; i++) {
                if (arrInt[i] == arrInt2[i]) {
                    dif++;
                }
            }
            System.out.println(dif);
        }
        s.close();
    }
}
