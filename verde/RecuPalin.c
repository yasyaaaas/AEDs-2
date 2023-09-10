#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <string.h>
#include <ctype.h> // Para a fun��o isalnum
#define TAM_MAX_STR 150
bool ehPalin(char* str, int i); // se é palindromo 
bool ehSpec(char c); // se tem char espec.
int main() 
{
  //1 string e alocou
  char* str = (char*)malloc(TAM_MAX_STR * sizeof(char));
  
  fgets(str, TAM_MAX_STR, stdin); // fgets = pega a string que vai ser colocada (string q vai ser colocada, tamanho, de onde sai)

  str[(int)strcspn(str, "\r\n")] = '\0'; // strcspn e mostra onde esta o quer vc não quer e subistitui, nesse caso subistitui \n por \0
  
  while (strcmp(str, "FIM") != 0) // fazer até str FIM
  {
    //condição ? valor_se_verdadeiro : valor_se_falso.
    printf("%s\n", ehPalin(str, 0) ? "SIM" : "NAO"); 
    // SIM = 1 / NAO = 0
    fgets(str, TAM_MAX_STR, stdin); // repete o 1° denovo
    str[(int)strcspn(str, "\r\n")] = '\0';
  }
  
  free(str); // libera pq allocou
  
  return 0;
}
bool ehPalin(char* str, int i) 
{
    if (i >= strlen(str)) { // condição de parada
        return true;
    }
    if (ehSpec(str[i])) { //se a string for um char especial
        return ehPalin(str, ++i); // chmamamos a função denovo só que aumentamos o i
    }
    if (tolower(str[i]) != tolower(str[strlen(str) - 1 - i])) {// // Compara o char atual com seu correspondente no final, ignorando maiúsculas/minúsculas
        return false; // Se os chars não forem iguais, não é um palíndromo, retorna false
    }
    return ehPalin(str, ++i); // Chama recursivamente a função para ver o próximo char
}

bool ehSpec(char c) 
{
  //isalnum(x)= verifica se o caractere é um caractere alfanumérico (ou seja, uma letra ou um dígito numérico);
  return !(isalnum(c) || c == ' ' || c == '-'); // sempre da falso se não for especial
}