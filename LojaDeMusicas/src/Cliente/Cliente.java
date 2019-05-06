package Cliente;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Cliente implements Runnable{

	public static void main(String args[]) throws Exception {
        Socket socket = new Socket("localhost", 56459);
        Cliente cliente = new Cliente(socket);
	    Thread sessao = new Thread(cliente);
	    sessao.start();
	}
	
    private Socket cliente;

    public Cliente(Socket cliente){
        this.cliente = cliente;
    }
    
   //Classe que trata a conexão e executa os protocolos
    public void tratarConexao() throws Exception {
    	System.out.println("O cliente conectou ao servidor");

    	//Receptor
        ObjectOutputStream output = new ObjectOutputStream(this.cliente.getOutputStream());
        //Transmissor
		ObjectInputStream input = new ObjectInputStream(this.cliente.getInputStream());
		
		String msg = "Oi";
		output.writeUTF(msg);
		output.flush();
		
		msg = (String)input.readUTF();
		System.out.println("Resposta: " + msg);
		
		input.close();
		output.close();
		this.cliente.close();
        System.out.println("Fim do cliente!");
    }

  //Thread onde ocorre a comunicação do cliente com o servidor.
    public void run() {
        try {
             tratarConexao();
        } catch (Exception erro) {
            erro.printStackTrace();
        }
    }
}