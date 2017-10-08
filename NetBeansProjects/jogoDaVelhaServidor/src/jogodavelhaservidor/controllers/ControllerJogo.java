/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogodavelhaservidor.controllers;

import jogodavelhaservidor.models.builders.BuilderJogador;
import jogodavelhaservidor.models.business.Jogador;
import jogodavelhaservidor.models.business.Jogo;
import jogodavelhaservidor.models.business.Tabuleiro;

/**
 *
 * @author Katarina
 */
public class ControllerJogo {
    private Jogo jogo;
    private BuilderJogador J1 = new BuilderJogador();
    private BuilderJogador j2 = new BuilderJogador();

    public BuilderJogador getJ1() {
        return J1;
    }

    public void setJ1(BuilderJogador J1) {
        this.J1 = J1;
    }

    public BuilderJogador getJ2() {
        return j2;
    }

    public void setJ2(BuilderJogador j2) {
        this.j2 = j2;
    }

    public Jogo getJogo() {
        return jogo;
    }
        
    
    public void selecionarNome(String nome){
        if(J1.getNome() == null){
            J1.setNome(nome);
        }else{
            j2.setNome(nome);
        }
    }
    
    public void selecionarSimbolo(String simbolo1, String simbolo2){
        
        J1.setSimbolo(simbolo1);
        j2.setSimbolo(simbolo2);
        
        iniciar();
    }
    
    public void iniciar(){
        jogo = new Jogo(0, J1.build(), j2.build(), new Tabuleiro(0));
    }
    
    public boolean verificarSeGanhou(){
        return jogo.verificarSeGanhou();
    }
    
    public String encerrar(int tipo){
        
        if(tipo == 0){
            return jogo.getJogadorAtual().getNome() + " ganhou!!!";
        }
        
        return "Velha";
        
    }
    
    public String executar(int casa){
        
        jogo.jogar(casa);
        //System.out.println(jogo.getTabuleiro().imprimirTabuleiro());
        
        if(jogo.getJogadorAtual().getJogadas() > 2){
            boolean r = verificarSeGanhou();
            
            if(r){
                return encerrar(0);
            }
        }
        
        if(jogo.getTabuleiro().estaCheio()){
            return encerrar(1);
        }
        
        jogo.alternarVez();
        
        return null;
    }
    
    public String imprimirTabuleiro(){
        return jogo.getTabuleiro().imprimirTabuleiro();
    }
    
    public String imprimirNomeJogadorAtual(){
        return jogo.getJogadorAtual().getNome();
    }
    
    public boolean continuar(){
        return jogo.getTabuleiro().estaCheio() == false && 
                jogo.isGanhou() == false;
    }
}
