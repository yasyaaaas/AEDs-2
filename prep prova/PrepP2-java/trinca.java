import java.util.Scanner;

public class trinca {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = Integer.parseInt(s.nextLine());
        for (int x = 0; x < n; x++) {
            int a = Integer.parseInt(s.nextLine());
            String linha = s.nextLine();
            int[] b = new int[a];
            for (int i = 0; i < a; i++) {
                b[i] = Character.getNumericValue(linha.charAt(i));
            }
            int[] count = new int[a + 1]; // Array para contar as ocorrências dos elementos
            for (int i = 0; i < a; i++) {
                count[b[i]]++; // quantas vezes um elemento específico apareceu
            }
            int maxCount = -1;
            for (int i = 1; i <= a; i++) {
                if (count[i] >= 3 && (maxCount == -1 || i > maxCount)) {
                    maxCount = i;
                }
            }
            System.out.println(maxCount == -1 ? -1 : maxCount);
        }
        s.close();
    }
}
