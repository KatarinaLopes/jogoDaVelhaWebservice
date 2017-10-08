/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogodavelhaservidor.servidor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Katarina
 */
public class Servidor {
    private static ServerSocket server;
    private static Socket cliente;
    
    private Servidor(){
        
    }

    public static ServerSocket getServer() {
        return server;
    }

    public static void setServer(ServerSocket server) {
        Servidor.server = server;
    }
    
    public static void conectarServidor(int porta) throws IOException{
        server = new ServerSocket(porta);
        System.out.println("Servidor conectado");
    }
    
    public static void desconectarServidor() throws IOException{
        server.close();
        System.out.println("Servidor desconectado");
    }
    
    public static void conectarCliente() throws IOException{
        cliente = server.accept();
        
        System.out.println("Cliente " + cliente.getInetAddress() + 
                " conectado");
    }
    
    public static void desconectarCliente() throws IOException{
        cliente.close();
        System.out.println("Cliente desconectado");
    }
    
    public static void main(String[] args) {
        try {
            Servidor.conectarServidor(12345);
        } catch (IOException ex) {
            System.out.println("Impossível conectar servidor. "
                    + "Tente novamente.");
            
            return;
            
        }
        
        try {
            Servidor.conectarCliente();
        } catch (IOException ex) {
            System.out.println("Impossível conectar cliente. "
                    + "Tente novamente.");
        }
        
        try {
            Servidor.desconectarCliente();
        } catch (IOException ex) {
            System.out.println("Falha ao desconectar cliente.");
        }
        
        try {
            Servidor.desconectarServidor();
        } catch (IOException ex) {
            System.out.println("Falha ao desconectar servidor.");
        }
    }
    
    
}
