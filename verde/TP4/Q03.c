#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include <stdbool.h>

typedef struct jogador jogador;
struct jogador
{
    int id;
    char nome[50];
    int altura;
    int peso;
    char universidade[50];
    int anoNascimento;
    char cidadeNascimento[50];
    char estadoNascimento[50];
};

jogador _jogador()
{
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

jogador new_jogador(int id, char *nome, int altura, int peso, char *universidade, int anoNascimento, char *cidadeNascimento, char *estadoNascimento)
{
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

void setid(jogador *this, int id)
{
    this->id = id;
}

void setnome(jogador *this, char *nome)
{
    strcpy(this->nome, nome);
}

void setaltura(jogador *this, int altura)
{
    this->altura = altura;
}

void setpeso(jogador *this, int peso)
{
    this->peso = peso;
}

void setuniversidade(jogador *this, char *universidade)
{
    strcpy(this->universidade, universidade);
}

void setanoNascimento(jogador *this, int anoNascimento)
{
    this->anoNascimento = anoNascimento;
}

void setcidadeNascimento(jogador *this, char *cidadeNascimento)
{
    strcpy(this->cidadeNascimento, cidadeNascimento);
}

void setestadoNascimento(jogador *this, char *estadoNascimento)
{
    strcpy(this->estadoNascimento, estadoNascimento);
}

int getid(jogador *this)
{
    return this->id;
}

char *getnome(jogador *this)
{
    return this->nome;
}

int getaltura(jogador *this)
{
    return this->altura;
}

int getpeso(jogador *this)
{
    return this->peso;
}

char *getuniversidade(jogador *this)
{
    return this->universidade;
}

int getanoNascimento(jogador *this)
{
    return this->anoNascimento;
}

char *getcidadeNascimento(jogador *this)
{
    return this->cidadeNascimento;
}

char *getestadoNascimento(jogador *this)
{
    return this->estadoNascimento;
}

void imprimir(jogador *this)
{
    printf("[%d ## %s ## %d ## %d ## %d ## %s ## %s ## %s]\n", this->id, this->nome, this->altura, this->peso, this->anoNascimento, this->universidade, this->cidadeNascimento, this->estadoNascimento);
}

void imprimirSemId(jogador *this)
{
    printf("## %s ## %d ## %d ## %d ## %s ## %s ## %s ##\n", this->nome, this->altura, this->peso, this->anoNascimento, this->universidade, this->cidadeNascimento, this->estadoNascimento);
}

void read(char *line, jogador *this)
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

bool isFim(char *str)
{
    bool resp = false;
    if (strlen(str) >= 3 && str[0] == 'F' && str[1] == 'I' && str[2] == 'M')
    {
        resp = true;
    }
    return resp;
}

struct No
{
    struct jogador elemento;
    struct No *esq, *dir;
    int nivel;
};

struct AVL
{
    struct No *raiz;
};

char *pesquisar(struct jogador x, struct No *i, char *path)
{
    char *resp;
    if (i == NULL)
    {
        resp = "NAO";
    }
    else if (strcmp(x.nome, i->elemento.nome) == 0)
    {
        resp = "SIM";
    }
    else if (strcmp(x.nome, i->elemento.nome) < 0)
    {
        resp = pesquisar(x, i->esq, path);
        strcat(path, " esq");
    }
    else
    {
        resp = pesquisar(x, i->dir, path);
        strcat(path, " dir");
    }
    return resp;
}

struct No *balancear(struct No *no);

struct No *inserir(struct jogador x, struct No *i)
{
    if (i == NULL)
    {
        i = (struct No *)malloc(sizeof(struct No));
        i->elemento = x;
        i->esq = i->dir = NULL;
        i->nivel = 1;
    }
    else if (strcmp(x.nome, i->elemento.nome) < 0)
    {
        i->esq = inserir(x, i->esq);
    }
    else if (strcmp(x.nome, i->elemento.nome) > 0)
    {
        i->dir = inserir(x, i->dir);
    }
    return balancear(i);
}

int getNivel(struct No *no)
{
    return (no == NULL) ? 0 : no->nivel;
}

void setNivel(struct No *no)
{
    no->nivel = 1 + max(getNivel(no->esq), getNivel(no->dir));
}

int max(int a, int b)
{
    return (a > b) ? a : b;
}

struct No *rotacionarDir(struct No *no)
{
    struct No *noEsq = no->esq;
    struct No *noEsqDir = noEsq->dir;

    noEsq->dir = no;
    no->esq = noEsqDir;
    setNivel(no);
    setNivel(noEsq);

    return noEsq;
}

struct No *rotacionarEsq(struct No *no)
{
    struct No *noDir = no->dir;
    struct No *noDirEsq = noDir->esq;

    noDir->esq = no;
    no->dir = noDirEsq;

    setNivel(no);
    setNivel(noDir);
    return noDir;
}

struct No *balancear(struct No *no)
{
    if (no != NULL)
    {
        int fator = getNivel(no->dir) - getNivel(no->esq);
        if (abs(fator) <= 1)
        {
            setNivel(no);
        }
        else if (fator == 2)
        {
            int fatorFilhoDir = getNivel(no->dir->dir) - getNivel(no->dir->esq);
            if (fatorFilhoDir == -1)
            {
                no->dir = rotacionarDir(no->dir);
            }
            no = rotacionarEsq(no);
        }
        else if (fator == -2)
        {
            int fatorFilhoEsq = getNivel(no->esq->dir) - getNivel(no->esq->esq);
            if (fatorFilhoEsq == 1)
            {
                no->esq = rotacionarEsq(no->esq);
            }
            no = rotacionarDir(no);
        }
    }
    return no;
}

void criarLog(char *matricula, long tempoExecucao, int numComparacoes)
{
    char filename[50];
    filename[0] = '\0';
    strcpy(filename, matricula);
    FILE *file = fopen(strcat(matricula, "800989_avl.txt"), "w");
    if (file == NULL)
    {
        printf("Erro ao criar o arquivo de log.\n");
        return;
    }
    fprintf(file, "800989\t%ld\t%d\n", tempoExecucao, numComparacoes);
    fclose(file);
}

struct No *inserir(struct jogador x, struct No *i);
void criarLog(char *matricula, long tempoExecucao, int numComparacoes);

int main()
{
    struct jogador jogador;
    struct AVL avl;
    avl.raiz = NULL;

    char entraString[1000];
    char base[1000] = "/tmp/players.csv";
    char line[1000];
    int numComparacoes = 0;

    scanf("%s", entraString);

    while (!isFim(entraString))
    {
        FILE *arq = fopen(base, "r");
        int num = atoi(entraString);
        for (int i = 0; i < num + 2; i++)
        {
            fgets(line, 1000, arq);
        }
        fclose(arq);

        struct jogador player = _jogador();
        read(line, &player);

        avl.raiz = inserir(player, avl.raiz);

        scanf("%s", entraString);
    }

    while (1)
    {
        char nomesJog[1000];
        scanf("%s", nomesJog);

        if (isFim(nomesJog))
        {
            break;
        }

        jogador = _jogador();
        setnome(&jogador, nomesJog);
        char path[1000] = "";
        printf("%s raiz %s\n", getnome(&jogador), pesquisar(jogador, avl.raiz, path));

        numComparacoes++;
    }

    criarLog("800989", 0, numComparacoes);
    return 0;
}