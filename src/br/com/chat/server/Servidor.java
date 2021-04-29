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

    /**
     * Liberar o servidor para aceitar as conexões do cliente
     */
    public void iniciar() {
        try {
            while (true) {
                System.out.println("Esperando alguem se conectar...");

                // Aceitar conexão
                Socket conexao = server.accept();

                // Criar intacia da conexão cliente com o servidor
                ConexaoServidor conexaoServidor = new ConexaoServidor(conexao);

                // Iniciar theard para escultar as mensagens recebidas/enviadas
                conexaoServidor.start();
            }
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
