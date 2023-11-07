import java.util.Scanner;

public class ContractRevision {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String numFal;
        String seq;

        while (true) {
            numFal = s.next();
            seq = s.next();
            if (numFal.charAt(0) == '0' && seq.charAt(0) == '0') {
                break;
            }
            char[] resp = new char[100];
            int index = 0;
            for (int i = 0; i < seq.length(); i++) {
                if (seq.charAt(i) != numFal.charAt(0)) { // excluir apenas uma parte!!!
                    resp[index] = seq.charAt(i);
                    index++;
                }
            }
            if (index == 0) {
                System.out.println("0");
            } else {
                System.out.println(resp);
            }
        }
        s.close();
    }
}
