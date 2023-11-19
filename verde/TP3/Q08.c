#include <err.h>
#include <time.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>

#define STR_MAX_LEN 80
#define BD_SIZE 3923 // Quantidade Jogadores

typedef const char* const literal;
typedef char* String;

char* readStr(FILE* stream, String input) {
	if (!stream) stream = stdin;

	fgets(input, STR_MAX_LEN, stream);
	input[(int)strcspn(input, "\n")] = '\0';
	return input;
}

int readInt() {
	int integer;
	scanf("%d%*c", &integer);
	return integer;
}

#define MAX_ATTRIBUTES 8

typedef struct Split {
	char array[MAX_ATTRIBUTES][STR_MAX_LEN];
} Split;

Split newSplit(FILE* CSV) {

	Split split;

	for (int i = 0; i < MAX_ATTRIBUTES; i++) {
		if (fscanf(CSV, "%[^,\n]", split.array[i]) == 0) {
			strcpy(split.array[i], "nao informado");
		}
		fgetc(CSV); // Despresando a virgula
	}

	return split;
}

Split splitSpace() {

	Split split;

	for (int i = 0; i < 3; i++) {
		scanf("%[^ \n]", split.array[i]);
		if (getchar() == '\n') i = 3;
	}

	return split;
}

typedef struct Timer {
	clock_t startTime;
	clock_t endTime;
	double totalTime;
	void (*Start)(struct Timer*);
	void (*Stop)(struct Timer*);
	double (*Time)(struct Timer*);
} Timer;

void TimerStart(Timer* timer) {
	timer->startTime = clock();
}

void TimerStop(Timer* timer) {
	timer->endTime = clock();
}

double TimerTime(Timer* timer) {
	timer->totalTime = ((double)(timer->endTime - timer->startTime)) / CLOCKS_PER_SEC;
	return timer->totalTime;
}

Timer newTimer() {
	Timer timer;
	timer.Start = TimerStart;
	timer.Stop = TimerStop;
	timer.Time = TimerTime;
	return timer;
}


typedef struct Log {
	int comparacoes, movimentacoes;
	void (*RegistroPesquisa) (literal fileName, Timer, struct Log);
	void (*RegistroOrdenacao) (literal fileName, Timer, struct Log);
} Log;

void RegistroPesquisa(literal fileName, Timer timer, Log log) {
	FILE* file = fopen(fileName, "w");

	fprintf(file, "Matrícula: 1462558\t");
	fprintf(file, "Tempo de execução: %fs\t", timer.Time(&timer));
	fprintf(file, "Número de comparações: %d", log.comparacoes);

	fclose(file);
}

void RegistroOrdenacao(literal fileName, Timer timer, Log log) {
	FILE* file = fopen(fileName, "w");

	fprintf(file, "Matrícula: 1462558\t");
	fprintf(file, "Tempo de execução: %fs\t", timer.Time(&timer));
	fprintf(file, "Número de comparações: %d\t", log.comparacoes);
	fprintf(file, "Número de movimentações: %d", log.movimentacoes);

	fclose(file);
}

Log newLog() {
	Log log = { 0, 0 };
	log.RegistroPesquisa = RegistroPesquisa;
	log.RegistroOrdenacao = RegistroOrdenacao;
	return log;
}

typedef struct Jogador {

	void* atributo;
	int id, altura, peso, anoNascimento;
	String nome;
	String universidade;
	String cidadeNascimento;
	String estadoNascimento;

	// Setter - Id
	void (*setId) (int id, struct Jogador*);

	// Setter - Altura
	void (*setAltura) (int altura, struct Jogador*);

	// Setter - Peso
	void (*setPeso) (int peso, struct Jogador*);

	// Setter - AnoNascimento
	void (*setAnoNascimento) (int anoNascimento, struct Jogador*);

	// Setter - Nome
	void (*setNome) (String nome, struct Jogador*);

	// Setter - Universidade
	void (*setUniversidade) (String universidade, struct Jogador*);

	// Setter - CidadeNascimento
	void (*setCidadeNascimento) (String cidadeNascimento, struct Jogador*);

	// Setter - EstadoNascimento
	void (*setEstadoNascimento) (String estadoNascimento, struct Jogador*);

	void (*Construtor) (Split, struct Jogador*);
	struct Jogador (*Clone) (struct Jogador);
	void (*Mostrar) (struct Jogador);
	void (*Close) (struct Jogador);

} Jogador;

