import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class HeapSort {
    public static int numComp = 0;
    public static int numMov = 0;

    // toda a jogador igual a 1° questão
    public class Jogador {
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

        public void ler(String novoID) {
            try {
                BufferedReader reader = new BufferedReader(new FileReader("/tmp/players.csv"));
                String info;
                while ((info = reader.readLine()) != null) {
                    String[] campos = info.split(",", -1);
                    if (campos.length == 8 && campos[0].equals(novoID.trim())) {
                        ;
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

        public static void ordenarPorAltura(List<Jogador> jogadores) {
            // codigo de ordenação por HeapSort
            int n = jogadores.size();
            Jogador[] array = new Jogador[n + 1];
            for (int i = 0; i < n; i++) {
                array[i + 1] = jogadores.get(i);
            }

            // Contrucao do heap
            for (int tamHeap = 2; tamHeap <= n; tamHeap++) {
                construir(array, tamHeap);
            }

            // Ordenacao propriamente dita
            int tamHeap = n;
            while (tamHeap > 1) {
                numComp++;
                swap(array, 1, tamHeap--);
                reconstruir(array, tamHeap);
            }

            // Atualizar a lista de jogadores ordenados por altura
            List<Jogador> jogadoresOrdenados = new ArrayList<>();
            for (int i = 1; i <= n; i++) {
                jogadoresOrdenados.add(array[i]);
            }

            // Substituir a lista original pelo resultado ordenado
            jogadores.clear(); // limpa tudo dos jogadores
            jogadores.addAll(jogadoresOrdenados); // e adiciona com eles com a altura ordenada

            // desempate por nome
            for (int i = 0; i < n; i++) {
                int j = i;
                while (j > 0 && jogadores.get(j).getAltura() == jogadores.get(j - 1).getAltura()) {
                    // Compara os nomes para manter em ordem alfabetica
                    if (jogadores.get(j).getNome().compareTo(jogadores.get(j - 1).getNome()) < 0) {
                        Jogador temp = jogadores.get(j);
                        jogadores.set(j, jogadores.get(j - 1));
                        jogadores.set(j - 1, temp);
                        // o .set( , ), é pq não pode jogadores.get(j) = jogadores.get(j - 1)
                    }
                    j--;
                }
            }

            numMov++;
            // Imprimir os jogadores ordenados por altura
            for (Jogador jogador : jogadores) {
                jogador.imprimir();
            }
        }

        public static void swap(Jogador[] array, int i, int j) {
            Jogador temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }

        public static void construir(Jogador[] array, int tamHeap) {
            for (int i = tamHeap; i > 1 && array[i].getAltura() > array[i / 2].getAltura(); i /= 2) {
                swap(array, i, i / 2);
            }
        }

        public static void reconstruir(Jogador[] array, int tamHeap) {
            int i = 1;
            while (i <= (tamHeap / 2)) {
                int filho = getMaiorFilho(array, i, tamHeap);
                if (array[i].getAltura() < array[filho].getAltura()) {
                    swap(array, i, filho);
                    i = filho;
                } else {
                    i = tamHeap;
                }
            }
        }

        public static int getMaiorFilho(Jogador[] array, int i, int tamHeap) {
            int filho;
            if (2 * i == tamHeap || array[2 * i].getAltura() > array[2 * i + 1].getAltura()) {
                filho = 2 * i;
            } else {
                filho = 2 * i + 1;
            }
            return filho;
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        List<Jogador> jogadores = new ArrayList<>();
        // cria uma lista para armazenar os jogadores
        String novoId;
        while (true) {
            novoId = scanner.nextLine();
            if (novoId.equals("FIM")) {
                break;
            }
            Jogador jogador = new HeapSort().new Jogador(); // cria um jogador
            jogador.ler(novoId); // le o jogador
            jogadores.add(jogador); // adiciona o jogador a lista jogadores
        }
        // ordena por seleção
        Jogador.ordenarPorAltura(jogadores);
        // Parte 3: Escrever log
        try {
            FileWriter arquivoLog = new FileWriter("matrícula_heapsort.txt");
            PrintWriter gravador = new PrintWriter(arquivoLog);
            String matricula = "800989";
            long tempoExecucao = System.currentTimeMillis(); // Registre o tempo inicial
            // Faça o processamento das pesquisas aqui
            tempoExecucao = System.currentTimeMillis() - tempoExecucao; // Calcule o tempo de execução
            gravador.printf("%s\t%d\t%d\t%d%n", matricula, numComp, numMov, tempoExecucao);
            arquivoLog.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        scanner.close();
    }
}
