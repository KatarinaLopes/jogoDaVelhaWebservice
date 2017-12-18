/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.garanhuns.aula.jogodavelhawebserviceiv.models.business;

import br.edu.ifpe.garanhuns.aula.jogodavelhaserviceiv.exceptions.JogoException;
import java.util.Scanner;

/**
 *
 * @author Katarina
 */
public class Jogo {

    private int id;
    private Jogador jogador1;
    private Jogador jogador2;
    private Tabuleiro tabuleiro;
    private int vez;
    private Jogador jogadorAtual;
    private boolean ganhou = false;

    @Deprecated
    public Jogo() {
    }

    public Jogo(int id, Jogador jogador1, Jogador jogador2, Tabuleiro tabuleiro) {
        this.id = id;
        this.jogador1 = jogador1;
        this.jogador2 = jogador2;
        this.tabuleiro = tabuleiro;
        
        jogadorAtual = jogador1;
    }

    public int getId() {
        return id;
    }

    public Jogador getJogador1() {
        return jogador1;
    }

    public void setJogador1(Jogador jogador1) {
        this.jogador1 = jogador1;
    }

    public Jogador getJogador2() {
        return jogador2;
    }

    public void setJogador2(Jogador jogador2) {
        this.jogador2 = jogador2;
    }

    public Tabuleiro getTabuleiro() {
        return tabuleiro;
    }

    public void setTabuleiro(Tabuleiro tabuleiro) {
        this.tabuleiro = tabuleiro;
    }

    public Jogador pegarJogadorAtual(){
        return jogadorAtual;
    }
    
    public Jogador getJogadorAtual() {
        if (vez == 0) {
            jogadorAtual = jogador1;
        } else {
            jogadorAtual = jogador2;
        }

        return jogadorAtual;
    }

    public boolean isGanhou() {
        return ganhou;
    }

    public void setGanhou(boolean ganhou) {
        this.ganhou = ganhou;
    }

    
    
    public void alternarVez() {
        if (vez == 0) {
            vez = 1;
        } else {
            vez = 0;
        }
    }

    public void realizarJogada(int casa, Jogador j) throws JogoException {

        if (tabuleiro.verificarCasaSelecionada(casa)) {
            throw new JogoException(JogoException.CASA_JA_FOI_SELECIONADA
            + " " + j.getNome() + ", escolha outra casa! Seu oponente deve "
                    + "deixar o campo inalterado.");
        }

        tabuleiro.setarCasaSelecionada(casa);
        tabuleiro.setarPecaNoQuadro(casa, j.getSimbolo());
        j.setJogadas();

        System.out.println(vez);
        
        alternarVez();
        
        
    }
    
    public boolean ganhou(Jogador j){
        boolean resultado = false;
        
        if(j.getJogadas() >= 3) {
           resultado = verificarSeGanhou(j);
        }
        
        ganhou = resultado;
        return resultado;
    }

    /*public void jogar(int casa) {
        int resultado = realizarJogada(casa, getJogadorAtual().getSimbolo());

        if (resultado == 0) {
            System.out.println("Esta casa já foi selecionada!!!");
        } else {
            getJogadorAtual().setJogadas();
            //alternarVez();
        }
    }*/

    public boolean verificarSeGanhou(Jogador j) {
        boolean r1 = Verificador.fazerVerificacaoColuna(j,tabuleiro);

        if (r1) {
            //ganhou = true;
            return r1;
        }

        boolean r2 = Verificador.
                fazerVerificacaoDiagonal00(j, tabuleiro);

        if (r2) {
            //ganhou = true;
            return r2;
        }

        boolean r3 = Verificador.
                fazerVerificacaoDiagonal20(j, tabuleiro);

        if (r3) {
            //ganhou = true;
            return r3;
        }

        boolean r4 = Verificador.fazerVerificacaoLinha(j,tabuleiro);

        if (r4) {
            //ganhou = true;
            return r4;
        }
        
        return false;
    }

    /*public void executar(int casa) {
        //Scanner s = new Scanner(System.in);

        //while (tabuleiro.estaCheio() == false) {

            // jogar(s.nextInt());
            if (getJogadorAtual().getJogadas() >= 3) {
                
                boolean r = verificarSeGanhou();
                
                if(r){
                    return;
                }
                /*boolean r1 = Verificador.fazerVerificacaoColuna(jogadorAtual, 
                        tabuleiro);
                
                if(r1){
                    return;
                }
                
                boolean r2 = Verificador.
                        fazerVerificacaoDiagonal00(jogadorAtual, tabuleiro);
                
                if(r2){
                    return;
                }
                
                boolean r3 = Verificador.
                        fazerVerificacaoDiagonal20(jogadorAtual, tabuleiro);
                
                if(r3){
                    return;
                }
                
                boolean r4 = Verificador.fazerVerificacaoLinha(jogadorAtual, 
                        tabuleiro);
                
                if(r4){
                    return;
                }*/

          //  }

//            jogar(casa);

            //System.out.println(jogadorAtual.getSimbolo());
  //          alternarVez();
            //System.out.println(tabuleiro.imprimirTabuleiro());
        //}
    //}*/

    /*public void executar() {
        Scanner sc = new Scanner(System.in);
        
        boolean r1 = false, r2 = false, r3 = false, r4 = false;
        boolean resultado = r1 || r2 || r3 || r4;
        
        while (tabuleiro.estaCheio() == false && resultado == false) {
            jogar(sc.nextInt());
            //System.out.println(tabuleiro.imprimirTabuleiro());
            
            if(getJogadorAtual().getJogadas() > 2){
                //r1 = Verificador.fazerVerificacaoColuna(jogadorAtual, tabuleiro);
                r2 = Verificador.fazerVerificacaoLinha(jogadorAtual, tabuleiro);
                //r3 = Verificador.fazerVerificacaoDiagonal00(jogadorAtual, tabuleiro);
                //r4 = Verificador.fazerVerificacaoDiagonal20(jogadorAtual, tabuleiro);
                
                resultado = r1 || r2 || r3 || r4;
            }
            
            alternarVez();
            System.out.println(tabuleiro.imprimirTabuleiro());
        }
    }*/

 /*public void jogar(int casa) {
        if (vez == 0) {
            int resultado = jogador1.realizarJogada(casa, jogador1.getSimbolo(), tabuleiro);

            if (resultado == 0) {
                System.out.println("Esta casa já foi selecionada!!!");
            } else {
                vez++;
                jogador1.setJogadas();
            }
        } else if (vez == 1) {
            int resultado = jogador2.realizarJogada(casa, jogador2.getSimbolo(), tabuleiro);

            if (resultado == 0) {
                System.out.println("Esta casa já foi selecionada!!!");
            } else {
                vez--;
                jogador2.setJogadas();
            }
        }
    }*/
    
    public String imprimirEstadoTabuleiro(){
        return tabuleiro.imprimirTabuleiro();
    }
    
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        Tabuleiro t = new Tabuleiro(1);

        Jogo j = new Jogo(1, new Jogador(1, "amor", "X"), new Jogador(2, "ódio", "O"), t);

        //j.executar(1);

        //Verificador v = new Verificador();

        /*int valor = 0;
        while (!j.getTabuleiro().estaCheio() && valor != 2) {
            //System.out.println(j.getTabuleiro().imprimirTabuleiro());
            j.jogar(s.nextInt());
            System.out.println(j.getTabuleiro().imprimirTabuleiro());

            valor = v.verificarSeGanhouColuna(1);

            System.out.println(valor);
        }*/
        //j.executar();
    }

}
