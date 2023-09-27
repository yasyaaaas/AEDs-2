public class PP3 {
    public static void main(String[] args) {
        String auau;
        char[] resp = new char[1000]; // string da resposta
        // se tem um char resposta tem que ter um contador para organizar o array
        char[] igualAuau = new char[1000]; // string auau em char
        while (true) {
            auau = MyIO.readLine();
            if (auau.charAt(0) == 'F' && auau.charAt(1) == 'I' && auau.charAt(2) == 'M') {
                break;
            }
            int a = auau.length();
            for (int i = 0; i < auau.length(); i++) { // passa string para array
                igualAuau[i] = auau.charAt(i);
            }
            int gato = 0;
            if (igualAuau[a - 1] != ' ') {
                resp[gato] = igualAuau[a - 1];
                gato++;
            }
            for (int i = 1; i < auau.length(); i++) {
                if (igualAuau[i] != ' ' && (i == auau.length() - 1 || igualAuau[i + 1] == ' ')) {
                    resp[gato] = igualAuau[i];
                    gato++;
                }
                // i == auau.length() - 1 -> ve se o i é a ulçtima letra da string
                // igualAuau[i + 1] == ' ' _. se o proximo chaer é um espaço devemos pegar o
                // char anterior (i)
            }
            for (int i = gato; i > 0; i--) {
                MyIO.print(resp[i]);
            }
            MyIO.print("\n");
        }
    }
}
