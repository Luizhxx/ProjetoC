package validacao;

import java.util.List;

import org.omg.CORBA.OBJECT_NOT_EXIST;

public class ValidacaoLabirinto {

	public static void validacaoEntradaLabirinto(List<String> labirintoEntrada) {
		int quantidadeLinhas;
		int temEntrada = 0;
		int temSaida = 0;
		
		for(String string : labirintoEntrada) {
			if (string.equals(labirintoEntrada.get(0))) {
				theFirstLineIsInt(string);
				quantidadeLinhas = Integer.parseInt(string);
				if ((labirintoEntrada.size() -1) > quantidadeLinhas) {
					throw new NumberFormatException("A quantidade linhas é maior quea definida no arquivo de entrada");
				}
				continue;
			}
			if (string.equals(labirintoEntrada.get(1)) || string.equals(labirintoEntrada.get(labirintoEntrada.size() - 1))) {
				temEntrada += possuiEntradaNa1Linha(string);
				temSaida += possuiSaidaNa1Linha(string);
			}			
		}
	}
	
	private static void theFirstLineIsInt(String primeiraLinha) {
		if ((Integer.parseInt(primeiraLinha) > 0 || Integer.parseInt(primeiraLinha) < 100000000)) {
			throw new OBJECT_NOT_EXIST("A primeira linha do arquivo de entrada não é um número válido");
		}
	}
	
	public static int possuiEntradaNa1Linha(String linha) {
		int qtdEntradas = 0;
		for (int i = 0; i < linha.length(); i++) {
			if (linha.charAt(i) == 'E' || linha.charAt(i) == 'e') {
				qtdEntradas++;
			}
		}
		return qtdEntradas;
	}
	
	public static int possuiSaidaNa1Linha(String linha) {
		int qtdSaida = 0;
		for (int i = 0; i < linha.length(); i++) {
			if (linha.charAt(i) == 'S' || linha.charAt(i) == 's') {
				qtdSaida++;
			}
		}
		return qtdSaida;
	}
}
