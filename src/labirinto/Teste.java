package labirinto;

import leitura.Leitor;

public class Teste {
	public static void main(String args[]) throws Exception {
		String[] teste = Leitor.lerArquivo("Teste.txt");
		Labirinto analise = new Labirinto(teste);
		analise.imprimir();
		analise.encontrarCaminho();
		System.out.println("");
		analise.imprimir();
	}
}
