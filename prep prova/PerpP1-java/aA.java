public class aA {
    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            int b = MyIO.readInt();
            int e = MyIO.readInt();

            int[] resp = new int[100]; // tamanho do array da vez
            int auau = 0;
            for (int x = b; x <= e; x++) {
                resp[auau] = x;
                auau++;
            }
            int[] resp2 = new int[100];
            int miau = 0;
            for (int x = e; x >= b; x--) {
                if (x < 10 && miau < resp.length) {
                    resp2[miau] = x % 10;
                    miau++;
                }
                if (x >= 10 && x < 100 && miau < resp2.length) {
                    resp2[miau] = x % 10; // Obtém a unidade;
                    miau++;
                    resp2[miau] = x / 10; // dezena
                    miau++;
                }
                if (x >= 100 && miau < resp2.length) {
                    resp2[miau] = x % 10; // Obtém a unidade
                    miau++;
                    resp2[miau] = (x / 10) % 10; // Obtém a dezena
                    miau++;
                    resp2[miau] = x / 100; // Obtém a centena
                    miau++;
                }
            }
            for (int x = 0; x < auau; x++) {
                MyIO.print(resp[x]);
            }
            for (int x = 0; x < miau; x++) {
                MyIO.print(resp2[x]);
            }
            MyIO.print("\n");
        }
    }
}
