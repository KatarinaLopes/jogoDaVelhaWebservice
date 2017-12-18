/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.garanhuns.aula.jogodavelhawebserviceiv.services;

import br.edu.ifpe.garanhuns.aula.jogodavelhaserviceiv.exceptions.JogoException;
import br.edu.ifpe.garanhuns.aula.jogodavelhawebserviceiv.dao.DaoJogador;
import br.edu.ifpe.garanhuns.aula.jogodavelhawebserviceiv.dao.DaoJogo;
import br.edu.ifpe.garanhuns.aula.jogodavelhawebserviceiv.dao.interfaces.DaoGenerico;
import br.edu.ifpe.garanhuns.aula.jogodavelhawebserviceiv.models.builders.BuilderJogador;
import br.edu.ifpe.garanhuns.aula.jogodavelhawebserviceiv.models.business.Jogador;
import br.edu.ifpe.garanhuns.aula.jogodavelhawebserviceiv.models.business.Jogo;
import br.edu.ifpe.garanhuns.aula.jogodavelhawebserviceiv.models.business.Tabuleiro;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

/**
 *
 * @author Katarina
 */
@Path("/jogo")
public class JogoService {

    private DaoGenerico daoJogo = new DaoJogo();
    private DaoGenerico daoJogador = new DaoJogador();

    @GET
    @Path("/selecionar_nome")
    public String selecionarNome(@QueryParam("nome1") String nome1,
            @QueryParam("nome2") String nome2,
            @QueryParam("simbolo1") String simbolo1,
            @QueryParam("simbolo2") String simbolo2) {

        if (!simbolo1.equals("X") && !simbolo1.equals("O")) {
            return "Símbolo do primeiro jogador incorreto!";
        }

        if (!simbolo2.equals("X") && !simbolo2.equals("O")) {
            return "Símbolo do segundo jogador incorreto!";
        }

        if (simbolo1.equals(simbolo2)) {
            return "Símbolos iguais!";
        }

        int id1 = DaoJogador.retornarTamanhoDaLista() + 1;

        Jogador j1 = new Jogador(id1, nome1, simbolo1);

        daoJogador.cadastrar(j1);

        int id2 = DaoJogador.retornarTamanhoDaLista() + 1;
        Jogador j2 = new Jogador(id2, nome2, simbolo2);
        daoJogador.cadastrar(j2);

        int idJogo = DaoJogo.retornarTamanhoDaLista() + 1;
        daoJogo.cadastrar(new Jogo(idJogo, j1, j2, new Tabuleiro(0)));

        String mensagem = "ID do Jogador 1: " + j1.getId()
                + "<br>Nome do Jogador 1: " + j1.getNome()
                + "<br>--------------<br>Símbolo: " + j1.getSimbolo()
                + "<br>--------------<br>ID do Jogador 2: " + j2.getId()
                + "<br>Nome do Jogador 2: " + j2.getNome() + "<br>Símbolo: "
                + j2.getSimbolo() + "<br>--------------<br>ID do jogo: "
                + idJogo + "<br>--------------<br>" + j1.getNome() +
                ", você começa!";

        return mensagem;
    }

    @GET
    @Path("/imprimir_tabuleiro")
    public String imprimirTabuleiro(@QueryParam("idJogo") int idJogo) {
        return ((Jogo) daoJogo.recuperar(idJogo)).imprimirEstadoTabuleiro();
    }

    @GET
    @Path("/fazer_jogada")
    public String fazerJogada(@QueryParam("idJogo") int idJogo,
            @QueryParam("casa1") int casa1) {

        Jogo jogo = (Jogo) daoJogo.recuperar(idJogo);

        if (jogo == null) {
            return "Id de jogo inválido";
        }

        if (jogo.isGanhou() == true) {
            return "Este jogo já foi concluído! Inicie outro!";
        }

        Jogador j = jogo.getJogadorAtual();
        
        try {
            jogo.realizarJogada(casa1, j);
        } catch (JogoException e) {
            return e.getMessage();
        }
        
        String mensagem = "Vez de " + jogo.getJogadorAtual().getNome();
        
        if (jogo.ganhou(j)) {
            mensagem = j.getNome() + " venceu!";
        }

        if (jogo.getTabuleiro().estaCheio() && jogo.isGanhou() == false) {
            mensagem = "Velha!";
            jogo.setGanhou(true);
        }

        //Nunca vai alcançar, porque o jogo recebe dois parâmetros
        daoJogo.atualizar(jogo);

        jogo = (Jogo) daoJogo.recuperar(idJogo);

        mensagem += "<br>" + jogo.imprimirEstadoTabuleiro();

        return mensagem;
    }
}
