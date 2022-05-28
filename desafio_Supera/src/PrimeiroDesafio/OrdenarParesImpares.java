package PrimeiroDesafio;

import java.util.Arrays;
import java.util.Scanner;

/*
 * Considerando a entrada de valores inteiros não negativos, ordene estes valores segundo
	o seguinte critério:
	• Primeiro os Pares
	• Depois os Ímpares
	Sendo que deverão ser apresentados os pares em ordem crescente e depois os ímpares
	em ordem decrescente.
	Entrada
	A primeira linha de entrada contém um único inteiro positivo N (1 < N <= 105) Este é o
	número de linhas de entrada que vem logo a seguir. As próximas N linhas conterão, cada
	uma delas, um valor inteiro não negativo.
	Saída
	Apresente todos os valores lidos na entrada segundo a ordem apresentada acima. Cada
	número deve ser impresso em uma linha, conforme exemplo abaixo.
 */


public class OrdenarParesImpares {

	public static void main(String[] args) {

		Scanner ler = new Scanner(System.in);
		System.out.println("Informe a quantidade total de numeros a serem digitados: ");
		int totNum = ler.nextInt();

		int[] cadNum = new int[totNum];

		
		System.out.println("Digite os numeros: ");

		for (int i = 0; i < totNum; i++) {
			cadNum[i] = ler.nextInt();
		}
		
		
		System.out.println(Arrays.toString(cadNum));

		int m = 0, n = 0;
		for (int i = 0; i < totNum; i++) {
			if (cadNum[i] % 2 == 0) {
				m++;
			} else {
				n++;
			}
		}

		int[] par = new int[m];
		int[] impar = new int[n];

		int j = 0, k = 0;

		for (int i = 0; i < totNum; i++) {
			if (cadNum[i] % 2 == 0) {
				par[j] = cadNum[i];
				j++;
			} else {
				impar[k] = cadNum[i];
				k++;
			}
		}

		for (int i = 0; i < par.length; i++) {
			for (int p = i + 1; p < par.length; p++) {
				if (par[i] > par[p]) {
					int tempPar = par[i];
					par[i] = par[p];
					par[p] = tempPar;
				}
			}
		}

		for (int i = 0; i < impar.length; i++) {
			for (int q = i + 1; q < impar.length; q++) {
				if (impar[i] < impar[q]) {
					int tempImp = impar[i];
					impar[i] = impar[q];
					impar[q] = tempImp;
				}
			}
		}

		for (int i = 0; i < par.length; i++) {
			System.out.println(par[i] + " ");
		}

		for (int i = 0; i < impar.length; i++) {
			System.out.println(impar[i] + " ");
		}

	}

}
