/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.garanhuns.aula.jogodavelhawebserviceiv.models.business;

/**
 *
 * @author Katarina
 */
public class Peca {
    private int id;
    private String simbolo;

    public Peca(int id, String simbolo) {
        this.id = id;
        this.simbolo = simbolo;
    }

    public int getId() {
        return id;
    }

    public String getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }
    
    
}
