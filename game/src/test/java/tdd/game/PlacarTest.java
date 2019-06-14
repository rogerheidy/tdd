package roger.game;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PlacarTest {

    @Test
    public void deveArmazenarPontosParaUmUsuario() {
        ArmazenamentoMock armazenamentoMock = new ArmazenamentoMock();
        Placar placar = new Placar(armazenamentoMock);

        placar.adicionaPontosUsuario("Guerra", "Estrela", 10);

        armazenamentoMock.adicionaPontosUsuario("Guerra", "Estrela", 10);
        assertEquals( armazenamentoMock.getQuantidadeTipo("Guerra", "Moeda"), 10);
    }
	
	
}
