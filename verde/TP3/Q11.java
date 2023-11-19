import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

class Jogador {
    private int id;
    private String nome;
    private int altura;
    private int peso;
    private String universidade;
    private int anoNascimento;
    private String cidadeNascimento;
    private String estadoNascimento;

    public Jogador() {

    }

    public Jogador(int id, String nome, int altura, int peso, String universidade,
            int anoNascimento, String cidadeNascimento, String estadoNascimento) {
        this.id = id;
        this.nome = nome;
        this.altura = altura;
        this.peso = peso;
        this.universidade = universidade;
        this.anoNascimento = anoNascimento;
        this.cidadeNascimento = cidadeNascimento;
        this.estadoNascimento = estadoNascimento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public String getUniversidade() {
        return universidade;
    }

    public void setUniversidade(String universidade) {
        this.universidade = universidade;
    }

    public int getAnoNascimento() {
        return anoNascimento;
    }

    public void setAnoNascimento(int anoNascimento) {
        this.anoNascimento = anoNascimento;
    }

    public String getCidadeNascimento() {
        return cidadeNascimento;
    }

    public void setCidadeNascimento(String cidadeNascimento) {
        this.cidadeNascimento = cidadeNascimento;
    }

    public String getEstadoNascimento() {
        return estadoNascimento;
    }

    public void setEstadoNascimento(String estadoNascimento) {
        this.estadoNascimento = estadoNascimento;
    }

    public Jogador clone() {
        return new Jogador(id, nome, altura, peso, universidade, anoNascimento,
                cidadeNascimento, estadoNascimento);
    }

    public void imprimir() {
        System.out.println(
                "[" + id + " ## " + nome + " ## " + altura + " ## " + peso + " ## " + anoNascimento + " ## "
                        + universidade + " ## " + cidadeNascimento + " ## " + estadoNascimento + "]");
    }

    public void ler(String novoID) { // pega o id colocado no input
        try {
            BufferedReader reader = new BufferedReader(new FileReader("/tmp/players.csv"));
            String info;
            while ((info = reader.readLine()) != null) {
                String[] campos = info.split(",", -1);
                if (campos.length == 8 && campos[0].equals(novoID.trim())) {
                    id = Integer.parseInt(campos[0]);
                    nome = campos[1];
                    altura = Integer.parseInt(campos[2]);
                    peso = Integer.parseInt(campos[3]);
                    universidade = campos[4];
                    anoNascimento = Integer.parseInt(campos[5]);
                    cidadeNascimento = campos[6];
                    estadoNascimento = campos[7];
                    break;
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (nome == null || nome.isEmpty()) {
            nome = "nao informado";
        }
        if (universidade == null || universidade.isEmpty()) {
            universidade = "nao informado";
        }
        if (cidadeNascimento == null || cidadeNascimento.isEmpty()) {
            cidadeNascimento = "nao informado";
        }
        if (estadoNascimento == null || estadoNascimento.isEmpty()) {
            estadoNascimento = "nao informado";
        }
    }

}

class CelulaDupla {
    public Jogador elemento;
    public CelulaDupla ant;
    public CelulaDupla prox;

    public CelulaDupla() {
        this(null);
    }

    public CelulaDupla(Jogador elemento) {
        this.elemento = elemento;
        this.ant = this.prox = null;
    }

    public CelulaDupla clone() {
        CelulaDupla tmp = new CelulaDupla(elemento);
        tmp.ant = this.ant;
        tmp.prox = this.prox;
        return tmp;
    }
}

class ListaDupla {
    private CelulaDupla primeiro;
    private CelulaDupla ultimo;

    public CelulaDupla getPrimeiro() {
        return primeiro.prox;
    }

    public CelulaDupla getUltimo() {
        return ultimo;
    }

    public ListaDupla() {
        primeiro = new CelulaDupla();
        ultimo = primeiro;
    }

    public void inserirInicio(Jogador x) {
        CelulaDupla tmp = new CelulaDupla(x);

        tmp.ant = primeiro;
        tmp.prox = primeiro.prox;
        primeiro.prox = tmp;
        if (primeiro == ultimo) {
            ultimo = tmp;
        } else {
            tmp.prox.ant = tmp;
        }
        tmp = null;
    }

    public void inserirFim(Jogador x) {
        ultimo.prox = new CelulaDupla(x);
        ultimo.prox.ant = ultimo;
        ultimo = ultimo.prox;
    }

    public Jogador removerInicio() throws Exception {
        if (primeiro == ultimo) {
            throw new Exception("Erro ao remover (vazia)!");
        }

        CelulaDupla tmp = primeiro;
        primeiro = primeiro.prox;
        Jogador resp = primeiro.elemento;
        tmp.prox = primeiro.ant = null;
        tmp = null;
        return resp;
    }

    public Jogador removerFim() throws Exception {
        if (primeiro == ultimo) {
            throw new Exception("Erro ao remover (vazia)!");
        }
        Jogador resp = ultimo.elemento;
        ultimo = ultimo.ant;
        ultimo.prox.ant = null;
        ultimo.prox = null;
        return resp;
    }

    public void inserir(Jogador x, int pos) throws Exception {

        int tamanho = tamanho();

        if (pos < 0 || pos > tamanho) {
            throw new Exception("Erro ao inserir posicao (" + pos + " / tamanho = " + tamanho + ") invalida!");
        } else if (pos == 0) {
            inserirInicio(x);
        } else if (pos == tamanho) {
            inserirFim(x);
        } else {
            // Caminhar ate a posicao anterior a insercao
            CelulaDupla i = primeiro;
            for (int j = 0; j < pos; j++, i = i.prox)
                ;

            CelulaDupla tmp = new CelulaDupla(x);
            tmp.ant = i;
            tmp.prox = i.prox;
            tmp.ant.prox = tmp.prox.ant = tmp;
            tmp = i = null;
        }
    }

    public Jogador remover(int pos) throws Exception {
        Jogador resp;
        int tamanho = tamanho();

        if (primeiro == ultimo) {
            throw new Exception("Erro ao remover (vazia)!");

        } else if (pos < 0 || pos >= tamanho) {
            throw new Exception("Erro ao remover (posicao " + pos + " / " + tamanho + " invalida!");
        } else if (pos == 0) {
            resp = removerInicio();
        } else if (pos == tamanho - 1) {
            resp = removerFim();
        } else {
            // Caminhar ate a posicao anterior a insercao
            CelulaDupla i = primeiro.prox;
            for (int j = 0; j < pos; j++, i = i.prox)
                ;

            i.ant.prox = i.prox;
            i.prox.ant = i.ant;
            resp = i.elemento;
            i.prox = i.ant = null;
            i = null;
        }

        return resp;
    }

    public void mostrar() {
        System.out.print("[ "); // Comeca a mostrar.
        for (CelulaDupla i = primeiro.prox; i != null; i = i.prox) {
            System.out.println(i.elemento.getNome() + " ");
        }
        System.out.println("] "); // Termina de mostrar.
    }

    public void mostrarInverso() {
        System.out.print("[ ");
        for (CelulaDupla i = ultimo; i != primeiro; i = i.ant) {
            System.out.print(i.elemento + " ");
        }
        System.out.println("] "); // Termina de mostrar.
    }

    public boolean pesquisar(Jogador x) {
        boolean resp = false;
        for (CelulaDupla i = primeiro.prox; i != null; i = i.prox) {
            if (i.elemento == x) {
                resp = true;
                i = ultimo;
            }
        }
        return resp;
    }

    public int tamanho() {
        int tamanho = 0;
        for (CelulaDupla i = primeiro; i != ultimo; i = i.prox, tamanho++)
            ;
        return tamanho;
    }

}

public class Q11 {

    public static int numComp = 0;
    public static int numMov = 0;

    private static void ordenarPorEstado(ListaDupla jogadores) {
        quicksort(jogadores, jogadores.getPrimeiro(), jogadores.getUltimo());
        // imprimir jogadores
        for (CelulaDupla i = jogadores.getPrimeiro(); i != null; i = i.prox) {
            i.elemento.imprimir();
        }
    }

    private static void quicksort(ListaDupla jogadores, CelulaDupla esq, CelulaDupla dir) {
        CelulaDupla i = esq;
        CelulaDupla j = dir;
        CelulaDupla pivo = esq;
        ;
        while (i != j) {
            while (j != pivo && j != i
                    && j.elemento.getEstadoNascimento().compareTo(pivo.elemento.getEstadoNascimento()) > 0
                    || j.elemento.getEstadoNascimento().compareTo(pivo.elemento.getEstadoNascimento()) == 0
                            && j.elemento.getNome().compareTo(pivo.elemento.getNome()) > 0) {
                j = j.ant;
                numComp++;
            }
            while (i != pivo && i != j
                    && i.elemento.getEstadoNascimento().compareTo(pivo.elemento.getEstadoNascimento()) < 0
                    || i.elemento.getEstadoNascimento().compareTo(pivo.elemento.getEstadoNascimento()) == 0
                            && i.elemento.getNome().compareTo(pivo.elemento.getNome()) > 0) {
                i = i.prox;
                numComp++;
            }
            if (i != j) {
                swap(i, j);
            }
        }
        if (pivo != j) {
            swap(pivo, j);
        }
        if (esq != j) {
            quicksort(jogadores, esq, j.ant);
        }
        if (dir != j) {
            quicksort(jogadores, j.prox, dir);
        }
    }

    public static void swap(CelulaDupla i, CelulaDupla j) {
        // CelulaDupla temp = i.clone();
        // i.ant.prox = j;
        // i.prox.ant = j;
        // if (j.prox != null) {
        // j.prox.ant = i;
        // }
        // j.ant.prox = i;
        // i.prox = j.prox;
        // i.ant = j.ant;
        // j.prox = temp.prox;
        // j.ant = temp.ant;
        Jogador temp2 = i.elemento;
        i.elemento = j.elemento;
        j.elemento = temp2;
        numMov++;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        long tempoExecucao = System.currentTimeMillis();
        ListaDupla jogadores = new ListaDupla();
        String novoId;
        while (true) {
            novoId = s.nextLine();
            if (novoId.charAt(0) == 'F' && novoId.charAt(1) == 'I' && novoId.charAt(2) == 'M') {
                break;
            }
            Jogador jogador = new Jogador(); // cria um Jogador
            jogador.ler(novoId); // le as info do jogador
            jogadores.inserirFim(jogador); // adiciona o jogador a listaDupla jogadores
        }
        ordenarPorEstado(jogadores);
        // Parte 3: Escrever log
        try {
            FileWriter arquivoLog = new FileWriter("matrícula_quicksort2.txt");
            PrintWriter gravador = new PrintWriter(arquivoLog);
            String matricula = "800989";
            tempoExecucao = System.currentTimeMillis() - tempoExecucao; // Calcule o tempo de execução
            gravador.printf("%s\t%d\t%d\t%d%n", matricula, numComp, numMov, tempoExecucao);
            arquivoLog.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        s.close();
    }
}
