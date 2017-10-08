/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogodavelhaservidor.servidor.threads;

import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import jogodavelhaservidor.view.Apresentação;

/**
 *
 * @author Katarina
 */
public class ThreadCLiente extends Thread{
    private Socket cliente;
    private Apresentação apresentacao;
    private int signal;

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

    public int getSignal() {
        return signal;
    }

    public void setSignal(int signal) {
        this.signal = signal;
    }
    
    @Override
    public void run(){
        apresentacao.selecionarNome();
        
        if(signal == 1){
            apresentacao.selecionarSimbolo();
        }else{
            apresentacao.anunciarSimboloOutroJogador();
        }
    }
}
