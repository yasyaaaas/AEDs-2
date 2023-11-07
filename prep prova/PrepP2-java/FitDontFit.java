import java.util.Scanner;

public class FitDontFit {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int numOca = s.nextInt();
        String PrimNum;
        String SecNum;
        for (int i = 0; i < numOca; i++) {
            PrimNum = s.next();
            SecNum = s.next();
            int lenA = PrimNum.length();
            int lenB = SecNum.length();
            boolean encaixa = true;
            // ver se o qeu esta na SecNum esta no final da PrimNum
            for (int j = 1; j <= lenB; j++) { // percorre os digitos de B da direita para esquerda
                // (ultimo ->primeiro)
                // tamanho de B
                if (lenA - j < 0 || PrimNum.charAt(lenA - j) != SecNum.charAt(lenB - j)) {
                    encaixa = false;
                    break;
                }
            }
            if (encaixa) {
                System.out.println("encaixa");
            } else {
                System.out.println("nao encaixa");
            }
        }
        s.close();
    }
}
