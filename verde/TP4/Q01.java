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
    public Jogador elemento; // Conteudo do no.
    public No esq, dir; // Filhos da esq e dir.

    public No(Jogador elemento) {
        this(elemento, null, null);
    }

    public No(Jogador elemento, No esq, No dir) {
        this.elemento = elemento;
        this.esq = esq;
        this.dir = dir;
    }
}

class ArvoreBinaria {
    private No raiz; // Raiz da arvore.

    public ArvoreBinaria() {
        raiz = null;
    }

    public String pesquisar(Jogador x) {
        return pesquisar(x, raiz, "");
    }

    private String pesquisar(Jogador x, No i, String nada) {
        String resp;
        if (i == null) {
            resp = "NAO";
        } else if (x.getNome().equals(i.elemento.getNome())) {
            resp = "SIM";
        } else if (x.getNome().compareTo(i.elemento.getNome()) < 0) {
            resp = pesquisar(x, i.esq, "esq");
        } else {
            resp = pesquisar(x, i.dir, "dir");
        }
        return nada + " " + resp;
    }

    public void inserir(Jogador x) throws Exception {
        raiz = inserir(x, raiz);
    }

    private No inserir(Jogador x, No i) throws Exception {
        if (i == null) {
            i = new No(x);

        } else if (x.getNome().compareTo(i.elemento.getNome()) < 0) {
            i.esq = inserir(x, i.esq);

        } else if (x.getNome().compareTo(i.elemento.getNome()) > 0) {
            i.dir = inserir(x, i.dir);

        } else {
            throw new Exception("Erro ao inserir!");
        }

        return i;
    }

    public void criarLog(String matricula, long tempoExecucao, int numComparacoes) {
        try {
            FileWriter fileWriter = new FileWriter(matricula + "800989_arvoreBinaria.txt");
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.println("800989" + "\t" + tempoExecucao + "\t" + numComparacoes);
            printWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

public class Q01 {
    public static void main(String[] args) throws Exception {
        Scanner s = new Scanner(System.in);
        long tempoInicial = System.currentTimeMillis();
        ArvoreBinaria ab = new ArvoreBinaria();
        String novoId;
        String nomesJog;
        int numComparacoes = 0;
        // le o id dos jogadores e os coloca na AB
        while (true) {
            novoId = s.nextLine();
            if (novoId.equals("FIM")) {
                break;
            }
            Jogador jogador = new Jogador();
            jogador.ler(novoId);
            ab.inserir(jogador);
        }
        // le os nomes a serem pesquisados
        while (true) {
            nomesJog = s.nextLine();
            if (nomesJog.equals("FIM")) {
                break;
            }
            Jogador jogador = new Jogador();
            jogador.setNome(nomesJog);
            System.out.println(jogador.getNome() + " raiz" + ab.pesquisar(jogador));
            numComparacoes++;
        }
        long tempoFinal = System.currentTimeMillis();
        ab.criarLog("800989", tempoFinal - tempoInicial, numComparacoes);
        s.close();
    }
}