package leitura;

public class Teste {
	public static void main(String args[]) throws Exception {
		try 
		{
			String teste[]= new String[10];
			teste = Leitor.lerArquivo("/home/kelvin/Área de Trabalho/Projeto C/ProjetoC/Teste.txt");
			for(int cont = 0; cont < teste.length; cont++)
			System.out.println(teste[cont]);
		}
		catch(Exception erro)
		{
			System.err.println(erro.getMessage());
		}
	}	
}
