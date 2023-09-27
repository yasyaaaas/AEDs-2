public class SeqEspVer2 {
    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            int b = MyIO.readInt();
            int e = MyIO.readInt();
            String resp = "";
            for (int x = b; x <= e; x++) {
                resp += x;
            }
            MyIO.print(resp);
            for (int x = resp.length() - 1; x >= 0; x--) { // ao contrário tem qu ese lenght() -1 (tira o 0)
                MyIO.print(resp.charAt(x));
            }
            MyIO.print("\n");
        }
    }
}
