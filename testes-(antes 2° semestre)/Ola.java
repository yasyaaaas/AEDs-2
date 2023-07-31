public class Ola {
    static void myMethod(String fname, int age) {
        System.out.println(fname + " Viegas" + " idade: " + age); // parâmetros
    }

    static int meuMetodo(int x, int y) {
        return x + y;
    }

    static void checkAge(int age) {
        if (age < 18) {
            System.out.println("Acesso negado - você não tem idade suficiente");
        } else {
            System.out.println("Acesso permitido - você tem idade suficiente");
        }
    }

    static int sum(int k) {
        if (k > 0) { // para no 0
            return k + sum(k - 1); // vai somando o k atual ao k anterior -> 10 + ( 9 + sum(8) )
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        System.out.println("hello world");
        System.out.println("me chamo yasmin");
        System.out.println("esse é o meu primeiro programa em java");
        System.out.println(" tenho que começar a particar e me impulcionar mais ");
        myMethod("Yasmin", 18); // argumentos
        myMethod("Arthur", 11);
        myMethod("Flavia", 43);
        myMethod("Coca", 50);
        int z = (meuMetodo(5, 3));
        System.out.println(z);
        checkAge(20);
        int result = sum(10);
        System.out.println(result);
        String a = "amor";
        System.out.println(a);
        char[] b = a.toCharArray();
        int tam = b.length;
        char aux;
        for (int i = 0; i < tam / 2; i++) {
            aux = b[i];
            b[i] = b[tam - 1 - i];
            b[tam - 1 - i] = aux; // char pq troca elemento de char
        }
        a = new String(b); // faz a troca do que estava no 'a' para uma nova string de 'b' (a invertida)
        System.out.println(a);
    }
}
