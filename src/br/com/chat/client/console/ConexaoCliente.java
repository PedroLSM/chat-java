package br.com.chat.client.console;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ConexaoCliente extends Thread {

    // socket do cliente
    private Socket socket;

    // quando verdadeiro encerrar conexao
    public static boolean done = false;

    public ConexaoCliente(Socket s) {
        socket = s;
    }

    public void run() {
        try {
            // Instâcia para ler as mensagens recebidas
            BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // Capturar e mostrar a mensagem recebida
            while (true) {
                String linha = entrada.readLine();

                if (linha == null || linha.split(":", 2).length < 2) {
                    System.out.println("Conexão encerrada!");
                    break;
                }

                System.out.println();
                String msgs[] = linha.split(":", 2);
                System.out.println(">> " + msgs[0] + ": " + msgs[1]);
                System.out.print("> ");
            }
        } catch (IOException e) {
            System.out.println("IOException: " + e);
        }

        done = true;
    }
}
