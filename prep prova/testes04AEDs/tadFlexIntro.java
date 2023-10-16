class tadFlexIntro {

    public class Celula {
        public int elemento;
        public Celula prox;

        public Celula() {
            this(0);
        }

        public Celula(int x) {
            this.elemento = x;
            this.prox = null;
        }
    }

    public static void main(String[] args) {
        Celula tmp = new tadFlexIntro().new Celula(3);
        System.out.println(tmp);
    }
}