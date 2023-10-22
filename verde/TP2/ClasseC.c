#include <stdio.h>
#include <stdlib.h>
#include <string.h>

//faz a struct do jogador
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


//imprime o jogador
void imprimirJogador(struct Jogador jogador) {
    printf("[%d ## %s ## %d ## %d ## %d ## %s ## %s ## %s]\n",
           jogador.id, jogador.nome, jogador.altura, jogador.peso,
           jogador.anoNascimento, jogador.universidade,
           jogador.cidadeNascimento, jogador.estadoNascimento);
}

//le o jogador
void lerJogador(struct Jogador *jogador, const char *novoID) {
    // passa o jogador e o id do input
    FILE *arquivo = fopen("/tmp/players.csv", "r");
    //le o arquivo
    if (arquivo == NULL) {
        printf("Erro ao abrir o arquivo.\n");
        return;
    }
    char linha[200];
    while (fgets(linha, sizeof(linha), arquivo)) { // ler até o final da linha do arquivo
        char *token = strtok(linha, ","); // separa quando tiver ,
        // strtok separa a string em partes menores
        if (token != NULL && atoi(token) == atoi(novoID)) { // se id for igual ao id do jogador
            jogador->id = atoi(token); // converte uma string de inteiros para um num inteiro

            token = strtok(NULL, ","); // obtem o próximo token da string
            if (token != NULL && strlen(token) > 0) {
                //se o token não for nulo e o se tamanho mair que zero
                strncpy(jogador->nome, token, sizeof(jogador->nome));
                // copia o que esta no token para o jogador->nome
                // terceiro argunemto é o tamanho que deve ir para o token
            } else {
                strncpy(jogador->nome, "nao informado", sizeof(jogador->nome));
                //senão copia "nao informado" para o jogador->nome
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
                //armazena tamanho do token em token_length
                if (token[token_length - 1] == '\n') {
                    token[token_length - 1] = '\0'; // Substitui o '\n' por '\0'
                }
                strncpy(jogador->cidadeNascimento, token, sizeof(jogador->cidadeNascimento));
            } else {
                strncpy(jogador->cidadeNascimento, "nao informado", sizeof(jogador->cidadeNascimento));
            }

            token = strtok(NULL, ",");
            if (token != NULL && strlen(token) > 0) {
                size_t token_length = strlen(token);
                if (token[token_length - 1] == '\n') {
                    token[token_length - 1] = '\0'; // Substitui o '\n' por '\0'
                }
                strncpy(jogador->estadoNascimento, token, sizeof(jogador->estadoNascimento));
            } else {
                strncpy(jogador->estadoNascimento, "nao informado", sizeof(jogador->estadoNascimento));
            }
            return; // Encontrou o jogador, pode sair da função
        }
    }
    fclose(arquivo); // Fechar o arquivo após ler todas as linhas
}

int main() {
    char novoId[100]; // cria o Id
    struct Jogador jogador; //cria o Jogador
    while (1) {
        scanf("%s", novoId); // le o novoId
        if (novoId[0] == 'F' && novoId[1] == 'I' && novoId[2] == 'M') {
            break; // quebra se for fim
        }
        lerJogador(&jogador, novoId); // le 
        imprimirJogador(jogador); // imprime
    }
    return 0;
}