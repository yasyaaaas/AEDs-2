import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class No {
    int elemento;
    public No esq;
    public No dir;

    public No(int elemento) {
        this.elemento = elemento;
        this.esq = null;
        this.dir = null;
    }

    public No(int elemento, No dir, No esq) {
        this.elemento = elemento;
        this.esq = esq;
        this.dir = dir;
    }
}

class ArvoreBinaria {
    public No raiz;

    ArvoreBinaria() {
        this.raiz = null;
    }

    void inserir(int x) throws Exception {
        raiz = inserir(x, raiz);
    }

    No inserir(int x, No i) throws Exception {
        if (i == null) {
            i = new No(x);
        } else if (x < i.elemento) {
            i.esq = inserir(x, i.esq);
        } else if (x > i.elemento) {
            i.dir = inserir(x, i.dir);
        } else {
            throw new Exception("Erro!");
        }
        return i;
    }

    void mostrarNivel() {
        if (raiz != null) {
            Queue<No> fila = new LinkedList<>();
            fila.add(raiz);

            while (!fila.isEmpty()) {
                No tempNode = fila.poll();
                System.out.print(tempNode.elemento + " ");

                if (tempNode.esq != null)
                    fila.add(tempNode.esq);
                if (tempNode.dir != null)
                    fila.add(tempNode.dir);
            }
        }
    }
}

public class percEmNivel {
    public static void main(String[] args) throws Exception {
        Scanner s = new Scanner(System.in);
        int numTent = s.nextInt();
        for (int j = 0; j < numTent; j++) {
            ArvoreBinaria ab = new ArvoreBinaria();
            int numTest = s.nextInt();
            for (int i = 0; i < numTest; i++) {
                try {
                    int elemento = s.nextInt();
                    ab.inserir(elemento);
                } catch (Exception e) {
                    System.out.println("Erro ao inserir elemento na árvore: " + e.getMessage());
                }
            }
            System.out.println("Case:");
            ab.mostrarNivel();
            System.out.println();
        }
        s.close();
    }
}