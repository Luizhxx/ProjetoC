package ClienteServidor;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import dbo.DBConnection;
import dbo.Musicas;

public class Servidor implements Runnable {

	public static void main(String[] args) throws Exception {
		int porta = 12353;
		ServerSocket servidor = new ServerSocket(porta);
		System.out.println("Porta " + porta + " aberta!");
		System.out.println("Aguardando conexão do cliente...");

// Faz com que o servidor receba vaios clientes até que seja encerrado
		while (true) {
			Socket cliente = servidor.accept();
			Servidor tratamento = new Servidor(cliente, servidor);
			Thread sessao = new Thread(tratamento);
			sessao.start();
		}
	}

	private Socket cliente;
	@SuppressWarnings("unused")
	private ServerSocket servidor;

	public Servidor(Socket cliente, ServerSocket servidor) {
		this.cliente = cliente;
		this.servidor = servidor;
	}

// Classe que trata a conexão e executa os protocolos
	public void tratarConexao() throws Exception {

// Receptor
		ObjectOutputStream output = new ObjectOutputStream(this.cliente.getOutputStream());
// Transmissor
		ObjectInputStream input = new ObjectInputStream(this.cliente.getInputStream());
		List<Musicas> musicasPesquisadas = new ArrayList<Musicas>();

		Comunicado mensagem = (Comunicado) input.readObject();
		String comando = mensagem.getComando();
		comando.toUpperCase();

		switch (comando) {

		case "CON":
			if (mensagem.getBusca().isEmpty() == true) {
				musicasPesquisadas = DBConnection.getAllMusics();
			} else {
				musicasPesquisadas = DBConnection.getMusicsByCantor(mensagem.getBusca());

				if (musicasPesquisadas.size() == 0) {
					musicasPesquisadas = DBConnection.getMusicsByEstilo(mensagem.getBusca());
				}

				if (musicasPesquisadas.size() == 0) {
					musicasPesquisadas = DBConnection.getMusicsByTitle(mensagem.getBusca());
				}
			}

			mensagem = new Comunicado("CON", musicasPesquisadas);
			output.writeObject(mensagem);
			output.flush();
			break;

		case "FIC":
			System.out.println("Cliente " + this.cliente.getInetAddress().getHostAddress() + " desconectou!");
			output.flush();
			output.close();
			input.close();
			break;

		default:
			output.writeObject("");
			output.flush();
		}
	}

// Thread onde ocorre o tratamento da conexão. Para cada cliente é gerada uma nova Thread separada.
	public void run() {
		System.out.println("Nova conexao com o cliente " + this.cliente.getInetAddress().getHostAddress());

		try {
			while (true) {
				tratarConexao();
			}
		} catch (Exception erro) {
			erro.printStackTrace();
		}
	}

}