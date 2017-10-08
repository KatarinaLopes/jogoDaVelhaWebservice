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
    private Socket cliente1; 
    private Socket cliente2;
    private Apresentação apresentacao;
    
    private int conexoes;
    
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
            Socket cliente = Servidor.conectarCliente();
            //apresentacao = new Apresentação(Servidor.getSaida(), 
              //      Servidor.getEntrada());
            
            if(cliente1 == null){
                cliente1 = cliente;
            }else{
                cliente2 = cliente;
            }
            
        } catch (IOException ex) {
            System.out.println("Falha ao conectar o cliente. "
                    + "Tente novamente.\n"
                    + "Erro: " + ex); 
        }
    }
    
    public void desconectarCliente(){
        try {
            cliente1.close();
            cliente2.close();
        } catch (IOException ex) {
            System.out.println("Falha ao desconectar os clientes. "
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
    
    public void tratarConexaoComCliente(){
        while(conexoes < 2){
            conectarCliente();
            
            conexoes++;
        }
    }
            
    public static void main(String[] args) throws IOException {
        InterfaceServidor interfaceServidor = new InterfaceServidor();
        
        interfaceServidor.tratarConexaoComCliente();
        //interfaceServidor.iniciarJogo();
        interfaceServidor.desconectarCliente();
    }
}