// Setter - Id
void SetIdJogador(int id, Jogador* jogador) {
	jogador->id = id;
}

// Setter - Nome
void SetNomeJogador(String nome, Jogador* jogador) {
	jogador->nome = strdup(nome);
}

// Setter - Altura
void SetAlturaJogador(int altura, Jogador* jogador) {
	jogador->altura = altura;
}

// Setter - Peso
void SetPesoJogador(int peso, Jogador* jogador) {
	jogador->peso = peso;
}

// Setter - AnoNascimento
void SetAnoNascimentoJogador(int anoNascimento, Jogador* jogador) {
	jogador->anoNascimento = anoNascimento;
}

// Setter - Universidade
void SetUniversidadeJogador(String universidade, Jogador* jogador) {
	jogador->universidade = strdup(universidade);
}

// Setter - CidadeNascimento
void SetCidadeNascimentoJogador(String cidadeNascimento, Jogador* jogador) {
	jogador->cidadeNascimento = strdup(cidadeNascimento);
}

// Setter - EstadoNascimento
void SetEstadoNascimentoJogador(String estadoNascimento, Jogador* jogador) {
	jogador->estadoNascimento = strdup(estadoNascimento);
}

void ConstrutorJogador(Split split, Jogador* jogador) {

	jogador->setId(atoi(split.array[0]), jogador);
	jogador->setNome(split.array[1], jogador);
	jogador->setAltura(atoi(split.array[2]), jogador);
	jogador->setPeso(atoi(split.array[3]), jogador);
	jogador->setUniversidade(split.array[4], jogador);
	jogador->setAnoNascimento(atoi(split.array[5]), jogador);
	jogador->setCidadeNascimento(split.array[6], jogador);
	jogador->setEstadoNascimento(split.array[7], jogador);

}

Jogador CloneJogador(Jogador jogador) {

	Jogador clone = jogador;

	clone.setNome(jogador.nome, &clone);
	clone.setUniversidade(jogador.universidade, &clone);
	clone.setCidadeNascimento(jogador.cidadeNascimento, &clone);
	clone.setEstadoNascimento(jogador.estadoNascimento, &clone);

	return clone;

}

void MostrarJogador(Jogador jogador) {

	// printf("[%d ## ", jogador.id);
	printf("%s ## ", jogador.nome);
	printf("%d ## ", jogador.altura);
	printf("%d ## ", jogador.peso);
	printf("%d ## ", jogador.anoNascimento);
	printf("%s ## ", jogador.universidade);
	printf("%s ## ", jogador.cidadeNascimento);
	printf("%s ##\n", jogador.estadoNascimento);

}

void CloseJogador(Jogador jogador) {

	free(jogador.nome);
	free(jogador.universidade);
	free(jogador.cidadeNascimento);
	free(jogador.estadoNascimento);

}

void swap(Jogador* jog1, Jogador* jog2, Log* log) {
	Jogador aux = *jog1;
	*jog1 = *jog2;
	*jog2 = aux;
	log->movimentacoes += 3;
}

