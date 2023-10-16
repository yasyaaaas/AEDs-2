public class tadFlexLista {
    public class Celula {
        public int elemento;
        public Celula prox;

        public Celula() {
            this(0);
        }

        public Celula(int x) {
            this.elemento = x; // elemento que colocam
            this.prox = null; // proxomo é nulo
        }
    }

    public class Lista {
        private int cont;
        private Celula primeiro, ultimo; // cria 2 ponteiros

        public Lista() {
            cont = 0;
            primeiro = new tadFlexLista().new Celula();
            ultimo = primeiro;
        }

        public void inserir(int x) { // inserir
            ultimo.prox = new tadFlexLista().new Celula(x);
            ultimo = ultimo.prox;
            cont++;
        }

        public int remover() throws Exception {
            // esse exclui o nó de cabeça
            if (primeiro == ultimo) {
                throw new Exception("Erro!");
            }
            Celula tmp = primeiro;
            primeiro = primeiro.prox;
            int elemento = primeiro.elemento;
            tmp.prox = null;
            tmp = null;
            cont--;
            return elemento;
            // esse remosve o 3
            /*
             * public int remover() throws Exception{
             * if (primeiro == ultimo)
             * throw new Exception("Erro!");
             * Celula tmp = primeiro.prox;
             * primeiro.prox = primeiro.prox.prox;
             * int elemento = tmp.elemento;
             * tmp.prox = null;
             * tmp = null;
             * return elemento;
             * }
             * 
             */

        }

        public void mostrar() {
            System.out.print("[ ");
            for (Celula i = primeiro; i != null; i = i.prox) {
                System.out.print(i.elemento + " ");
            }
            System.out.println("]");
        }

        public void inserirInicio(int x) {
            Celula tmp = new tadFlexLista().new Celula(x);
            tmp.prox = primeiro.prox; // aponta para o segundo
            primeiro.prox = tmp; // primeirop aponta poara a celula nova
            // para ser o no de cabeça -> tmp.prox = primeiro; primeiro = tmp;
            if (primeiro == ultimo) {
                ultimo = tmp;
            }
            tmp = null;
            cont++;
        }

        public int removerFinal() {
            Celula i;
            for (i = primeiro; i.prox != ultimo; i = i.prox)
                ;
            int elemento = ultimo.elemento;
            ultimo = i;
            i = null;
            ultimo.prox = null;
            cont--;
            return elemento;
        }

        public void inserirIP(int x, int pos) {
            Celula i = primeiro;
            for (int j = 0; j < pos; j++, i = i.prox)
                ;
            Celula tmp = new tadFlexLista().new Celula(x);
            tmp.prox = i.prox; // tmp aponta para a proxima do i
            i.prox = tmp; // o proximo do i passa a ser o tmp
            tmp = null;
            i = null;
            cont++;
        }

        public int getCont() {
            return cont;
        }

        public int getTamanho() {
            int tamanho = 0;
            Celula atual = primeiro.prox;
            while (atual != null) {
                tamanho++;
                atual = atual.prox;
            }
            return tamanho;
        }

        public void ordenar() {
            // jo coloca Celula no lugar do int
            for (Celula i = primeiro; i != null; i = i.prox) { // já tirei o no de cabeça
                Celula menor = i; // menor = i
                for (Celula j = i.prox; j != null; j = j.prox) {
                    if (j.elemento < menor.elemento) {
                        menor = j;
                    }
                }
                // swap
                if (menor != i) {
                    // Troque os elementos
                    int temp = menor.elemento;
                    menor.elemento = i.elemento;
                    i.elemento = temp;
                }
            }
        }

        // questão de prova 2!!!!!
        public void inverter() {
            Celula i = primeiro;
            Celula j = ultimo;
            Celula k;
            while (i != j && j.prox != i) {
                // swap
                int tmp = i.elemento;
                i.elemento = j.elemento;
                j.elemento = tmp;
                i = i.prox; // passa o i para o prox
                for (k = primeiro; k.prox != j; k = k.prox)
                    ; // coloca o k na posição anterior do j
                j = k; // o j vira o k (seu anterior) -> passa o j para seu anterior
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Lista lista = new tadFlexLista().new Lista();
        lista.inserir(3);
        lista.inserir(7);
        lista.inserir(5);
        lista.inserir(9);
        lista.inserir(12);
        lista.remover();
        lista.inserirInicio(1);
        lista.removerFinal();
        lista.inserirIP(6, 2);
        lista.ordenar();
        lista.mostrar();
        System.out.println("Contador: " + lista.getCont());
        lista.inverter();
        lista.mostrar();
    }
}
