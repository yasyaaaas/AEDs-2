import java.util.Scanner;

public class obiUri {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = Integer.parseInt(s.nextLine());
        String linha = s.nextLine();
        String[] arr = linha.split(" ");
        String linhaCorreta = "";
        for (int i = 0; i < n; i++) {
            String palavra = arr[i];
            int tamanho = palavra.length();
            String corretoPal = palavra;
            if (tamanho <= 3) {
                if (palavra.charAt(0) == 'O' && palavra.charAt(1) == 'B') {
                    corretoPal = "OBI";
                } else if (palavra.charAt(0) == 'U' && palavra.charAt(1) == 'R') {
                    corretoPal = "OBI";
                }
                // olhar
            }
        }
        s.close();
    }
}
