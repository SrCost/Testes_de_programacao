package SegundoDesafio;

import java.text.DecimalFormat;
import java.util.Scanner;

public class DecomposiçãoValorEmDinheiro {

	/*
	 * Leia um valor de ponto flutuante com duas casas decimais. Este valor representa um valor
	monetário. A seguir, calcule o menor número de notas e moedas possíveis no qual o valor
	pode ser decomposto. As notas consideradas são de 100, 50, 20, 10, 5, 2. As moedas
	possíveis são de 1, 0.50, 0.25, 0.10, 0.05 e 0.01. A seguir mostre a relação de notas
	necessárias.
	Entrada
	O arquivo de entrada contém um valor de ponto flutuante N (0 ≤ N ≤ 1000000.00).
	Saída
	Imprima a quantidade mínima de notas e moedas necessárias para trocar o valor inicial,
	conforme exemplo fornecido.
	 */
	
	public static void main(String[] args) {

		Scanner ler = new Scanner(System.in);

		double valor;

		System.out.printf("Informe um valor a ser convertido em notas: ");
		valor = ler.nextDouble();

		System.out.printf("%s", calcularNotas(valor));

	}

	public static String calcularNotas(double valor) {
		DecimalFormat formatador = new DecimalFormat("###,##0.00");

		int nota[] = { 100, 50, 20, 10, 5, 2, 1 };
		int centavos[] = { 50, 25, 10, 5, 1 };

		String resul;
		int i, vlr, ct;

		resul = "\nValor = R$" + formatador.format(valor) + "\n\n";

		vlr = (int) valor;
		i = 0;
		while (vlr != 0) {
			ct = vlr / nota[i];
			if (ct != 0) {
				resul = resul + (ct + " nota(s) de R$ " + nota[i] + "\n");
				vlr = vlr % nota[i];
			}
			i = i + 1;
		}

		resul = resul + "\n";

		vlr = (int) Math.round((valor - (int) valor) * 100);
		i = 0;
		while (vlr != 0) {
			ct = vlr / centavos[i];
			if (ct != 0) {
				resul = resul + (ct + " moeda(s) de " + centavos[i] + " centavo(s)\n");
				vlr = vlr % centavos[i];
			}
			i = i + 1;
		}
		return (resul);

	}

}
