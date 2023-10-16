public class tadFlexFila {
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
            // ambos apontam par a mesma celula
            // A primeira célula da nossa fila é o nó cabeça, célula cafe com leite cuja
            // função é eliminar um if no inserir
            primeiro = new tadFlexFila().new Celula();
            ultimo = primeiro;
        }

        public void inserir(int x) { // inserir
            ultimo.prox = new tadFlexFila().new Celula(x);
            ultimo = ultimo.prox;
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

        public int maior() {
            int maior = primeiro.elemento;
            for (Celula i = primeiro; i != null; i = i.prox) {
                if (i.elemento > maior) {
                    maior = i.elemento;
                }
            }
            System.out.println("[ Maior: " + maior + " ]");
            return maior;
        }

        public void terceiro() {
            System.out.println("[ Terceiro: " + primeiro.prox.prox.elemento + "]");
        }

        public int soma() {
            int soma = 0;
            for (Celula i = primeiro; i != null; i = i.prox) {
                soma += i.elemento;
            }
            System.out.println("[ Soma: " + soma + " ]");
            return soma;
        }

        /*
         * public void inverte() {
         * // pra inverter é o .length() / 2
         * // não entendi!!
         * Celula fim = ultimo;
         * while (primeiro != fim) {
         * Celula nova = new tadFlexFila().new Celula();
         * nova.prox = fim.prox;
         * fim.prox = nova;
         * Celula tmp = primeiro.prox;
         * primeiro.prox = tmp.prox;
         * nova = tmp = tmp.prox = null;
         * if (ultimo == fim) {
         * ultimo = ultimo.prox;
         * }
         * fim = null;
         * }
         * }
         */

        public int contar() {
            return contar(primeiro);
        }

        public int contar(Celula i) {
            int resp;
            if (i == null) {
                resp = 0;
            } else if (i.elemento % 2 == 0 && i.elemento % 5 == 0) {
                resp = 1 + contar(i.prox);
            } else {
                resp = contar(i.prox);
            }
            return resp;
        }

    }

    public static void main(String[] args) throws Exception {
        Fila fila = new tadFlexFila().new Fila();
        // Inserir os elementos 3, 5, 6 e 7 na pilha
        fila.inserir(3);
        fila.inserir(5);
        fila.inserir(6);
        fila.inserir(30);
        fila.mostrar(); // tem o 0
        fila.remover();
        fila.mostrar();
        fila.maior();
        fila.terceiro();
        fila.soma();
        // fila.inverte();
        int resultado = fila.contar();
        System.out.println("[ Contador: " + resultado + " ]");
    }
}
