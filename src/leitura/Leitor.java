package leitura;
import java.io.BufferedReader;
import java.io.FileReader;

public class Leitor 
{
	@SuppressWarnings("resource")
	public static String[] lerArquivo(String caminho) throws Exception
	{
		try 
		{
			BufferedReader leitor = new BufferedReader(new FileReader(caminho)); 
			int tamanho = Integer.parseInt(leitor.readLine());
			String linhas[] = new String[tamanho+1];
			linhas[0] = Integer.toString(tamanho);
			int cont = 1;
			
			while(leitor.ready())
			{ 
				linhas[cont] = leitor.readLine();  
				cont++;
			}
			leitor.close();
			return linhas;
		} 
		catch(Exception erro)
		{
			throw new Exception ("Arquivo Invalido");
		}
	}
}