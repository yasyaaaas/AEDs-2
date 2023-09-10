#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <string.h>

int main(){
    int num = 0;
    scanf("%i",&num);
    FILE* arq = fopen("Ex.txt","w");//abre ou cria um arq para esquever
    if(arq!=NULL){ // se não for nulo
        for(int i =0; i<num; i++){
            double valor;
            scanf("%lf",&valor);// escaneia os valores                
            fprintf(arq, "%.3lf\n", valor);  // Escreve o valor no arquivo com 3 casas decimais
        }
        fclose(arq);// fecha arq
    }else {
        printf("Erro ao abrir o arquivo para escrita.\n");
        return 1; // Retorna 1 para indicar erro
    }
    FILE* file = fopen("Ex.txt", "r");//abre para ler um arq
    if (file != NULL) { // se o arq não for nulo
        double valores[num]; // Array para armazenar os valores
        for (int i = 0; i < num; i++) {
            if (fscanf(file, " %lf", &valores[i]) != 1) { // le os valores do arq
                printf("Erro ao ler valores do arquivo.\n");//menasgem ed erro
                return 1;
            }
        }
        fclose(file);// fecha o arq
        for (int i = num - 1; i >= 0; i--) { // pega os valores que estão no num e os inverte
            if (valores[i] == (int)valores[i]) { // Verifica se o valor é inteiro
                printf("%.0lf\n", valores[i]); // printa como inteiro (sem casas decimais)
            } else if ((valores[i] * 100) == (int)(valores[i] * 100)) { // Verifica se tem duas casas decimais
                printf("%.2lf\n", valores[i]); // printa com duas casas decimais
            } else if ((valores[i] * 10) == (int)(valores[i] * 10)) { // Verifica se tem uma casa decimal
                printf("%.1lf\n", valores[i]); // printa com uma casa decimal
            }else {
                printf("%.3lf\n", valores[i]); // printa com três casas decimais
            }
        }
    }else {
        printf("Erro ao abrir o arquivo para leitura.\n");
        return 1; // Retorna 1 para indicar erro
    }
    return 0;
}