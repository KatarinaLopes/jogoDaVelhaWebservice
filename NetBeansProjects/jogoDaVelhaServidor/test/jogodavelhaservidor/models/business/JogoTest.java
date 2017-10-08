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
public class JogoTest {
    private Jogo jogo;
    
    public JogoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        jogo = new Jogo(0, new Jogador(0, "a", "X"), new Jogador(0, "b", "O"), 
               new Tabuleiro(1));
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void deveTestarRealizarJogadaVerificandoRetorno0EEstado() {
        Tabuleiro t = jogo.getTabuleiro();
        
        t.setarCasaSelecionada(1);
        t.setarPecaNoQuadro(1, "X");
        
        int r = jogo.realizarJogada(1, "X");
        
        assertEquals(0, r);
        
    }
    
    @Test
    public void deveTestarRealizarJogadaVerificandoRetorno1EEstado() {
        int r = jogo.realizarJogada(1, "O");
        
        assertEquals(1, r);
        
        boolean r1 = jogo.getTabuleiro().verificarCasaSelecionada(1);
        boolean r2 = jogo.getTabuleiro().getQuadro()[0][0].getSimbolo().
                equals("O");
        
        assertTrue(r1);
        assertTrue(r2);
    }

    @Test
    public void testJogar() {
       
    }

    @Test
    public void testMain() {
    }
    
    
}
