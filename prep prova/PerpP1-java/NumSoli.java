public class NumSoli {
    public static void main(String[] args) {
        String numCasos;
        String num;
        String resp = "";
        char[] numC = new char[50];
        while (true) {
            numCasos = MyIO.readLine();
            if (numCasos.charAt(0) == '0') {
                break;
            }
            num = MyIO.readLine();
            for (int i = 0; i < num.length(); i++) {
                numC[i] = num.charAt(i);
            }
            for (int i = 1; i < num.length() - 1; i++) {
                if (numC[i] == numC[i + 1] && numC[i] == numC[i - 1]) {
                    resp += numC[i];
                } else if (numC[i] != numC[i + 1] && numC[i] != numC[i - 1]) {
                    if (numC[i + 1] == numC[i - 1]) {
                        resp += numC[i];
                    }
                }
            }
            MyIO.println(resp);
            resp = "";
        }
    }
}
