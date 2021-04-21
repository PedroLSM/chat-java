package br.com.chat.server;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        Servidor servidor = new Servidor(61000);
        
        servidor.iniciar();
    }
}
