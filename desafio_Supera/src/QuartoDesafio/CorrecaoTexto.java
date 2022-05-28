package QuartoDesafio;

/* A sua impressora foi infectada por um vírus e está imprimindo de forma incorreta. Depois
	de olhar para várias páginas impressas por um tempo, você percebe que ele está
	imprimindo cada linha de dentro para fora. Em outras palavras, a metade esquerda de cada
	linha está sendo impressa a partir do meio da página até a margem esquerda. Do mesmo
	modo, a metade direita de cada linha está sendo impressa à partir da margem direita e
	prosseguindo em direção ao centro da página.
	
	Por exemplo a linha:
	THIS LINE IS GIBBERISH
	está sendo impressa como:
	I ENIL SIHTHSIREBBIG S
	
	Da mesma forma, a linha " MANGOS " está sendo impressa incorretamente como
	"NAM SOG". Sua tarefa é desembaralhar (decifrar) a string a partir da forma como ela foi
	impressa para a sua forma original. Você pode assumir que cada linha conterá um número
	par de caracteres.
	Entrada
	A entrada contém vários casos de teste. A primeira linha de entrada contém um
	inteiro N que indica a quantidade de casos de teste. Seguem N linhas, cada uma com uma
	frase com no mínimo 2 e no máximo 100 caracteres de letras maiúsculas e espaços que
	deverá ser desembaralhada (decifrada) à partir da forma impressa para a sua forma
	original, conforme especificação acima.
	Saída
	Para cada linha de entrada deverá ser impressa uma linha de saída com a frase decifrada,
	conforme a especificação acima.
	 * 
	 * Exemplo de Entrada
	
	I ENIL SIHTHSIREBBIG S
	LEVELKAYAK
	H YPPAHSYADILO
	ABCDEFGHIJKLMNOPQRSTUVWXYZ
	VOD OWT SNEH HCNERF EGDIRTRAP A DNA SE
	
	 Exemplo de Saída
	THIS LINE IS GIBBERISH
	LEVELKAYAK
	HAPPY HOLIDAYS
	MLKJIHGFEDCBAZYXWVUTSRQPON
	FRENCH HENS TWO DOVES AND A PARTRIDGE
	 */


public class CorrecaoTexto {

	public static String txt1 = "I ENIL SIHTHSIREBBIG S";
	public static String txt2 = "LEVELKAYAK";
	public static String txt3 = "H YPPAHSYADILO";
	public static String txt4 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	public static String txt5 = "VOD OWT SNEH HCNERF EGDIRTRAP A DNA SE";

	public static void main(String[] args) {

		divideLinha(txt1);
		divideLinha(txt2);
		divideLinha(txt3);
		divideLinha(txt4);
		divideLinha(txt5);
		
	}

	public static void divideLinha(String txt) {
		int tam = txt.length() / 2;
		String ini = txt.substring(0, tam);
		String iniInv = new StringBuffer(ini).reverse().toString();

		String fim = txt.substring(tam);
		String fimInv = new StringBuffer(fim).reverse().toString();

		System.out.println(iniInv + fimInv);

	}
}
