#include <stdio.h>
#include <stdlib.h>
#include <string.h>

//até o ler mesma coisa da 1° questão
struct Jogador {
    int id;
    char nome[100];
    int altura;
    int peso;
    char universidade[100];
    int anoNascimento;
    char cidadeNascimento[100];
    char estadoNascimento[100];
};


void imprimirJogador(struct Jogador jogador) {
    printf("[%d ## %s ## %d ## %d ## %d ## %s ## %s ## %s]\n",
           jogador.id, jogador.nome, jogador.altura, jogador.peso,
           jogador.anoNascimento, jogador.universidade,
           jogador.cidadeNascimento, jogador.estadoNascimento);
}


void lerJogador(struct Jogador *jogador, const char *novoID) {
    FILE *arquivo = fopen("/tmp/players.csv", "r");
    if (arquivo == NULL) {
        printf("Erro ao abrir o arquivo.\n");
        return;
    }
    char linha[200];
    while (fgets(linha, sizeof(linha), arquivo)) { 
        char *token = strtok(linha, ","); 
        if (token != NULL && atoi(token) == atoi(novoID)) { 
            jogador->id = atoi(token);

            token = strtok(NULL, ",");
            if (token != NULL && strlen(token) > 0) {
                strncpy(jogador->nome, token, sizeof(jogador->nome));
            } else {
                strncpy(jogador->nome, "nao informado", sizeof(jogador->nome));
            }

            token = strtok(NULL, ",");
            jogador->altura = atoi(token);

            token = strtok(NULL, ",");
            jogador->peso = atoi(token);

            token = strtok(NULL, ",");
            if (token != NULL && strlen(token) > 0) {
                strncpy(jogador->universidade, token, sizeof(jogador->universidade));
            } else {
                strncpy(jogador->universidade, "nao informado", sizeof(jogador->universidade));
            }

            token = strtok(NULL, ",");
            jogador->anoNascimento = atoi(token);

            token = strtok(NULL, ",");
            if (token != NULL && strlen(token) > 0) {
                size_t token_length = strlen(token);
                if (token[token_length - 1] == '\n') {
                    token[token_length - 1] = '\0';
                }
                strncpy(jogador->cidadeNascimento, token, sizeof(jogador->cidadeNascimento));
            } else {
                strncpy(jogador->cidadeNascimento, "nao informado", sizeof(jogador->cidadeNascimento));
            }

            token = strtok(NULL, ",");
            if (token != NULL && strlen(token) > 0) {
                size_t token_length = strlen(token);
                if (token[token_length - 1] == '\n') {
                    token[token_length - 1] = '\0'; 
                }
                strncpy(jogador->estadoNascimento, token, sizeof(jogador->estadoNascimento));
            } else {
                strncpy(jogador->estadoNascimento, "nao informado", sizeof(jogador->estadoNascimento));
            }
            return; 
        }
    }
    fclose(arquivo); 
}

void swap(struct Jogador *a, struct Jogador *b) {
    struct Jogador temp = *a;
    *a = *b;
    *b = temp;
}

void quicksortRec(struct Jogador *jogadores, int esq, int dir) {
    int i = esq, j = dir;
    struct Jogador pivo = jogadores[(dir + esq) / 2]; // Use a struct Jogador as a pivot

    while (i <= j) {
        while (strcmp(jogadores[i].estadoNascimento, pivo.estadoNascimento) < 0 || 
               (strcmp(jogadores[i].estadoNascimento, pivo.estadoNascimento) == 0 &&
                strcmp(jogadores[i].nome, pivo.nome) < 0))
            i++;
        
        while (strcmp(jogadores[j].estadoNascimento, pivo.estadoNascimento) > 0 || 
               (strcmp(jogadores[j].estadoNascimento, pivo.estadoNascimento) == 0 &&
                strcmp(jogadores[j].nome, pivo.nome) > 0))
            j--;

        if (i <= j) {
            swap(&jogadores[i], &jogadores[j]);
            i++;
            j--;
        }
    }

    if (esq < j) quicksortRec(jogadores, esq, j);
    if (i < dir) quicksortRec(jogadores, i, dir);
}

void quickSortEstado(struct Jogador *jogadores, int n, int cont){
    quicksortRec(jogadores, 0, n-1);
}


int main() {
    char novoId[100]; // cria o Id
    struct Jogador jogadores[4000]; //cria o Jogador
    int cont =0;
    size_t n = sizeof(struct Jogador);
    while (1) {
        scanf("%s", novoId); // le o novoId
        if (novoId[0] == 'F' && novoId[1] == 'I' && novoId[2] == 'M') {
            break; // quebra se for fim
        }
        lerJogador(&jogadores[cont], novoId); // le 
        cont++;
    }
    quickSortEstado(jogadores, cont, cont);
    for (int i = 0; i < cont; i++) {
        imprimirJogador(jogadores[i]); 
    }
    return 0;
}