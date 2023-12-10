import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

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

    public void ler(String novoID) {
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

class No {
    public Jogador elemento;
    public final int tamanho = 255;
    public No[] prox;
    public boolean folha;

    public No() {
        this(null);
    }

    public No(Jogador elemento) {
        this.elemento = elemento;
        prox = new No[tamanho];
        for (int i = 0; i < tamanho; i++)
            prox[i] = null;
        folha = false;
    }

    public static int hash(char x) {
        return (int) x;
    }
}

class ArvoreTrie {
    No raiz;

    public ArvoreTrie() {
        raiz = new No();
    }

    public boolean pesquisar(Jogador x) throws Exception {
        return pesquisar(x, raiz, 0);
    }

    public boolean pesquisar(Jogador x, No no, int i) throws Exception {
        boolean resp;
        if (no.prox[x.getNome().charAt(i)] == null) {
            resp = false;
        } else if (i == x.getNome().length() - 1) {
            resp = (no.prox[x.getNome().charAt(i)].folha == true);
        } else if (i < x.getNome().length() - 1) {
            resp = pesquisar(x, no.prox[x.getNome().charAt(i)], i + 1);
        } else {
            throw new Exception("Erro ao pesquisar!");
        }
        return resp;
    }

    public void inserir(Jogador x) throws Exception {
        inserir(x, raiz, 0);
    }

    private void inserir(Jogador x, No no, int i) throws Exception {
        if (no.prox[x.getNome().charAt(i)] == null) {
            no.prox[x.getNome().charAt(i)] = new No(x);

            if (i == x.getNome().length() - 1) {
                no.prox[x.getNome().charAt(i)].folha = true;
            } else {
                inserir(x, no.prox[x.getNome().charAt(i)], i + 1);
            }

        } else if (no.prox[x.getNome().charAt(i)].folha == false && i < x.getNome().length() - 1) {
            inserir(x, no.prox[x.getNome().charAt(i)], i + 1);

        } else {
            // System.out.println("Inserção inválida para jogador: " + x.getNome());
        }
    }

    public void criarLog(String matricula, long tempoExecucao, int numComparacoes) {
        try {
            FileWriter fileWriter = new FileWriter(matricula + "800989_arvoreTrie.txt");
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.println("800989" + "\t" + tempoExecucao + "\t" + numComparacoes);
            printWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

public class Q06 {

    private static void mergeTries(ArvoreTrie trie1, ArvoreTrie trie2) {
        mergeTriesRecursive(trie1.raiz, trie2.raiz, trie1);
    }

    private static void mergeTriesRecursive(No no1, No no2, ArvoreTrie trie1) {
        if (no2.folha) {
            try {
                trie1.inserir(no2.elemento.clone());
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            for (int i = 0; i < no2.tamanho; i++) {
                if (no2.prox[i] != null) {
                    if (no1.prox[i] == null) {
                        no1.prox[i] = new No();
                    }
                    mergeTriesRecursive(no1.prox[i], no2.prox[i], trie1);
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner s = new Scanner(System.in);
        long tempoInicial = System.currentTimeMillis();
        ArvoreTrie trie1 = new ArvoreTrie();
        ArvoreTrie trie2 = new ArvoreTrie();
        String novoId;
        String nomesJog;
        int numComparacoes = 0;
        while (true) {
            novoId = s.nextLine();
            if (novoId.equals("FIM")) {
                break;
            }
            Jogador jogador = new Jogador();
            jogador.ler(novoId);
            trie1.inserir(jogador);
        }
        while (true) {
            nomesJog = s.nextLine();
            if (nomesJog.equals("FIM")) {
                break;
            }
            Jogador jogador = new Jogador();
            jogador.setNome(nomesJog);
            trie2.inserir(jogador);
        }
        mergeTries(trie1, trie2);
        while (true) {
            nomesJog = s.nextLine();
            if (nomesJog.equals("FIM")) {
                break;
            }
            Jogador jogador = new Jogador();
            jogador.setNome(nomesJog);
            boolean resultadoPesquisa = trie1.pesquisar(jogador);
            System.out.println(jogador.getNome() + (resultadoPesquisa ? " SIM" : " NAO"));
            numComparacoes++;
        }
        long tempoFinal = System.currentTimeMillis();
        trie2.criarLog("800989", tempoFinal - tempoInicial, numComparacoes);
        s.close();
    }
}
