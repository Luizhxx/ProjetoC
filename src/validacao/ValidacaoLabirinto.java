package validacao;

import com.sun.media.sound.InvalidFormatException;

public class ValidacaoLabirinto {

	public static void validacaoLabirinto(String[] labirinto) throws Exception {
		
		theFirstLineIsInt(labirinto[0]);	
		temEntrada(labirinto);
		temSaida(labirinto);
		todosElementosValidos(labirinto);
	}
	
	public static void theFirstLineIsInt(String firstLine) throws InvalidFormatException {
		if (!(Integer.parseInt(firstLine) > 0 && Integer.parseInt(firstLine) < 10000000)) {
			throw new InvalidFormatException("Arquivo Invalido");
		}
	}
	
	private static void temEntrada(String[] labirinto) throws InvalidFormatException {
		int entrada = 0;
		for (int i = 1; i < labirinto.length; i++) {
			String linha = labirinto[i];
			if (i == 1 || i == labirinto.length - 1) {
				for (int j = 0; j < linha.length(); j++) {
					if (linha.charAt(j) == 'E') {
						entrada++;
					}
				}
				continue;
			}
			if (linha.charAt(0) == 'E' || linha.charAt(linha.length() - 1) == 'E') {
				entrada++;
			}
		}
		
		if (entrada == 0) {
			throw new InvalidFormatException("O labirinto não possui entrada!");
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
			throw new InvalidFormatException("O labirinto não possui saida!");
		}
		
		if (saida > 1) {
			throw new InvalidFormatException("O labirinto possui mais de uma entrada!");
		}
	}
	
	private static void todosElementosValidos(String[] labirinto) throws InvalidFormatException {
		for (int i = 1; i < labirinto.length; i++) {
			String linha = labirinto[i];
			for (int j = 0; j < linha.length(); j++) {
				if (!(linha.charAt(j) == 'S' || linha.charAt(j) == 'E' || linha.charAt(j) == '#' || linha.charAt(j) == ' ')) {
					throw new InvalidFormatException("O labirinto possui elementos inválidos!");
				}
			}
		}
	}
}