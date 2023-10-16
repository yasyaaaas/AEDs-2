public class tadFlexFilaSN {
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

    public class Fila {
        private Celula primeiro, ultimo; // cria 2 ponteiros

        public Fila() {
            // tem o nó pra eliminar esse if
            primeiro = null;
            ultimo = null;
        }

        public void inserir(int x) { // inserir
            Celula nova = new tadFlexFilaSN().new Celula(x); // cria celula
            if (primeiro == null) {
                primeiro = nova; // coloca na primeira posição
            } else {
                ultimo.prox = nova; // se nãop for a primeira coloca depois da ultima
            }
            ultimo = nova; // pasa a nova para a última posição
        }

        public void mostrar() {
            System.out.print("[ ");
            for (Celula i = primeiro; i != null; i = i.prox) {
                System.out.print(i.elemento + " ");
            }
            System.out.println("]");
        }
    }

    public static void main(String[] args) {
        Fila fila = new tadFlexFilaSN().new Fila();
        // Inserir os elementos 3, 5, 6 e 7 na pilha
        fila.inserir(3);
        fila.inserir(5);
        fila.inserir(6);
        fila.inserir(30);
        fila.mostrar(); // tem o 0
    }
}
