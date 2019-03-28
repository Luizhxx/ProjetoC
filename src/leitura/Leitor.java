package leitura;

import java.io.BufferedReader;
import java.io.FileReader;

import validacao.ValidacaoLabirinto;

public class Leitor {

	@SuppressWarnings("resource")
	public static String[] lerArquivo(String caminho) throws Exception {
		
		BufferedReader leitor = new BufferedReader(new FileReader(caminho));
		int cont = 0;

		String tamanho = leitor.readLine();
		String[] linhas = new String[Integer.parseInt(tamanho) + 1];
		linhas[cont] = tamanho;
		cont++;

		while (leitor.ready()) {
			if (linhas.length > Integer.parseInt(tamanho) + 1) {
				throw new IndexOutOfBoundsException("a quantidade de linhas n�o est� de acordo com a quantidade de linhas definida");
			}
			linhas[cont] = leitor.readLine();
			cont++;
		}

		ValidacaoLabirinto.validacaoLabirinto(linhas);
		leitor.close();
		return linhas;
	}
}