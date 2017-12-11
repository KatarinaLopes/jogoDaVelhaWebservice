/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.garanhuns.aula.jogodavelhawebserviceiv.dao;

import br.edu.ifpe.garanhuns.aula.jogodavelhawebserviceiv.dao.interfaces.DaoGenerico;
import br.edu.ifpe.garanhuns.aula.jogodavelhawebserviceiv.models.business.Jogo;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Katarina
 */
public class DaoJogo implements DaoGenerico<Jogo, Integer>{
    
    private static List<Jogo> jogos = new ArrayList<>();
    
    public static int retornarTamanhoDaLista(){
        return jogos.size();
    }
    
    @Override
    public void cadastrar(Jogo c) {
        jogos.add(c);
    }

    @Override
    public Jogo recuperar(Integer i) {
        for (Jogo jogo : jogos) {
            if(jogo.getId() == i){
                return jogo;
            }
        }
        
        return null;
    }

    @Override
    public void atualizar(Jogo c) {
        for (Jogo jogo : jogos) {
            if(jogo.getId() == c.getId()){
                jogo.setGanhou(c.isGanhou());
                jogo.setJogador1(c.getJogador1());
                jogo.setJogador2(c.getJogador2());
                jogo.setTabuleiro(c.getTabuleiro());
            }
        }
    }

    @Override
    public void remover(Jogo c) {
        jogos.remove(c);
    }

    
}
