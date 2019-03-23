package leitura;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Leitor {

	
	@SuppressWarnings("resource")
	public static String leitorDeArquivos() {
		String linha = "";
		try {
			FileInputStream arquivo = new FileInputStream("teste1.txt");
			InputStreamReader input = new InputStreamReader(arquivo);
			BufferedReader br = new BufferedReader(input);
			do {
				linha = br.readLine();
				if (linha != null) {
					System.out.println(linha);
				}
				
			} while (linha != null);
		} catch (IOException e) {
			System.err.println("Erro ao ler o arquivo");
		}
		System.out.println(linha);
		return linha;
	}
	
}