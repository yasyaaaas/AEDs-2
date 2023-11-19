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

class Pilha {
    public static int index = 0;
    private Celula topo;

    public Pilha() {
        topo = null;
    }

    public void inserir(Jogador x) {
        Celula tmp = new Celula(x);
        tmp.prox = topo;
        topo = tmp;
        tmp = null;
    }

    public Jogador remover() throws Exception {
        if (topo == null) {
            throw new Exception("Erro ao remover!");
        }
        Jogador resp = topo.elemento;
        Celula tmp = topo;
        topo = topo.prox;
        tmp.prox = null;
        tmp = null;
        return resp;
    }

    public void mostrar() {
        mostrarRecursivo(topo);
        // inverter
        /*
         * for (Celula i = topo; i != null; i = i.prox) {
         * Jogador jogador = i.elemento; // pega o elento (dados do jogador)
         * if (jogador != null) { // ve o jogador não é nulo (da erro)
         * System.out.println("[" + index + "] ## " + jogador.getNome() + " ## " +
         * jogador.getAltura() + " ## "
         * + jogador.getPeso() +
         * " ## " + jogador.getAnoNascimento() + " ## " + jogador.getUniversidade() +
         * " ## " +
         * jogador.getCidadeNascimento() + " ## " + jogador.getEstadoNascimento() +
         * " ##");
         * }
         * index++;
         * }
         */

    }

    private void mostrarRecursivo(Celula celula) {
        if (celula != null) {
            mostrarRecursivo(celula.prox);
            Jogador jogador = celula.elemento;
            if (jogador != null) {
                System.out.println("[" + index + "] ## " + jogador.getNome() + " ## " + jogador.getAltura() + " ## " +
                        jogador.getPeso() + " ## " + jogador.getAnoNascimento() + " ## " + jogador.getUniversidade() +
                        " ## " + jogador.getCidadeNascimento() + " ## " + jogador.getEstadoNascimento() + " ##");
                index++;
            }
        }
    }
}

public class Q03 {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        Pilha jogadores = new Pilha();
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
            jogadores.inserir(jogador); // adiciona o jogador a lista jogadores
        }
        // rempções e inserções
        num = scanner.nextInt();
        scanner.nextLine();
        for (int j = 0; j < num; j++) {
            entrada = scanner.nextLine();
            String[] campo = entrada.split(" ");
            if (campo[0].equals("I")) {
                Jogador jogador = new Jogador();
                jogador.ler(campo[1]);
                jogadores.inserir(jogador);
            } else if (campo[0].equals("R")) {
                Jogador removedPlayer = jogadores.remover();
                removedPlayers.add(removedPlayer);
            }
        }

        for (Jogador removedPlayer : removedPlayers) {
            System.out.println("(R) " + removedPlayer.getNome()); // printa o nome do Jogador removido
        }

        jogadores.mostrar();
        scanner.close();
    }
}
