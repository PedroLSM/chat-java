package br.com.chat.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Cliente {
    private Socket socket;
    private PrintStream saida;
    private BufferedReader entrada;
    
    public Cliente(String host, int porta) throws UnknownHostException, IOException {
        socket = new Socket(host, porta);
        
        saida = new PrintStream(socket.getOutputStream());
        entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }

    public Cliente(int porta) throws UnknownHostException, IOException {
        socket = new Socket("127.0.0.1", porta);
        
        saida = new PrintStream(socket.getOutputStream());
        entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        
        // this.enviar(apelido);
    }
    
    public void enviar(String mensagem) {
        saida.println(mensagem);
    }
    
    public String escutar()  {
        try {
            return this.entrada.readLine();
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
