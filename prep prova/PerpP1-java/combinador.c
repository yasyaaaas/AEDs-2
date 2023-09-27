#include <stdbool.h>
#include <stdio.h>
#include <stdlib.h>

int main() {
  for (int i = 0; i < 3; i++) {
    char str1[500];
    char str2[500];
    char resp[1000];
    int miau = 0;
    scanf("%s%s", str1, str2);
    int len1 = strlen(str1); // Obtenha o tamanho real de str1
    int len2 = strlen(str2); // Obtenha o tamanho real de str2
    int maxLen =0;
    if(len1>len2){
      maxLen = len1;
    }
    else{
      maxLen = len2;
    }
    for (int x = 0; x< maxLen; x++) {
        if (x < len1) {
            resp[miau] = str1[x];
            miau++;
        }
        if (x < len2) {
            resp[miau] = str2[x];
            miau++;
        }
    }
    resp[miau] = '\0'; // estava no lugar errado
    printf("%s\n", resp);
  }
  return 0;
}