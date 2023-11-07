#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <string.h>
#include <ctype.h>

struct Dragao
{
    int dias, multa;
};

int main(){
    int tempo, multa;
    double multadia = 0.0; // Multa paga por dia por todos os dragões
    double multatotal = 0.0; // Resposta
    int treinando = 0;
    int diasrestantes = 0; // Tempo restante do treinamento
    struct Dragao fila[10000]; // cria uma fila de dragões
    int index = 0;

    while (scanf("%d %d", &tempo, &multa) == 2)
    {
        fila[index].dias = tempo;
        fila[index].multa = multa;
        multadia += multa;
        index++;
    }
    
    printf("%.lf\n", multatotal);
    return 0;
}