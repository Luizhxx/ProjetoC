package formatacaoLeitor;

import java.util.ArrayList;
import java.util.List;

public class FormatacaoDaEntradaLab {
	
	public static void main(String[] args) {
		labirinto();
	}

	private static void labirinto() {
		int limiteSubString = 0;
		List<String> labirinto = new ArrayList<String>();
		String labirintoEntrada = leitura.Leitor.leitorDeArquivos();
		System.out.println(labirintoEntrada);
		for (int i = 0; i < labirintoEntrada.length(); i++) {
			if (labirintoEntrada.charAt(i) == ' ') {
				labirinto.add(labirintoEntrada.substring(limiteSubString, i - 1));
				limiteSubString += i + 1;
			}
			
		}
		for (String linha : labirinto) {
			System.out.println(linha);
		}
	}
}
