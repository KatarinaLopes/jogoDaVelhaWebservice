/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogodavelhaservidor.servidor.threads;

import java.net.Socket;

/**
 *
 * @author Katarina
 */
public class ThreadCLiente extends Thread{
    private Socket cliente;

    public ThreadCLiente(Socket cliente) {
        this.cliente = cliente;
    }

    public Socket getCliente() {
        return cliente;
    }

    public void setCliente(Socket cliente) {
        this.cliente = cliente;
    }
    
    
    
    @Override
    public void run(){
        System.out.println(1+1);
    }
}
