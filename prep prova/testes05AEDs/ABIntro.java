public class ABIntro {
    public class No {
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

    public class ArvoreBinaria {
        public No raiz;

        ArvoreBinaria() {
            this.raiz = null;
        }

        void inserir(int x) throws Exception {
            raiz = inserir(x, raiz);
        }

        No inserir(int x, No i) throws Exception {
            // tem que chamar recursivamente
            if (i == null) {
                i = new ABIntro().new No(x);
            } else if (x < i.elemento) { // se for menor esquerda
                i.esq = inserir(x, i.esq);
            } else if (x > i.elemento) { // se for maior direita
                i.dir = inserir(x, i.dir);
            } else {
                throw new Exception("Erro!");
            }
            return i;
        }

        public void inserirPai(int x) throws Exception {
            if (raiz == null) {
                raiz = new No(x); // cria primeiro
            } else if (x < raiz.elemento) {
                inserirPai(x, raiz.esq, raiz); // insere na esq
            } else if (x > raiz.elemento) {
                inserirPai(x, raiz.dir, raiz); // insere na dir
            } else {
                throw new Exception("Erro!");
            }
        }

        private void inserirPai(int x, No i, No pai) throws Exception {
            if (i == null) { // vão ser os primeiros filhos
                if (x < pai.elemento) {
                    pai.esq = new No(x);
                } else {
                    pai.dir = new No(x);
                }
            } else if (x < i.elemento) { // inserir nos filhos
                inserirPai(x, i.esq, i);
            } else if (x > i.elemento) {
                inserirPai(x, i.dir, i);
            } else {
                throw new Exception("Erro!");
            }
        }

        private void ordenar() {
            ordenar(raiz);
        }

        private void ordenar(No i) {
            if (i != null) {
                ordenar(i.esq);
                System.out.print(i.elemento + " ");
                ordenar(i.dir);
            }
        }

        private void remover(int x) throws Exception {
            raiz = remover(x, raiz);
        }

        private No remover(int x, No i) throws Exception {
            if (i == null) {
                throw new Exception("Erro!");
            } else if (x < i.elemento) {
                i.esq = remover(x, i.esq);
            } else if (x > i.elemento) {
                i.dir = remover(x, i.dir);
            } else if (i.dir == null) {
                i = i.esq;
            } else if (i.esq == null) {
                i = i.dir;
            } else {
                i.esq = maiorEsq(i, i.esq);
            }
            return i;
        }

        private No maiorEsq(No i, No j) throws Exception {
            if (j.dir == null) {
                i.elemento = j.elemento;
                j = j.dir;
            } else {
                j.dir = maiorEsq(i, j.dir);
            }
            return j;
        }
    }

    private static boolean iguais(ArvoreBinaria i, ArvoreBinaria j) { // manda duas arvores
        return iguais(i.raiz, j.raiz); // manda as raizes delas
    }

    private static boolean iguais(No i, No j) { // vai indo pelos nos
        boolean resp = false;
        if (i != null && j != null) {
            resp = (i.elemento == j.elemento && iguais(i.dir, j.dir) && iguais(i.esq, j.esq));
        } else if (i == null && j == null) {
            resp = true;
        }

        return resp;
    }

    public static void main(String[] args) throws Exception {
        ArvoreBinaria ab = new ABIntro().new ArvoreBinaria();
        ab.inserir(3);
        ab.inserir(5);
        ab.inserir(1);
        ab.inserir(8);
        ab.inserir(2);
        ab.inserir(4);
        ab.inserir(7);
        ab.inserir(6);
        ab.ordenar();
        System.out.println("");
        ArvoreBinaria ab2 = new ABIntro().new ArvoreBinaria();
        ab2.inserirPai(3);
        ab2.inserirPai(5);
        ab2.inserirPai(1);
        ab2.inserirPai(8);
        ab2.inserirPai(6);
        ab2.inserirPai(7);
        ab2.remover(5);
        ab2.ordenar();
        System.out.println("");
        ArvoreBinaria ab3 = new ABIntro().new ArvoreBinaria();
        ab3.inserir(3);
        ab3.inserir(5);
        ab3.inserir(1);
        ab3.inserir(8);
        ab3.inserir(2);
        ab3.inserir(4);
        ab3.inserir(7);
        ab3.inserir(6);
        ab3.ordenar();
        System.out.println("");
        ArvoreBinaria ab4 = new ABIntro().new ArvoreBinaria();
        ab4.inserir(3);
        ab4.inserir(5);
        ab4.inserir(1);
        ab4.inserir(8);
        ab4.inserir(2);
        ab4.inserir(4);
        ab4.inserir(7);
        ab4.inserir(6);
        ab4.ordenar();
        System.out.println("");
        boolean resposta = iguais(ab3, ab4);
        System.out.println(resposta);
    }
}