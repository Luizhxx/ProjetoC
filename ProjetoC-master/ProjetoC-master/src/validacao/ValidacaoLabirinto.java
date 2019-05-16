package validacao;

import com.sun.media.sound.InvalidFormatException;

public class ValidacaoLabirinto {

	public static void validacaoLabirinto(String[] labirinto) throws Exception {
		temElementoNulo(labirinto);
		qtdLinhasValidas(labirinto);
		lineValidation(labirinto);
		todosElementosValidos(labirinto);
		theFirstLineIsInt(labirinto[0]);
		temEntradaValida(labirinto);
		temSaida(labirinto);
		entryPositionValidation(labirinto);
		exitPositionValidation(labirinto);
	}

	public static void lineValidation(String[] linhas) throws InvalidFormatException {
		String linha = linhas[1];
		int tamanhoPrimeiraLinha = linha.length() - 1;
		for (int i = 2; i < linhas.length; i++) {
			String linhaTeste = linhas[i];
			int tamanhoLinha = linhaTeste.length() - 1;
			if (tamanhoLinha != tamanhoPrimeiraLinha) {
				throw new InvalidFormatException("Arquivo possui tamanhos de linhas diferentes!");
			}
		}
	}

	public static void entryPositionValidation(String[] labirinto) throws InvalidFormatException {
		for (int i = 1; i < labirinto.length; i++) {
			String linha = labirinto[i];
			for (int j = 0; j < linha.length(); j++) {
				String linhaAnterior;
				String linhaPosterior;
				if (linha.charAt(j) == 'E') {
					if((i > 1 && i < labirinto.length - 1) && ((j > 0) && (j < linha.length()))) {
						linhaAnterior = labirinto[i - 1];
						linhaPosterior = labirinto[i + 1];
						if((linhaAnterior.charAt(j) == '#') && (linha.charAt(j + 1) == '#') && ((linha.charAt(j - 1) == '#')
								&& (linhaPosterior.charAt(j) == '#')))
							throw new InvalidFormatException("Entrada bloqueada!");
					}						
					
					if(i == 1 && (j > 0) && (j < linha.length())) {
						linhaPosterior = labirinto[i + 1];
						if((linha.charAt(j + 1) == '#') && (linha.charAt(j - 1) == '#')
								&& (linhaPosterior.charAt(j) == '#'))
							throw new InvalidFormatException("Entrada bloqueada!");
					}
					if((i == labirinto.length - 1) && (j > 0) && (j < linha.length())) {
						linhaAnterior = labirinto[i - 1];
						if((linhaAnterior.charAt(j) == '#') && ((linha.charAt(j + 1) == '#') || linha.charAt(j - 1) == '#'))
							throw new InvalidFormatException("Entrada bloqueada!");
					}
			
					if(j == 0 && i == 1) {
						linhaPosterior = labirinto[i + 1];
						if( linha.charAt(j + 1) == '#' && linhaPosterior.charAt(j) == '#')
							throw new InvalidFormatException("Entrada bloqueada!");
					}
					if(j == 0 && i == labirinto.length - 1) {
						linhaPosterior = labirinto[i + 1];
						if( linha.charAt(j + 1) == '#' && linhaPosterior.charAt(j) == '#')
							throw new InvalidFormatException("Entrada bloqueada!");
					}
					if(j == linha.length() && i == 1) {
						linhaAnterior = labirinto[i - 1];
						if( linha.charAt(j - 1) == '#' && linhaAnterior.charAt(j) == '#')
							throw new InvalidFormatException("Entrada bloqueada!");
					}
					if(j == linha.length() && i == labirinto.length - 1) {
						linhaAnterior = labirinto[i - 1];
						if( linha.charAt(j - 1) == '#' && linhaAnterior.charAt(j) == '#') {
							throw new InvalidFormatException("Entrada bloqueado!");
						}
					}	
				}
			}
		}
	}
	
