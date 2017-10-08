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
public class VerificadorTest {

    public VerificadorTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    public void testVerificarSeGanhouLinha() {
        Tabuleiro t = new Tabuleiro(0);

        t.setarPecaNoQuadro(1, "X");
        t.setarPecaNoQuadro(2, "X");
        t.setarPecaNoQuadro(3, "X");

        int r1 = Verificador.verificarSeGanhouLinha(1, t);

        assertEquals(2, r1);
        
    }
    
    @Test
    public void ft(){
        Tabuleiro t = new Tabuleiro(0);
        
        t.setarPecaNoQuadro(4, "X");
        t.setarPecaNoQuadro(5, "X");
        t.setarPecaNoQuadro(6, "X");
        
        int r = Verificador.verificarSeGanhouLinha(4, t);
        
        assertEquals(2, r);
    }
    
    @Test
    public void ads(){
        Tabuleiro t = new Tabuleiro(0);
        
        t.setarPecaNoQuadro(7, "X");
        t.setarPecaNoQuadro(8, "X");
        t.setarPecaNoQuadro(9, "X");
        
        int r = Verificador.verificarSeGanhouLinha(7, t);
        
        assertEquals(2, r);
    }

    @Test
    public void deveTestarVerificar() {
        Tabuleiro t = new Tabuleiro(0);
        t.setarPecaNoQuadro(1, "O");
        t.setarPecaNoQuadro(2, " ");
        t.setarPecaNoQuadro(3, " ");

        int r2 = Verificador.verificarSeGanhouLinha(1, t);

        assertEquals(0, r2);
    }

    @Test
    public void deve() {
        Tabuleiro t = new Tabuleiro(0);
        t.setarPecaNoQuadro(1, " ");
        t.setarPecaNoQuadro(2, "O");
        t.setarPecaNoQuadro(3, "O");

        int r3 = Verificador.verificarSeGanhouLinha(1, t);

        assertEquals(0, r3);

    }

    @Test
    public void testV(){
        Tabuleiro t = new Tabuleiro(0);
        
        t.setarPecaNoQuadro(1, "X");
        t.setarPecaNoQuadro(2, "X");
        t.setarPecaNoQuadro(3, "O");
        
        int r4 = Verificador.verificarSeGanhouLinha(1, t);
        
        assertEquals(1, r4);
    }
    
    @Test
    public void testVerificarSeGanhouColuna() {
        Tabuleiro t = new Tabuleiro(0);
        
        t.setarPecaNoQuadro(1, "X");
        t.setarPecaNoQuadro(4, "X");
        t.setarPecaNoQuadro(7, "X");
        
        int r1 = Verificador.verificarSeGanhouColuna(1, t);
        
        assertEquals(2, r1);
    }
    
    @Test
    public void deveAs(){
        Tabuleiro gt = new Tabuleiro(0);
        
        gt.setarPecaNoQuadro(1, "O");
        gt.setarPecaNoQuadro(4, " ");
        gt.setarPecaNoQuadro(7, " ");
        
        int r = Verificador.verificarSeGanhouColuna(1, gt);
        
        assertEquals(0, r);
    }

    @Test
    public void fdf(){
        Tabuleiro ta = new Tabuleiro(0);
        
        ta.setarPecaNoQuadro(1, "O");
        ta.setarPecaNoQuadro(4, "X");
        ta.setarPecaNoQuadro(7, "X");
        
        int r = Verificador.verificarSeGanhouColuna(1, ta);
        
        assertEquals(1, r);
    }
    
    @Test
    public void testVerificarSeGanhouDiagonal00() {
        Tabuleiro ac = new Tabuleiro(0);
        
        ac.setarPecaNoQuadro(1, "O");
        ac.setarPecaNoQuadro(5, "O");
        ac.setarPecaNoQuadro(9, "O");
        
        int resu = Verificador.verificarSeGanhouDiagonal00(ac);
        
        assertEquals(2, resu);
    }
    


    @Test
    public void testVerificarSeGanhouDiagonal20() {
    }

    @Test
    public void testFazerVerificacaoComPecas() {
        int r1 = Verificador.fazerVerificacaoComPecas(" ", " ", " ");

        assertEquals(0, r1);

        int r2 = Verificador.fazerVerificacaoComPecas(" ", "X", "X");

        assertEquals(0, r2);

        int r3 = Verificador.fazerVerificacaoComPecas("X", " ", "X");

        assertEquals(0, r3);

        int r4 = Verificador.fazerVerificacaoComPecas("X", "X", " ");

        assertEquals(0, r4);

        int r5 = Verificador.fazerVerificacaoComPecas(" ", "O", "X");

        assertEquals(0, r5);

        int r6 = Verificador.fazerVerificacaoComPecas("O", "X", "X");

        assertEquals(1, r6);

        int r7 = Verificador.fazerVerificacaoComPecas("X", "O", "X");

        assertEquals(1, r7);

        int r8 = Verificador.fazerVerificacaoComPecas("X", "X", "O");

        assertEquals(1, r8);

        int r9 = Verificador.fazerVerificacaoComPecas("X", "X", "X");

        assertEquals(2, r9);
    }

    @Test
    public void testFazerVerificacaoLinha() {
        
    }

    @Test
    public void testFazerVerificacaoColuna() {
    }

    @Test
    public void testFazerVerificacaoDiagonal00() {
    }

    @Test
    public void testFazerVerificacaoDiagonal20() {
    }

}
