import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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
                " ## " + nome + " ## " + altura + " ## " + peso + " ## " + anoNascimento + " ## "
                        + universidade + " ## " + cidadeNascimento + " ## " + estadoNascimento + "##");
    }

    public void ler(String novoID) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("/tmp/players.csv"));
            String info;
            while ((info = reader.readLine()) != null) {
                String[] campos = info.split(",", -1);
                if (campos.length == 8 && campos[0].equals(novoID.trim())) {
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
        } catch (

        IOException e) {
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

class Celula {
    public Jogador elemento;
    public Celula prox;

    public Celula() {
        this(null);
    }

    public Celula(Jogador elemento) {
        this.elemento = elemento;
        this.prox = null;
    }
}

class Lista {
    private Celula primeiro;
    private Celula ultimo;

    public Lista() {
        primeiro = new Celula();
        ultimo = primeiro;
    }

    public Celula getPrimeiro() {
        return primeiro;
    }

    public void inserirInicio(Jogador x) {
        Celula tmp = new Celula(x);
        tmp.prox = primeiro.prox;
        primeiro.prox = tmp;
        if (primeiro == ultimo) {
            ultimo = tmp;
        }
        tmp = null;
    }

    public void inserirFim(Jogador x) {
        ultimo.prox = new Celula(x);
        ultimo = ultimo.prox;
    }

    public Jogador removerInicio() throws Exception {
        if (primeiro == ultimo) {
            throw new Exception("Erro ao remover (vazia)!");
        }

        Celula tmp = primeiro;
        primeiro = primeiro.prox;
        Jogador resp = primeiro.elemento;
        tmp.prox = null;
        tmp = null;
        return resp;
    }

    public Jogador removerFim() throws Exception {
        if (primeiro == ultimo) {
            throw new Exception("Erro ao remover (vazia)!");
        }

        Celula i;
        for (i = primeiro; i.prox != ultimo; i = i.prox)
            ;

        Jogador resp = ultimo.elemento;
        ultimo = i;
        i = ultimo.prox = null;

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
            Celula i = primeiro;
            for (int j = 0; j < pos; j++, i = i.prox)
                ;

            Celula tmp = new Celula(x);
            tmp.prox = i.prox;
            i.prox = tmp;
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
            Celula i = primeiro;
            for (int j = 0; j < pos; j++, i = i.prox)
                ;

            Celula tmp = i.prox;
            resp = tmp.elemento;
            i.prox = tmp.prox;
            tmp.prox = null;
            i = tmp = null;
        }

        return resp;
    }

    public void mostrar() {
        System.out.print("[ ");
        for (Celula i = primeiro.prox; i != null; i = i.prox) {
            System.out.print(i.elemento + " ");
        }
        System.out.println("] ");
    }

    boolean pesquisar(Jogador x) {
        boolean resp = false;
        for (Celula i = primeiro.prox; i != null; i = i.prox) {
            if (i.elemento == x) {
                resp = true;
                i = ultimo;
            }
        }
        return resp;
    }

    public int tamanho() {
        int tamanho = 0;
        for (Celula i = primeiro; i != ultimo; i = i.prox, tamanho++)
            ;
        return tamanho;
    }
}

class ColetaLixo {
    private Celula primeiro;

    public ColetaLixo() {
        primeiro = new Celula();
    }

    public void inserir(Jogador x) {
        primeiro.prox = new Celula(x);
        primeiro = primeiro.prox;
    }
}

public class Q05 {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        Lista jogadores = new Lista();
        ColetaLixo coletaLixo = new ColetaLixo();
        List<Jogador> removedPlayers = new ArrayList<>(); // cria uma lista de jogadores removidos
        String novoId;
        int num;
        String entrada;
        // ler até fim
        while (true) {
            novoId = scanner.nextLine(); // le o id do input
            if (novoId.charAt(0) == 'F' && novoId.charAt(1) == 'I' && novoId.charAt(2) == 'M') {
                break; // vai ate fim
            }
            Jogador jogador = new Jogador(); // cria um Jogador
            jogador.ler(novoId); // le as info do jogador
            jogadores.inserirFim(jogador); // adiciona o jogador a lista jogadores
        }
        // rempções e inserções
        num = scanner.nextInt();
        scanner.nextLine();
        for (int j = 0; j < num; j++) {
            entrada = scanner.nextLine();
            String[] campo = entrada.split(" ");
            if (campo[0].equals("II")) {
                Jogador jogador = new Jogador();
                jogador.ler(campo[1]);
                jogadores.inserirInicio(jogador);
            } else if (campo[0].equals("I*")) {
                Jogador jogador = new Jogador();
                jogador.ler(campo[2]);
                int posi = Integer.parseInt(campo[1]);
                jogadores.inserir(jogador, posi);
            } else if (campo[0].equals("IF")) {
                Jogador jogador = new Jogador();
                jogador.ler(campo[1]);
                jogadores.inserirFim(jogador);
            } else if (campo[0].equals("RI")) {
                Jogador removedPlayer = jogadores.removerInicio();
                removedPlayers.add(removedPlayer);
                coletaLixo.inserir(removedPlayer);
            } else if (campo[0].equals("R*")) {
                int posi = Integer.parseInt(campo[1]);
                Jogador removedPlayer = jogadores.remover(posi);
                removedPlayers.add(removedPlayer);
                coletaLixo.inserir(removedPlayer);
            } else if (campo[0].equals("RF")) {
                Jogador removedPlayer = jogadores.removerFim();
                removedPlayers.add(removedPlayer);
                coletaLixo.inserir(removedPlayer);
            }
        }

        for (Jogador removedPlayer : removedPlayers) {
            System.out.println("(R) " + removedPlayer.getNome()); // printa o nome do Jogador removido
        }

        int index = 0;
        // Celula i = primeiro; i != null; i = i.prox
        for (Celula celula = jogadores.getPrimeiro().prox; celula != null; celula = celula.prox) {
            Jogador jogador = celula.elemento; // pega o elento (dados do jogador)
            if (jogador != null) { // ve o jogador não é nulo (da erro)
                System.out.println("[" + index + "] ## " + jogador.getNome() + " ## " + jogador.getAltura() + " ## "
                        + jogador.getPeso() +
                        " ## " + jogador.getAnoNascimento() + " ## " + jogador.getUniversidade() + " ## " +
                        jogador.getCidadeNascimento() + " ## " + jogador.getEstadoNascimento() + " ##");
            }
            index++;
        }
        scanner.close();
    }
}
