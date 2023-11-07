import java.util.Scanner;

public class IdenTea {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String num;
        String guess;
        while (true) {
            num = s.nextLine();
            guess = s.nextLine();
            if (num.charAt(0) == '0') {
                break;
            }
            int cont = 0;
            for (int i = 0; i < guess.length(); i++) {
                if (guess.charAt(i) == num.charAt(0)) {
                    cont++;
                }
            }
            System.out.println(cont);
        }
        s.close();
    }
}
