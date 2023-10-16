class tadFlexPilha {
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

    public class Pilha {
        private Celula topo; // cria um ponteiro topo

        public Pilha() {
            topo = null; // coloca o topo apontando para null
        }

        public void inserir(int x) { // inserir
            Celula tmp = new tadFlexPilha().new Celula(x);
            // cria ponteiro tmp que aponta para um anova uma nova celula
            tmp.prox = topo; // o proximo vai apontar par o topo, assim empilhando
            topo = tmp; // topo vira o tmp, qeu é o novo topo
            tmp = null; // tmp aponta para null
        }

        public int remover() throws Exception {
            if (topo == null) {
                throw new Exception("Erro!");
            }
            // remove o elemnto do topo
            int elemento = topo.elemento; // elemento = 1°
            Celula tmp = topo; // tmp vai para o topo
            topo = topo.prox; // -> topo vai para o prox
            tmp.prox = null; // tmp vai apontar para nulo
            tmp = null; // tmp volta a apontar para nulo
            return elemento; // return elemento: remove elemento
        }

        public void mostrar() {
            System.out.print("[ ");
            for (Celula i = topo; i != null; i = i.prox) {
                System.out.print(i.elemento + " ");
            }
            System.out.println("]");
        }

        public void mostraPilha() {
            mostraPilha(topo);
            System.out.println("----------------------------");
        }

        private void mostraPilha(Celula i) {
            if (i != null) {
                mostraPilha(i.prox);
                System.out.println("" + i.elemento);
            }
        }

        public void mostraPilha2() {
            mostraPilha2(topo);
            System.out.println("----------------------------");
        }

        private void mostraPilha2(Celula i) {
            if (i != null) {
                System.out.println("" + i.elemento);
                mostraPilha(i.prox);
            }
        }

        private void mostrarPilha3() {
            for (Celula i = topo; i != null; i = i.prox) {
                System.out.println("" + i.elemento);
            }
            System.out.println("----------------------------");
        }

    }

    public static void main(String[] args) throws Exception {
        Pilha pilha = new tadFlexPilha().new Pilha();
        // Inserir os elementos 3, 5, 7 e 6 na pilha
        pilha.inserir(3);
        pilha.inserir(5);
        pilha.inserir(7);
        pilha.inserir(6);
        pilha.remover();
        pilha.mostrar();
        pilha.mostraPilha();
        pilha.mostraPilha2();
        pilha.mostrarPilha3();
    }
}