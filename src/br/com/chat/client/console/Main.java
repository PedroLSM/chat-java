package br.com.chat.client.console;

import java.io.IOException;
import java.net.UnknownHostException;

public class Main extends Thread {

    public static void main(String[] args) throws UnknownHostException, IOException {
        // Criar instância da conexão do cliente com o servidor
        ClienteConsole cliente = new ClienteConsole(61000);

        // Iniciar conexão
        cliente.iniciarConexao();
    }

}