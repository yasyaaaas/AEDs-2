import java.util.Scanner;

public class ContChar {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String linha;
        String maior = "";
        while (true) {
            linha = s.nextLine();
            if (linha.equals("0")) {
                break;
            }
            String[] arr = linha.split(" ");
            String tamanho = ""; // saida dos tamanhos
            int maxLength = 0; // maior palavra
            for (int i = 0; i < arr.length; i++) {
                String palavras = arr[i];
                if (palavras.length() >= maxLength) {
                    maxLength = palavras.length();
                    maior = palavras;
                }
                tamanho += palavras.length();
                if (i < palavras.length() - 1) {
                    tamanho += "-";
                }
            }
            System.out.println(tamanho); // tamaho da string
        }
        System.out.println("Maior palavra: " + maior);
        s.close();
    }
}
