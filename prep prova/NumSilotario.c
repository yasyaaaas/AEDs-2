#include <stdbool.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
int main() {
  char numCasos[50];
  char num[50];
  char resp[50] = "";
  char numC[50];
  while (1) {
    fgets(numCasos, sizeof(numCasos), stdin);
        if (numCasos[0] == '0') {
            break;
        }
        fgets(num, sizeof(num), stdin);

        for (int i = 0; i < strlen(num); i++) {
            numC[i] = num[i];
        }

        for (int i = 1; i < strlen(num) - 1; i++) {
            if (numC[i] == numC[i + 1] && numC[i] == numC[i - 1]) {
                strncat(resp, &numC[i], 1);
            } else if (numC[i] != numC[i + 1] && numC[i] != numC[i - 1]) {
                if (numC[i + 1] == numC[i - 1]) {
                    strncat(resp, &numC[i], 1);
                }
            }
        }

        printf("%s\n", resp);
        memset(resp, 0, sizeof(resp));
  }
  return 0;
}