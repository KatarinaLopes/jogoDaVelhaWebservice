/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogodavelhaservidor.servidor.interfaceVelha;

import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import jogodavelhaservidor.servidor.Servidor;
import jogodavelhaservidor.view.Apresentação;

/**
 *
 * @author Katarina
 */
public class InterfaceServidor {
    private Socket cliente; 
    private Apresentação apresentacao;
    
    public InterfaceServidor(){
        try {
            Servidor.conectarServidor(12345);
        } catch (IOException ex) {
            System.out.println("Falha ao conectar o servidor. "
                    + "Tente novamente.\n"
                    + "Erro: " + ex);
        }
        
        
        
    }
    
    public void encerrarConexao(){
        try {
            Servidor.desconectarServidor();
        } catch (IOException ex) {
            System.out.println("Falha ao desconectar servidro. "
                    + "Tente novamente.\n"
                    + "Erro: " + ex);
        }
    }
    
    public void conectarCliente(){
        try {
            Servidor.conectarCliente();
            apresentacao = new Apresentação(Servidor.getSaida(), 
                    Servidor.getEntrada());
        } catch (IOException ex) {
            System.out.println("Falha ao conectar o cliente. "
                    + "Tente novamente.\n"
                    + "Erro: " + ex); 
        }
    }
    
    public void desconectarCliente(){
        try {
            Servidor.desconectarCliente();
        } catch (IOException ex) {
            System.out.println("Falha ao desconectar o cliente. "
                    + "Tente novamente.\n"
                    + "Erro: " + ex);
        }
    }
    
    public void iniciarJogo() {
        String msg = "";
        
        apresentacao.selecionarNome();
        apresentacao.selecionarSimbolo();
 
        while(!msg.equals("#END_COMUNICATE")){
            msg = apresentacao.iniciarJogo();
        }
    }
            
    public static void main(String[] args) throws IOException {
        InterfaceServidor interfaceServidor = new InterfaceServidor();
        
        interfaceServidor.conectarCliente();
        interfaceServidor.iniciarJogo();
        interfaceServidor.desconectarCliente();
    }
}
