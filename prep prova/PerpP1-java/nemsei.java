public class nemsei {
    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            int b = MyIO.readInt();
            int e = MyIO.readInt();

            int[] resp = new int[e - b + 1];
            int auau = 0;
            for (int x = b; x <= e; x++) {
                resp[auau] = x;
                auau++;
            }

            int[] resp2 = new int[e - b + 1];
            int miau = 0;
            for (int x = e; x >= b; x--) {
                resp2[miau] = x;
                miau++;
            }

            for (int x = 0; x < auau; x++) {
                MyIO.print(resp[x]);
            }
            for (int x = 0; x < miau; x++) {
                MyIO.print(resp2[x]);
            }
            for (int x = miau - 1; x >= 0; x--) { // Imprime resp2 invertido
                MyIO.print(resp2[x]);
            }
            for (int x = auau - 1; x >= 0; x--) { // Imprime resp invertido
                MyIO.print(resp[x]);
            }
            MyIO.print("\n");
        }
    }
}
