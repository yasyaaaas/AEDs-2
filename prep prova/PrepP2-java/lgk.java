
// last good kid
import java.util.Scanner;

public class lgk {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String[] goodKids = new String[1000];
        int index = 0;
        while (s.hasNext()) {
            String nome = s.nextLine();
            goodKids[index] = nome;
            index++;
        } // leu o nome das crianças e armazenou no goodKids
        for (int i = 0; i < (index - 1); i++) {
            int menor = i;
            for (int j = 1; j < index; j++) {
                if (goodKids[menor].compareToIgnoreCase(goodKids[j]) > 0) {
                    menor = j;
                }
            }
            String temp = goodKids[menor];
            goodKids[menor] = goodKids[i];
            goodKids[i] = temp;
        }
        System.out.println(goodKids[index - 1]);
        s.close();
    }
}