/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogodavelhaservidor.servidor.interfaceVelha;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import jogodavelhaservidor.servidor.Servidor;
import jogodavelhaservidor.servidor.threads.ThreadCLiente;
import jogodavelhaservidor.view.Apresentacao;

/**
 *
 * @author Katarina
 */
public class InterfaceServidor {

    private ThreadCLiente cliente1;
    private ThreadCLiente cliente2;
    private ThreadCLiente clienteAtual;
    private ThreadCLiente clienteEmAguardo;
    private Apresentacao apresentacao;

    private int conexoes;

    public InterfaceServidor() {
        try {
            Servidor.conectarServidor(12345);
        } catch (IOException ex) {
            System.out.println("Falha ao conectar o servidor. "
                    + "Tente novamente.\n"
                    + "Erro: " + ex);
        }

        apresentacao = new Apresentacao();
    }

    public void encerrarConexao() {
        try {
            Servidor.desconectarServidor();
        } catch (IOException ex) {
            System.out.println("Falha ao desconectar servidor. "
                    + "Tente novamente.\n"
                    + "Erro: " + ex);
        }
    }

    public void conectarCliente() throws InterruptedException {
        try {
            Socket cliente = Servidor.conectarCliente();
            //apresentacao = new Apresentação(Servidor.getSaida(), 
            //      Servidor.getEntrada());

            apresentacao.setEntrada(new PrintStream(
                    cliente.getOutputStream()));
            apresentacao.setS(new Scanner(cliente.getInputStream()));

            clienteAtual = new ThreadCLiente(cliente, apresentacao);

            apropriarCliente();

            clienteAtual.start();

        } catch (IOException ex) {
            System.out.println("Falha ao conectar o cliente. "
                    + "Tente novamente.\n"
                    + "Erro: " + ex);
        }
    }

    public void desconectarCliente() {
        //try {
        cliente1.interrupt();
        cliente2.interrupt();
        /*} catch (IOException ex) {
            System.out.println("Falha ao desconectar os clientes. "
                    + "Tente novamente.\n"
                    + "Erro: " + ex);
        }*/
    }

    public String iniciarJogo() throws IOException, InterruptedException {
        synchronized (clienteAtual) {

            System.out.println(clienteAtual + " " + clienteEmAguardo);

            String msg = "";

            while (!msg.equals("#END_COMUNICATE")) {

                apresentacao.setEntrada(new PrintStream(
                        clienteAtual.getCliente().getOutputStream()));
                apresentacao.setS(new Scanner(
                        clienteAtual.getCliente().getInputStream()));

                msg = apresentacao.iniciarJogo();

                if (msg.equals("#NEXT_PLAYER")) {
                    chavearClientes();
                }

            }
            notify();
            return msg;
        }

    }

    public void tratarConexaoComCliente() throws InterruptedException, IOException {

        while (conexoes < 2) {
            conectarCliente();
            synchronized (clienteAtual) {
                clienteAtual.wait();
            }

            // rodarThreads();
            conexoes++;

        }

        //rodarThreads();
        clienteAtual = cliente1;
        clienteEmAguardo = cliente2;

        //cliente1.wait();
        //clienteEmAguardo.notify();
    }

    public void chavearClientes() throws InterruptedException {

        if (clienteAtual == cliente1) {
            clienteAtual = cliente2;
            clienteEmAguardo = cliente1;
        } else {
            clienteAtual = cliente1;
            clienteEmAguardo = cliente2;
        }

    }

    public void apropriarCliente() {
        System.out.println(clienteAtual);

        if (cliente1 == null) {
            cliente1 = clienteAtual;
            ThreadCLiente.setSignal(1);
        } else {
            cliente2 = clienteAtual;
            ThreadCLiente.setSignal(2);
        }
    }

    public void rodar() throws InterruptedException, IOException {
        tratarConexaoComCliente();
        synchronized (clienteEmAguardo) {
            clienteEmAguardo.wait();
        }
        iniciarJogo();
    }

    public void rodarThreads() throws InterruptedException {
        //cliente2.start();
    }

    public static void main(String[] args) throws IOException,
            InterruptedException {
        InterfaceServidor interfaceServidor = new InterfaceServidor();

        interfaceServidor.tratarConexaoComCliente();
        //interfaceServidor.rodarThreads();
        interfaceServidor.iniciarJogo();
    }
}
