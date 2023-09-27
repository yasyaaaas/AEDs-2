public class SeqEspVer3 {
    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            int b = MyIO.readInt();
            int e = MyIO.readInt();
            int[] resp = new int[20];
            int index = 0;
            for (int x = b; x <= e; x++) {
                resp[index] += x; // mesma coisa de = x
                index++;
            }
            for (int x = 0; x < index; x++) {
                MyIO.print(resp[x]);
            }
            for (int x = index - 1; x >= 0; x--) {
                MyIO.print(resp[x]);
            }
            MyIO.print("\n");
        }
    }
}
