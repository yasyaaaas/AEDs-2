// MATRIZ ESTA AQUI!!!!!!!!!!!!  MATRIZ ESTA AQUI!!!!!!!!!!!!!!!!!!
public class Mya {
    int x = 5; // se quer que seja const -> final
    String pnome = "Yasmin";
    String Snome = "Viegas";
    int age = 18;

    public static void main(String[] args) {
        Mya myObj = new Mya();
        myObj.x = 40;
        Mya myObj2 = new Mya();
        System.out.println(myObj.x); // especificar que vc vai pegar o x da Mya
        System.out.println(myObj2.x);
        Mya myObj3 = new Mya();
        System.out.println("Nome: " + myObj3.pnome + " " + myObj3.Snome);
        System.out.println("Idade: " + myObj3.age);
        final int n = 3;
        int[][] m = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

        // soma da diagonal principal
        int result1 = 0;
        int soma1 = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    soma1 += m[i][j];
                }
            }
        }
        result1 = soma1;
        System.out.println("soma diagonal principal: " + result1);

        // soma diagonal secundária
        int result2 = 0;
        int soma2 = 0;
        for (int i = 0; i < n; i++) {
            // for (int j = 0; j < n; j++) {
            soma2 += m[i][n - 1 - i];
            // }
        }
        result2 = soma2;
        System.out.println("soma diagonal secundaria: " + result2);

        // ver maior número da matriz
        int result3 = 0;
        int maior = m[0][0];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (m[i][j] > maior) {
                    maior = m[i][j];
                }
            }
        }
        result3 = maior;
        System.out.println("maior número da matriz: " + result3);

        // maior acima da diagonla principal
        int result4 = 0;
        int maiorADP = m[0][0];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j > i) {
                    if (m[i][j] > maiorADP) {
                        maiorADP = m[i][j];
                    }
                }
            }
        }
        result4 = maiorADP;
        System.out.println("maior acima diagonal principal: " + result4);

        // menor acima da diagonal principal
        int result5 = 0;
        int menorADP = m[0][1]; // tem q começar a partir do q vale
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j > i && m[i][j] < menorADP)
                    menorADP = m[i][j];
            }
        }
        result5 = menorADP;
        System.out.println("menor acima diagonal principal: " + result5);

        // maior acima diagonal secundária
        int result6 = 0;
        int maiorADS = m[0][0];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i + j < n - 1) {
                    if (m[i][j] > maiorADS) {
                        maiorADS = m[i][j];
                    }
                }
            }
        }
        result6 = maiorADS;
        System.out.println("maior acima diagonal secundária: " + result6);

        // menor acima diagonal secundaria
        int result7 = 0;
        int menorADS = m[0][0];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i + j < n - 1) {
                    if (menorADS > m[i][j]) {
                        menorADS = m[i][j];
                    }
                }
            }
        }
        result7 = menorADS;
        System.out.println("menor acima diagonal secundária: " + result7);

        // maior ABAIXO da diagonal principal
        int result8 = 0;
        int maiorAbDP = m[2][0];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i > j) {
                    if (maiorAbDP < m[i][j]) {
                        maiorAbDP = m[i][j];
                    }
                }
            }
        }
        result8 = maiorAbDP;
        System.out.println("maior abaixo diagonal principal: " + result8);

        // menor ABAIXO diagonal principal
        int result9 = 0;
        int menorAbDP = m[2][0];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i > j) {
                    if (menorAbDP > m[i][j]) {
                        menorAbDP = m[i][j];
                    }
                }
            }
        }
        result9 = menorAbDP;
        System.out.println("menor abaixo diagonal principal: " + result9);

        // maior ABAIXO diagonal secundária
        int result10 = 0;
        int maiorAbDS = m[n - 1][n - 1]; // naão da 3 ou n pq só vai de 0 até 2
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i + j > n - 1) {
                    if (maiorAbDS < m[i][j]) {
                        maiorAbDS = m[i][j];
                    }
                }
            }
        }
        result10 = maiorAbDS;
        System.out.println("maior abaixo diagonal secundária: " + result10);

        // menor ABAIXO da diagonal secundária
        int result11 = 0;
        int menorAbDS = m[n - 1][n - 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i + j > n - 1) {
                    if (menorAbDS > m[i][j]) {
                        menorAbDS = m[i][j];
                    }
                }
            }
        }
        result11 = menorAbDS;
        System.out.println("menor abaixo diagonal secundária: " + result11);

        // media acima diagonal principal
        double result12 = 0;
        double mediaADP = 0;
        double soma3 = 0;
        int c1 = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j > i) {
                    soma3 += m[i][j];
                    c1++;
                }
            }
        }
        mediaADP = soma3 / c1;
        result12 = mediaADP;
        System.out.println("média acima diagonal principal: " + result12);

        // media abaixo diagonal principal
        double result13 = 0;
        double soma4 = 0;
        double mediaAbDP = 0;
        int c2 = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i > j) {
                    soma4 += m[i][j];
                    c2++;
                }
            }
        }
        mediaAbDP = soma4 / c2;
        result13 = mediaAbDP;
        System.out.println("média abaixo diagonal principal: " + result13);

        // media acima diagonal secundaria
        double result14 = 0;
        double soma5 = 0;
        double mediaADS = 0;
        int c3 = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i + j < n - 1) {
                    soma5 += m[i][j];
                    c3++;
                }
            }
        }
        mediaADS = soma5 / c3;
        result14 = mediaADS;
        System.out.println("média acima diagonal secundária: " + result14);

        // media abaixo diagonal secundaria
        double soma6 = 0;
        double mediaAbDS = 0;
        int c4 = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i + j > n - 1) {
                    soma6 += m[i][j];
                    c4++;
                }
            }
        }
        mediaAbDS = soma6 / c4;
        System.out.println("média abaixo diagonal secundária: " + mediaAbDS);
    }

}
