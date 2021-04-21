package br.com.chat.client.console;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClienteConsole {

    private Socket socket;

    public ClienteConsole(String host, int porta) throws UnknownHostException, IOException {
        socket = new Socket(host, porta);
    }

    public ClienteConsole(int porta) throws UnknownHostException, IOException {
        socket = new Socket("127.0.0.1", porta);
    }
    
    public void iniciarConexao() throws IOException {

        PrintStream saida = new PrintStream(socket.getOutputStream());
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Informe seu apelido: ");
        String meuNome = teclado.readLine();

        ConexaoCliente conexaoCliente = new ConexaoCliente(socket);
        conexaoCliente.start();

        String linha;
        while (true) {
            System.out.print("> ");

            linha = meuNome + ":" + teclado.readLine();

            if (ConexaoCliente.done) {
                break;
            }

            saida.println(linha);
        }
    }
}
