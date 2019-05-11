package ClienteServidor;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor implements Runnable {

	public static void main(String[] args) throws Exception {
		int porta = 56433;
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
		
		Comunicado comunicado = (Comunicado) input.readObject();
		String comando = comunicado.getComando();
		comando.toUpperCase();
		
		switch (comando) {
		case "FIC":
			System.out.println("Cliente " + this.cliente.getInetAddress().getHostAddress() + " desconectou!");
			output.flush();
			output.close();
			input.close();
		}
	}

// Thread onde ocorre o tratamento da conexão. Para cada cliente é gerada uma nova Thread separada.
	public void run() {
		System.out.println("Nova conexao com o cliente " + this.cliente.getInetAddress().getHostAddress());

		try {
			tratarConexao();
		} catch (Exception erro) {
			erro.printStackTrace();
		}
	}
}