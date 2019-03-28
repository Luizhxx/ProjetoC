package interfacegrafica;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import leitura.Leitor;

public class MenuLabirintos {
	
	public static void MenuLabs() {
		BufferedReader entradaUsuario= new BufferedReader(new InputStreamReader(System.in));
		String escolha = new String();
		String caminho = new String();
		String[] labirinto = new String[100];
		do {
			try {
				System.out.println("\t+------------------------------------------------+");
				System.out.println("\t|                   LABIRINTOS                   |");
				System.out.println("\t+------------------------------------------------+\n");
				System.out.println("\t+------------------------------------------------+");
				System.out.println("\t| 1 - Configurar o path do arquivo do labirinto  |");;
				System.out.println("\t|                                                |");
				System.out.println("\t| 2 - Para iniciar a fuga do labirinto           |");
				System.out.println("\t|                                                |");
				System.out.println("\t| 3 - Para voltar ao menu                        |");
				System.out.println("\t+------------------------------------------------+");

				escolha = entradaUsuario.readLine();
				
				switch (escolha) {
				case "1":
					System.out.println("Digite o caminho do arquivo labirinto");
					caminho = entradaUsuario.readLine(); 
					labirinto = Leitor.lerArquivo(caminho);
					
					break; 
				case "2":
					if (labirinto.equals(null)) {
						labirinto = Leitor.lerArquivo(caminho);
					}
					
					break;
				case "3":
					
					break;
				default:
					throw new Exception("Opção inválida, tente novamente!");
				}
			} catch (Exception e) {
				System.err.println(e.getMessage());
				continue;
			}
		} while (!escolha.equals("3"));
	}
}
