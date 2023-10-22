#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <time.h>



// até o ler é a mesma struct da 2° pergunta
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

int pesqBinaria(int *ids, int tam, int nome) {
    // faz a pesquisa binaria
    int esq = 0;
    int dir = tam - 1;
    while (esq <= dir) {
        int meio = esq + (dir - esq) / 2;

        if (ids[meio] == nome) {
            return 1; // O ID foi encontrado
        } else if (ids[meio] < nome) {
            esq = meio + 1;
        } else {
            dir = meio - 1;
        }
    }
    return 0; // O ID não foi encontrado
}

void swap(struct Jogador *a, struct Jogador *b) {
    struct Jogador temp = *a;
    *a = *b;
    *b = temp;
}

void OrdSelRec(struct Jogador *jogadores, int n, int i, int comp){
    if (i >= n - 1) {
        return;
    }
    
    int menor = i;
    for (int j = i + 1; j < n; j++) {
        if (strcmp(jogadores[menor].nome, jogadores[j].nome) > 0) {
            comp++;
            menor = j;
        }
    }
    
    if (menor != i) {
        swap(&jogadores[menor], &jogadores[i]);
    }

    OrdSelRec(jogadores, n, i + 1, comp);
}

int main() {
    char novoId[100]; // cria o Id
    char novoNome[100]; // os nomes
    int maxJogadores = 2000; // Tamanho máximo da lista de jogadores
    int numJogadores = 0;
    int comp=0;
    struct Jogador jogadores[maxJogadores]; // cria uma lista de jogadores
    int ids[maxJogadores]; // ve quantas ids tem
    // Parte 1: Ler jogadores e IDs
    while (1) {
        if (scanf("%s", novoId) != 1) {
            break;
        }
        if (novoId[0] == 'F' && novoId[1] == 'I' && novoId[2] == 'M') {
            break;
        }
        lerJogador(&jogadores[numJogadores], novoId);
        ids[numJogadores] = jogadores[numJogadores].id;
        numJogadores++;
    }
    //ordernar por nome
    OrdSelRec(jogadores, numJogadores, 0, comp);
    // Parte 2: Pesquisar nomes
    while (1) {
        if (scanf("%s", novoNome) != 1) {
            break;
        }
        if (novoNome[0] == 'F' && novoNome[1] == 'I' && novoNome[2] == 'M') {
            break;
        }
        if (pesqBinaria(ids, numJogadores, atoi(novoNome))) {
            printf("SIM\n");
        } else {
            printf("NAO\n");
        }
    }
    // Parte 3: Log
    clock_t tempoInicial = clock();
    FILE *escrever;
    escrever = fopen("matricula_sequencial.txt", "w");
    if (escrever == NULL) {
        perror("Erro ao abrir o arquivo");
        return 1;
    }
    fprintf(escrever, "800989 \t %ld \t %d\n", (clock() - tempoInicial), comp);
    fclose(escrever);

    return 0;
}