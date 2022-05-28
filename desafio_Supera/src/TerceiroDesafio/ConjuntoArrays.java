package TerceiroDesafio;

import java.util.Scanner;

/*
 * 	Dado um array de inteiros e um valor alvo, determine o número de pares entre os elementos
	do array em que a sua diferença seja igual ao valor alvo.
	
	Exemplo
	K = 1
	arr = [1,2,3,4]
	Existem 3 valores cuja diferença é igual ao valor alvo K: 2-1 = 1, 3-2 = 1, 4-3 = 1.
	
	Descrição do problema:
	Os pares têm os seguintes parâmetros:
	int k: Um Inteiro, valor alvo.
	int arr[n]: Um array de Inteiros.
	
	Retorno
	int: O número de pares que satisfazem o critério.
	
	Formatos de Entrada
	Seu código deve conter duas entradas n e k, que representam o tamanho do array e o valor
	alvo.
	Seu código deve conter um array de inteiros, de tamanho n.
	
	Exemplos de entrada
	
	STDIN Function
	----- --------
	5 2 arr[] tamanho n = 5, k =2
	1 5 3 4 2 arr = [1, 5, 3, 4, 2]
	
	Exemplo de saida
	3
 */

public class ConjuntoArrays {

	static int numerosPares(int arr[], int n, int k) {
		int contador = 0;

		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++)
				if (arr[i] - arr[j] == k || arr[j] - arr[i] == k)
					contador++;
		}
		return contador;
	}

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		System.out.println("Digite um numero: ");
		int num = entrada.nextInt();
		System.out.println("Qual o tamanho deste vetor?");
		int vetor = entrada.nextInt();

		int[] sequencia = new int[vetor];

		System.out.println("Digite uma sequencia de numeros: ");

		for (int i = 0; i < vetor; i++) {
			sequencia[i] = entrada.nextInt();
		}

		System.out.println("Total de pares " + numerosPares(sequencia, vetor, num));

	}

}
