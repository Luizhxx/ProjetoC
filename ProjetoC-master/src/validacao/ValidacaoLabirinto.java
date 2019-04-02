package validacao;

import com.sun.media.sound.InvalidFormatException;

public class ValidacaoLabirinto {

	public static void validacaoLabirinto(String[] labirinto) throws Exception {
		temElementoNulo(labirinto);
		qtdLinhasValidas(labirinto);
		todosElementosValidos(labirinto);
		theFirstLineIsInt(labirinto[0]);	
		temEntradaValida(labirinto);
		temSaida(labirinto);
	}
	
	public static void theFirstLineIsInt(String firstLine) throws InvalidFormatException {
		if (!(Integer.parseInt(firstLine) > 0 && Integer.parseInt(firstLine) < 100000000)) {
			throw new InvalidFormatException("Arquivo Invalido");
		}
	}
	
	private static void temElementoNulo(String[] labirinto) throws InvalidFormatException {
		for(int i = 0; i < labirinto.length; i++) {
			if (labirinto[i] == null) {
				throw new InvalidFormatException("O aquivo possui elemento(s) nulo(s)!");
			}
		}
	}
	
	private static void temEntradaValida(String[] labirinto) throws InvalidFormatException {
		int entrada = 0;
		for (int i = 0; i < labirinto.length; i++) {
			String linha = labirinto[i];
				for (int j = 0; j < linha.length(); j++) {
					if (linha.charAt(j) == 'E') {
						entrada++;
					}
				continue;
			}
		}		
		if (entrada == 0) {
			throw new InvalidFormatException("O labirinto n„o possui entrada!");
		}
		
		if (entrada > 1) {
			throw new InvalidFormatException("O labirinto possui mais de uma entrada!");
		}
	}
	
	private static void temSaida(String[] labirinto) throws InvalidFormatException {
		int saida = 0;
		for (int i = 1; i < labirinto.length; i++) {
			String linha = labirinto[i];
			for (int j = 0; j < linha.length(); j++) {
				if (linha.charAt(j) == 'S') {
					saida++;
				}
			}
		}
		
		if (saida == 0) {
			throw new InvalidFormatException("O labirinto n„o possui saida!");
		}
		
		if (saida > 1) {
			throw new InvalidFormatException("O labirinto possui mais de uma saida!");
		}
	}
	
	private static void qtdLinhasValidas(String[] labirinto) {
		int qtdLinhas = Integer.parseInt(labirinto[0]);
		if (labirinto.length - 2 > qtdLinhas) {
			throw new IllegalArgumentException("Quantidade de linhas inv√°lidas!");
		}
	}
	
	private static void todosElementosValidos(String[] labirinto) throws InvalidFormatException {
		for (int i = 1; i < labirinto.length; i++) {
			String linha = labirinto[i];
			for (int j = 0; j < linha.length(); j++) {
				if (!(linha.charAt(j) == 'S' || linha.charAt(j) == 'E' || linha.charAt(j) == '#' || linha.charAt(j) == ' ')) {
					throw new InvalidFormatException("O labirinto possui elementos inv√°lidos!");
				}
			}
		}
	}
}