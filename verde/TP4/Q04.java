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

class NoAN {
    public boolean cor;
    public Jogador elemento;
    public NoAN esq, dir;

    public NoAN(Jogador elemento) {
        this(elemento, false, null, null);
    }

    public NoAN(Jogador elemento, boolean cor) {
        this(elemento, cor, null, null);
    }

    public NoAN(Jogador elemento, boolean cor, NoAN esq, NoAN dir) {
        this.cor = cor;
        this.elemento = elemento;
        this.esq = esq;
        this.dir = dir;
    }
}

class Alvinegra {
    private NoAN raiz; // Raiz da arvore.

    public Alvinegra() {
        raiz = null;
    }

    public String pesquisar(Jogador x) {
        return pesquisar(x, raiz, "");
    }

    private String pesquisar(Jogador x, NoAN i, String path) {
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

    public void inserir(Jogador elemento) throws Exception {
        if (raiz == null) {
            raiz = new NoAN(elemento);
        } else if (raiz.esq == null && raiz.dir == null) {
            if (elemento.getNome().compareTo(raiz.elemento.getNome()) < 0) {
                raiz.esq = new NoAN(elemento);
            } else {
                raiz.dir = new NoAN(elemento);
            }
        } else if (raiz.esq == null) {
            if (elemento.getNome().compareTo(raiz.elemento.getNome()) < 0) {
                raiz.esq = new NoAN(elemento);

            } else if (elemento.getNome().compareTo(raiz.dir.elemento.getNome()) < 0) {
                raiz.esq = new NoAN(raiz.elemento);
                raiz.elemento = elemento;
            } else {
                raiz.esq = new NoAN(raiz.elemento);
                raiz.elemento = raiz.dir.elemento;
                raiz.dir.elemento = elemento;
            }
            raiz.esq.cor = raiz.dir.cor = false;
        } else if (raiz.dir == null) {
            if (elemento.getNome().compareTo(raiz.elemento.getNome()) > 0) {
                raiz.dir = new NoAN(elemento);
            } else if (elemento.getNome().compareTo(raiz.esq.elemento.getNome()) > 0) {
                raiz.dir = new NoAN(raiz.elemento);
                raiz.elemento = elemento;
            } else {
                raiz.dir = new NoAN(raiz.elemento);
                raiz.elemento = raiz.esq.elemento;
                raiz.esq.elemento = elemento;
            }
            raiz.esq.cor = raiz.dir.cor = false;
        } else {
            inserir(elemento, null, null, null, raiz);
        }
        raiz.cor = false;
    }

    private void balancear(NoAN bisavo, NoAN avo, NoAN pai, NoAN i) {
        if (pai.cor == true) {
            if (pai.elemento.getNome().compareTo(avo.elemento.getNome()) > 0) {
                if (i.elemento.getNome().compareTo(pai.elemento.getNome()) > 0) {
                    avo = rotacaoEsq(avo);
                } else {
                    avo = rotacaoDirEsq(avo);
                }
            } else {
                if (i.elemento.getNome().compareTo(pai.elemento.getNome()) < 0) {
                    avo = rotacaoDir(avo);
                } else {
                    avo = rotacaoEsqDir(avo);
                }
            }
            if (bisavo == null) {
                raiz = avo;
            } else if (avo.elemento.getNome().compareTo(bisavo.elemento.getNome()) < 0) {
                bisavo.esq = avo;
            } else {
                bisavo.dir = avo;
            }
            avo.cor = false;
            avo.esq.cor = avo.dir.cor = true;
        }
    }

    private void inserir(Jogador elemento, NoAN bisavo, NoAN avo, NoAN pai, NoAN i) throws Exception {
        if (i == null) {
            if (elemento.getNome().compareTo(pai.elemento.getNome()) < 0) {
                i = pai.esq = new NoAN(elemento, true);
            } else {
                i = pai.dir = new NoAN(elemento, true);
            }
            if (pai.cor == true) {
                balancear(bisavo, avo, pai, i);
            }
        } else {
            if (i.esq != null && i.dir != null && i.esq.cor == true && i.dir.cor == true) {
                i.cor = true;
                i.esq.cor = i.dir.cor = false;
                if (i == raiz) {
                    i.cor = false;
                } else if (pai.cor == true) {
                    balancear(bisavo, avo, pai, i);
                }
            }
            if (elemento.getNome().compareTo(i.elemento.getNome()) < 0) {
                inserir(elemento, avo, pai, i, i.esq);
            } else if (elemento.getNome().compareTo(i.elemento.getNome()) > 0) {
                inserir(elemento, avo, pai, i, i.dir);
            } else {
                throw new Exception("Erro inserir (elemento repetido)!");
            }
        }
    }

    private NoAN rotacaoDir(NoAN no) {
        NoAN noEsq = no.esq;
        NoAN noEsqDir = noEsq.dir;

        noEsq.dir = no;
        no.esq = noEsqDir;

        return noEsq;
    }

    private NoAN rotacaoEsq(NoAN no) {
        NoAN noDir = no.dir;
        NoAN noDirEsq = noDir.esq;

        noDir.esq = no;
        no.dir = noDirEsq;
        return noDir;
    }

    private NoAN rotacaoDirEsq(NoAN no) {
        no.dir = rotacaoDir(no.dir);
        return rotacaoEsq(no);
    }

    private NoAN rotacaoEsqDir(NoAN no) {
        no.esq = rotacaoEsq(no.esq);
        return rotacaoDir(no);
    }

    public void criarLog(String matricula, long tempoExecucao, int numComparacoes) {
        try {
            FileWriter fileWriter = new FileWriter(matricula + "800989_alvinegra.txt");
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.println("800989" + "\t" + tempoExecucao + "\t" + numComparacoes);
            printWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

public class Q04 {
    public static void main(String[] args) throws Exception {
        Scanner s = new Scanner(System.in);
        long tempoInicial = System.currentTimeMillis();
        Alvinegra an = new Alvinegra();
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
            an.inserir(jogador);
        }
        // le os nomes a serem pesquisados
        while (true) {
            nomesJog = s.nextLine();
            if (nomesJog.equals("FIM")) {
                break;
            }
            Jogador jogador = new Jogador();
            jogador.setNome(nomesJog);
            System.out.println(jogador.getNome() + " raiz" + an.pesquisar(jogador));
            numComparacoes++;
        }
        long tempoFinal = System.currentTimeMillis();
        an.criarLog("800989", tempoFinal - tempoInicial, numComparacoes);
        s.close();
    }
}
