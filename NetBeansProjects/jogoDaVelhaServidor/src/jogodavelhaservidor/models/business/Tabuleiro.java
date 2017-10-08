/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogodavelhaservidor.models.business;

/**
 *
 * @author Katarina
 */
public class Tabuleiro {
    private int id;
    private Peca[][] quadro = new Peca[3][3];
    private int[] escolhidas = new int[9];

    @Deprecated
    public Tabuleiro() {
    }

    public Tabuleiro(int id) {
        this.id = id;
        comporQuadro();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Peca[][] getQuadro() {
        return quadro;
    }

    public void setQuadro(Peca[][] quadro) {
        this.quadro = quadro;
    }

    public int[] getEscolhidas() {
        return escolhidas;
    }

    public void setEscolhidas(int[] escolhidas) {
        this.escolhidas = escolhidas;
    }
    
    public boolean estaCheio(){
        for (int i = 0; i < escolhidas.length; i++) {    
            if(escolhidas[i] == 0){
                return false;
            }
        }
        
        return true;
    }
    
    public boolean verificarCasaSelecionada (int casa){
        if(casa <= 0 || casa > 9){
            throw new IllegalArgumentException();
        }
        
        int p = casa-1;
        return escolhidas[p] == casa;
    }
    
    public void setarCasaSelecionada (int casa) {
        int posicao = casa-1;
        escolhidas[posicao] = casa;
    }
    
    public void setarPecaNoQuadro(int casa, String simbolo){
        for (Peca[] quadro1 : quadro) {
            for (int j = 0; j < quadro.length; j++) {
                if (quadro1[j].getId() == casa) {
                    quadro1[j].setSimbolo(simbolo);
                    return;
                }
            }
        }
        
    }
    
    public void comporQuadro(){
        int id = 1;
        
        for (int i = 0; i < quadro.length; i++) {
            for (int j = 0; j < quadro.length; j++) {
                
                quadro[i][j] = new Peca(id, " ");
                id++;                
            }            
        }
    }
    
    public String imprimirTabuleiro(){
        String tabuleiro = "";
        
        for (int i = 0; i < quadro.length; i++) {
            for (int j = 0; j < quadro.length; j++) {
                if(quadro[i][j].getSimbolo().equals(" ")){
                    tabuleiro += quadro[i][j].getId();
                }else{
                    tabuleiro += quadro[i][j].getSimbolo();
                }
                
                tabuleiro += " | ";
                
            }
            
            tabuleiro += "\n___________\n";
           
        }
        
        return tabuleiro;
    }
    
    //Fazer aqui, depois mudar
    
    //public static void main(String[] args) {
        //Tabuleiro t = new Tabuleiro(1);
        
        //t.realizarJogada(1, "X");
        //t.realizarJogada(1, "O");
        
        //System.out.println(t.imprimirTabuleiro());
    //}
}
