public class SrSeverino {
    public static void main(String[] args) {
        int numLivro = 0;
        for (int x = 0; x < 2; x++) {
            numLivro = MyIO.readInt(); // le num de livros
            int[] codLivro = new int[numLivro]; // array de inteiro, codigo dos livros como tamanho do numero de livros
            for (int i = 0; i < numLivro; i++) {
                codLivro[i] = MyIO.readInt(); // le cada codigo de livro
            }
            // aqui é so ordenação
            for (int i = 0; i < (numLivro - 1); i++) {
                int menor = i;
                for (int j = (i + 1); j < numLivro; j++) {
                    if (codLivro[menor] > codLivro[j]) { // so funciona com arr e com arr de int
                        menor = j;
                    }
                }
                int temp = codLivro[menor];
                codLivro[menor] = codLivro[i];
                codLivro[i] = temp;
            }
            // aqui é print
            for (int i = 0; i < numLivro; i++) {
                String formattedNum = String.format("%04d", codLivro[i]); // formata
                MyIO.print(formattedNum + "\n"); // printa
            }
        }
    }
}
