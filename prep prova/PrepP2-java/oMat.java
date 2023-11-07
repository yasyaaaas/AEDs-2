import java.util.Scanner;

public class oMat {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int num = Integer.parseInt(s.nextLine());
        for (int x = 0; x < num; x++) {
            String linha = s.nextLine();
            String[] arr = linha.split("x");
            int i = Integer.parseInt(arr[0]);
            int j = Integer.parseInt(arr[1]);
            // int mult = 0;
            for (int k = 0; k < 10; k++) {
                System.out.println(
                        i + " x " + (i + (k + 1)) + " = " + (i * (i + k + 1)) + " && " + j + " x " + (j + k) + " = "
                                + (j * (j + k)));
            }
        }
        s.close();
    }
}
