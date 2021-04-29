package br.com.chat.server;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexaoServidor extends Thread {
    // caminho do arquivo que será salvo as mensagens
    private String pathMsg = System.getProperty("user.dir") + "\\chat.txt";

    // parte que controla a conexão por meio de threads
    private static Collection<PrintStream> clientes;

    // socket do cliente
    private Socket socket;

    public ConexaoServidor(Socket s) {
        if (clientes == null) {
            clientes = Collections.synchronizedCollection(new ArrayList<>());
        }

        socket = s;
    }

    @Override
    public void run() {
        PrintStream saida = null;

        try {
            // Instâcia para ler as mensagens recebidas
            BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // Instâcia para enviar as mensagens recebidas
            saida = new PrintStream(socket.getOutputStream());

            System.out.println("Cliente conectado...");

            // Salvar a conexão do cliente
            clientes.add(saida);

            // Enviar mensagens anterios para o cliente novo, se existir
            enviarMensagensAnteriores(saida);

            // Ler as mensagens do cliente e enviar para os demais
            String linha = entrada.readLine();
            while (linha != null && !(linha.trim().equals(""))) {
                enviarMensagemParaClientesConectados(saida, linha);
                linha = entrada.readLine();
            }

            // Remover cliente
            clientes.remove(saida);
            socket.close();

        } catch (IOException e) {
            System.out.println("Cliente desconectado...");

            // Remover cliente
            clientes.remove(saida);
        }
    }

    /**
     * Ler as mensagens anteriores salvas e enviar para o cliente conectado
     * 
     * @param saida stream de conexao para enviar mensagem
     * @throws IOException
     */
    private void enviarMensagensAnteriores(PrintStream saida) throws IOException {
        // Preparar instância para ler as mensagens anteriores
        try (BufferedReader br = new BufferedReader(new FileReader(pathMsg))) {

            // ler linha do arquivo
            String line = br.readLine();

            // se possuir conteudo enviar para o cliente novo a mensagem
            while (line != null) {
                saida.println(line);
                line = br.readLine();
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ConexaoServidor.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Enviar mensagem para todos os clientes conectados
     * 
     * @param saida    stream de conexao para enviar mensagem
     * @param mensagem mensagem a ser enviada
     * @throws IOException
     */
    private void enviarMensagemParaClientesConectados(PrintStream saida, String mensagem) throws IOException {
        // Criar instância do arquivo
        File f = new File(pathMsg);

        // Criar instância para gravar no arquivo
        FileWriter fw = new FileWriter(f, true);

        PrintWriter pw = new PrintWriter(fw);

        // Obter lista de clientes
        Iterator<PrintStream> e = clientes.iterator();

        while (e.hasNext()) {
            PrintStream chat = (PrintStream) e.next();

            // Gravar mensagem no arquivo
            pw.println(mensagem);

            fw.close();

            // Enviar mensagem para todos os clientes conectados
            if (chat != saida) {
                chat.println(mensagem);
            }
        }
    }
}