Jogador newJogador() {

	Jogador jogador;

	jogador.setId = SetIdJogador;
	jogador.setAltura = SetAlturaJogador;
	jogador.setPeso = SetPesoJogador;
	jogador.setAnoNascimento = SetAnoNascimentoJogador;
	jogador.setNome = SetNomeJogador;
	jogador.setUniversidade = SetUniversidadeJogador;
	jogador.setCidadeNascimento = SetCidadeNascimentoJogador;
	jogador.setEstadoNascimento = SetEstadoNascimentoJogador;

	jogador.Construtor = ConstrutorJogador;
	jogador.Clone = CloneJogador;

	jogador.Mostrar = MostrarJogador;
	jogador.Close = CloseJogador;

	return jogador;
}

typedef struct BD {

	Jogador *array;
	int maxSize, size;

	Jogador (*Get) (int id, struct BD);
	void (*ImportDataBase) (literal filePath, struct BD*);

	void (*Inserir) (Jogador, struct BD*);

	void (*Close) (struct BD*);

} BD;

Jogador GetBD(int id, BD BD) { return BD.array[id]; }

void ImportDataBaseBD(literal filePath, BD* BD) {

	FILE* CSV;
	if (!(CSV = fopen(filePath, "r"))) {
		printf("Erro: Falha ao abrir players.csv\n");
		exit(0);
	}

	char inputCSV[STR_MAX_LEN];
	readStr(CSV, inputCSV); // Despresando o header do .csv
	
	Jogador jogador;

	while (!feof(CSV)) {

		Split array = newSplit(CSV);

		jogador = newJogador();
		jogador.Construtor(array, &jogador);

		BD->Inserir(jogador, BD);

	}

}

void InserirBD(Jogador jogador, BD* BD) {

	if (BD->size == BD->maxSize) {
		fprintf(stderr, "Erro ao inserir: Banco De Dados cheio.\n");
		return;
	}

	BD->array[BD->size++] = jogador.Clone(jogador);

}

void CloseBD(BD* BD) {
	
	for (int i = 0; i < BD->size; i++) {
		BD->array[i].Close(BD->array[i]);
	}

	free(BD->array);
	
	BD->maxSize = BD->size = 0;
}

BD newBD(size_t maxSize) {

	BD BD;

	if (maxSize == 0) maxSize = 80;

	BD.size = 0;
	BD.maxSize = maxSize;
	BD.array = (Jogador*)malloc(maxSize * sizeof(Jogador));

	BD.Get = GetBD;
	BD.ImportDataBase = ImportDataBaseBD;
	BD.Inserir = InserirBD;

	BD.Close = CloseBD;

	return BD;
}

typedef struct CelulaDupla {
	Jogador jogador;
	struct CelulaDupla *esq, *dir;
	void (*Close) (struct CelulaDupla*);
} CelulaDupla;

void CloseCelulaDupla(CelulaDupla* celula) {
	celula->jogador.Close(celula->jogador);
	free(celula);
}

CelulaDupla* newCelulaDupla(Jogador jogador, CelulaDupla* esq, CelulaDupla* dir) {
	CelulaDupla* celula = malloc(sizeof(CelulaDupla));

	celula->jogador = jogador.Clone(jogador);
	celula->esq = esq;
	celula->dir = dir;
	celula->Close = CloseCelulaDupla;

	return celula;
}

typedef struct ListaDupla {

	int size;
	CelulaDupla *primeiro, *ultimo;

	void (*Mostrar) (struct ListaDupla);
	int (*CompareTo) (CelulaDupla* jog1, CelulaDupla* jog2, Log* log);
	void (*InserirInicio) (Jogador, struct ListaDupla*);
	void (*InserirFim) (Jogador, struct ListaDupla*);
	void (*Close) (struct ListaDupla*);

} ListaDupla;

int CompareToListaDupla(CelulaDupla* cel1, CelulaDupla* pivot, Log* log) {

	log->comparacoes++;

	Jogador jog1 = cel1->jogador, pivotJog = pivot->jogador;

	int strComp = strcmp(jog1.estadoNascimento, pivotJog.estadoNascimento);

	if (strComp == 0) {
		log->comparacoes++;
		strComp = strcmp(jog1.nome, pivotJog.nome);
	}

	return strComp;
}

