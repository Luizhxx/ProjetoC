package ClienteServidor;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Cliente implements Runnable{

	public static void main(String args[]) throws Exception {
        Socket socket = new Socket("localhost", 56429);
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
    	ObjectOutputStream output;
    	ObjectInputStream input;
    	String comando = null; 
    	Comunicado mensagem;
    	
    	System.out.println("O cliente conectou ao servidor");
    	System.out.println("Digite o comando: ");
    	
    	while(comando == null) {
    		comando = Teclado.Teclado.getUmString().toUpperCase();
    	}
    	
    	if(comando!= null && comando != "FIC") {
//Receptor
            output = new ObjectOutputStream(this.cliente.getOutputStream());
//Transmissor
    		input = new ObjectInputStream(this.cliente.getInputStream());
    		
    		switch(comando) {
    			case "FIC":
    				mensagem = new Comunicado("FIC");
    				output.writeObject(mensagem);
    				output.flush();
    				output.close();
    				input.close();
    				this.cliente.close();
    	            System.out.println("Fim do cliente!");
    	            break;
    		}
    	}	
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