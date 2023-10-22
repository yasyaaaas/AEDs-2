import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class QuickSort {
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

        public static void ordenarPorEstado(List<Jogador> jogadores, int k) {
            // k = 10;
            // codigo de ordenação por Quick Sort Parcial
            int n = jogadores.size();

            quicksort(jogadores, 0, n - 1, 10);

            // desempate por nome
            for (int i = 0; i < n; i++) {
                int j = i;
                while (j > 0 && jogadores.get(j).getEstadoNascimento().equals(jogadores.get(j -
                        1).getEstadoNascimento())) {
                    // Compara os nomes para manter em ordem alfabetica
                    if (jogadores.get(j).getNome().compareTo(jogadores.get(j - 1).getNome()) < 0) {
                        Jogador temp = jogadores.get(j);
                        jogadores.set(j, jogadores.get(j - 1));
                        jogadores.set(j - 1, temp);
                    }
                    j--;
                }
            }

            // imprimir jogadores
            for (int i = 0; i < k && i < n; i++) {
                jogadores.get(i).imprimir();
            }
        }

        private static void quicksort(List<Jogador> jogadores, int esq, int dir, int k) {
            int i = esq, j = dir;
            String pivo = jogadores.get((dir + esq) / 2).getEstadoNascimento();
            while (i <= j) {
                while (jogadores.get(i).getEstadoNascimento().compareTo(pivo) < 0)
                    i++;
                while (jogadores.get(j).getEstadoNascimento().compareTo(pivo) > 0)
                    j--;
                if (i <= j) {
                    swap(jogadores, i, j);
                    i++;
                    j--;
                }
            }
            if (esq < j)
                quicksort(jogadores, esq, j, 10);
            if (i < k && i < dir)
                quicksort(jogadores, i, dir, 10);
        }

        public static void swap(List<QuickSort.Jogador> jogadores, int i, int j) {
            Jogador temp = jogadores.get(i);
            jogadores.set(i, jogadores.get(j));
            jogadores.set(j, temp);
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
            Jogador jogador = new QuickSort().new Jogador(); // cria um jogador
            jogador.ler(novoId); // le o jogador
            jogadores.add(jogador); // adiciona o jogador a lista jogadores
        }
        // ordena por seleção
        Jogador.ordenarPorEstado(jogadores, 10);
        scanner.close();
    }
}
