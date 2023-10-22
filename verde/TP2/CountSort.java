import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class CountSort {
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

        public static int getMaior(List<Jogador> jogadores) {
            int n = jogadores.size();
            int maior = jogadores.get(0).getAltura();
            for (int i = 0; i < n; i++) {
                if (maior < jogadores.get(i).getAltura()) {
                    maior = jogadores.get(i).getAltura();
                }
            }
            return maior;
        }

        public static void ordenarPorAlatura(List<Jogador> jogadores) {
            // codigo de ordenação Counting Sort
            int n = jogadores.size();
            int maior = CountSort.Jogador.getMaior(jogadores);
            // Array para contar o numero de ocorrencias de cada elemento
            int[] count = new int[maior + 1];
            Jogador[] ordenado = new Jogador[n];

            // Inicializar cada posicao do array de contagem
            for (int i = 0; i < count.length; i++) {
                count[i] = 0;
            }

            // Agora, o count[i] contem o numero de elemento iguais a i
            for (int i = 0; i < n; i++) {
                count[jogadores.get(i).getAltura()]++;
            }

            // Agora, o count[i] contem o numero de elemento menores ou iguais a i
            for (int i = 1; i < count.length; i++) {
                count[i] += count[i - 1];
            }

            // Ordenando
            for (int i = n - 1; i >= 0; i--) {
                int altura = jogadores.get(i).getAltura();
                ordenado[count[altura] - 1] = jogadores.get(i);
                count[altura]--;
                numComp++;
            }

            // desempate por nome
            for (int i = 0; i < n; i++) {
                int j = i;
                while (j > 0 && ordenado[j].getAltura() == ordenado[j - 1].getAltura()) {
                    // Compara os nomes para manter em ordem alfabetica
                    if (ordenado[j].getNome().compareTo(ordenado[j - 1].getNome()) < 0) {
                        Jogador temp = ordenado[j];
                        ordenado[j] = ordenado[j - 1];
                        ordenado[j - 1] = temp;
                    }
                    j--;
                }
            }
            numMov++;
            // Copiando para o array original
            for (int i = 0; i < n; i++) {
                jogadores.set(i, ordenado[i]);
            }
            // Imprimir os jogadores ordenados por nome
            for (Jogador jogador : jogadores) {
                jogador.imprimir();
            }
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
            Jogador jogador = new CountSort().new Jogador(); // croa um jogador
            jogador.ler(novoId); // le o jogador
            jogadores.add(jogador); // adiciona o jogador a lista jogadores
        }
        // ordena por Counting Sort
        Jogador.ordenarPorAlatura(jogadores);
        // Parte 3: Escrever log
        try {
            FileWriter arquivoLog = new FileWriter("matrícula_countingsort.txt");
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
