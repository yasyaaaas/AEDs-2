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
    public No esq, dir;
    public int nivel;

    public No(Jogador elemento) {
        this(elemento, null, null, 1);
    }

    public No(Jogador elemento, No esq, No dir, int nivel) {
        this.elemento = elemento;
        this.esq = esq;
        this.dir = dir;
        this.nivel = nivel;
    }

    public void setNivel() {
        this.nivel = 1 + Math.max(getNivel(esq), getNivel(dir));
    }

    public static int getNivel(No no) {
        return (no == null) ? 0 : no.nivel;
    }
}

class AVL {
    private No raiz;

    public AVL() {
        raiz = null;
    }

    public String pesquisar(Jogador x) {
        return pesquisar(x, raiz, "");
    }

    private String pesquisar(Jogador x, No i, String path) {
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
        return path + " " + resp;
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
        return balancear(i);
    }

    private No balancear(No no) throws Exception {
        if (no != null) {
            int fator = No.getNivel(no.dir) - No.getNivel(no.esq);
            if (Math.abs(fator) <= 1) {
                no.setNivel();
            } else if (fator == 2) {
                int fatorFilhoDir = No.getNivel(no.dir.dir) - No.getNivel(no.dir.esq);
                if (fatorFilhoDir == -1) {
                    no.dir = rotacionarDir(no.dir);
                }
                no = rotacionarEsq(no);
            } else if (fator == -2) {
                int fatorFilhoEsq = No.getNivel(no.esq.dir) - No.getNivel(no.esq.esq);
                if (fatorFilhoEsq == 1) {
                    no.esq = rotacionarEsq(no.esq);
                }
                no = rotacionarDir(no);
            } else {
                throw new Exception(
                        "Erro no No(" + no.elemento + ") com fator de balanceamento (" + fator + ") invalido!");
            }
        }
        return no;
    }

    private No rotacionarDir(No no) {
        No noEsq = no.esq;
        No noEsqDir = noEsq.dir;

        noEsq.dir = no;
        no.esq = noEsqDir;
        no.setNivel();
        noEsq.setNivel();

        return noEsq;
    }

    private No rotacionarEsq(No no) {
        No noDir = no.dir;
        No noDirEsq = noDir.esq;

        noDir.esq = no;
        no.dir = noDirEsq;

        no.setNivel();
        noDir.setNivel();
        return noDir;
    }

    public void criarLog(String matricula, long tempoExecucao, int numComparacoes) {
        try {
            FileWriter fileWriter = new FileWriter(matricula + "800989_avl.txt");
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.println("800989" + "\t" + tempoExecucao + "\t" + numComparacoes);
            printWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

public class teste3 {
    public static void main(String[] args) throws Exception {
        Scanner s = new Scanner(System.in);
        long tempoInicial = System.currentTimeMillis();
        AVL avl = new AVL();
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
            avl.inserir(jogador);
        }
        while (true) {
            nomesJog = s.nextLine();
            if (nomesJog.equals("FIM")) {
                break;
            }
            Jogador jogador = new Jogador();
            jogador.setNome(nomesJog);
            System.out.println(jogador.getNome() + " raiz" + avl.pesquisar(jogador));
            numComparacoes++;
        }
        long tempoFinal = System.currentTimeMillis();
        avl.criarLog("800989", tempoFinal - tempoInicial, numComparacoes);
        s.close();
    }
}
