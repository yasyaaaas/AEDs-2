public class PP2ver2 {
    public static void main(String args[]) {
        String str = MyIO.readLine();
        char[] resp = new char[1000];
        char[] entradaChar = new char[1000];
        for (int i = 0; i < str.length(); i++) { // muda string para char
            entradaChar[i] = str.charAt(i);
        }
        int respIndex = 0;// cada letra e colocada no espaço correto de resp
        // Adicionando a primeira letra da primeira palavra manualmente
        if (str.length() > 0 && entradaChar[0] != ' ') {
            resp[respIndex] = entradaChar[0];
            respIndex++;
        }
        for (int i = 0; i < str.length(); i++) {
            if (entradaChar[i] == ' ' && entradaChar[i + 1] != ' ') {
                resp[respIndex] = entradaChar[i + 1];
                respIndex++;
            }
        }
        for (int i = 0; i < respIndex; i++) {
            MyIO.print(resp[i]);
        }
    }
}
