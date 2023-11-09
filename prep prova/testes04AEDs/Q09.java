//EStudar prova

import java.util.Scanner;

class Celula {
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
        this.linha = l;
        this.coluna = c;
        this.inicio = new Celula();
        Celula i = inicio;

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
            resp = new Matriz(m1.linha, m1.coluna); // cria uma matriz de resposta
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

    public static Matriz multiplicacao(Matriz m1, Matriz m2) {
        Matriz resp = null;
        if (m1.linha == m2.linha && m1.coluna == m2.coluna) {
            resp = new Matriz(m1.linha, m1.coluna);
            // ponteiros inicio
            Celula InicioR = resp.inicio;
            Celula InicioI = m1.inicio;

            while (InicioR != null) {
                // o que realmente vai mecher
                Celula r = InicioR;
                Celula i = InicioI;
                Celula j = m2.inicio; // sempre começa no início

                while (r != null) { // ve se existe
                    int soma = 0;
                    Celula iLin = i;
                    Celula jCol = j;

                    while (iLin != null && jCol != null) { // ve se existe
                        soma += iLin.elemento * jCol.elemento; // adiona na soma as mult. que se deve fazer
                        iLin = iLin.dir; // passa prox elemento (dir)
                        jCol = jCol.inf; // passa para baixo
                    }

                    r.elemento = soma; // coloca elemneto na matriz
                    r = r.dir; // passa para o prox
                    j = j.dir;
                    // a primeira linha faz todas as colunas e so depois vai ra baixo
                }
                // passa tudo pro pra baixo
                InicioR = InicioR.inf;
                InicioI = InicioI.inf;

            }
        }
        return resp;
    }

    public void mostrarDiagonalPrincipal() {
        Celula atual = inicio;
        for (int i = 0; i < linha; i++) {
            if (atual != null) { // não pode ser nulo
                System.out.print(atual.elemento + " ");
                if (atual.dir != null && atual.dir.inf != null) { // ve se a celula existe
                    atual = atual.dir.inf;
                } else {
                    break; // sai se não tiver mais digonais
                }
            } else {
                break; // sai se for nulo
            }
        }
        System.out.println(); // prox linha
    }

    public void mostrarDiagonalSecundaria() {
        Celula atual = inicio;
        // vai para a celula mais a direita
        for (int i = 0; i < coluna - 1; i++) {
            if (atual.dir != null) {
                atual = atual.dir;
            } else {
                return; // se não tem mais a direira sai
            }
        }
        // vai indo para baixo (diagonal)
        for (int i = 0; i < linha; i++) {
            if (atual != null) {
                System.out.print(atual.elemento + " ");
                if (atual.esq != null && atual.esq.inf != null) { // ve se existe
                    atual = atual.esq.inf;
                } else {
                    break; // sai se não existir
                }
            } else {
                break; // sai se for nulo
            }
        }
        System.out.println(); // prox linha
    }
}

public class Q09 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int casos = 0;
        casos = s.nextInt();
        for (int k = 0; k < casos; k++) {
            int l1 = s.nextInt();
            int c1 = s.nextInt();
            Matriz mat1 = new Matriz(l1, c1); // cria
            for (int i = 0; i < l1; i++) {
                for (int j = 0; j < c1; j++) {
                    int elemento = s.nextInt(); // os numeros a serem colocados
                    mat1.setElemento(i, j, elemento); // coloca os numeros na matriz
                }
            }
            int l2 = s.nextInt();
            int c2 = s.nextInt();
            Matriz mat2 = new Matriz(l2, c2);
            for (int i = 0; i < l2; i++) {
                for (int j = 0; j < c2; j++) {
                    int elemento = s.nextInt();
                    mat2.setElemento(i, j, elemento);
                }
            }
            mat1.mostrarDiagonalPrincipal();
            mat1.mostrarDiagonalSecundaria();
            Matriz mat3;
            mat3 = Matriz.soma(mat1, mat2);
            mat3.mostrar();
            Matriz mat4;
            mat4 = Matriz.multiplicacao(mat1, mat2);
            mat4.mostrar();
        }
        s.close();
    }
}
