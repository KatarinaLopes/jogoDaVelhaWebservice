/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogodavelhaservidor.servidor.threads;

import java.net.Socket;
import jogodavelhaservidor.view.Apresentação;

/**
 *
 * @author Katarina
 */
public class ThreadCLiente extends Thread{
    private Socket cliente;
    private Apresentação apresentacao;

    public ThreadCLiente(Socket cliente, Apresentação apresentacao) {
        this.cliente = cliente;
        this.apresentacao = apresentacao;
    }

    public Socket getCliente() {
        return cliente;
    }

    public void setCliente(Socket cliente) {
        this.cliente = cliente;
    }   
    
    @Override
    public void run(){
        apresentacao.selecionarNome();
    }
}
