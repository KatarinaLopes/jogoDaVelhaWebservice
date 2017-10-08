/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogodavelhaservidor.servidor;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Katarina
 */
public class Servidor {

    private static ServerSocket server;
    private static Socket cliente;
    private static PrintStream entrada;
    private static Scanner saida;

    private Servidor() {

    }

    public static ServerSocket getServer() {
        return server;
    }

    public static Socket getCliente() {
        return cliente;
    }

    public static PrintStream getEntrada() {
        return entrada;
    }

    public static Scanner getSaida() {
        return saida;
    }

    public static void conectarServidor(int porta) throws IOException {
        server = new ServerSocket(porta);
        System.out.println("Servidor conectado");
    }

    public static void desconectarServidor() throws IOException {
        server.close();
        System.out.println("Servidor desconectado");
    }

    public static void conectarCliente() throws IOException {
        cliente = server.accept();

        entrada = new PrintStream(cliente.getOutputStream());
        saida = new Scanner(cliente.getInputStream());

        System.out.println("Cliente " + cliente.getInetAddress()
                + " conectado");
    }

    public static void enviarDados(String msg) {
        entrada.println(msg);
    }

    public static String receberDados() {
        return saida.next();
    }

    public static void desconectarCliente() throws IOException {
        saida.close();
        entrada.close();
        cliente.close();
        System.out.println("Cliente desconectado");
    }

    public static void main(String[] args) {

        while (Servidor.getSaida().hasNextLine()) {
            String msg = Servidor.receberDados();

            System.out.println(msg);

            if (msg.equals("quit")) {

                try {
                    Servidor.desconectarCliente();
                    break;
                } catch (IOException ex) {
                    System.out.println("Falha ao desconectar cliente."
                            + " Tente novamente");
                }
            }
        }
    }

}