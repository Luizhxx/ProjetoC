package ClienteServidor;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.swing.JLabel;

import Recursos.Lista;
import dbo.Musicas;

@SuppressWarnings("unused")
public class Cliente {

	public static void main(String args[]) throws Exception {
		Socket socket = new Socket("localhost", 12353);
		Cliente cliente = new Cliente(socket);
		Tela tela = new Tela(cliente);
	}

	private Socket cliente;
	private Lista<Musicas> listMusicas = null;
	private Lista<Musicas> listDesejos;

	public Cliente(Socket cliente) {
		this.cliente = cliente;
	}

//Classe que trata a conexão e executa os protocolos
	public void tratarConexao(String comando, String busca) throws Exception {
		ObjectOutputStream output;
		ObjectInputStream input;
		Comunicado mensagem;

//Receptor
		output = new ObjectOutputStream(this.cliente.getOutputStream());
//Transmissor
		input = new ObjectInputStream(this.cliente.getInputStream());

		switch (comando) {

		case "CON":
			mensagem = new Comunicado("CON", busca);
			output.writeObject(mensagem);
			output.flush();
			mensagem = (Comunicado) input.readObject();
			listMusicas = new Lista<>();
			listDesejos = new Lista<>();
			for (Musicas musicas : mensagem.getMusica()) {
				listMusicas.insereItem(musicas);
			}

			break;

		case "FIC":
			mensagem = new Comunicado("FIC");
			output.writeObject(mensagem);
			output.flush();
			output.close();
			input.close();
			this.cliente.close();
			break;

		default:
			output.writeObject("");
			output.flush();
			input.readObject();
		}
	}


	public void limparMusicas() throws Exception {
		listMusicas = null;
	}

	public void limparMDesejos() throws Exception {
		listDesejos = null;
	}

	public Lista<Musicas> getListMusicas() {
		return listMusicas;
	}

	public void setListMusicas(Lista<Musicas> listMusicas) {
		this.listMusicas = listMusicas;
	}

	public Lista<Musicas> getListDesejos() {
		return listDesejos;
	}

	public void setListDesejos(Lista<Musicas> listDesejos) {
		this.listDesejos = listDesejos;
	}

	JLabel lblNewLabel_1 = new JLabel("Lista de M\u00FAsicas");
}