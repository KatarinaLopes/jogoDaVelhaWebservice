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

        String mensagem = "ID do Jogador 1: " + id1 + "<br>Nome do Jogador 1: "
                + nome1 + "<br>--------------<br>Símbolo: " + simbolo1
                + "<br>--------------<br>ID do Jogador 2: " + id2
                + "<br>Nome do Jogador 2: " + nome2 + "<br>Símbolo: "
                + simbolo2 + "<br>--------------<br>ID do jogo: " + idJogo;;

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
            @QueryParam("id1") int id1,
            @QueryParam("casa1") int casa1,
            @QueryParam("id2") int id2,
            @QueryParam("casa2") int casa2) {

        if (id1 == id2) {
            return "Jogadores iguais!";
        }

        if (casa1 == casa2) {
            return "Casas iguais!";
        }

        Jogo jogo = (Jogo) daoJogo.recuperar(idJogo);

        if (jogo == null) {
            return "Id de jogo inválido";
        }

        if (jogo.isGanhou() == true) {
            return "Este jogo já foi concluído! Inicie outro!";
        }

        Jogador j1 = jogo.getJogador1();
        Jogador j2 = jogo.getJogador2();

        if (j1 == null || j2 == null) {
            return "Selecione as características do jogador primeiro!";
        }

        try {
            jogo.realizarJogada(casa1, j1);
            jogo.realizarJogada(casa2, j2);
        } catch (JogoException e) {
            return e.getMessage();
        }
        
        String mensagem = "";
        
        
        if (jogo.ganhou(j1)) {
            mensagem = j1.getNome() + " venceu!";
        } else if (jogo.ganhou(j2)) {
            mensagem = j2.getNome() + " venceu!";
        }
        
        if (jogo.getTabuleiro().retornarTamanhoPreenchidoTabuleiro() == 8) {
            mensagem = "Velha!";
        }

        //Nunca vai alcançar, porque o jogo recebe dois parâmetros
        daoJogo.atualizar(jogo);

        jogo = (Jogo) daoJogo.recuperar(idJogo);

        mensagem += "<br>" + jogo.imprimirEstadoTabuleiro();

        return mensagem;
    }
}
