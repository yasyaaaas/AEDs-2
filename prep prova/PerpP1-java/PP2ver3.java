public class PP2ver3 {
    // não daaaaaaaaaaa
    public static void main(String[] args) {
        String auau;
        char[] miau = new char[1000];
        boolean primeiraLetra = true; // joga um bool
        while (true) {
            auau = MyIO.readLine();
            if (auau.charAt(0) == 'F' && auau.charAt(1) == 'I' && auau.charAt(2) == 'M') {
                break;
            }
            String resp = "";
            // if (auau.length() > 0 && auau.charAt(0) != ' ') {
            // resp += auau.charAt(0);
            // }
            for (int i = 0; i < auau.length(); i++) {
                char letra = auau.charAt(i);
                if (letra != ' ') {
                    if (primeiraLetra) { // começa verdadeira lá em cima pq é a primeira letra
                        resp += letra; // adiciona a resposta a letra
                        primeiraLetra = false; // e muda para falso
                    }
                } else {
                    primeiraLetra = true; // Resetar a variável quando encontramos um espaço em branco
                }
            }
            int ordem = 0;
            for (int i = 0; i < resp.length(); i++) {
                miau[ordem] = resp.charAt(i);
                ordem++;
            }
            for (int i = 0; i < ordem; i++) {
                MyIO.print(miau[i]);
            }
            MyIO.print("\n");
        }
    }
}