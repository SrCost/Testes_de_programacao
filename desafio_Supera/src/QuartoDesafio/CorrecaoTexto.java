package QuartoDesafio;

/* A sua impressora foi infectada por um v�rus e est� imprimindo de forma incorreta. Depois
	de olhar para v�rias p�ginas impressas por um tempo, voc� percebe que ele est�
	imprimindo cada linha de dentro para fora. Em outras palavras, a metade esquerda de cada
	linha est� sendo impressa a partir do meio da p�gina at� a margem esquerda. Do mesmo
	modo, a metade direita de cada linha est� sendo impressa � partir da margem direita e
	prosseguindo em dire��o ao centro da p�gina.
	
	Por exemplo a linha:
	THIS LINE IS GIBBERISH
	est� sendo impressa como:
	I ENIL SIHTHSIREBBIG S
	
	Da mesma forma, a linha " MANGOS " est� sendo impressa incorretamente como
	"NAM SOG". Sua tarefa � desembaralhar (decifrar) a string a partir da forma como ela foi
	impressa para a sua forma original. Voc� pode assumir que cada linha conter� um n�mero
	par de caracteres.
	Entrada
	A entrada cont�m v�rios casos de teste. A primeira linha de entrada cont�m um
	inteiro N que indica a quantidade de casos de teste. Seguem N linhas, cada uma com uma
	frase com no m�nimo 2 e no m�ximo 100 caracteres de letras mai�sculas e espa�os que
	dever� ser desembaralhada (decifrada) � partir da forma impressa para a sua forma
	original, conforme especifica��o acima.
	Sa�da
	Para cada linha de entrada dever� ser impressa uma linha de sa�da com a frase decifrada,
	conforme a especifica��o acima.
	 * 
	 * Exemplo de Entrada
	
	I ENIL SIHTHSIREBBIG S
	LEVELKAYAK
	H YPPAHSYADILO
	ABCDEFGHIJKLMNOPQRSTUVWXYZ
	VOD OWT SNEH HCNERF EGDIRTRAP A DNA SE
	
	 Exemplo de Sa�da
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