	public static void exitPositionValidation(String[] labirinto) throws InvalidFormatException {
		for (int i = 1; i < labirinto.length; i++) {
			String linha = labirinto[i];
			for (int j = 0; j < linha.length(); j++) {
				String linhaAnterior;
				String linhaPosterior;
				if (linha.charAt(j) == 'S') {
					if((i > 1 && i < labirinto.length - 1) && ((j > 0) && (j < linha.length()))) {
						System.out.println(i);
						System.out.println(j);
						linhaAnterior = labirinto[i - 1];
						linhaPosterior = labirinto[i + 1];
						if((linhaAnterior.charAt(j) == '#') && (linha.charAt(j + 1) == '#') && ((linha.charAt(j - 1) == '#')
								&& (linhaPosterior.charAt(j) == '#')))
							throw new InvalidFormatException("Entrada bloqueada!");
					}						
					
					if(i == 1 && (j > 0) && (j < linha.length())) {
						linhaPosterior = labirinto[i + 1];
						if((linha.charAt(j + 1) == '#') && (linha.charAt(j - 1) == '#')
								&& (linhaPosterior.charAt(j) == '#'))
							throw new InvalidFormatException("Entrada bloqueada!");
					}
					if((i == labirinto.length - 1) && (j > 0) && (j < linha.length())) {
						linhaAnterior = labirinto[i - 1];
						if((linhaAnterior.charAt(j) == '#') && ((linha.charAt(j + 1) == '#') || linha.charAt(j - 1) == '#'))
							throw new InvalidFormatException("Entrada bloqueada!");
					}
			
					if(j == 0 && i == 1) {
						linhaPosterior = labirinto[i + 1];
						System.out.println("Entrou no 4 if");
						if( linha.charAt(j + 1) == '#' && linhaPosterior.charAt(j) == '#')
							throw new InvalidFormatException("Entrada bloqueada!");
					}
					if(j == 0 && i == labirinto.length - 1) {
						System.out.println("Entrou no 5 if");
						linhaPosterior = labirinto[i + 1];
						if( linha.charAt(j + 1) == '#' && linhaPosterior.charAt(j) == '#')
							throw new InvalidFormatException("Entrada bloqueada!");
					}
					if(j == linha.length() && i == 1) {
						linhaAnterior = labirinto[i - 1];
						if( linha.charAt(j - 1) == '#' && linhaAnterior.charAt(j) == '#')
							throw new InvalidFormatException("Entrada bloqueada!");
					}
					if(j == linha.length() && i == labirinto.length - 1) {
						linhaAnterior = labirinto[i - 1];
						if( linha.charAt(j - 1) == '#' && linhaAnterior.charAt(j) == '#') {
							throw new InvalidFormatException("Entrada bloqueado!");
						}
					}	
				}
			}
		}
	}

	public static void theFirstLineIsInt(String firstLine) throws InvalidFormatException {
		if (!(Integer.parseInt(firstLine) > 0 && Integer.parseInt(firstLine) < 10000000)) {
			throw new InvalidFormatException("Arquivo Invalido");
		}
	}

	private static void temElementoNulo(String[] labirinto) throws InvalidFormatException {
		for (int i = 0; i < labirinto.length; i++) {
			if (labirinto[i] == null) {
				throw new InvalidFormatException("O aquivo possui elemento(s) nulo(s)!");
			}
		}
	}

	private static void temEntradaValida(String[] labirinto) throws InvalidFormatException {
		int entrada = 0;
		for (int i = 1; i < labirinto.length; i++) {
			String linha = labirinto[i];
			if (i == 1 || i == labirinto.length - 1) {
				for (int j = 0; j < linha.length(); j++) {
					if (linha.charAt(j) == 'E') {
						entrada++;
						break;
					}
				}
				continue;
			}
			if (linha.charAt(0) == 'E' || linha.charAt(linha.length() - 1) == 'E') {
				entrada++;
			}
		}
		System.out.println(entrada);
		if (entrada == 0) {
			throw new InvalidFormatException("O labirinto não possui entrada!");
		}

		if (entrada > 1) {
			throw new InvalidFormatException("O labirinto possui mais de uma entrada!");
		}
		temEntradaInterna(labirinto, entrada);
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
			throw new InvalidFormatException("O labirinto possui mais de uma saida!");
		}
	}

	private static void temEntradaInterna(String[] labirinto, int entrada) throws InvalidFormatException {

		for (int i = 2; i < labirinto.length - 1; i++) {
			String linha = labirinto[i];
			for (int j = 1; j < linha.length() - 1; j++) {
				if (linha.charAt(j) == 'E') {
					entrada++;
				}
			}
		}
		if (entrada > 1) {
			throw new InvalidFormatException("O labirinto possui mais de uma entrada!");
		}
	}

	private static void qtdLinhasValidas(String[] labirinto) {
		int qtdLinhas = Integer.parseInt(labirinto[0]);
		if (labirinto.length - 2 > qtdLinhas) {
			throw new IllegalArgumentException("Quantidade de linhas inválidas!");
		}
	}

	private static void todosElementosValidos(String[] labirinto) throws InvalidFormatException {
		for (int i = 1; i < labirinto.length; i++) {
			String linha = labirinto[i];
			for (int j = 0; j < linha.length(); j++) {
				if (!(linha.charAt(j) == 'S' || linha.charAt(j) == 'E' || linha.charAt(j) == '#'
						|| linha.charAt(j) == ' ')) {
					throw new InvalidFormatException("O labirinto possui elementos inválidos!");
				}
			}
		}
	}
}