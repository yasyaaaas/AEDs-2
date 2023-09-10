#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <string.h>

 int main(){
    char pal[1000]; // cria um char chama pal 
    srand(4); // sprand 4 igual o seed 4 no java
    //cria duas variaveis contendo char aleatorios pela formula de chars aleatorios
    char aleatorio1 = 'a' + (abs(rand()) % 26);
    char aleatorio2 = 'a' + (abs(rand()) % 26);
    while(1){ // enquanto for verdade
        fgets(pal, sizeof(pal), stdin); // le a string de entrada
        pal[strcspn(pal, "\n")] = '\0'; // Removendo o caractere de nova linha ('\n') da string lida
        if (strcmp(pal, "FIM") == 0) { // se a palavra for fim acba o programa
            break;
        }
        char result[1000]; // cria uma variavel para comportar o resultado
        int tamanho = strlen(pal); // tamanho do resultado é o mesmo tamanho da palavra
        int tamResult = 0; // contador dentro do array
        for (size_t i = 0; i < tamanho; ++i) { // for para percorrer todo o array
            char letra = pal[i]; // o char que estamos agora
            if (letra == aleatorio1) { //se a letra do aleatorio1 for igual a alguma das letrs de entrada 
                result[tamResult++] = aleatorio2; // aumentamos o o contado do array e substituimos a letra pela letra aleatoria 2
            } else {
                result[tamResult++] = letra; //se a letra do aleatorio 1 não for a mesma letra qeu está na string a letra fiva normal
            }
        }
        result[tamResult] = '\0'; //começamos o array do res7ultado com o vazio
        printf("%s\n", result);// printamos o resultado
    }
    return 0;
 }