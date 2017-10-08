/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogodavelhaservidor.models.business;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Katarina
 */
public class TabuleiroTest {
    private Tabuleiro tabuleiro;
    
    public TabuleiroTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        tabuleiro = new Tabuleiro(0);
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void deveTestarEstaCheioRetornandoTrue() {
        int[] escolhidasTodoPreenchido = new int[9];
        
        escolhidasTodoPreenchido[0] = 1;
        escolhidasTodoPreenchido[1] = 2;
        escolhidasTodoPreenchido[2] = 3;
        escolhidasTodoPreenchido[3] = 4;
        escolhidasTodoPreenchido[4] = 5;
        escolhidasTodoPreenchido[5] = 6;
        escolhidasTodoPreenchido[6] = 7;
        escolhidasTodoPreenchido[7] = 8;
        escolhidasTodoPreenchido[8] = 9;
        
        tabuleiro.setEscolhidas(escolhidasTodoPreenchido);
        
        boolean resultado = tabuleiro.estaCheio();
        
        assertTrue(resultado);
        
    }
    
    @Test
    public void deveTestarEstaCheioRetornandoFalse(){
        int[] escolhidasFaltandoPreencher = new int[9];
        
        escolhidasFaltandoPreencher[0] = 0;
        escolhidasFaltandoPreencher[1] = 2;
        escolhidasFaltandoPreencher[2] = 3;
        escolhidasFaltandoPreencher[3] = 4;
        escolhidasFaltandoPreencher[4] = 5;
        escolhidasFaltandoPreencher[5] = 6;
        escolhidasFaltandoPreencher[6] = 7;
        escolhidasFaltandoPreencher[7] = 8;
        escolhidasFaltandoPreencher[8] = 9;
        
        tabuleiro.setEscolhidas(escolhidasFaltandoPreencher);
        
        boolean resultado1 = tabuleiro.estaCheio();
        
        assertFalse(resultado1);
        
        escolhidasFaltandoPreencher[0] = 1;
        escolhidasFaltandoPreencher[1] = 0;
        
        tabuleiro.setEscolhidas(escolhidasFaltandoPreencher);
        
        boolean resultado2 = tabuleiro.estaCheio();
        
        assertFalse(resultado2);
        
        escolhidasFaltandoPreencher[1] = 2;
        escolhidasFaltandoPreencher[7] = 0;
        
        tabuleiro.setEscolhidas(escolhidasFaltandoPreencher);
        
        boolean resultado3 = tabuleiro.estaCheio();
        
        assertFalse(resultado3);
        
        escolhidasFaltandoPreencher[7] = 8;
        escolhidasFaltandoPreencher[8] = 0;
        
        tabuleiro.setEscolhidas(escolhidasFaltandoPreencher);
        
        boolean resultado4 = tabuleiro.estaCheio();
        
        assertFalse(resultado4);
    }

    @Test
    public void deveTestarVerificarCasaSelecionadaRetornandoTrue() {
        int[] escolhidas = new int[9];
        
        escolhidas[0] = 1;
        
        tabuleiro.setEscolhidas(escolhidas);
        
        boolean resultado1 = tabuleiro.verificarCasaSelecionada(1);
        
        assertTrue(resultado1);
        
        escolhidas[1] = 2;
        
        tabuleiro.setEscolhidas(escolhidas);
        
        boolean resultado2 = tabuleiro.verificarCasaSelecionada(2);
        
        assertTrue(resultado2);
        
        escolhidas[7] = 8;
        
        tabuleiro.setEscolhidas(escolhidas);
        
        boolean resultado8 = tabuleiro.verificarCasaSelecionada(8);
        
        assertTrue(resultado8);
        
        escolhidas[8] = 9;
        
        tabuleiro.setEscolhidas(escolhidas);
        
        boolean resultado9 = tabuleiro.verificarCasaSelecionada(9);
        
        assertTrue(resultado9);
        
    }
    
    @Test
    public void deveTestarVerificarCasaSelecionadaRetornandoFalse(){
        boolean resultado1 = tabuleiro.verificarCasaSelecionada(1);
        
        assertFalse(resultado1);
        
        boolean resultado2 = tabuleiro.verificarCasaSelecionada(2);
        
        assertFalse(resultado2);
        
        boolean resultado8 = tabuleiro.verificarCasaSelecionada(8);
        
        assertFalse(resultado8);
        
        boolean resultado9 = tabuleiro.verificarCasaSelecionada(9);
        
        assertFalse(resultado9);
    }

    @Test
    public void deveTestarSetarCasaSelecionadaVerificandoEstado() {
        tabuleiro.setarCasaSelecionada(1);
        
        int resultado1 = tabuleiro.getEscolhidas()[0];
        
        assertEquals(1, resultado1);
        
        tabuleiro.setarCasaSelecionada(2);
        
        int resultado2 = tabuleiro.getEscolhidas()[1];
        
        assertEquals(2, resultado2);
        
        tabuleiro.setarCasaSelecionada(8);
        
        int resultado8 = tabuleiro.getEscolhidas()[7];
        
        assertEquals(8, resultado8);
        
        tabuleiro.setarCasaSelecionada(9);
        
        int resultado9 = tabuleiro.getEscolhidas()[8];
        
        assertEquals(9, resultado9);
        
    }

    @Test
    public void deveTestarSetarPecaNoQuadroVerificandoEstado() {
        tabuleiro.setarPecaNoQuadro(1, "X");
        
        String resultado1x = tabuleiro.getQuadro()[0][0].getSimbolo();
        
        assertEquals("X", resultado1x);
        
        tabuleiro.setarPecaNoQuadro(2, "O");
        
        String resultado2o = tabuleiro.getQuadro()[0][1].getSimbolo();
        
        assertEquals("O", resultado2o);
        
        tabuleiro.setarPecaNoQuadro(8, "O");
        
        String resultado8o = tabuleiro.getQuadro()[2][1].getSimbolo();
        
        assertEquals("O", resultado8o);
        
        tabuleiro.setarPecaNoQuadro(9, "O");
        
        String resultado9o = tabuleiro.getQuadro()[2][2].getSimbolo();
        
        assertEquals("O", resultado9o);
        
    }

    @Test
    public void deveTestarComporQuadroVerificandoEstado() {
        tabuleiro.comporQuadro();
        
        Peca resultado1 = tabuleiro.getQuadro()[0][0];
        
        assertEquals(1, resultado1.getId());
        assertEquals(" ", resultado1.getSimbolo());
        
        Peca resultado2 = tabuleiro.getQuadro()[0][1];
        
        assertEquals(2, resultado2.getId());
        assertEquals(" ", resultado2.getSimbolo());
       
    }

    @Test
    public void testImprimirTabuleiro() {
        String tabuleiroCriado = "1 | 2 | 3 | \n__________\n4 | 5 | 6 | "
                + "\n___________"
                + "\n7 | 8 | 9 | ";
        
        String tab = tabuleiro.imprimirTabuleiro();
        
        assertEquals(tab, tabuleiroCriado);
    }
    
}
