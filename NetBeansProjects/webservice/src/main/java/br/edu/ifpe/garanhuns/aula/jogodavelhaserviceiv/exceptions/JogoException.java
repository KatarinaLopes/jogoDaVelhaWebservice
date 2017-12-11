/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.garanhuns.aula.jogodavelhaserviceiv.exceptions;
/**
 *
 * @author Katarina
 */
public class JogoException extends Exception{
    public static final String CASA_JA_FOI_SELECIONADA = "Esta casa já foi "
            + "selecionada!";
    public static final String CASA_INVALIDA = "Escolha uma casa entre 1 e 9!";
    
    public JogoException(String mensagem){
        super(mensagem);
    }
    
}
