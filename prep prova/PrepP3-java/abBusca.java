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

    void mostrarPre() {
        mostrarPre(raiz);
    }

    private void mostrarPre(No i) {
        if (i != null) {
            System.out.print(i.elemento + " ");
            mostrarPre(i.esq);
            mostrarPre(i.dir);
        }
    }

    void mostrar() {
        mostrar(raiz);
    }

    private void mostrar(No i) {
        if (i != null) {
            mostrar(i.esq);
            System.out.print(i.elemento + " ");
            mostrar(i.dir);
        }
    }

    void mostrarPos() {
        mostrarPos(raiz);
    }

    private void mostrarPos(No i) {
        if (i != null) {
            mostrarPos(i.esq);
            mostrarPos(i.dir);
            System.out.print(i.elemento + " ");
        }
    }
}

public class abBusca {
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
            System.out.println("Case " + (j + 1) + ":");
            System.out.print("Pre.: ");
            ab.mostrarPre();
            System.out.println();
            System.out.print("In..: ");
            ab.mostrar();
            System.out.println();
            System.out.print("Pos.: ");
            ab.mostrarPos();
            System.out.println("\n");
        }
        s.close();
    }
}