void InserirInicioListaDupla(Jogador jogador, ListaDupla* lista) {

	CelulaDupla* new = newCelulaDupla(jogador, NULL, NULL);
	
	if (lista->primeiro == NULL) lista->primeiro = lista->ultimo = new;

	else {
		new->dir = lista->primeiro;
		lista->primeiro = lista->primeiro->esq = new;
	}

	lista->size++;

}

void InserirFimListaDupla(Jogador jogador, ListaDupla* lista) {

	CelulaDupla* new = newCelulaDupla(jogador, NULL, NULL);
	
	if (lista->ultimo == NULL) lista->ultimo = lista->primeiro = new;

	else {
		new->esq = lista->ultimo;
		lista->ultimo = lista->ultimo->dir = new;
	}

	lista->size++;

}

void MostrarListaDupla(ListaDupla lista) {
	if (lista.size == 0) {
		errx(1, "Erro ao mostrar: Lista Dupla vazia.\n");
	}

	for (CelulaDupla* i = lista.primeiro; i != NULL; i = i->dir) {
		printf("[%d ## ", i->jogador.id);
		printf("%s ## ", i->jogador.nome);
		printf("%d ## ", i->jogador.altura);
		printf("%d ## ", i->jogador.peso);
		printf("%d ## ", i->jogador.anoNascimento);
		printf("%s ## ", i->jogador.universidade);
		printf("%s ## ", i->jogador.cidadeNascimento);
		printf("%s]\n", i->jogador.estadoNascimento);
	}

}

void CloseListaDupla(ListaDupla* lista) {
	
	CelulaDupla* i = lista->primeiro;
	while (i != NULL) {
		CelulaDupla* tmp = i;
		i = i->dir;
		tmp->Close(tmp);
	}

	lista->size = 0;
}

ListaDupla newListaDupla() {

	ListaDupla lista;

	lista.size = 0;
	lista.primeiro = lista.ultimo = NULL;

	lista.CompareTo = CompareToListaDupla;

	lista.InserirInicio = InserirInicioListaDupla;
	lista.InserirFim = InserirFimListaDupla;

	lista.Mostrar = MostrarListaDupla;
	lista.Close = CloseListaDupla;

	return lista;
}

int contador = 0;

typedef CelulaDupla Celula;

void QuickSortRec(Celula* left, Celula* right, Log* log, ListaDupla lista) {

	Celula *pivot = left, *i = left->dir, *j = right;
	while (j->dir != i && j->dir != i->esq) {
		while (i != NULL && lista.CompareTo(i, pivot, log) < 0) i = i->dir;
		while (lista.CompareTo(j, pivot, log) > 0) j = j->esq;
		if (j->dir != i) {
			swap(&i->jogador, &j->jogador, log);
			i = i->dir, j = j->esq;
		}
	}

	swap(&pivot->jogador, &j->jogador, log);

	if (j != left) QuickSortRec(left, j->esq, log, lista);
	if (j != right) QuickSortRec(j->dir, right, log, lista);
}

void QuickSort(Log* log, ListaDupla lista) {
	QuickSortRec(lista.primeiro, lista.ultimo, log, lista);
}

int main() {
	
	Timer timer = newTimer();
	Log log = newLog();

	BD BD = newBD(BD_SIZE);
	BD.ImportDataBase("/tmp/players.csv", &BD);

	ListaDupla lista = newListaDupla();

	char inputPUBIN[STR_MAX_LEN];

	while (strcmp(readStr(0, inputPUBIN), "FIM")) {
		int id = atoi(inputPUBIN);
		lista.InserirFim(BD.Get(id, BD), &lista);
	}

	timer.Start(&timer);
	QuickSort(&log, lista);
	timer.Stop(&timer);

	lista.Mostrar(lista);

	log.RegistroOrdenacao("1462558_quicksort2.txt", timer, log);

	lista.Close(&lista);
	BD.Close(&BD);

}