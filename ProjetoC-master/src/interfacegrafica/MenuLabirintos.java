package interfacegrafica;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import labirinto.Labirinto;
import leitura.Leitor;

public class MenuLabirintos {
	
	public static void MenuLabs() throws IOException {
		BufferedReader entradaUsuario= new BufferedReader(new InputStreamReader(System.in));
		String escolha = new String();
		String caminho = new String();
		String[] labirinto = null;
				
		do {
			try {
				System.out.println("\t+------------------------------------------------+");
				System.out.println("\t|                   LABIRINTOS                   |");
				System.out.println("\t+------------------------------------------------+\n");
				System.out.println("\t+------------------------------------------------+");
				System.out.println("\t| 1 - Configurar o path do arquivo do labirinto  |");;
				System.out.println("\t|                                                |");
				System.out.println("\t| 2 - Imprimir o arquivo                         |");
				System.out.println("\t|                                                |");
				System.out.println("\t| 3 - Iniciar a fuga do labirinto                |");
				System.out.println("\t|                                                |");
				System.out.println("\t| 4 - Voltar ao menu                             |");
				System.out.println("\t+------------------------------------------------+");

				escolha = entradaUsuario.readLine();
				
				switch (escolha) {
				case "1":
					System.out.println("Digite o caminho do arquivo labirinto");
					caminho = entradaUsuario.readLine(); 
					labirinto = Leitor.lerArquivo(caminho);
					break; 
					
				case "2":
					if(labirinto == null)
						throw new Exception("Arquivo não informado!");
					
					System.out.println("\t+------------------------------------------------+");
					System.out.println("\t|                    IMPRESSÃO                   |\n");					
					System.out.println("\t+------------------------------------------------+\n");
					
					for(int cont = 0; cont < labirinto.length; cont++) {
						System.out.println("\t\t" + labirinto[cont]);
					}
					break;
					
				case "3":
					
					Labirinto labirintoLido = new Labirinto(labirinto);
					labirintoLido.encontrarCaminho();
					labirintoLido.imprimir();
					
					break;
					
				case "4":
					break;
					
				default:
					throw new Exception("Opção inválida, tente novamente!");
				}
				
			} catch (Exception erro) {
				System.err.println("\n" + erro.getMessage() + "\n");
				erro.printStackTrace();
				continue;
			}
		} while (!escolha.equals("4"));
	}
}
