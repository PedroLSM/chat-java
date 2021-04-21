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
            
            BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            saida = new PrintStream(socket.getOutputStream());
            
            System.out.println("Cliente conectado...");
            clientes.add(saida);

            lerMensagensAnteriores(saida);

            String linha = entrada.readLine();
            while (linha != null && !(linha.trim().equals(""))) {
                enviarTodos(saida, ": ", linha);
                linha = entrada.readLine();
            }

            clientes.remove(saida);
            socket.close();
            
        } catch (IOException e) {
            System.out.println("Cliente desconectado...");
            clientes.remove(saida);
        }
    }

    private void lerMensagensAnteriores(PrintStream saida) throws IOException {
        try {
            try (BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.dir") + "\\chat.txt"))) {
                String line = br.readLine();

                while (line != null) {
                    saida.println(line);
                    line = br.readLine();
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ConexaoServidor.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void enviarTodos(PrintStream saida, String acao, String linha) throws IOException {
        File f = new File(System.getProperty("user.dir") + "\\chat.txt");

        FileWriter fw = new FileWriter(f, true);

        PrintWriter pw = new PrintWriter(fw);

        Iterator e = clientes.iterator();

        while (e.hasNext()) {
            PrintStream chat = (PrintStream) e.next();
            
            pw.println(linha);

            fw.close();
            
            if (chat != saida) {
                chat.println(linha);
            }
        }
    }
}
