/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogodavelhaservidor.view;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.InputMismatchException;
import java.util.Scanner;
import jogodavelhaservidor.controllers.ControllerJogo;

/**
 *
 * @author Katarina
 */
public class Apresentação1 {

    private ControllerJogo controller = new ControllerJogo();
    private Scanner s = new Scanner(System.in);
    
    /*public Apresentação1() throws IOException{
        Servidor.conectarServidor(12345);
        Servidor.conectarCliente();
    }

    public void selecionarNome() throws IOException {
        Servidor.imprimirSaida("Nome do Jogador 1: \n#INIT_COMUNICATE");
        
        String nomeJ1 = Servidor.pegarSaida();
        
        //Servidor.getSaidaCliente().close(); 
        
        Servidor.imprimirSaida("Nome do Jogador 2: \n#INIT_COMUNICATE");
        
        String nomeJ2 = Servidor.pegarSaida();

        //controller.selecionarNomeJogadores(nomeJ1, nomeJ2);
    }

    public void selecionarSimbolo() {
        Servidor.imprimirSaida("Jogador 1, escolha 1 para X ou 2 para O"
                + "\n#INIT_COMUNICATE");

        int escolha = 0;

        do {

            escolha = Integer.parseInt(Servidor.pegarSaida());

            if (escolha != 1 && escolha != 2) {
                System.out.println("Escolha 1 ou 2!");
            }

        } while (escolha != 1 && escolha != 2);

        String simbolo1 = escolha == 1 ? "X" : "O";
        String simbolo2 = escolha == 2 ? "X" : "O";
        
        Servidor.imprimirSaida(controller.getJ2().getNome() + 
                " ficou com " + simbolo2);
        
        controller.selecionarSimboloJogador1(simbolo1, simbolo2);
    }
    
    public void iniciarJogo() throws IOException{
        Servidor.imprimirSaida("Início!!!");
        
        boolean co = controller.continuar();
        
        while(controller.continuar() == true){
            
            Servidor.imprimirSaida("Vez de " + controller.
                    imprimirNomeJogadorAtual());
            
            //controller.executar(Integer.parseInt(Servidor.pegarSaida()));
            
            Servidor.imprimirSaida(controller.imprimirTabuleiro());
            
            
            Servidor.imprimirSaida("#INIT_COMUNICATE");
            
            
            String msg = controller.
                    executar(Integer.parseInt(Servidor.pegarSaida()));
            
            if(msg != null){
                Servidor.imprimirSaida(msg);
                Servidor.desconectarCliente();
            }
            
            
        }
    }
    
    public void jogar() throws IOException{
        selecionarNome();
        //selecionarNome();
        selecionarSimbolo();
        iniciarJogo();
    }

    public static void main(String[] args) throws IOException {
        Apresentação1 a = new Apresentação1();

        a.jogar();
    }
    */
}
