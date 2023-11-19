#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include <stdbool.h>

typedef struct jogador jogador;
struct jogador{
    int id;
    char nome[50];
    int altura;
    int peso;
    char universidade[50];
    int anoNascimento;
    char cidadeNascimento[50];
    char estadoNascimento[50];
};

jogador _jogador(){
    jogador j;
    j.id = 0;
    strcpy(j.nome, "");
    j.altura = 0;
    j.peso = 0;
    strcpy(j.universidade, "");
    j.anoNascimento = 0;
    strcpy(j.cidadeNascimento, "");
    strcpy(j.estadoNascimento, "");
    return j;
}

jogador new_jogador(int id, char *nome, int altura, int peso, char *universidade, int anoNascimento, char *cidadeNascimento, char *estadoNascimento){
    jogador j;
    j.id = id;
    strcpy(j.nome, nome);
    j.altura = altura;
    j.peso = peso;
    strcpy(j.universidade, universidade);
    j.anoNascimento = anoNascimento;
    strcpy(j.cidadeNascimento, cidadeNascimento);
    strcpy(j.estadoNascimento, estadoNascimento);
    return j;
}

void setid(jogador* this, int id){
    this->id = id;
}

void setnome(jogador* this, char* nome){
    strcpy(this->nome, nome);
}

void setaltura(jogador* this, int altura){
    this->altura = altura;
}

void setpeso(jogador* this, int peso){
    this->peso = peso;
}

void setuniversidade(jogador* this, char* universidade){
    strcpy(this->universidade, universidade);
}

void setanoNascimento(jogador* this, int anoNascimento){
    this->anoNascimento = anoNascimento;
}

void setcidadeNascimento(jogador* this, char* cidadeNascimento){
    strcpy(this->cidadeNascimento, cidadeNascimento);
}

void setestadoNascimento(jogador* this, char* estadoNascimento){
    strcpy(this->estadoNascimento, estadoNascimento);
}

int getid(jogador* this){
    return this->id;
}

char* getnome(jogador* this){
    return this->nome;
}

int getaltura(jogador* this){
    return this->altura;
}

int getpeso(jogador* this){
    return this->peso;
}

char* getuniversidade(jogador* this){
    return this->universidade;
}

int getanoNascimento(jogador* this){
    return this->anoNascimento;
}

char* getcidadeNascimento(jogador* this){
    return this->cidadeNascimento;
}

char* getestadoNascimento(jogador* this){
    return this->estadoNascimento;
}

void imprimir(jogador* this){
    printf("[%d ## %s ## %d ## %d ## %d ## %s ## %s ## %s]\n", this->id, this->nome, this->altura, this->peso, this->anoNascimento, this->universidade, this->cidadeNascimento, this->estadoNascimento);
}

void imprimirNome(jogador* this){
    printf("(R) %s\n", this->nome);
}


void imprimirsemID(jogador* this){
    printf("%s ## %d ## %d ## %d ## %s ## %s ## %s]\n", this->nome, this->altura, this->peso, this->anoNascimento, this->universidade, this->cidadeNascimento, this->estadoNascimento);
}
void read(char *line, jogador* this){
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

    while(1){

        if(line[index] == ','){
            for(i = atr_index; i < index; i++){
                id_string[i - atr_index] = line[i];
            }
            id_string[index - atr_index] = '\0';

            if(strcmp(id_string, "") == 0 || strcmp(id_string, ",") == 0){
                this->id = 0;
                atr_index = ++index;
            }else{
                this->id = atoi(id_string);
                atr_index = ++index;
            }

            break;
        }
        index++;

    }
    
    while(1){
        if(line[index] == ','){
            for(i = atr_index; i < index; i++){
                nome_string[i - atr_index] = line[i];
            }
            nome_string[index - atr_index] = '\0';

            if(strcmp(nome_string, "") == 0 || strcmp(nome_string, ",") == 0){
                strcpy(this->nome, "nao informado");
                atr_index = ++index;
            }else{
                strcpy(this->nome, nome_string);
                atr_index = ++index;
            }
            break;
        }
        index++;
    }

    while(1){

        if(line[index] == ','){
            for(i = atr_index; i < index; i++){
                altura_string[i - atr_index] = line[i];
            }
            altura_string[index - atr_index] = '\0';

            if(strcmp(altura_string, "") == 0 || strcmp(altura_string, ",") == 0){
                this->altura = 0;
                atr_index = ++index;
            }else{
                this->altura = atoi(altura_string);
                atr_index = ++index;
            }
            break;
        }
        index++;
    }

    while(1){
            if(line[index] == ','){
                for(i = atr_index; i < index; i++){
                    peso_string[i - atr_index] = line[i];
                }
                peso_string[index - atr_index] = '\0';
                if(strcmp(peso_string, "") == 0 || strcmp(peso_string, ",") == 0){
                    this->peso = 0;
                    atr_index = ++index;
                }else{
                    this->peso = atoi(peso_string);
                    atr_index = ++index;
                }

                break;
            }
            index++;
        }

        while(1){
            

            if(line[index] == ','){
                for(i = atr_index; i < index; i++){
                    universidade_string[i - atr_index] = line[i];
                }
                universidade_string[index - atr_index] = '\0';
                if(strcmp(universidade_string, "") == 0 || strcmp(universidade_string, ",") == 0){
                    strcpy(this->universidade, "nao informado");
                    atr_index = ++index;
                }else{
                    strcpy(this->universidade, universidade_string);
                    atr_index = ++index;
                }
                break;
            }
            index++;
        }

        while(1){
            

            if(line[index] == ','){
                for(i = atr_index; i < index; i++){
                    anoNascimento_string[i - atr_index] = line[i];
                }
                anoNascimento_string[index - atr_index] = '\0';

                if(strcmp(anoNascimento_string, "") == 0){
                    this->anoNascimento = 0;
                    atr_index = ++index;
                }else{
                    this->anoNascimento = atoi(anoNascimento_string);
                    atr_index = ++index;
                }
                
                break;
            }
            index++;
        }


    while(1){
            if(line[index] == ','){
                for(i = atr_index; i < index; i++){
                    cidadeNascimento_string[i - atr_index] = line[i];
                }
                cidadeNascimento_string[index - atr_index] = '\0';
                
                if(strcmp(cidadeNascimento_string, "") == 0 || strcmp(cidadeNascimento_string, ",") == 0){
                    strcpy(this->cidadeNascimento, "nao informado");
                    atr_index = ++index;
                }else{
                    strcpy(this->cidadeNascimento, cidadeNascimento_string);
                    atr_index = ++index;
                }
                break;
            }
            index++;
        }

        while(1){
            if(index == strlen(line) - 1){
                for(i = atr_index; i < index; i++){
                    estadoNascimento_string[i - atr_index] = line[i];
                }
                estadoNascimento_string[index - atr_index] = '\0';
                
                if(strcmp(estadoNascimento_string, "") == 0  || strcmp(estadoNascimento_string, ",") == 0 ){
                    strcpy(this->estadoNascimento, "nao informado");
                    atr_index = ++index;
                }else{
                    strcpy(this->estadoNascimento, estadoNascimento_string);
                }
                break;
            }
            index++;
        }
}



