import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class amigos {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String l = s.nextLine(); // lista luigi
        String n = s.nextLine(); // novos amigos
        String amigo = s.nextLine(); // nome amigo
        List<String> amigos = new ArrayList<>();
        String[] listaAtual = l.split(" ");
        String[] adicionar = n.split(" ");
        for (int i = 0; i < listaAtual.length; i++) {
            amigos.add(listaAtual[i]);
        }
        if (!amigo.equals("nao")) {
            // Verifica se o amigo indicado está na lista
            int posiAmigo = amigos.indexOf(amigo);

            if (posiAmigo != -1) { // se o amigo esat na lista
                amigos.addAll(posiAmigo, List.of(adicionar));
                // List.of(adicionar) -> cria lista em adicionar
                // e a coloca antes da posição do amigo
            } else {
                amigos.addAll(List.of(adicionar));
            }
        } else {
            amigos.addAll(List.of(adicionar));
        }
        for (String amizades : amigos) {
            System.out.print(amizades + " ");
        }

        s.close();
    }
}
