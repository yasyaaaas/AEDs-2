#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main(){
    char entrada[1000];
    while (scanf("%s", entrada) != EOF){
        int cont =0;
        for (int i = 0; i < strlen(entrada); i++){
            if (entrada[i] == "("){
               cont++;
            } else if (entrada[i] == ")"){
                if(cont > 0){
                    cont--;
                }
            }
        }
        for(int i =0; i < strlen(entrada); i++){
            if(entrada[0] == ")"){
                cont == 1;
            }
        }
        if (cont == 0){
            printf("Partiu RU!\n");
        } else {
            printf("ainda temos %i assunto(s) pendente(s)!", cont);
        }
    }
    return 0;
}