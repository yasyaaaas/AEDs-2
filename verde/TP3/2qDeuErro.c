#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <string.h>

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

void read(char *line, struct Jogador *this)
{
    int index = 0; // controla posição atual da linha do arq
    int atr_index = 0; // controla o depois da vírgula
    // passa tudo para string
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



//TIPO CELULA ===================================================================
typedef struct Celula {
	struct Jogador elemento;        // Elemento inserido na celula.
	struct Celula* prox; // Aponta a celula prox.
} Celula;

Celula* novaCelula(struct Jogador elemento) {
   Celula* nova = (Celula*) malloc(sizeof(Celula));
   nova->elemento = elemento;
   nova->prox = NULL;
   return nova;
}

//LISTA PROPRIAMENTE DITA =======================================================
Celula* primeiro;
Celula* ultimo;


void start () {
   struct Jogador defaultPlayer = {0, "Default Player", 0, 0, "Default University", 0, "Default City", "Default State"};
   primeiro = novaCelula(defaultPlayer);
   ultimo = primeiro;
}


void inserirInicio(struct Jogador x) {
   Celula* tmp = novaCelula(x);
   tmp->prox = primeiro->prox;
   primeiro->prox = tmp;
   if (primeiro == ultimo) {                    
      ultimo = tmp;
   }
   tmp = NULL;
}


void inserirFim(struct Jogador x) {
   ultimo->prox = novaCelula(x);
   ultimo = ultimo->prox;
}


struct Jogador removerInicio() {
   if (primeiro == ultimo) {
      errx(1, "Erro ao remover!");
   }

   Celula* tmp = primeiro;
   primeiro = primeiro->prox;
   struct Jogador resp = primeiro->elemento;
   tmp->prox = NULL;
   free(tmp);
   tmp = NULL;
   return resp;
}


struct Jogador removerFim() {
   if (primeiro == ultimo) {
      errx(1, "Erro ao remover!");
   } 

   // Caminhar ate a penultima celula:
   Celula* i;
   for(i = primeiro; i->prox != ultimo; i = i->prox);

   struct Jogador resp = ultimo->elemento;
   ultimo = i;
   free(ultimo->prox);
   i = ultimo->prox = NULL;

   return resp;
}


int tamanho() {
   int tamanho = 0;
   Celula* i;
   for(i = primeiro; i != ultimo; i = i->prox, tamanho++);
   return tamanho;
}


void inserir(struct Jogador x, int pos) {

   int tam = tamanho();

   if(pos < 0 || pos > tam){
      errx(1, "Erro ao inserir posicao (%d/ tamanho = %d) invalida!", pos, tam);
   } else if (pos == 0){
      inserirInicio(x);
   } else if (pos == tam){
      inserirFim(x);
   } else {
      // Caminhar ate a posicao anterior a insercao
      int j;
      Celula* i = primeiro;
      for(j = 0; j < pos; j++, i = i->prox);

      Celula* tmp = novaCelula(x);
      tmp->prox = i->prox;
      i->prox = tmp;
      tmp = i = NULL;
   }
}


struct Jogador remover(int pos) {
   struct Jogador resp;
   int tam = tamanho();

   if (primeiro == ultimo){
      errx(1, "Erro ao remover (vazia)!");
   } else if(pos < 0 || pos >= tam){
      errx(1, "Erro ao remover posicao (%d/ tamanho = %d) invalida!", pos, tam);
   } else if (pos == 0){
      resp = removerInicio();
   } else if (pos == tam - 1){
      resp = removerFim();
   } else {
      // Caminhar ate a posicao anterior a insercao
      Celula* i = primeiro;
      int j;
      for(j = 0; j < pos; j++, i = i->prox);

      Celula* tmp = i->prox;
      resp = tmp->elemento;
      i->prox = tmp->prox;
      tmp->prox = NULL;
      free(tmp);
      i = tmp = NULL;
   }
   return resp;
}


void mostrar() {
   printf("[ ");
   Celula* i;
   for (i = primeiro->prox; i != NULL; i = i->prox) {
      printf("%d ", i->elemento);
   }
   printf("] \n");
}



int main(){
    start();
    char novoId[100]; // cria o Id
    struct Jogador jogadores[4000]; //cria o Jogador
    char entrada[50];
    int num =0;
    int cont =0;
    while (1) {
        scanf("%s", novoId); // le o novoId
        if (strcmp(novoId, "FIM") == 0) {
            break; // quebra se for fim
        }
        lerJogador(&jogadores[cont], novoId); // le 
        cont++;
        printf("Jogador lido e inserido na lista: %s\n", novoId);
    }
    for (int i = 0; i < cont; i++) {
        inserirFim(jogadores[i]);
    }

    scanf("%i",num);

    for(int j =0; j < num; j++){
        fgets(entrada, sizeof(entrada), stdin);
        char *command = strtok(entrada, " ");
        if (strcmp(command, "II") == 0) {
            char playerId[100];
            sscanf(strtok(NULL, " "), "%s", playerId);
            struct Jogador jogador;
            lerJogador(&jogador, playerId);
            inserirInicio(jogador);
        } else if (strcmp(command, "I*") == 0) {
            int pos;
            char playerId[100];
            sscanf(strtok(NULL, " "), "%d", &pos);
            sscanf(strtok(NULL, " "), "%s", playerId);
            struct Jogador jogador;
            lerJogador(&jogador, playerId);
            inserir(jogador, pos);
        } else if (strcmp(command, "IF") == 0) {
            char playerId[100];
            sscanf(strtok(NULL, " "), "%s", playerId);
            struct Jogador jogador;
            lerJogador(&jogador, playerId);
            inserirFim(jogador);
        } else if (strcmp(command, "RI") == 0) {
            struct Jogador removedPlayer = removerInicio();
            printf("(R) %s\n", removedPlayer.nome);
        } else if (strcmp(command, "R*") == 0) {
            int pos;
            sscanf(strtok(NULL, " "), "%d", &pos);
            struct Jogador removedPlayer = remover(pos);
            printf("(R) %s\n", removedPlayer.nome);
        } else if (strcmp(command, "RF") == 0) {
            struct Jogador removedPlayer = removerFim();
            printf("(R) %s\n", removedPlayer.nome);
        }
    }

    int index = 0;
    Celula* celula = primeiro->prox;
    while (celula != NULL) {
        struct Jogador jogador = celula->elemento;
        if (jogador.id != 0) { // Check if the player is not empty
            printf("[%d] ## %s ## %d ## %d ## %s ## %d ## %s ## %s ##\n",
            index, jogador.nome, jogador.altura, jogador.peso,
            jogador.universidade, jogador.anoNascimento,
            jogador.cidadeNascimento, jogador.estadoNascimento);
        }
        index++;
        celula = celula->prox;
    }
    return 0;
}