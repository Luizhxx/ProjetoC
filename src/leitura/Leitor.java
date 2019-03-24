package leitura;
import java.io.BufferedReader;
import java.io.FileReader;

import validacao.ValidacaoLabirinto;

public class Leitor 
{

	public static String[] lerArquivo(String caminho) throws Exception
	{
		BufferedReader leitor = null;
		String tamanho = null;
		String linhas[] = null;
		int cont = 0;
		
		try
		{
			leitor = new BufferedReader(new FileReader(caminho));
			tamanho = leitor.readLine();
			linhas = new String[Integer.parseInt(tamanho)+1];
			linhas[cont] = tamanho;
			cont++;
		}
		catch(Exception erro)
		{
			System.err.println("Arquivo invalido: Vazio / Em branco / Outro");
		}
		
		while(leitor.ready())
		{ 
			linhas[cont] = leitor.readLine();  
			cont++;
		}
		
		leitor.close();
		ValidacaoLabirinto.validacaoLabirinto(linhas);
		return linhas;
	}
}