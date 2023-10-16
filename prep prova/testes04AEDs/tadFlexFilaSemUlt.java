public class tadFlexFilaSemUlt {
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
        private Celula primeiro; // cria 2 ponteiros

        public Fila() {
            primeiro = new tadFlexFilaSemUlt().new Celula();
        }

        public void inserir(int x) { // inserir
            for (Celula i = primeiro; i != null; i = i.prox) {
                i.prox = new tadFlexFilaSemUlt().new Celula(x);
                i = null;
            }

        }

        public int remover() throws Exception {
            // esse exclui o nó de cabeça
            // if (primeiro == ultimo) {
            // throw new Exception("Erro!");
            // }
            Celula tmp = primeiro;
            primeiro = primeiro.prox;
            int elemento = primeiro.elemento;
            tmp.prox = null;
            tmp = null;
            return elemento;
        }

        public void mostrar() {
            System.out.print("[ ");
            for (Celula i = primeiro; i != null; i = i.prox) {
                System.out.print(i.elemento + " ");
            }
            System.out.println("]");
        }
    }

    public static void main(String[] args) throws Exception {
        Fila fila = new tadFlexFilaSemUlt().new Fila();
        fila.inserir(3);
        fila.inserir(5);
        fila.inserir(6);
        fila.inserir(30);
        fila.mostrar(); // tem o 0
        fila.remover();
        fila.mostrar();
    }
}
