/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogodavelhaservidor.models.business;

import java.util.Random;

/**
 *
 * @author Katarina
 */
public class Jogador {

    private int id;
    private String nome;
    private String simbolo;
    private int jogadas;
    private int jogadasSucedidas;
    private int[][] tabelaVerificacao = new int[3][5];

    @Deprecated
    public Jogador() {
    }

    public Jogador(int id, String nome, String simbolo) {
        this.id = id;
        this.nome = nome;
        this.simbolo = simbolo;
        setTabelaVerificacao();
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }

    public int getJogadas() {
        return jogadas;
    }

    public void setJogadas() {
        this.jogadas++;
    }

    public int getJogadasSucedidas() {
        return jogadasSucedidas;
    }

    public void setJogadasSucedidas(int jogadasSucedidas) {
        this.jogadasSucedidas = jogadasSucedidas;
    }

    public int[][] getTabelaVerificacao() {
        return tabelaVerificacao;
    }

    public void setTabelaVerificacao() {
        int valor = 1;

        for (int i = 0; i < tabelaVerificacao.length; i++) {
            for (int j = 0; j < tabelaVerificacao[i].length; j++) {
                tabelaVerificacao[i][j] = valor++;
            }

            valor = 1;
        }

        tabelaVerificacao[0][1] = tabelaVerificacao[2][1] = 0;
        tabelaVerificacao[0][2] = tabelaVerificacao[2][2] = 0;
        tabelaVerificacao[1][3] = tabelaVerificacao[2][3] = 0;
        tabelaVerificacao[1][4] = 0;
        
        tabelaVerificacao[0][4] = tabelaVerificacao[2][4] = 7;

    }

    public void alterarTabela(int i, int j) {
        tabelaVerificacao[i][j] = 0;
    }

    /*public int realizarJogada(int casa, Tabuleiro tabuleiro) {

        if (tabuleiro.verificarCasaSelecionada(casa)) {
            return 0; //Erro 0 - Casa já selecionada
        }

        tabuleiro.setarCasaSelecionada(casa);
        tabuleiro.setarPecaNoQuadro(casa, this.simbolo);

        return 1; //Código 1 - Jogada realizada;

    }*/

    public static void main(String[] args) {
        
    }
}
