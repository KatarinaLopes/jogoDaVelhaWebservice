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
public class Apresentação {

    private ControllerJogo controller = new ControllerJogo();
    private Scanner s = new Scanner(System.in);
    
    public Apresentação() throws IOException{
    }

    public void selecionarNome() throws IOException {
        System.out.println("Nome do Jogador 1:");
        
        String nomeJ1 = s.next();
        
        //Servidor.getSaidaCliente().close(); 
        
        System.out.println("Nome do Jogador 2:");
        
        String nomeJ2 = s.next();

        controller.selecionarNome(nomeJ1, nomeJ2);
    }

    public void selecionarSimbolo() {
        System.out.println("Jogador 1, escolha 1 para X ou 2 para O");

        int escolha = 0;

        do {

            escolha = s.nextInt();

            if (escolha != 1 && escolha != 2) {
                System.out.println("Escolha 1 ou 2!");
            }

        } while (escolha != 1 && escolha != 2);

        String simbolo1 = escolha == 1 ? "X" : "O";
        String simbolo2 = escolha == 2 ? "X" : "O";
        
        System.out.println(controller.getJ2().getNome() + 
                " ficou com " + simbolo2);
        
        controller.selecionarSimbolo(simbolo1, simbolo2);
    }
    
    public void iniciarJogo() throws IOException{
        System.out.println("Início!!!");
        
        boolean co = controller.continuar();
        
        while(controller.continuar() == true){
            
            System.out.println("Vez de " + controller.
                    imprimirNomeJogadorAtual());
            
            //controller.executar(Integer.parseInt(Servidor.pegarSaida()));
            
            System.out.println(controller.imprimirTabuleiro());
            
            
            
            String msg = controller.
                    executar(s.nextInt());
            
            if(msg != null){
                System.out.println(msg);
                return;
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
        Apresentação a = new Apresentação();

        a.jogar();
    }
}
