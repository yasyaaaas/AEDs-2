import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class MergeSort {
    public static int comp = 0;
    public static int mov = 0;

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

        public static void mergeSort(List<MergeSort.Jogador> jogadores) {
            mergeSort(jogadores, 0, jogadores.size() - 1);
        }

        public static void mergeSort(List<Jogador> jogadores, int esq, int dir) {
            if (esq < dir) {
                int meio = (esq + dir) / 2;
                mergeSort(jogadores, esq, meio);
                mergeSort(jogadores, meio + 1, dir);
                merge(jogadores, esq, meio, dir);
            }
        }

        public static void merge(List<Jogador> jogadores, int esq, int meio, int dir) {
            int n1 = meio - esq + 1;
            int n2 = dir - meio;

            Jogador[] a = new Jogador[n1];
            Jogador[] b = new Jogador[n2];

            for (int i = 0; i < n1; i++) {
                a[i] = jogadores.get(esq + i);
            }
            for (int j = 0; j < n2; j++) {
                b[j] = jogadores.get(meio + 1 + j);
            }

            int i = 0;
            int j = 0;
            int k = esq;

            while (i < n1 && j < n2) {
                comp++;
                if (a[i].getUniversidade().compareTo(b[j].getUniversidade()) < 0) {
                    mov++;
                    jogadores.set(k, a[i]);
                    i++;
                } else if (a[i].getUniversidade().compareTo(b[j].getUniversidade()) > 0) {
                    jogadores.set(k, b[j]);
                    mov++;
                    j++;
                } else {
                    if (a[i].getNome().compareTo(b[j].getNome()) < 0) {
                        jogadores.set(k, a[i]);
                        mov++;
                        i++;
                    } else {
                        jogadores.set(k, b[j]);
                        j++;
                    }

                }
                k++;
            }

            while (i < n1) {
                jogadores.set(k, a[i]);
                i++;
                k++;
            }

            while (j < n2) {
                jogadores.set(k, b[j]);
                j++;
                k++;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        List<Jogador> jogadores = new ArrayList<>();
        int numComp = 0;
        // cria uma lista para armazenar os jogadores
        String novoId;
        while (true) {
            novoId = scanner.nextLine();
            if (novoId.equals("FIM")) {
                break;
            }
            Jogador jogador = new MergeSort().new Jogador(); // cria um jogador
            jogador.ler(novoId); // le o jogador
            jogadores.add(jogador); // adiciona o jogador a lista jogadores
        }
        // ordena por Counting Sort
        Jogador.mergeSort(jogadores);
        for (int i = 0; i < jogadores.size(); i++) {
            jogadores.get(i).imprimir();
        }
        // Parte 3: Escrever log
        try {
            FileWriter arquivoLog = new FileWriter("matricula_mergesort.txt");
            PrintWriter gravador = new PrintWriter(arquivoLog);
            String matricula = "800989";
            long tempoExecucao = System.currentTimeMillis(); // Registre o tempo inicial
            // Faça o processamento das pesquisas aqui
            tempoExecucao = System.currentTimeMillis() - tempoExecucao; // Calcule o tempo de execução
            gravador.printf("%s\t%d\t%d%n", matricula, tempoExecucao, numComp);
            arquivoLog.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        scanner.close();
    }
}
