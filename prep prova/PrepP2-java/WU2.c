#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <string.h>
#include <ctype.h>

int main(void){
    int n; // num de cartelas
    int k; // numeros de cada cartela
    int u;
    scanf("%d %d %d", &n, &k, &u);
    int cartela[n][k];
    for(int i = 0; i < n; i++){
        for(int j = 0; j<k; j++){
            scanf("%i", &cartela[i][j]); // le as apostas de cda cartela
        }
    }
    int numSort[u];
    for(int i = 0; i < u; i++){
        scanf("%i",&numSort[i]); // le os num sorteados
    }
    int cartelasCompletas[n];
    for (int i = 0; i < n; i++) {
        cartelasCompletas[i] = 0; // nenhuma cartela foi completa ainda
    }
    int numerosRestantes[k];
    for (int i = 0; i < k; i++) {
        numerosRestantes[i] = k; // ve quantos num faltam para completar cada cartela
    }
    int vencedor = 0;
    for(int sorteio =0; sorteio < u; sorteio++){ // sorteio
        for(int i =0; i < n; i++){
            for(int j =0; j < k; j++){
                if(numSort[sorteio]==cartela[i][j]){ // ve o numero sorteado é igual o num de alguma cartela
                   numerosRestantes[i]--;
                   if(numerosRestantes[i]==0){
                      cartelasCompletas[i]=1;
                      vencedor = 1;
                      break;
                   }
                }
            }
            if(vencedor){
                break;
            }
        }
    }
    for (int i = 0; i < n; i++) {
        if (cartelasCompletas[i]) {
            printf("%d ", i + 1);
        }
    }
    printf("\n");
    return 0;
}
