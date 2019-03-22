package leitura;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import org.omg.CORBA.OBJECT_NOT_EXIST;

public class Leitor {
	
	public static void main(String[] args) {
		leitorDeArquivos();
	}
	
	public static void formatacaoDoLeitor() {
		String labFormatado = leitorDeArquivos();
		int comecoLinha = 0;
		for (int i = 0; i < labFormatado.length(); i++) {
			
			
		}
	}
	
	private static String leitorDeArquivos() {
		String linha = null;
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
		} catch (IOException | IllegalArgumentException | OBJECT_NOT_EXIST e) {
			System.err.println("Erro ao ler o arquivo, verifique se o mesmo é válido");
		}
		return linha;
	}
	
}