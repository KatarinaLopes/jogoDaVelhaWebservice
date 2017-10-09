/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogodavelhaservidor.servidor.threads;

import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import jogodavelhaservidor.servidor.Servidor;
import jogodavelhaservidor.view.Apresentacao;

/**
 *
 * @author Katarina
 */
public class ThreadCLiente extends Thread {

    private Socket cliente;
    private Apresentacao apresentacao;
    private static int signal;

    public ThreadCLiente(Socket cliente, Apresentacao apresentacao) {
        this.cliente = cliente;
        this.apresentacao = apresentacao;
    }

    public Socket getCliente() {
        return cliente;
    }

    public void setCliente(Socket cliente) {
        this.cliente = cliente;
    }

    public static int getSignal() {
        return signal;
    }

    public static void setSignal(int sign) {
        signal = sign;
    }

    @Override
    public void run() {
        synchronized (this) {

            apresentacao.selecionarNome();

            if (signal == 1) {
                apresentacao.selecionarSimbolo();
            } else {
                apresentacao.anunciarSimboloOutroJogador();
            }

            notify();
        }

    }

    public String jogar() {

        String msg = apresentacao.iniciarJogo();

        return msg;
    }
}
