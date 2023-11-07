import java.util.Scanner;

class WU1 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int numTest = 0;
        numTest = Integer.parseInt(s.nextLine());
        for (int k = 0; k < numTest; k++) {
            int numCri = Integer.parseInt(s.nextLine());
            int[] posi = new int[numCri];
            int[] posi2 = new int[numCri];
            String crianca = s.nextLine();
            int dif = 0;
            String[] arr = crianca.split(" ");
            for (int i = 0; i < arr.length; i++) {
                posi[i] = Integer.parseInt(arr[i]);
                posi2[i] = Integer.parseInt(arr[i]);
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