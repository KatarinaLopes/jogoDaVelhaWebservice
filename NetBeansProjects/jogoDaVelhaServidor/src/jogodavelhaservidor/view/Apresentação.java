/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogodavelhaservidor.view;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import jogodavelhaservidor.controllers.ControllerJogo;

/**
 *
 * @author Katarina
 */
public class Apresentação {

    private ControllerJogo controller = new ControllerJogo();
    private Scanner s;
    
    private PrintStream entrada;
    
    public Apresentação() {
    }

    public Scanner getS() {
        return s;
    }

    public void setS(Scanner s) {
        this.s = s;
    }

    public PrintStream getEntrada() {
        return entrada;
    }

    public void setEntrada(PrintStream entrada) {
        this.entrada = entrada;
    }
   
    public void selecionarNome() {
        entrada.println("Nome do Jogador: \n#INIT_COMUNICATE");
        
        String nomeJ1 = s.next();
        
        //Servidor.getSaidaCliente().close();
        
        controller.selecionarNome(nomeJ1);
        
    }

    public void selecionarSimbolo() {
        entrada.println("Jogador 1, escolha 1 para X ou 2 para O "
                + "\n#INIT_COMUNICATE");

        int escolha = 0;

        do {

            escolha = s.nextInt();

            if (escolha != 1 && escolha != 2) {
                System.out.println("Escolha 1 ou 2!");
            }

        } while (escolha != 1 && escolha != 2);

        String simbolo1 = escolha == 1 ? "X" : "O";
        String simbolo2 = escolha == 2 ? "X" : "O";
        
        entrada.println(controller.getJ2().getNome() + 
                " ficou com " + simbolo2);
        
        controller.selecionarSimbolo(simbolo1, simbolo2);
    }

    public void anunciarSimboloOutroJogador(){
        entrada.println("Você ficou com o símbolo " + 
                controller.getJ2().getSimbolo());
    }
    
    public String iniciarJogo(){
        entrada.println("Início!!!");
        
        boolean co = controller.continuar();
        
        while(controller.continuar() == true){
            
            entrada.println("Vez de " + controller.
                    imprimirNomeJogadorAtual());
            
            //controller.executar(Integer.parseInt(Servidor.pegarSaida()));
            
            entrada.println(controller.imprimirTabuleiro() + 
                    "\n#INIT_COMUNICATE");
            
            
            
            String msg = controller.
                    executar(s.nextInt());
            
            if(msg != null){
                entrada.println(msg);
                return "#END_COMUNICATE";
            }
            
            
        }
        
        return "";
    }
    
    public void jogar() throws IOException{
        selecionarNome();
        //selecionarNome();
        selecionarSimbolo();
        iniciarJogo();
    }

    public static void main(String[] args) {
    }
}
