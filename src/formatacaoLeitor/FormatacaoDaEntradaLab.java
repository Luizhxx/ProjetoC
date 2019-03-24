package formatacaoLeitor;

import java.util.List;

import leitura.Leitor;

public class FormatacaoDaEntradaLab {
	
	public static void main(String[] args) throws Exception {
		String teste[] = new String[10];
		String caminho = "/home/kelvin/Área de Trabalho/Projeto C/ProjetoC/Teste.txt";
		teste = Leitor.lerArquivo(caminho);
		System.out.println(teste[0]);
	}
}
