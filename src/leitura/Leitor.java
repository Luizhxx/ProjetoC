package leitura;

import java.io.BufferedReader;
import java.io.FileReader;

import validacao.ValidacaoLabirinto;

public class Leitor {

	@SuppressWarnings("resource")
	public static String[] lerArquivo(String caminho) throws Exception {
		BufferedReader leitor = null;
		String tamanho = null;
		String linhas[] = null;
		int cont = 0;

		leitor = new BufferedReader(new FileReader(caminho));
		tamanho = leitor.readLine();
		linhas = new String[Integer.parseInt(tamanho) + 1];
		linhas[cont] = tamanho;
		cont++;

		while (leitor.ready()) {
			if (linhas.length == Integer.parseInt(tamanho) + 1) {
				throw new IndexOutOfBoundsException("a quantidade de linhas não está de acordo com a quantidade de linhas definida");
			}
			linhas[cont] = leitor.readLine();
			cont++;
		}

		ValidacaoLabirinto.validacaoLabirinto(linhas);
		leitor.close();
		return linhas;
	}
}