bool isFim(char *str){
    bool resp = false;
    if(strlen(str) >= 3 && str[0] == 'F' && str[1] == 'I' && str[2] == 'M'){
        resp = true;
    }
    return resp;
}
#define MAX_JOGADORES 470
#define MAX_LENGTH 200



void insercaoPorCor(jogador *array, int n, int cor, int h){
    for (int i = (h + cor); i < n; i+=h) {
        jogador tmp = array[i];
        int j = i - h;
        while ((j >= 0) && (array[j].peso > tmp.peso || (array[j].peso == tmp.peso && strcmp(array[j].nome, tmp.nome) > 0))) {
            array[j + h] = array[j];
            j-=h;
        }
        array[j + h] = tmp;
    }
}

void shellsort(jogador *array, int n) {
    int h = 1;

    do { h = (h * 3) + 1; } while (h < n);

    do {
        h /= 3;
        for(int cor = 0; cor < h; cor++){
            insercaoPorCor(array, n, cor, h);
        }
    } while (h != 1);
}

int main(){

    char entraString[MAX_LENGTH];
    char base[20] = "/tmp/players.csv";
    char line[MAX_LENGTH];
    jogador array[MAX_JOGADORES];
    memset(array, 0, MAX_LENGTH);

    int k = 0 ;

    scanf("%s", entraString);

    while(!isFim(entraString)){
        FILE *arq = fopen(base, "r");
        int num = atoi(entraString);
        for(int i = 0; i < num + 2; i++){
            fgets(line, MAX_LENGTH, arq);
        }
        jogador player;
        read(line, &player);
        array[k] = player;
        k++;
        scanf("%s", entraString);
    }
    int n = 0;
    scanf("%i", &n);

for (int i = 0; i < n; i++) {
        char comando[MAX_LENGTH];
        fgets(comando, sizeof(comando), stdin);

        comando[strcspn(comando, "\n")] = '\0';

        size_t posicao_espaco = strcspn(comando, " ");

        if (strncmp(comando, "II", 2) == 0) {
            jogador player;
            read(line, &player);
            for (int j = k; j > 0; j--) {
                array[j] = array[j - 1];
            }
            array[0] = player;
            k++;
        } else if (strncmp(comando, "I*", 2) == 0) {
            int posicao;
            sscanf(comando + 2, "%d", &posicao);
            jogador player;
            read(line, &player);
            for (int j = k; j > posicao; j--) {
                array[j] = array[j - 1];
            }
            array[posicao] = player;
            k++;
        } else if (strncmp(comando, "IF", 2) == 0) {
            jogador player;
            read(line, &player);
            array[k] = player;
            k++;
        } else if (strncmp(comando, "RI", 2) == 0) {
            if (k > 0) {
                imprimirNome(&array[0]);
                for (int j = 0; j < k - 1; j++) {
                    array[j] = array[j + 1];
                }
                k--;
            }
            continue;
        } else if (strncmp(comando, "R*", 2) == 0) {
            int posicao;
            sscanf(comando + 2, "%d", &posicao);
            if (posicao >= 0 && posicao < k) {
                imprimirNome(&array[posicao]);
                for (int j = posicao; j < k - 1; j++) {
                    array[j] = array[j + 1];
                }
                k--;
            }
        } else if (strncmp(comando, "RF", 2) == 0) {
            if (k > 0) {
                imprimirNome(&array[k - 1]);
                k--;
            }
        }
    }
    for (int i = 0; i < k; i++) {
        printf("[%i] ## ", i);
        imprimirsemID(&array[i]);
    }

    return 0;
}