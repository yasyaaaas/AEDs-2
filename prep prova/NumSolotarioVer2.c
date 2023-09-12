#include <stdbool.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
int main() {
  char numCasos[50];
  char num[50];
  char resp[50];
  char numC[50];
  int index =0;
  while (1) {
    scanf("%s",numCasos);
        if (numCasos[0] == '0') {
            break;
        }
        scanf("%s",num);

        for (int i = 0; i < strlen(num); i++) {
            numC[i] = num[i];
        }
    //inicia resp e index antes do loop
        index = 0;//
        memset(resp, 0, sizeof(resp)); // limpa o resp

        for (int i = 1; i < strlen(num) - 1; i++) {
            if (numC[i] == numC[i + 1] && numC[i] == numC[i - 1]) {
                resp[index] += numC[i];
              index++;
            } else if (numC[i] != numC[i + 1] && numC[i] != numC[i - 1]) {
                if (numC[i + 1] == numC[i - 1]) {
                    resp[index] += numC[i];
              index++;
                }
            }
        }
          printf("%s\n",resp);
        //memset(resp, 0, sizeof(resp));
  }
  return 0;
}