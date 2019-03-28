package interfacegrafica;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Menu {
	
	public static void menu() {
		String escolha = null;
		BufferedReader entradaUsuario= new BufferedReader(new InputStreamReader(System.in));
		do {
			try {

				System.out.println("\t+------------------------------------------------+");
				System.out.println("\t|                      MENU                      |");
				System.out.println("\t+------------------------------------------------+\n");
				
				System.out.println("\t+------------------------------------------------+");
				System.out.println("\t| 1 - Labirintos                                 |");
				System.out.println("\t|                                                |");
				System.out.println("\t| 2 - Para sair da aplicação                     |");
				System.out.println("\t+------------------------------------------------+");
				
				escolha = entradaUsuario.readLine();
				
				switch (escolha) {
				case "1":
					MenuLabirintos.MenuLabs();
					break;
				case "2":
					
					break;
				default:
					System.err.println("Opção inválida, tente novamente!");
					continue;
				}
			}catch (Exception e) {
				System.err.println("Opção inválida, tente novamente!");
				continue;
			}
		} while (!escolha.equals("2") );
	}
}
