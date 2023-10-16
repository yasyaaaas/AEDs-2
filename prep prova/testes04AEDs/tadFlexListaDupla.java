public class tadFlexListaDupla {
    public class CelulaDupla {
        public int elemento;
        public CelulaDupla ant, prox;

        public CelulaDupla() {
            this(0);
        }

        public CelulaDupla(int x) {
            this.elemento = x;
            this.ant = null;
            this.prox = null;
        }
    }

    public class ListaDupla {
        private CelulaDupla primeiro, ultimo;

        public ListaDupla() {
            primeiro = new tadFlexListaDupla().new CelulaDupla();
            ultimo = primeiro;
        }

        // similar a lista simples
        public void inserirInicio(int x) {
            CelulaDupla tmp = new tadFlexListaDupla().new CelulaDupla(x);
            tmp.ant = primeiro; // tmp anterior aponta para o prim
            tmp.prox = primeiro.prox; // o tmp aponta para o antigo segundo
            primeiro.prox = tmp; // o primeiro aponta para a celula nova, assim encaixando-a
            if (primeiro == ultimo) {
                ultimo = tmp;
            } else {
                tmp.prox.ant = tmp; // o anterior do segundo aponta para o tmp
            }
            tmp = null;
        }

        public void inserir(int x) {
            ultimo.prox = new tadFlexListaDupla().new CelulaDupla(x);
            ultimo.prox.ant = ultimo;
            ultimo = ultimo.prox; // passa o último para a celula criada
        }

        public int remover() throws Exception {
            if (primeiro == ultimo)
                throw new Exception("Erro!");
            CelulaDupla tmp = primeiro; // o que vai ser removido
            primeiro = primeiro.prox; // passa o prim para o segundo
            int elemento = primeiro.elemento; // pega o elemento do primeiro
            tmp.prox = primeiro.ant = null;
            // faz o tmp não apontar pra nada e faz o agora primeiro não apontar pra traz
            tmp = null;
            return elemento; // deleta

        }

        public int removerFinal() throws Exception {
            if (primeiro == ultimo)
                throw new Exception("Erro!");
            int elemento = ultimo.elemento; // pega o elemento
            ultimo = ultimo.ant; // passa o ultimo para o anterior
            ultimo.prox.ant = null; // faz o anterior do proximo elemento (o antes ultimo) apontar pra nada
            ultimo.prox = null; // faz então o ultimo não appontar pra nada
            return elemento; // deleta
        }

        public void inserirIP(int x, int pos) {
            CelulaDupla i = primeiro;
            for (int j = 0; j < pos; j++, i = i.prox)
                ;
            CelulaDupla tmp = new tadFlexListaDupla().new CelulaDupla(x);
            tmp.ant = i;
            tmp.prox = i.prox; // tmp aponta para a proxima do i
            i.prox = tmp; // o proximo do i passa a ser o tmp
            tmp.ant.prox = tmp.prox.ant = tmp;
            tmp = null;
            i = null;
        }

        public void mostrar() {
            System.out.print("[ ");
            for (CelulaDupla i = primeiro; i != null; i = i.prox) {
                System.out.print(i.elemento + " ");
            }
            System.out.println("]");
        }

        public void inverter() { // olhar
            CelulaDupla i = primeiro;
            CelulaDupla j = ultimo;
            while (i != j && j.prox != i) { // impar i!=j par j.prox!=i -> para qundo for ultra passar
                // swap
                int tmp = i.elemento;
                i.elemento = j.elemento;
                j.elemento = tmp;
                i = i.prox; // vai pro proximo
                j = j.ant; // vai pro anteror
            }
        }

        // shellSort e QuickSort implementar
    }

    public static void main(String[] args) throws Exception {
        ListaDupla lista = new tadFlexListaDupla().new ListaDupla();
        lista.inserir(3);
        lista.inserir(7);
        lista.inserir(5);
        lista.inserir(9);
        lista.inserir(12);
        lista.remover(); // remove 0
        lista.remover(); // remove 3
        lista.inserirInicio(1);
        lista.removerFinal();
        lista.inserirIP(6, 2);
        lista.mostrar();
        lista.inverter();
        lista.mostrar();
    }
}
