class No {
    public char elemento;
    public final int tamanho = 255;
    public No[] prox;
    public boolean folha;

    public No() {
        this(' ');
    }

    public No(char elemento) {
        this.elemento = elemento;
        prox = new No[tamanho];
        for (int i = 0; i < tamanho; i++)
            prox[i] = null;
        folha = false;
    }

    public static int hash(char x) {
        return (int) x;
    }
}

class Trie {
    private No raiz;

    public Trie() {
        raiz = new No();
    }

    public boolean pesquisar(String s) throws Exception {
        return pesquisar(s, raiz, 0);
    }

    public boolean pesquisar(String s, No no, int i) throws Exception {
        boolean resp;
        if (no.prox[s.charAt(i)] == null) {
            resp = false;
        } else if (i == s.length() - 1) {
            resp = (no.prox[s.charAt(i)].folha == true);
        } else if (i < s.length() - 1) {
            resp = pesquisar(s, no.prox[s.charAt(i)], i + 1);
        } else {
            throw new Exception("Erro ao pesquisar!");
        }
        return resp;
    }

    public void inserir(String s) throws Exception {
        inserir(s, raiz, 0);
    }

    private void inserir(String s, No no, int i) throws Exception {
        System.out.print("\nEM NO(" + no.elemento + ") (" + i + ")"); // elemeto é o char
        if (no.prox[s.charAt(i)] == null) { // prox nulo
            System.out.print("--> criando filho(" + s.charAt(i) + ")");
            no.prox[s.charAt(i)] = new No(s.charAt(i)); // cria filho com o novo elemento

            if (i == s.length() - 1) {
                System.out.print("(folha)");
                no.prox[s.charAt(i)].folha = true; // se for o ultimo coloca cmo folha
            } else {
                inserir(s, no.prox[s.charAt(i)], i + 1); // se não for folha ainda, vai inserir até ser folha
            }

        } else if (no.prox[s.charAt(i)].folha == false && i < s.length() - 1) { // se não for folha ainda e já tiver vai
                                                                                // inserindo
            inserir(s, no.prox[s.charAt(i)], i + 1);

        } else {
            throw new Exception("Erro ao inserir!");
        }
    }

    public void mostrar() {
        mostrar("", raiz);
    }

    public void mostrar(String s, No no) {
        if (no.folha == true) {
            System.out.println("Palavra: " + (s + no.elemento)); // printa a álavr aquando for folha
        } else {
            for (int i = 0; i < no.prox.length; i++) {
                if (no.prox[i] != null) {
                    System.out.println("ESTOU EM (" + no.elemento + ") E VOU PARA (" + no.prox[i].elemento + ")");
                    mostrar(s + no.elemento, no.prox[i]); // vai apara o prox
                }
            }
        }
    }

    public int contarAs() {
        int resp = 0;
        if (raiz != null) {
            resp = contarAs(raiz);
        }
        return resp;
    }

    public int contarAs(No no) {
        int resp = (no.elemento == 'A') ? 1 : 0;

        if (no.folha == false) {
            for (int i = 0; i < no.prox.length; i++) {
                if (no.prox[i] != null) {
                    resp += contarAs(no.prox[i]);
                }
            }
        }
        return resp;
    }
}

public class ArvoreTrie {
    public static void main(String[] args) throws Exception {
        Trie arv = new Trie();

        String array[] = new String[8];
        array[0] = "ABACAXI";
        array[1] = "BALA";
        array[2] = "BOLO";
        array[3] = "ABACATE";
        array[4] = "galo";
        array[5] = "pata";
        array[6] = "pato";
        array[7] = "gato";

        for (int i = 0; i < array.length; i++) {
            arv.inserir(array[i]);
        }
        arv.mostrar();
        /*
         * for(int i = 0; i < array.length; i++){
         * System.out.println("Pesquisar(" + array[i] + "):" + arv.pesquisar(array[i]));
         * }
         * 
         * String s = "ABACA";
         * System.out.println("Pesquisar(" + s + "):" + arv.pesquisar(s));
         * 
         * s = "ABACAXIS";
         * System.out.println("Pesquisar(" + s + "):" + arv.pesquisar(s));
         * 
         * s = "gaga";
         * System.out.println("Pesquisar(" + s + "):" + arv.pesquisar(s));
         */

    }
}
