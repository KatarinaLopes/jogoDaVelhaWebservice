/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.garanhuns.aula.jogodavelhawebserviceiv.dao;

import br.edu.ifpe.garanhuns.aula.jogodavelhawebserviceiv.dao.interfaces.DaoGenerico;
import br.edu.ifpe.garanhuns.aula.jogodavelhawebserviceiv.models.business.Jogador;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Katarina
 */
public class DaoJogador implements DaoGenerico<Jogador, Integer>{

    private static List<Jogador> jogadores = new ArrayList<>();
    
    public static int retornarTamanhoDaLista(){
        return jogadores.size();
    }
    
    @Override
    public void cadastrar(Jogador c) {
        jogadores.add(c);
    }

    @Override
    public Jogador recuperar(Integer i) {
        for (Jogador jogadore : jogadores) {
            if(jogadore.getId() == i){
                return jogadore;
            }
            
        }
        
        return null;
    }

    @Override
    public void atualizar(Jogador c) {
        for (Jogador jogadore : jogadores) {
            if(jogadore.getId() == c.getId()){
                jogadore.setNome(c.getNome());
                jogadore.setSimbolo(c.getSimbolo());
            }
        }
    }

    @Override
    public void remover(Jogador c) {
        jogadores.remove(c);
    }
    
}
