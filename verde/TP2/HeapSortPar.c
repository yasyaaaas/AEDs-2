#include <stdio.h>
#include <stdlib.h>
#include <string.h>

//sté o ler mesma coisa da 1° questão
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
        read(linha, jogador);
        if (jogador->id == atoi(novoID)) {
            fclose(arquivo);
            return;
        }
    }
    fclose(arquivo); 
}

void read(char *line, struct Jogador *this)
{
    int index = 0;
    int atr_index = 0;
    char id_string[10];
    char nome_string[100];
    char altura_string[10];
    char peso_string[10];
    char universidade_string[100];
    char anoNascimento_string[10];
    char cidadeNascimento_string[100];
    char estadoNascimento_string[100];

    int i;

    while (1)
    {

        if (line[index] == ',')
        {
            for (i = atr_index; i < index; i++)
            {
                id_string[i - atr_index] = line[i];
            }
            id_string[index - atr_index] = '\0';

            if (strcmp(id_string, "") == 0 || strcmp(id_string, ",") == 0)
            {
                this->id = 0;
                atr_index = ++index;
            }
            else
            {
                this->id = atoi(id_string);
                atr_index = ++index;
            }

            break;
        }
        index++;
    }

    while (1)
    {
        if (line[index] == ',')
        {
            for (i = atr_index; i < index; i++)
            {
                nome_string[i - atr_index] = line[i];
            }
            nome_string[index - atr_index] = '\0';

            if (strcmp(nome_string, "") == 0 || strcmp(nome_string, ",") == 0)
            {
                strcpy(this->nome, "nao informado");
                atr_index = ++index;
            }
            else
            {
                strcpy(this->nome, nome_string);
                atr_index = ++index;
            }
            break;
        }
        index++;
    }

    while (1)
    {

        if (line[index] == ',')
        {
            for (i = atr_index; i < index; i++)
            {
                altura_string[i - atr_index] = line[i];
            }
            altura_string[index - atr_index] = '\0';

            if (strcmp(altura_string, "") == 0 || strcmp(altura_string, ",") == 0)
            {
                this->altura = 0;
                atr_index = ++index;
            }
            else
            {
                this->altura = atoi(altura_string);
                atr_index = ++index;
            }
            break;
        }
        index++;
    }

    while (1)
    {
        if (line[index] == ',')
        {
            for (i = atr_index; i < index; i++)
            {
                peso_string[i - atr_index] = line[i];
            }
            peso_string[index - atr_index] = '\0';
            if (strcmp(peso_string, "") == 0 || strcmp(peso_string, ",") == 0)
            {
                this->peso = 0;
                atr_index = ++index;
            }
            else
            {
                this->peso = atoi(peso_string);
                atr_index = ++index;
            }

            break;
        }
        index++;
    }

    while (1)
    {

        if (line[index] == ',')
        {
            for (i = atr_index; i < index; i++)
            {
                universidade_string[i - atr_index] = line[i];
            }
            universidade_string[index - atr_index] = '\0';
            if (strcmp(universidade_string, "") == 0 || strcmp(universidade_string, ",") == 0)
            {
                strcpy(this->universidade, "nao informado");
                atr_index = ++index;
            }
            else
            {
                strcpy(this->universidade, universidade_string);
                atr_index = ++index;
            }
            break;
        }
        index++;
    }

    while (1)
    {

        if (line[index] == ',')
        {
            for (i = atr_index; i < index; i++)
            {
                anoNascimento_string[i - atr_index] = line[i];
            }
            anoNascimento_string[index - atr_index] = '\0';

            if (strcmp(anoNascimento_string, "") == 0)
            {
                this->anoNascimento = 0;
                atr_index = ++index;
            }
            else
            {
                this->anoNascimento = atoi(anoNascimento_string);
                atr_index = ++index;
            }

            break;
        }
        index++;
    }

    while (1)
    {
        if (line[index] == ',')
        {
            for (i = atr_index; i < index; i++)
            {
                cidadeNascimento_string[i - atr_index] = line[i];
            }
            cidadeNascimento_string[index - atr_index] = '\0';

            if (strcmp(cidadeNascimento_string, "") == 0 || strcmp(cidadeNascimento_string, ",") == 0)
            {
                strcpy(this->cidadeNascimento, "nao informado");
                atr_index = ++index;
            }
            else
            {
                strcpy(this->cidadeNascimento, cidadeNascimento_string);
                atr_index = ++index;
            }
            break;
        }
        index++;
    }

    while (1)
    {
        if (index == strlen(line) - 1)
        {
            for (i = atr_index; i < index; i++)
            {
                estadoNascimento_string[i - atr_index] = line[i];
            }
            estadoNascimento_string[index - atr_index] = '\0';

            if (strcmp(estadoNascimento_string, "") == 0 || strcmp(estadoNascimento_string, ",") == 0)
            {
                strcpy(this->estadoNascimento, "nao informado");
                atr_index = ++index;
            }
            else
            {
                strcpy(this->estadoNascimento, estadoNascimento_string);
            }
            break;
        }
        index++;
    }
}

void construir(struct Jogador *jogadores, int tamHeap){
    for(int i = tamHeap; i > 1 && jogadores[i].altura > jogadores[i/2].altura; i /= 2){
        swap(&jogadores[i], &jogadores[i/2]);
    }
}

void swap(struct Jogador *a, struct Jogador *b) {
    struct Jogador temp = *a;
    *a = *b;
    *b = temp;
}

int getMaiorFilho(struct Jogador *jogadores, int i, int tamHeap){
    int filho;
    if (2*i == tamHeap || jogadores[2*i].altura > jogadores[2*i+1].altura){
        filho = 2*i;
    } else {
        filho = 2*i + 1;
    }
    return filho;
}

void reconstruir(struct Jogador *jogadores, int tamHeap){
    int i = 1;
    while(i <= (tamHeap/2)){
        int filho = getMaiorFilho(jogadores, i, tamHeap);
        if(jogadores[i].altura < jogadores[filho].altura){
            swap(&jogadores[i], &jogadores[filho]);
            i = filho;
        }else{
            i = tamHeap;
        }
    }
}

void heapParAltura(struct Jogador *jogadores, int n, int cont, int k){
    //Alterar o vetor ignorando a posicao zero
    struct Jogador arrayTmp[n+1];
    for(int i = 0; i < n; i++){
        arrayTmp[i+1] = jogadores[i];
    }

    //Construção do heap com os k primeiros elementos
    //Construção do heap com todos os elementos
    for (int tam = 2; tam <= n; tam++){
        construir(jogadores, tam);
    }

    //Para cada um dos (n-k) demais elementos, se ele for
    //menor que a raiz, inserir do heap
    //Reconstruir o heap
    for (int tam = n; tam > 1; tam--){
        swap(&jogadores[1], &jogadores[tam]);
        reconstruir(jogadores, tam-1);
    }


    //Alterar o vetor para voltar a posicao zero
    for(int i = 0; i < n; i++){
        jogadores[i] = arrayTmp[i+1];
    }
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
    heapParAltura(jogadores, cont, cont, 10);
    for (int i = 0; i < 10; i++) {
        imprimirJogador(jogadores[i]); 
    }
    return 0;
}