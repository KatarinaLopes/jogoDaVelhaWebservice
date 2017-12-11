/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.garanhuns.aula.jogodavelhawebserviceiv.dao.interfaces;

/**
 *
 * @author Katarina
 */
public interface DaoGenerico <C,I>{
    
    public abstract void cadastrar(C c);
    public abstract C recuperar(I i);
    public abstract void atualizar(C c);
    public abstract void remover(C c);
}
