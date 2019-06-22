package tdd.game;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PlacarTest {

    @Test
    public void deveArmazenarPontosParaUmUsuario() {
        ArmazenamentoMock armazenamentoMock = new ArmazenamentoMock();
        Placar placar = new Placar(armazenamentoMock);

        placar.adicionaPontosUsuario("Guerra", "Estrela", 10);
        Integer valor = 10;
        assertEquals(valor, armazenamentoMock.recuperarPontuacaoUsuario("Estrela", "Guerra"));
       }
    

    
    
	
	
}
