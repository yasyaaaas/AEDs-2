import java.util.Scanner;

public class LonelyNum {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String cont;
        String num;
        char[] numC = new char[10];
        while (true) {
            cont = s.nextLine();
            num = s.nextLine();
            if (cont.charAt(0) == '0') {
                break;
            }
            for (int i = 0; i < num.length(); i++) {
                numC[i] = num.charAt(i);
            }
            char resp = ' ';
            for (int i = 1; i < num.length(); i++) {
                if (numC[i] == numC[i + 1] && numC[i] == numC[i - 1]) {
                    resp = numC[i];
                } else if (numC[i] != numC[i + 1] && numC[i] != numC[i - 1]) {
                    if (numC[i + 1] == numC[i - 1]) {
                        resp = numC[i];
                    }
                }
            }
            System.out.println(resp);
        }
        s.close();
    }
}