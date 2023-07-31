class Main {
    public static void main(String[] args) {
        System.out.println("hello world");
        System.out.println("me chamo yasmin");
        System.out.println("esse é o meu primeiro programa em java");
        System.out.print(" tenho que começar a particar e me impulcionar mais ");
        System.out.println(18);
        System.out.println(3 * 5);
        // deu certo eu acho
        String name = "Yasmin";
        System.out.println(name);
        int x = 18;
        x = 15;
        System.out.println(x);
        String primNome = "Yasmin ";
        String secNome = "Viegas";
        String nomeComp = primNome + secNome;
        System.out.println(nomeComp);
        boolean isJavaFun = true;
        boolean isFishTasty = false;
        System.out.println(isJavaFun);
        System.out.println(isFishTasty);
        System.out.println(9 < 10);
        int minIdade = 18;
        int idadeVoto = 16;
        if (minIdade >= idadeVoto) {
            System.out.println("Você pode votar");
        } else {
            System.out.println("Você não pode votar");
        }
        int myAge = 18;
        String resp = (myAge >= 18) ? "Você é maior de idade" : "Você é menor de idade";
        System.out.println(resp);
        /*
         * Scanner scanner = new Scanner(System.in);
         * System.out.println("Coloque o número: ");
         * int texte = scanner.nextInt();
         * System.out.printf("Esse é o número: %d", texte);
         * scanner.close();
         */
        int dia = 8;
        switch (dia) {
            case 1:
                System.out.println("Segunda");
                break;
            case 2:
                System.out.println("Terça");
                break;
            case 3:
                System.out.println("Quarta");
                break;
            case 4:
                System.out.println("Quinta");
                break;
            case 5:
                System.out.println("Sexta");
                break;
            case 6:
                System.out.println("Sabado");
                break;
            case 7:
                System.out.println("Domingo");
                break;
            default:
                System.out.println("Só quero o final de semana");
        }
        int h = 0;
        while (h < 5) {
            System.out.println(h);
            h++;
        }
        int i = 0;
        do {
            System.out.println(i);
            i++;
        } while (i < 5);
        int f = 6;
        for (int e = 0; e < f; e++) {
            System.out.println(e);
        }
        // Outer loop
        for (int p = 1; p <= 2; p++) {
            System.out.println("Outer: " + p); // Executes 2 times
            // Inner loop
            for (int j = 1; j <= 3; j++) {
                System.out.println(" Inner: " + j); // Executes 6 times (2 * 3)
            }
        }
        for (int v = 0; v < 10; v++) {
            if (v == 4) {
                break;
            }
            System.out.println(v);
        }
        for (int u = 0; u < 10; u++) {
            if (u == 4) {
                continue;
            }
            System.out.println(u);
        }
        int[][] Nums = { { 1, 2, 3 }, { 4, 5, 6 } };
        for (int r = 0; r < Nums.length; r++) {
            for (int j = 0; j < Nums[r].length; j++) {
                System.out.println(Nums[r][j] + " ");
            }
            System.out.println();
        }
    }
}
