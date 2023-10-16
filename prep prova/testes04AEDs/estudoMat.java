class estudoMat {
    public class Celula {
        public int elemento;
        public Celula sup, inf, esq, dir;

        public Celula() {
            this(0);
        }

        public Celula(int x) {
            this.elemento = x;
            this.sup = this.inf = this.esq = this.dir = null;
        }

        public Celula(int x, Celula inf, Celula sup, Celula dir, Celula esq) {
            this.elemento = x;
            this.sup = sup;
            this.inf = inf;
            this.esq = esq;
            this.dir = dir;
        }
    }

    class Matriz {
        private Celula inicio;
        private int linha, coluna;

        public Matriz() {
            this(3, 3);

        }

        public Matriz(int l, int c) {
            // DESENHE ISSO!!! -> dapra desenhar
            this.linha = l;
            this.coluna = c;
            this.inicio = new Celula();
            Celula i = inicio;

            // Cria a primeira linha da matriz
            // max
            for (int k = 0; k < c - 1; k++) { // 1° linha
                i.dir = new Celula();
                i.dir.esq = i;
                i = i.dir;
            }

            // Cria as demais linhas e conecta com as anteriores
            Celula j = inicio; // 2° linha
            for (int m = 1; m < l; m++) {
                j.inf = new Celula();
                j.inf.sup = j;
                i = j.inf;

                Celula previousRowCell = j; // Cria uma referência para a célula da linha anterior (acima).
                // PRC -> percorre as colunas para o j continuar na 1°

                for (int k = 0; k < c - 1; k++) {
                    i.dir = new Celula();
                    i.dir.esq = i;
                    i.dir.sup = previousRowCell.dir; // seria j.dir
                    previousRowCell.dir.inf = i.dir; // j.dir.inf
                    i = i.dir; // atualiza i
                    previousRowCell = previousRowCell.dir; // Atualiza a referência para a célula da linha anterior.
                }
                j = j.inf; // volta com o j para esq -> avança para baixo
            }
        }

        public void setElemento(int linha, int coluna, int valor) {
            if (linha >= 0 && linha < this.linha && coluna >= 0 && coluna < this.coluna) { // ve se esta dentro do ok
                Celula cell = this.inicio; // cell apont apara o inicio
                // vai caçar a posição colocada
                for (int i = 0; i < linha; i++) {
                    cell = cell.inf;
                }

                for (int j = 0; j < coluna; j++) {
                    cell = cell.dir;
                }
                // depois disso a cell está na posição certa
                cell.elemento = valor;// coloca valor
            } else {
                System.out.println("Posição inválida na matriz.");
            }
        }

        public void mostrar() {
            Celula atual = inicio; // so ta apontando para o inicio

            for (int i = 0; i < linha; i++) {
                Celula cellAtual = atual;
                // vai percorrer as colunas par a atual não perder a posição da Cell atual

                for (int j = 0; j < coluna; j++) {
                    System.out.print(cellAtual.elemento + " "); // imprime a celual daquela coluna
                    cellAtual = cellAtual.dir; // passa para a diteita
                }

                System.out.println(); // Mova para a próxima linha
                atual = atual.inf; // Mova para a próxima linha na matriz por canta do ponteiro
            }
        }

        public static Matriz soma(Matriz m1, Matriz m2) {
            Matriz resp = null;
            if (m1.linha == m2.linha && m1.coluna == m2.coluna) { // confere o mesmo tamanho
                resp = new estudoMat().new Matriz(m1.linha, m1.coluna); // cria uma matriz de resposta
                Celula inicioK = resp.inicio; // tem qeu colocar um ponteiro
                Celula inicioI = m1.inicio;
                Celula inicioJ = m2.inicio;
                // ponteiros para o inicio de cada matriz
                while (inicioK != null) { // se 1 não é nulo, todos também não são, e para quando for!!
                    Celula k = inicioK; // k -> vai percorrer a célula, inicia no início
                    Celula i = inicioI, j = inicioJ;
                    while (k != null) { // linha
                        k.elemento = i.elemento + j.elemento; // soma eles
                        k = k.dir; // passa o que vai percorrer para o proximo
                        i = i.dir;
                        j = j.dir;
                    }
                    inicioK = inicioK.inf; // passa o início da celula para baixo
                    inicioI = inicioI.inf;
                    inicioJ = inicioJ.inf;
                }

            }
            return resp;
        }

    }

    public static void main(String[] args) {
        Matriz m1 = new estudoMat().new Matriz();
        m1.setElemento(0, 0, 1);
        m1.setElemento(0, 1, 2);
        m1.setElemento(0, 2, 3);
        m1.setElemento(1, 0, 4);
        m1.setElemento(1, 1, 5);
        m1.setElemento(1, 2, 6);
        m1.setElemento(2, 0, 7);
        m1.setElemento(2, 1, 8);
        m1.setElemento(2, 2, 9);
        m1.mostrar();
        System.out.println("     ");
        Matriz m2 = new estudoMat().new Matriz();
        m2.setElemento(0, 0, 9);
        m2.setElemento(0, 1, 8);
        m2.setElemento(0, 2, 7);
        m2.setElemento(1, 0, 6);
        m2.setElemento(1, 1, 5);
        m2.setElemento(1, 2, 4);
        m2.setElemento(2, 0, 3);
        m2.setElemento(2, 1, 2);
        m2.setElemento(2, 2, 1);
        m2.mostrar();
        System.out.println("     ");
        Matriz m3;
        m3 = Matriz.soma(m1, m2);
        m3.mostrar();
    }
}
