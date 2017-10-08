/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogodavelhaservidor.models.business;

import jogodavelhaservidor.models.business.Jogador;
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
public class JogadorTest {
    
    private Jogador jogador;
    
    public JogadorTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        jogador = new Jogador(0, "nome", "X");
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void deveTestarSetTabelaVerificacaoEmDefaultSeCorrespondeOEsperado(){
        int[][] tabelaVerificacaoCorreta = new int[3][5];
        
        tabelaVerificacaoCorreta[0][0] = 1;
        tabelaVerificacaoCorreta[0][1] = 0;
        tabelaVerificacaoCorreta[0][2] = 0;
        tabelaVerificacaoCorreta[0][3] = 4;
        tabelaVerificacaoCorreta[0][4] = 5;
        
        tabelaVerificacaoCorreta[1][0] = 1;
        tabelaVerificacaoCorreta[1][1] = 2;
        tabelaVerificacaoCorreta[1][2] = 3;
        tabelaVerificacaoCorreta[1][3] = 0;
        tabelaVerificacaoCorreta[1][4] = 0;
        
        tabelaVerificacaoCorreta[2][0] = 1;
        tabelaVerificacaoCorreta[2][1] = 0;
        tabelaVerificacaoCorreta[2][2] = 0;
        tabelaVerificacaoCorreta[2][3] = 0;
        tabelaVerificacaoCorreta[2][4] = 5;
        
        jogador.setTabelaVerificacao();
        
        int[][] tabelaJogador = jogador.getTabelaVerificacao();
        
        assertArrayEquals(tabelaVerificacaoCorreta, tabelaJogador);
        
    }

    @Test
    public void deveTestarAlterarTabelaVerificandoSeValorPassadoFoiAlterado() {
        jogador.setTabelaVerificacao();
        
        jogador.alterarTabela(0, 0);
        jogador.alterarTabela(1, 0);
        jogador.alterarTabela(2, 0);
        jogador.alterarTabela(0, 4);
        jogador.alterarTabela(2, 4);
        
        int valorL1 = jogador.getTabelaVerificacao()[0][0];
        int valorL2 = jogador.getTabelaVerificacao()[1][0];
        int valorL3 = jogador.getTabelaVerificacao()[2][0];
        int valorL1C5 = jogador.getTabelaVerificacao()[0][4];
        int valorL3C5 = jogador.getTabelaVerificacao()[2][4];
        
        assertEquals(0, valorL1);
        assertEquals(0, valorL2);
        assertEquals(0, valorL3);
        assertEquals(0, valorL1C5);
        assertEquals(0, valorL3C5);
        
    }

    @Test
    public void testMain() {
    }
    
    

}