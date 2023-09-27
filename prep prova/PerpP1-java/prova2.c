#include <stdio.h>
#include <stdlib.h>
int main() {
  int quant =0;
  int resp =0;
  scanf("%i",&quant);
  int contador=quant;
  char pokemons[quant];
  for(int i =0; i<quant; i++){
    scanf("%s\n",&pokemons[i]);
    for(int j =1; j<quant; j++){
        if(pokemons[i]==pokemons[j]){
           contador--;
        }
    }
  }
  int resp2 = quant+contador;
  resp = 151-resp2;
  printf("Falta(m) %i pokemon(s)",resp);
  return 0;
}