/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogodavelhaservidor.models.builders;

import jogodavelhaservidor.models.business.Jogador;

/**
 *
 * @author Katarina
 */
public class BuilderJogador {
    private String nome;
    
    private String simbolo;

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
    
    
    public Jogador build(){
        return new Jogador(0, nome, simbolo);
    }
    
}
