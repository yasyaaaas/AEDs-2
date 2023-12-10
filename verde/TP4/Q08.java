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

class Hash {
    Jogador tabela[];
    int m;
    final int NULO = -1;

    public Hash() {
        this(25);
    }

    public Hash(int m) {
        this.m = m;
        this.tabela = new Jogador[this.m];
        for (int i = 0; i < m; i++) {
            tabela[i] = null;
        }
    }

    public int h(Jogador elemento) {
        return elemento.getAltura() % m;
    }

    public int reh(Jogador elemento) {
        return (elemento.getAltura() + 2) % m;
    }

    public boolean inserir(Jogador elemento) {
        boolean resp = false;
        if (elemento != null) {
            int pos = h(elemento);
            if (tabela[pos] == null) {
                tabela[pos] = elemento;
                resp = true;
            } else {
                pos = reh(elemento);
                if (tabela[pos] == null) {
                    tabela[pos] = elemento;
                    resp = true;
                }
            }
        }
        return resp;
    }

    public String pesquisar(Jogador elemento) {
        String resp = "NAO";
        int pos = h(elemento);
        if (tabela[pos] != null && tabela[pos].getNome().equals(elemento.getNome())) {
            resp = "SIM";
        } else if (tabela[pos] != null) {
            pos = reh(elemento);
            if (tabela[pos] != null && tabela[pos].getNome().equals(elemento.getNome())) {
                resp = "SIM";
            }
        }
        return resp;
    }

    public void criarLog(String matricula, long tempoExecucao, int numComparacoes) {
        try {
            FileWriter fileWriter = new FileWriter(matricula + "800989_hashRehash.txt");
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.println("800989" + "\t" + tempoExecucao + "\t" + numComparacoes);
            printWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

public class Q08 {
    public static void main(String[] args) throws Exception {
        Scanner s = new Scanner(System.in);
        long tempoInicial = System.currentTimeMillis();
        Hash h = new Hash();
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
            h.inserir(jogador);
        }
        // le os nomes a serem pesquisados
        while (true) {
            nomesJog = s.nextLine();
            if (nomesJog.equals("FIM")) {
                break;
            }
            Jogador jogador = new Jogador();
            jogador.setNome(nomesJog);
            System.out.println(jogador.getNome() + " " + h.pesquisar(jogador));
            numComparacoes++;
        }
        long tempoFinal = System.currentTimeMillis();
        h.criarLog("800989", tempoFinal - tempoInicial, numComparacoes);
        s.close();
    }
}
