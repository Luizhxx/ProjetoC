package leitura;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Leitor {
	
	public static void main(String[] args) {
		leitorDeArquivos();
	}
	
	@SuppressWarnings("resource")
	public static void leitorDeArquivos() {
		try {
			FileInputStream arquivo = new FileInputStream("teste1.txt");
			InputStreamReader input = new InputStreamReader(arquivo);
			BufferedReader br = new BufferedReader(input);
			String linha;
			do {
				linha = br.readLine();
				if (linha != null) {
					System.out.println(linha);
				}
			} while (linha != null);
		} catch (IOException e) {
			e.getStackTrace();
			e.getMessage();
			System.out.println("Erro ao ler o arquivo");
		}
	}
}