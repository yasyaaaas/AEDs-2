import java.io.IOException;
import java.io.RandomAccessFile;
import java.text.DecimalFormat;

public class ArqTP {
    public static void main(String[] args) throws IOException {
        int num; // entramos com um número
        num = MyIO.readInt(); // lemso um número
        RandomAccessFile raf = new RandomAccessFile("Ex.txt", "rw"); // criamos um raf
        for (int i = 0; i < num; i++) { // percorremos todos os números
            double valor = MyIO.readDouble(); // colocamos os valoes em double pois temos maitos deles em valores reais
            raf.writeDouble(valor); // Escreve o valor lido no passo anterior no arquivo aberto raf usando
                                    // writeDouble()
        }
        raf.close(); // fechamos o arquivo
        RandomAccessFile file = new RandomAccessFile("Ex.txt", "rw");
        DecimalFormat decimalFormat = new DecimalFormat("#.###"); // Formato para até 3 casas decimais
        for (int i = num - 1; i >= 0; i--) { // le de tras pra fentre o código
            long position = i * 8; // Cada double tem 8 bytes, clacula posição de byts
            file.seek(position); // Move o ponteiro de leitura/escrita do arquivo para a posição calculada.
            double valor = file.readDouble(); // Lê um valor double do arquivo na posição atual do ponteiro.
            String formattedValue = decimalFormat.format(valor); // Formata o valor para
            // evitar ".0" em números inteiros
            MyIO.println(formattedValue);// printa o valor
        }
        file.close(); // fecha o arquivo
    }
}
