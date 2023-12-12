#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main()
{
    int entrada;
    while (1){
        scanf("%i", &entrada);
        if (entrada == 0){
            break;
        }
        int pilhas[entrada][3]; // matriz para armazenar valores / matriz[2][3]
        for (int i = 0; i < entrada; i++){
            for (int j = 0; j < 3; j++){
                scanf("%i", &pilhas[i][j]);
            }
        }
        int soma = 0;
        for (int i = 0; i < entrada; i++){
            for (int j = 0; j < 3; j++){
                soma += pilhas[i][j];
            }
        }
        if (soma % 3 == 0){
            printf("1\n");
        }
        else{
            printf("0\n");
        }
    }
    return 0;
}