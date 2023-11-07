#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main(){
    char linha[10000];
    while(fgets(linha, sizeof(linha), stdin) != NULL){
        char saida[10000];
        int indexSaida =0;
        int cursor =0;
        int ehHome =0;
        for(int i =0; linha[i] != '\0'; i++){
            if(linha[i]=='['){
                cursor =0;
                ehHome = 1;
            } else if (linha[i]==']'){
                ehHome = 0;
            } else {
                if(ehHome){
                    memmove(saida + cursor + 1, saida + cursor, strlen(saida+cursor) +1);
                    saida[cursor] = linha[i];
                    cursor++;
                } else {
                    saida[indexSaida++] = linha[i];
                }
            }
        }
        saida[indexSaida + cursor] = '\0';
        printf("%s", saida);
    }
    return 0;
}