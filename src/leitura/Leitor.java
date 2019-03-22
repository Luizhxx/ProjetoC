package leitura;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.omg.CORBA.OBJECT_NOT_EXIST;

import validacao.ValidacaoLabirinto;

public class Leitor {
	
	public static void main(String[] args) {
		leitorDeArquivos();
	}
	
	@SuppressWarnings("resource")
	public static List<String> leitorDeArquivos() {
		List<String> labirinto = new ArrayList<String>();
		try {
			FileInputStream arquivo = new FileInputStream("teste1.txt");
			InputStreamReader input = new InputStreamReader(arquivo);
			BufferedReader br = new BufferedReader(input);
			String linha;
			do {
				linha = br.readLine();
				if (linha != null) {
					System.out.println(linha);
					labirinto.add(linha);
				}
			ValidacaoLabirinto.validacaoEntradaLabirinto(labirinto );
			} while (linha != null);
		} catch (IOException | IllegalArgumentException | OBJECT_NOT_EXIST e) {
			System.err.println("Erro ao ler o arquivo, verifique se o mesmo é válido");
		}
		return labirinto;
	}
}