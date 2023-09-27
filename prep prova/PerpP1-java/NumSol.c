#include <stdbool.h>
#include <stdio.h>
#include <stdlib.h>
int main(){
    char numCasos[50];
    char num[50];
    char resp [50] = "";
    char numC[50];
    while(1){
        scanf("%s", numCasos);
        if (numCasos[0] == '0') {
            break;
        }
        scanf("%s", num);
        int len = strlen(num);
        for (int i = 0; i < len; i++) {
            numC[i] = num[i];
        }
        for (int i = 1; i < len - 1; i++) {
            if (numC[i] == numC[i + 1] && numC[i] == numC[i - 1]) {
                resp[i - 1] = numC[i];
            } else if (numC[i] != numC[i + 1] && numC[i] != numC[i - 1]) {
                if (numC[i + 1] == numC[i - 1]) {
                    resp[i - 1] = numC[i];
                }
            }
        }
        printf("%s\n", resp);
        memset(resp, 0, sizeof(resp));
    }
    return 0;
}