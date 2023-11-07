import java.util.Scanner;

public class nomeDecifrar {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = Integer.parseInt(s.nextLine());
        for (int i = 0; i < n; i++) {
            String linha1 = s.nextLine();
            String linha2 = s.nextLine();
            String nome = "";
            String[] l1 = linha1.split(" ");
            String[] l2 = linha2.split(" ");
            for (int j = 0; j < l1.length; j++) {
                String firstName = "";
                String lastName = "";

                if (l1[j].length() >= 2) {
                    firstName = l1[j].charAt(0) + "" + l1[j].charAt(1);
                }

                if (l2[j].length() >= 2) {
                    firstName += l2[j].charAt(0) + "" + l2[j].charAt(1);
                }

                if (l1[j].length() >= 4) {
                    lastName = l1[j].charAt(2) + "" + l1[j].charAt(3);
                }

                if (l2[j].length() >= 4) {
                    lastName += l2[j].charAt(2) + "" + l2[j].charAt(3);
                }

                nome += firstName + " " + lastName + " ";
            }
            System.out.println(nome);
        }
        s.close();
    }
}
