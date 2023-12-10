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
    public No esq;
    public Jogador elemento;
    public No dir;

    No() {
        this(null);
    }

    No(Jogador elemento) {
        this.esq = this.dir = null;
        this.elemento = elemento;
    }

    No(No esq, Jogador elemento, No dir) {
        this.esq = esq;
        this.elemento = elemento;
        this.dir = dir;
    }

    public No clone() {
        return new No(esq, elemento, dir);
    }
}

class No2 {
    public No2 esq;
    public int val;
    public ArvoreBinaria ab;
    public No2 dir;

    No2() {
        this(new ArvoreBinaria(), 0);
    }

    No2(int val) {
        this(new ArvoreBinaria(), val);
    }

    No2(ArvoreBinaria ab, int val) {
        esq = dir = null;
        this.ab = ab;
        this.val = val;
    }
}

class ArvoreBinaria {
    No raiz;

    ArvoreBinaria() {
        raiz = null;
    }

    public void inserir(Jogador x) throws Exception {
        raiz = inserir(raiz, x);
    }

    private No inserir(No no, Jogador x) throws Exception {
        if (no == null) {
            no = new No(x);
        } else if (x.getNome().compareTo(no.elemento.getNome()) < 0) {
            no.esq = inserir(no.esq, x);
        } else if (x.getNome().compareTo(no.elemento.getNome()) > 0) {
            no.dir = inserir(no.dir, x);
        } else {
            throw new Exception("Erro");
        }
        return no;
    }

    public No pesquisa(String nome) {
        No resultado = null;
        No i = raiz;

        while (i != null) {
            if (nome.compareTo(i.elemento.getNome()) < 0) {
                i = i.esq;
            } else if (nome.compareTo(i.elemento.getNome()) > 0) {
                i = i.dir;
            } else {
                resultado = i;
                i = null;
            }
        }
        return resultado;
    }

    public boolean pesqBool(String nome) {
        return pesqBool(raiz, nome);
    }

    private boolean pesqBool(No i, String nome) {
        boolean resultado = false;

        if (i != null) {
            resultado = nome.compareTo(i.elemento.getNome()) == 0;
            if (resultado == false) {
                System.out.print("ESQ ");
                resultado = pesqBool(i.esq, nome);
            }
            if (resultado == false) {
                System.out.print("DIR ");
                resultado = pesqBool(i.dir, nome);
            }
        }
        return resultado;
    }
}

class ArvoreBinaria2 {
    No2 raiz;

    ArvoreBinaria2() throws Exception {
        raiz = null;
        int[] alturas = { 7, 3, 11, 1, 5, 9, 12, 0, 2, 4, 6, 8, 10, 13, 14 };
        inserir(alturas);
    }

    public void insertJogador(Jogador x) throws Exception {
        No2 noInsercao = pesq(x.getAltura() % 15);
        if (noInsercao == null)
            throw new Exception("Erro");
        noInsercao.ab.inserir(x);
    }

    public void inserir(int[] val) throws Exception {
        for (int pos = 0; pos < val.length; pos++) {
            raiz = inserir(val[pos], raiz);
        }
    }

    private No2 inserir(int val, No2 i) throws Exception {
        if (i == null) {
            i = new No2(val);
        } else if (val < i.val) {
            i.esq = inserir(val, i.esq);
        } else if (val > i.val) {
            i.dir = inserir(val, i.dir);
        } else {
            throw new Exception("Erro");
        }
        return i;
    }

    public No2 pesq(int val) {
        No2 tmp = raiz;
        No2 resultado = null;
        while (tmp != null) {
            if (val < tmp.val) {
                tmp = tmp.esq;
            } else if (val > tmp.val) {
                tmp = tmp.dir;
            } else {
                resultado = tmp;
                tmp = null;
            }
        }
        return resultado;
    }

    public boolean pesqBool(String teste) {
        System.out.print("raiz ");
        return pesqBool(raiz, teste);
    }

    private boolean pesqBool(No2 i, String teste) {
        boolean resultado = false;
        if (i != null) {
            resultado = i.ab.pesqBool(teste);
            if (resultado == false) {
                System.out.print("esq ");
                resultado = pesqBool(i.esq, teste);
            }
            if (resultado == false) {
                System.out.print("dir ");
                resultado = pesqBool(i.dir, teste);
            }
        }
        return resultado;
    }

    public void criarLog(String matricula, long tempoExecucao, int numComparacoes) {
        try {
            FileWriter fileWriter = new FileWriter(matricula + "800989_arvoreArvore.txt");
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.println("800989" + "\t" + tempoExecucao + "\t" + numComparacoes);
            printWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

public class Q02 {
    public static void main(String[] args) throws Exception {
        Scanner s = new Scanner(System.in);
        long tempoInicial = System.currentTimeMillis();
        ArvoreBinaria2 ab = new ArvoreBinaria2();
        Jogador jogador = new Jogador();
        int numComparacoes = 0;
        String novoId = s.nextLine();
        try {
            while (!novoId.equals("FIM")) {
                jogador.ler(novoId);
                ab.insertJogador(jogador.clone());
                novoId = s.nextLine();
            }

            novoId = s.nextLine();
            while (!novoId.equals("FIM")) {
                System.out.print(novoId + " ");
                if (ab.pesqBool(novoId) == true) {
                    System.out.print("SIM\n");
                } else {
                    System.out.print("NAO\n");
                }
                novoId = s.nextLine();
            }

        } catch (Exception e) {
            System.out.println("Erro");
        }
        long tempoFinal = System.currentTimeMillis();
        ab.criarLog("800989", tempoFinal - tempoInicial, numComparacoes);
        s.close();
    }
}
