package br.com.chat.client.console;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClienteConsole {

    // socket do cliente
    private Socket socket;

    public ClienteConsole(String host, int porta) throws UnknownHostException, IOException {
        socket = new Socket(host, porta);
    }

    public ClienteConsole(int porta) throws UnknownHostException, IOException {
        socket = new Socket("127.0.0.1", porta);
    }

    /**
     * Iniciar conexão com o servidor
     * 
     * @throws IOException
     */
    public void iniciarConexao() throws IOException {
        // Instâcia para enviar as mensagens
        PrintStream saida = new PrintStream(socket.getOutputStream());

        // Instâcia para ler as mensagens
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));

        // Solicitar apelido
        System.out.print("Informe seu apelido: ");
        String meuNome = teclado.readLine();

        // Estabelecer conexão com o servidor
        ConexaoCliente conexaoCliente = new ConexaoCliente(socket);
        conexaoCliente.start();

        // Ler e enviar para servidor mensagem do cliente
        while (true) {
            System.out.print("> ");

            String linha = meuNome + ":" + teclado.readLine();

            if (ConexaoCliente.done)
                break;

            saida.println(linha);
        }
    }
}
