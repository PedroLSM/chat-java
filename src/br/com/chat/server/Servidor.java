package br.com.chat.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Servidor {
	private ServerSocket server;
	
	public Servidor(int porta) throws IOException {
		server = new ServerSocket(porta);
		
		System.out.println("Servidor iniciado na porta " + server.getLocalPort());
	}
	
    public void iniciar() {
        try {
            while (true) {
                System.out.println("Esperando alguem se conectar...");
                Socket conexao = server.accept();

                ConexaoServidor conexaoServidor = new ConexaoServidor(conexao);

                conexaoServidor.start();
            }
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
