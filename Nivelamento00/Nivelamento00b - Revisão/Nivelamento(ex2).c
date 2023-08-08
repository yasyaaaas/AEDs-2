#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

bool segundo(int arr[], int x, int tam)
{
  // metodo da busca binária
  
  int esquerda=0; // posição início
  int direita=tam-1; // posição final
  while(esquerda<=direita)
    {
      int meio=(esquerda+direita)/2;
      if (arr[meio] == x) 
      {
         return true;
      } 
      else if (arr[meio] < x) 
      {
        esquerda = meio + 1;
      } 
      else 
      {
         direita = meio - 1;
      }
    }
  return false;
}
int main() 
{
  int arr[]={1,2,3,4,5};
  int x=4;
  int tam= sizeof(arr)/sizeof(arr[0]);
  segundo(arr,x,tam);
  if(segundo(arr,x,tam))
  {
    printf("\nO número esta contido no array");
  }
  else
  {
    printf("\nO número não esta contido no array");
  }
  return 0;
}