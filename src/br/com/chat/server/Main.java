package br.com.chat.server;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        // Criar instancia do servidor na porta 61000
        Servidor servidor = new Servidor(61000);

        // Iniciar servidor e aceitar as conexões
        servidor.iniciar();
    }
}
