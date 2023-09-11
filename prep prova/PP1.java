public class PP1 {
    public static void swap(int a, int b, int[] arr) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void main(String args[]) {
        int x, y, z;
        x = MyIO.readInt();
        y = MyIO.readInt();
        z = MyIO.readInt();
        int[] arr = { x, y, z };
        for (int i = 0; i < (arr.length - 1); i++) {
            int menor = i;
            for (int j = (i + 1); j < arr.length; j++) {
                if (arr[menor] > arr[j]) {
                    menor = j;
                }
            }
            swap(menor, i, arr);
        }
        System.out.print("\n" + arr[1]);
    }
}
